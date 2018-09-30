package com.mcs.repository;

import org.springframework.stereotype.Repository;

import com.mcs.model.termRelationship;

@Repository
public interface termRelationshipMapper {
	int insert(termRelationship record);

	int insertSelective(termRelationship record);
}