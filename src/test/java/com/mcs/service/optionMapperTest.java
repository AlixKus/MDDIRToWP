package com.mcs.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mcs.config.RootConfig;
import com.mcs.model.option;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RootConfig.class)
public class optionMapperTest {
	@Autowired
	CategoryService service;

	Logger log = LoggerFactory.getLogger(optionMapperTest.class);

	@Test
	void test1() {
		option c = service.getCategoryChildren();
		log.info(c.getOption_value());
	}

	@Test
	void test2() {
		service.updateCategoryChildren("a:1:{i:2;a:2:{i:0;i:3;i:1;i:11;}}");
	}
}
