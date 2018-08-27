package com.mcs.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class catalogServiceTest {
	 catalogService s = new catalogService();
	/**
	 * 
	 */
	@Test
	void testAddCatalog() {
		
		Long id =s.addCatalog("10:52","ass");
		assertNotNull(id);
		System.out.println(id);
	}

}
