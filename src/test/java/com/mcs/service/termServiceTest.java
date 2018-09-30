package com.mcs.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mcs.config.RootConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RootConfig.class)
class termServiceTest {

	@Autowired
	termService service;

	@Test
	void testInsertTermStringLong() {
		long id = service.insertTerm("Father");
		System.out.println(id);
		service.insertTerm("FaChhhhd", id);
	}

}
