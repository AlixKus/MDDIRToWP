package com.mcs.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mcs.config.RootConfig;
import com.mcs.model.taxonomy;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RootConfig.class)
public class optionMapperTest {
	@Autowired
	CategoryService service;

	@Autowired
	termService tService;

	Logger log = LoggerFactory.getLogger(optionMapperTest.class);

	@Test
	void test1() {
		taxonomy t = tService.insertTerm("test666", 2L);
		service.insertCategory(t);

	}

}
