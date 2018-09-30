package com.mcs.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mcs.model.postWithBLOBs;
import com.mcs.repository.postMapper;

@Service
public class postService {

	@Autowired
	private postMapper mapper;

	@Value("${guidprefix}")
	private String guidprefix;

	public postService()
	{
		
	}
	
	public postService(String guidprefix) {
		this.guidprefix = guidprefix;
	}

	public Long addPost(String title, String context) {
		Long id = insert(title, context);
		updateGuid(id);
		return id;
	}

	private Long insert(String title, String context) {
		postWithBLOBs p = new postWithBLOBs();
		// tittle & content
		p.setPostContent(context);
		p.setPostTitle(title);

		// admin
		p.setPostAuthor(1L);
		Date postDate = new Date();
		// date
		p.setPostDate(postDate);
		p.setPostDateGmt(postDate);
		p.setPostModified(postDate);
		p.setPostModifiedGmt(postDate);

		p.setPostContentFiltered("");
		p.setPostExcerpt("");
		p.setToPing("");
		p.setPinged("");
		p.setCommentCount(0L);

		mapper.insertSelective(p);
		return p.getId();
	}

	private void updateGuid(Long id) {
		String value = guidprefix + id;
		mapper.updateGuidById(value, id);
	}
}
