package com.book.rocketmq.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.book.rocketmq.annotation.surpport.RocketMQRegistrar;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(RocketMQRegistrar.class)
public @interface EnableRocketMQ {
	String[] packages() default {};
}
