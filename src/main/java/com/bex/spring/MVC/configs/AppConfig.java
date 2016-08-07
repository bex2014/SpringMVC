package com.bex.spring.MVC.configs;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	public static void main(String[] args) {
		/*
		 * ApplicationContext ctx = new
		 * AnnotationConfigApplicationContext(AppConfig.class, JPAConfig.class);
		 * for (String bean : ctx.getBeanDefinitionNames()) {
		 * System.out.println("bean = " + bean); }
		 */
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { DispatcherServletConfiguration.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {
		Filter[] singleton = { new CORSFilter() };
		return singleton;
	}

}