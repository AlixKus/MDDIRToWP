package com.mcs.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mcs.model.term;

@Repository
public interface termMapper {
	term selectByID(Long id);

	List<term> selectByName(String string);

	List<term> selectAll();

	int insert(term t);
}