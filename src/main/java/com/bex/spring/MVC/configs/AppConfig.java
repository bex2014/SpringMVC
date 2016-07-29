package com.bex.spring.MVC.configs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.bex.spring.MVC.TestClass;
import com.bex.spring.MVC.TestJDKProxy;

@Configuration
@ComponentScan(basePackages = "com.bex.spring.MVC")
public class AppConfig {
	
	private int count = 0;

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		TestJDKProxy o1 = ctx.getBean("testJDKProxy", TestJDKProxy.class);
		TestClass o2 = ctx.getBean("testClass", TestClass.class);
		o1.test1();
		o2.test3();
		for (String bean : ctx.getBeanDefinitionNames()) {
			System.out.println("bean = " + bean);
		}
	}
	
	@Bean(name="Count")
	@Scope("singleton")
	public Integer getCount() {
		System.out.println("exec getCount...");
		return ++count;
	}
	
	public void init() {
		System.out.println("---- Init ----");
	}
}
