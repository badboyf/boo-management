package com.book.rocketmq.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties("rocketmq.producer")
public class RMQProducerProperties {
	private String groupName;
	private String namesrvAddr;
	private String instanceName;
	private int maxMessageSize;
	private int sendMsgTimeout;
}
