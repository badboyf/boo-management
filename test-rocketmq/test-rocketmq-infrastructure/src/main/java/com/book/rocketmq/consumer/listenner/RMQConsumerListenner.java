package com.book.rocketmq.consumer.listenner;

import java.util.List;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import com.book.rocketmq.util.MessageUtil;

public interface RMQConsumerListenner<T> extends MessageListenerConcurrently {
	@Override
	@SuppressWarnings("unchecked")
	default ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
		ConsumeConcurrentlyStatus result = ConsumeConcurrentlyStatus.CONSUME_SUCCESS;

		for (MessageExt messageExt : msgs) {
			T body = (T) MessageUtil.toObject(messageExt.getBody());
			ConsumeConcurrentlyStatus status = consume(body, context);
			if (status == ConsumeConcurrentlyStatus.RECONSUME_LATER) {
				result = ConsumeConcurrentlyStatus.RECONSUME_LATER;
			}
		}

		return result;
	}

	ConsumeConcurrentlyStatus consume(T msg, ConsumeConcurrentlyContext context);
}
