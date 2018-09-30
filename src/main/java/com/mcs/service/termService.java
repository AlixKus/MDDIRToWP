package com.mcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcs.model.taxonomy;
import com.mcs.model.term;
import com.mcs.repository.taxonomyMapper;
import com.mcs.repository.termMapper;

@Service
public class termService {
	@Autowired
	termMapper mapper;

	@Autowired
	taxonomyMapper tMapper;

	public taxonomy insertTerm(String name, String slug, long parentID) {
		term t = new term();
		t.setName(name);
		t.setSlug(slug);
		mapper.insert(t);
		taxonomy ty = new taxonomy();
		ty.setTermId(t.getTermId());
		ty.setParent(parentID);
		tMapper.insert(ty);
		return ty;
	}

	public taxonomy insertTerm(String name, long parentID) {
		return insertTerm(name, name, parentID);
	}

	public taxonomy insertTerm(String name) {
		return insertTerm(name, name, 0);
	}

}
