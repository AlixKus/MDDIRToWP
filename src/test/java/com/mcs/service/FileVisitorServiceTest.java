package com.mcs.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mcs.config.RootConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RootConfig.class)
class FileVisitorServiceTest {

	@Autowired
	FileVisitorService<Path> service;

	@Test
	void test() throws IOException {
		Files.walkFileTree(service.getRoot(), service);
	}

}
