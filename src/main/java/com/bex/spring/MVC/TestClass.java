package com.bex.spring.MVC;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component(value="testClass")
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS, value="singleton")
public class TestClass {
	
	public TestClass() {
		
	}

	public void test3() {
		System.out.println("test3");
	}
	
	public void test4() {
		System.out.println("test4");
	}
	
}
