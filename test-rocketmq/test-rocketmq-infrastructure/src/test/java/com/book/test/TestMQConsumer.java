package com.book.test;

import java.util.List;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import lombok.Data;

@Data
public class TestMQConsumer {
	public static void main(String[] args) {
		TestMQConsumer consumer = new TestMQConsumer();
		consumer.getRocketMQConsumer();
	}

	private String namesrvAddr = "192.168.133.130:9876";
	private String groupName = "test-group";
	private String topic = "test-topic";;
	private String tag = "test-tag";;
	private int consumeThreadMin = 2;
	private int consumeThreadMax = 4;

	public DefaultMQPushConsumer getRocketMQConsumer() {
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(groupName);
		consumer.setNamesrvAddr(namesrvAddr);
		consumer.setConsumeThreadMin(consumeThreadMin);
		consumer.setConsumeThreadMax(consumeThreadMax);
		consumer.registerMessageListener(new MessageListenner());

		try {
			consumer.subscribe(topic, tag);
			consumer.start();
		} catch (MQClientException e) {
			e.printStackTrace();
		}
		return consumer;
	}

}

class MessageListenner implements MessageListenerConcurrently {

	@Override
	public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
		for (MessageExt msg : msgs) {
			try {
				System.out.println(msg);
				System.out.println(new String(msg.getBody()));
			} catch (Exception e) {
				return ConsumeConcurrentlyStatus.RECONSUME_LATER;
			}
		}

		return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
	}

}
