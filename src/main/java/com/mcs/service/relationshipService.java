package com.mcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcs.model.termRelationship;
import com.mcs.repository.termRelationshipMapper;

@Service
public class relationshipService {
	@Autowired
	termRelationshipMapper mapper;

	public void saveRelation(Long postId, Long catalodId) {
		termRelationship trs = new termRelationship();
		trs.setObjectId(postId);
		trs.setTermTaxonomyId(catalodId);
		mapper.insertSelective(trs);
	}
}
