package com.mcs.service;

import com.mcs.model.taxonomy;
import com.mcs.model.term;
import com.mcs.repository.taxonomyMapper;
import com.mcs.repository.termMapper;
import com.mcs.util.MapperUtil;

public class catalogService {

	private static taxonomyMapper tymMapper = MapperUtil.getMapper(taxonomyMapper.class);
	private static termMapper termMapper = MapperUtil.getMapper(termMapper.class);

	public Long addCatalog(String catalogname) {
		return addCatalog(catalogname, catalogname);
	}

	public Long addCatalog(String catalogname, String alias) {
		Long termid = insertterm(catalogname, alias).getTermId();
		Long taxonomyid = inserttaxonomy(termid).getTermTaxonomyId();
		return taxonomyid;
	}

	private static term insertterm(String catalogname, String alias) {
		term t = new term();
		t.setName(catalogname);
		t.setSlug(catalogname);
		termMapper.insert(t);
		return t;
	}

	private static taxonomy inserttaxonomy(Long termid) {
		taxonomy ty = new taxonomy();
		ty.setTermId(termid);
		ty.setTaxonomy("category");
		ty.setCount(0L);
		ty.setParent(0L);
		ty.setDescription("");
		tymMapper.insert(ty);
		return ty;
	}
}
