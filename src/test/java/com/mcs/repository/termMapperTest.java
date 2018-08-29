package com.mcs.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mcs.model.term;
import com.mcs.util.SessionUtil;

class termMapperTest {

	static termMapper mapper;

	@BeforeAll
	static void init() {
		mapper = SessionUtil.getSession().getMapper(termMapper.class);
	}

	@Test
	void testselectByID() {
		Long id = 1L;
		term t = mapper.selectByID(id);
		assertNotNull(t);
	}

	@Test
	void testselectAll() {
		List<term> results = mapper.selectAll();
		assertNotNull(results);
	}

	@Test
	void testselectByName() {
		List<term> results = mapper.selectByName("MySql");
		assertNotNull(results);
	}

	@Test
	void testinsert() {
		term t = new term();
		t.setName("nnnn222");
		t.setSlug("nnnn222");
		int row = mapper.insert(t);
		assertEquals(1, row);
		assertNotNull(t.getTermId());
	}

}
