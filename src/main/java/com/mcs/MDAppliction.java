package com.mcs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ComponentScan
public class MDAppliction {

	Logger log = LoggerFactory.getLogger(MDAppliction.class);

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		new AnnotationConfigApplicationContext(MDAppliction.class).getBean(MDAppliction.class).run();
	}

	public void run() {
		log.info("Starting Appliction");
	}
}
