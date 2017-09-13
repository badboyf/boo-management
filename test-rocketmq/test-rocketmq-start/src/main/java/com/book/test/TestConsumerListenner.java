package com.book.test;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;

import com.book.rocketmq.annotation.RMQConsumer;
import com.book.rocketmq.consumer.listenner.RMQConsumerListenner;

@RMQConsumer(message = TestMessage.class)
public class TestConsumerListenner implements RMQConsumerListenner<String> {

	@Override
	public ConsumeConcurrentlyStatus consume(String msg, ConsumeConcurrentlyContext context) {

		System.out.println(msg);

		return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
	}

}
