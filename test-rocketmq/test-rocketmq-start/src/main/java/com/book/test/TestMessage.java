package com.book.test;

import com.book.rocketmq.message.IMQMessage;

public class TestMessage implements IMQMessage<String> {

	@Override
	public String getKey() {
		return "test-key";
	}

	@Override
	public String getTopic() {
		return "test-topic";
	}

	@Override
	public String getTag() {
		return "test-tag";
	}

	@Override
	public String getMessage() {
		return "test-message";
	}

}
