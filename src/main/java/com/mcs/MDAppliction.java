package com.mcs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.mcs.service.FileVisitorService;

@Component
@Configuration
@ComponentScan
public class MDAppliction {

	@Autowired
	FileVisitorService<Path> service;

	Logger log = LoggerFactory.getLogger(MDAppliction.class);

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		new AnnotationConfigApplicationContext(MDAppliction.class).getBean(MDAppliction.class).run();
	}

	public void run() {
		try {
			Files.walkFileTree(service.getRoot(), service);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
