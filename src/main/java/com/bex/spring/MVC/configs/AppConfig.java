package com.bex.spring.MVC.configs;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@ComponentScan(basePackages = "com.bex.spring.MVC")
public class AppConfig implements WebApplicationInitializer {
	
	public static void main(String[] args) {
/*		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class, JPAConfig.class);
		for (String bean : ctx.getBeanDefinitionNames()) {
			System.out.println("bean = " + bean);
		}*/
	}

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class, JPAConfig.class, DispatcherServletConfiguration.class);
        container.addListener(new ContextLoaderListener(rootContext));
        
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(rootContext));
        dispatcher.setAsyncSupported(true);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");		
	}
}