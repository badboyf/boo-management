package com.book.rocketmq.annotation.surpport;

import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.book.rocketmq.RMQConfig;
import com.book.rocketmq.annotation.EnableRocketMQ;

public class RocketMQRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		boolean exist = importingClassMetadata.hasAnnotation(EnableRocketMQ.class.getName());
		if (!exist) {
			return;
		}
		Map<String, Object> defaultAttrs = importingClassMetadata.getAnnotationAttributes(EnableRocketMQ.class.getName(), true);
		String[] packages = (String[]) defaultAttrs.get("packages");

		RootBeanDefinition beanDefinition = new RootBeanDefinition();
		beanDefinition.setBeanClass(RMQConfig.class);
		beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
		registry.registerBeanDefinition(RMQConfig.class.getSimpleName(), beanDefinition);

		ConstructorArgumentValues values = new ConstructorArgumentValues();
		values.addGenericArgumentValue(packages);
		beanDefinition.setConstructorArgumentValues(values);
	}

}
