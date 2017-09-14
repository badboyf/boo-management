package com.book.rocketmq.producer;

import java.util.List;

import org.apache.rocketmq.client.producer.DefaultMQProducer;

public class ProducerHolder {
	private static List<DefaultMQProducer> producers;
	private static int index = 0;

	public static void setProducers(List<DefaultMQProducer> producers) {
		ProducerHolder.producers = producers;
	}

	public static DefaultMQProducer getProducer() {
		int totalSize = ProducerHolder.producers.size();
		if (index >= ProducerHolder.producers.size()) {
			index = 0;
		}

		return ProducerHolder.producers.get((index++) % totalSize);
	}

}
