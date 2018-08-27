package com.mcs.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mcs.model.taxonomy;
import com.mcs.model.term;
import com.mcs.util.SessionUtil;

class taxonomyMapperTest {
	static taxonomyMapper mapper;

	private static String CATAGORY = "category";

	@BeforeAll
	static void init() {
		mapper = SessionUtil.getSession().getMapper(taxonomyMapper.class);
	}

	@Test
	void testInsert() {
		termMapper termMapper = SessionUtil.getSession().getMapper(termMapper.class);
		term t = new term();
		t.setName("nnnn");
		t.setSlug("nnnn");
		termMapper.insert(t);

		Long termid = t.getTermId();

		taxonomy ty = new taxonomy();
		ty.setTermId(termid);
		ty.setTaxonomy(CATAGORY);
		ty.setCount(0L);
		ty.setParent(0L);
		ty.setDescription("");

		int row = mapper.insert(ty);
		assertEquals(1, row);
		assertNotNull(ty.getTermTaxonomyId());
	}

}
