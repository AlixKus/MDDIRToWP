package com.mcs.repository;

import java.util.List;

import com.mcs.model.term;

public interface termMapper {
	term slectByID(Long id);

	List<term> slectAll();

	int insert(term t);
}