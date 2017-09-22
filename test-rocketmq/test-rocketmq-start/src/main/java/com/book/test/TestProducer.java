package com.book.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.rocketmq.producer.RMQProducer;

@RequestMapping()
@RestController
public class TestProducer {

	@RequestMapping(value = "/send")
	public void send() {
		try {
			RMQProducer.sendMessage(new TestMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
