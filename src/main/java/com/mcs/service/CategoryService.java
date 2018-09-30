package com.mcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcs.model.option;
import com.mcs.model.taxonomy;
import com.mcs.repository.optionMapper;

import de.ailis.pherialize.MixedArray;
import de.ailis.pherialize.Pherialize;

@Service
public class CategoryService {
	@Autowired
	optionMapper oMpr;

	@Autowired
	termService tService;

	public option getCategoryChildren() {
		return oMpr.selectByname(option.CATEGORY);
	}

	public void updateCategoryChildren(String val) {
		oMpr.updateOptionValueByname(val, option.CATEGORY);
	}

	public void insertCategory(taxonomy t) {
		option c = getCategoryChildren();
		String val = c.getOption_value();
		MixedArray a = Pherialize.unserialize(val).toArray();
		MixedArray chd;
		try {
			chd = a.getArray(t.getParent());
		} catch (NullPointerException e) {
			chd = new MixedArray();
			a.put(t.getParent(), chd);
		}
		chd.put(chd.size() - 1, t.getTermId());
		String result = Pherialize.serialize(a);
		updateCategoryChildren(result);
	}

}
