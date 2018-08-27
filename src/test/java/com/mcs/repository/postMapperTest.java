package com.mcs.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mcs.model.postWithBLOBs;
import com.mcs.util.MapperUtil;

class postMapperTest {
	static postMapper mapper;

	@BeforeAll
	static void init() {
		mapper = MapperUtil.getMapper(postMapper.class);
	}

	@Test
	void testInsertSelective() {
		postWithBLOBs p = new postWithBLOBs();
		// admin
		p.setPostAuthor(1L);
		Date postDate = new Date();
		// date
		p.setPostDate(postDate);
		p.setPostDateGmt(postDate);
		p.setPostModified(postDate);
		p.setPostModifiedGmt(postDate);
		// tittle & content
		p.setPostContent("TTTTTTTT");
		p.setPostTitle("TTTTTT");

		p.setPostContentFiltered("");
		p.setPostExcerpt("");
		p.setToPing("");
		p.setPinged("");
		p.setCommentCount(0L);

		mapper.insertSelective(p);

		assertNotNull(p.getId());
		System.out.println(p.getId());
	}

	@Test
	void testUpdateGuid() {
		int row = mapper.updateGuidById("qqqq", 5L);
		assertNotNull(row);
	}
}
