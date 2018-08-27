package com.mcs.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class postServiceTest {

	static postService service = new postService("http://59.110.162.40/?p");

	@Test
	void test() {
		Long id = service.addPost("11.33", "Eat something?");
		assertNotNull(id);
		System.out.println(id);
	}

}
