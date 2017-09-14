package com.book.rocketmq;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.annotation.AnnotationUtils;

import com.book.rocketmq.annotation.RMQConsumer;
import com.book.rocketmq.annotation.surpport.Scanner;
import com.book.rocketmq.config.RMQConsumerProperties;
import com.book.rocketmq.config.RMQProducerProperties;
import com.book.rocketmq.consumer.listenner.RMQConsumerListenner;
import com.book.rocketmq.message.IMQMessage;
import com.book.rocketmq.producer.ProducerHolder;

@EnableConfigurationProperties({ RMQConsumerProperties.class, RMQProducerProperties.class })
public class RMQConfig {
	@Autowired
	RMQConsumerProperties consumerProperties;

	@Autowired
	RMQProducerProperties producerProperties;

	@Value("${rocketmq.producerSize}")
	int producerSize;

	private String[] packages;

	public RMQConfig(String[] packages) throws Exception {
		this.packages = packages;
	}

	@PostConstruct
	public void init() throws Exception {
		startRMQConsumer();
		startRMQProducer();
	}

	public void startRMQConsumer() throws Exception {
		Set<Class<?>> rmqConsumerClasses = Scanner.scan(packages, RMQConsumer.class);

		for (Class<?> rmqConsumerClass : rmqConsumerClasses) {
			RMQConsumer rmqConsumer = AnnotationUtils.findAnnotation(rmqConsumerClass, RMQConsumer.class);
			Class<? extends IMQMessage<?>> mqMessage = rmqConsumer.message();

			// Type type = rmqConsumerClass.getGenericSuperclass();
			// ParameterizedType parameterizedType = (ParameterizedType) type;
			// Class<?> class1 =
			// parameterizedType.getActualTypeArguments()[0].getClass();

			RMQConsumerListenner<?> listenner = (RMQConsumerListenner<?>) rmqConsumerClass.newInstance();
			start(mqMessage.newInstance(), listenner);
		}
	}

	public void start(IMQMessage<?> mqMessage, RMQConsumerListenner<?> listenner) throws Exception {
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(producerProperties.getGroupName());
		consumer.setNamesrvAddr(consumerProperties.getNamesrvAddr());
		consumer.setConsumeThreadMin(consumerProperties.getConsumeThreadMin());
		consumer.setConsumeThreadMax(consumerProperties.getConsumeThreadMax());
		consumer.registerMessageListener(listenner);

		try {
			consumer.subscribe(mqMessage.getTopic(), mqMessage.getTag());
			consumer.start();
		} catch (MQClientException e) {
			throw new Exception();
		}
	}

	public void startRMQProducer() {
		List<DefaultMQProducer> producers = new ArrayList<DefaultMQProducer>();

		for (int i = 0; i < producerSize; i++) {
			DefaultMQProducer producer = new DefaultMQProducer(producerProperties.getGroupName());
			producer.setNamesrvAddr(producerProperties.getNamesrvAddr());
			producer.setInstanceName(producerProperties.getInstanceName());
			producer.setMaxMessageSize(producerProperties.getMaxMessageSize());
			producer.setSendMsgTimeout(producerProperties.getSendMsgTimeout());
			try {
				producer.start();
			} catch (MQClientException e) {
				e.printStackTrace();
			}
			producers.add(producer);
		}

		ProducerHolder.setProducers(producers);
	}
}
