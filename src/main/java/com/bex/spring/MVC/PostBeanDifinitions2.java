package com.bex.spring.MVC;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class PostBeanDifinitions2 implements BeanDefinitionRegistryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0) throws BeansException {
		System.out.println("---------- postProcessBeanFactory 2 ------------");

	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry arg0) throws BeansException {
		System.out.println("---------- postProcessBeanDefinitionRegistry 2 ------------");
	}

}
