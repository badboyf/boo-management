package com.book.rocketmq.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties("rocketmq.consumer")
public class RMQConsumerProperties {
	private String namesrvAddr;
	private String topic;
	private String tag;
	private int consumeThreadMin;
	private int consumeThreadMax;
}
