package com.mcs.repository;

import com.mcs.model.termRelationship;

public interface termRelationshipMapper {
    int insert(termRelationship record);

    int insertSelective(termRelationship record);
}