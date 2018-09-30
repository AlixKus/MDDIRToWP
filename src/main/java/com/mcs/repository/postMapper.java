package com.mcs.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mcs.model.postWithBLOBs;

@Repository
public interface postMapper {
	int insert(postWithBLOBs record);

	int insertSelective(postWithBLOBs record);

	int updateGuidById(@Param("val") String value, @Param("id") Long id);
}