package com.mcs.service;

import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcs.repository.taxonomyMapper;

@Service
public class FileService {
	@Autowired
	PraseService psService;
	@Autowired
	private postService pService;
	@Autowired
	taxonomyMapper tMapper;
	@Autowired
	private relationshipService rService;

	public Long insert(Path md) {

		String filename = md.getFileName().toString();
		if (filename.endsWith(".md"))
			filename = filename.substring(0, filename.indexOf("."));
		String context = psService.praseContext(md);
		Long postId = pService.addPost(filename, context);
		String parent = md.getParent().getFileName().toString();
		System.out.println("插入" + parent + "/" + filename);
		Long parentID = tMapper.findIDByName(parent);
		rService.saveRelation(postId, parentID);
		return postId;
	}
}
