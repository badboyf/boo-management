package com.book.rocketmq.annotation.surpport;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

public class Scanner {

	public static Set<Class<?>> scan(String[] packages, Class<? extends Annotation> destClass) {
		Assert.notNull(destClass, "需要扫描的类不能为空");

		ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
		provider.addIncludeFilter(new AnnotationTypeFilter(destClass));

		Set<Class<?>> classes = new HashSet<Class<?>>();

		for (String scanPackage : packages) {
			for (BeanDefinition beanDefinition : provider.findCandidateComponents(scanPackage)) {
				try {
					classes.add(ClassUtils.forName(beanDefinition.getBeanClassName(), beanDefinition.getClass().getClassLoader()));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (LinkageError e) {
					e.printStackTrace();
				}
			}
		}

		return classes;
	}
}
