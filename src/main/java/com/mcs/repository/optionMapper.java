package com.mcs.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mcs.model.option;

@Repository
public interface optionMapper {
	public option selectByname(String name);

	public void updateOptionValueByname(@Param("val") String val, @Param("name") String name);
}
