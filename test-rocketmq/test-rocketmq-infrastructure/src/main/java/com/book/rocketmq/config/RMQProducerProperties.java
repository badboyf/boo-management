package com.book.rocketmq.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties("rocketmq.producer")
public class RMQProducerProperties {
	private String group;
	private String namesrvAddr;
	private String instanceName;
	private Integer maxMessageSize;
	private Integer sendMsgTimeout;
	private Integer retryTimes;
	private Integer defaultTopicQueueNums;
}
