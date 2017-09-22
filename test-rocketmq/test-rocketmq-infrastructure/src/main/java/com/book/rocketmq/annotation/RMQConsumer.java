package com.book.rocketmq.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.book.rocketmq.message.IMQMessage;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface RMQConsumer {

	Class<? extends IMQMessage<?>> message();
	
	String group() default "";

	// Class<? extends RMQConsumerListenner> listener();
}
