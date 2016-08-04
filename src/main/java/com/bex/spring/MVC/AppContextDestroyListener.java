package com.bex.spring.MVC;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

@Component
public class AppContextDestroyListener implements ApplicationListener<ContextStoppedEvent>{

	@Override
	public void onApplicationEvent(ContextStoppedEvent event) {
		System.out.println("----------------- onApplicationEvent.ContextStoppedEvent -------------");
	}
}