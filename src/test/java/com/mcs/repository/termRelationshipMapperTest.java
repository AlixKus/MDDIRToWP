package com.mcs.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.mcs.model.termRelationship;
import com.mcs.util.MapperUtil;

class termRelationshipMapperTest {

	@Test
	void testInsertSelective() {
		termRelationshipMapper tr = MapperUtil.getMapper(termRelationshipMapper.class);
		termRelationship trp = new termRelationship();

		// articleID
		trp.setObjectId(12L);
		trp.setTermTaxonomyId(10L);

		int row = tr.insertSelective(trp);
		assertEquals(1, row);
	}

}
