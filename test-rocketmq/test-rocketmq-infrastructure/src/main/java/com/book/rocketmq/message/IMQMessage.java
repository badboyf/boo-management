package com.book.rocketmq.message;

public interface IMQMessage<T> {
	String getKey();

	String getTopic();

	String getTag();

	T getMessage();

}
