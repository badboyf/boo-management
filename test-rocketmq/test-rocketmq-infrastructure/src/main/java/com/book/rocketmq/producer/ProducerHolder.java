package com.book.rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;

public class ProducerHolder {
	private static DefaultMQProducer producer;

	public static void setProducer(DefaultMQProducer producer) {
		ProducerHolder.producer = producer;
	}

	public static DefaultMQProducer getProducer() {
		return ProducerHolder.producer;
	}

}
