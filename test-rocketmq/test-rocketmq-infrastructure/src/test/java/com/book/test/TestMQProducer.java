package com.book.test;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import lombok.Data;

@Data
public class TestMQProducer {
	public static void main(String[] args) {
		TestMQProducer producer = new TestMQProducer();
		producer.sendMessage();
	}

	private String groupName = "test-group";
	private String namesrvAddr = "192.168.133.130:9876";
	private String instanceName = "testProducer";
	private String topic = "test-topic";
	private String tag = "test-tag";
	private String key = "test-key";
	private int maxMessageSize = 131072;
	private int sendMsgTimeout = 10000;

	public void sendMessage() {
		Message msg = new Message(topic, // topic
				tag, // tag
				key, // key用于标识业务的唯一性
				("Hello RocketMQ !!!!!!!!!!").getBytes()// body 二进制字节数组
		);
		DefaultMQProducer producer = getRocketMQProducer();
		try {
			SendResult result = producer.send(msg);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		producer.shutdown();
	}

	public DefaultMQProducer getRocketMQProducer() {
		DefaultMQProducer producer;
		producer = new DefaultMQProducer(this.groupName);
		producer.setNamesrvAddr(this.namesrvAddr);
		producer.setInstanceName(instanceName);
		producer.setMaxMessageSize(this.maxMessageSize);
		producer.setSendMsgTimeout(this.sendMsgTimeout);
		try {
			producer.start();
		} catch (MQClientException e) {
			e.printStackTrace();
		}

		return producer;
	}
}
