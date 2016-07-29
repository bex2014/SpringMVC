package com.bex.spring.MVC;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class PostBeanTest implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object paramObject, String paramString) throws BeansException {
		System.out.println("postProcessAfterInitialization: [" + paramObject + "], params ["+ paramString + "]");
		return paramObject;
	}

	@Override
	public Object postProcessBeforeInitialization(Object paramObject, String paramString) throws BeansException {
		System.out.println("");
		System.out.println("------------------------------");
		System.out.println("postProcessBeforeInitialization: [" + paramObject + "], params ["+ paramString + "]");
		return paramObject;
	}

}
