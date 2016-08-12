package com.bex.spring.MVC.configs;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import java.util.Collection;

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

	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		System.out.println(">>>>>>>>>>> customizeRegistration <<<<<<<<<<<<<<<<<");
		for (String c : registration.getMappings()) {
			System.out.println("mapping = " + c);
		}
	}

}