package com.gemicle.parsewebsite;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring-config.xml");
	}
}
