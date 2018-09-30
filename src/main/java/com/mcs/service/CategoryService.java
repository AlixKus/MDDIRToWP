package com.mcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcs.model.option;
import com.mcs.repository.optionMapper;

@Service
public class CategoryService {
	@Autowired
	optionMapper oMpr;

	public option getCategoryChildren() {
		return oMpr.selectByname(option.CATEGORY);
	}

	public void updateCategoryChildren(String val) {
		oMpr.updateOptionValueByname(val, option.CATEGORY);
	}

	public void insertCategory(String category) {
	}
}
