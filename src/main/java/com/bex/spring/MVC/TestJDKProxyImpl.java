package com.bex.spring.MVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component(value="testJDKProxy")
@Scope(proxyMode=ScopedProxyMode.INTERFACES, value="singleton")
public class TestJDKProxyImpl implements TestJDKProxy {
	@Autowired
	TestClass testClass;

	@Override
	public void test1() {
		System.out.println("test1");
		testClass.test4();
	}

	@Override
	public void test2() {
		System.out.println("test1");
	}
}
