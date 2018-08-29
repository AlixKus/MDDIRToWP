package com.mcs.repository;

import java.util.List;

import com.mcs.model.term;

public interface termMapper {
	term selectByID(Long id);

	List<term> selectByName(String string);

	List<term> selectAll();

	int insert(term t);
}