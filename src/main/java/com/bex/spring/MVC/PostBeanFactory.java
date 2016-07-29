package com.bex.spring.MVC;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class PostBeanFactory implements BeanFactoryPostProcessor{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0) throws BeansException {
		System.out.println("----------- postProcessBeanFactory -------------");
		
	}

}
