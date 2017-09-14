package com.book.rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import com.book.rocketmq.message.IMQMessage;
import com.book.rocketmq.util.MessageUtil;

public class RMQProducer {

	public static SendResult sendMessage(IMQMessage<?> message) throws Exception {
		Message msg = new Message(message.getTopic(), message.getTag(), message.getKey(), MessageUtil.toByteArray(message.getMessage()));
		DefaultMQProducer producer = ProducerHolder.getProducer();

		return producer.send(msg);
	}
}
