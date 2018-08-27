package com.mcs.service;

import com.mcs.model.termRelationship;
import com.mcs.repository.termRelationshipMapper;
import com.mcs.util.MapperUtil;

public class relationshipService {
	termRelationshipMapper mapper = MapperUtil.getMapper(termRelationshipMapper.class);

	

	public void saveRelation(Long postId, Long catalodId) {
		termRelationship trs = new termRelationship();
		trs.setObjectId(postId);
		trs.setTermTaxonomyId(catalodId);
		mapper.insertSelective(trs);
	}
}
