package com.mcs.repository;

import org.springframework.stereotype.Repository;

import com.mcs.model.taxonomy;

@Repository
public interface taxonomyMapper {
	int insert(taxonomy record);

	Long findIDByName(String name);
	
}