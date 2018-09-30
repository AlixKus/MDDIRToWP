package com.mcs.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.mcs.md.MDParser;

public class PraseService {
	private Path rootLocation;

	private catalogService cs;
	private postService ps;
	private relationshipService rs;

	public PraseService(Path rootLocation, catalogService cs, postService ps, relationshipService rs) {
		this.rootLocation = rootLocation;
		this.cs = cs;
		this.ps = ps;
		this.rs = rs;
	}

	public void Parse() throws Exception {
		Files.walk(rootLocation, 1).filter((p) -> !p.equals(rootLocation)).forEach(p -> {
			ParseDir(p);
		});
	}

	private void ParseDir(Path p) {
		if (!p.toFile().isDirectory())
			return;
		String catalogName = p.getFileName().toString();
		// 注册目录
		Long catlogid = cs.addCatalog(catalogName);
		System.out.println(catalogName);
		try {
			Files.walk(p, 1).filter(md -> !md.equals(p)).forEach((md) -> {
				String filename = md.getFileName().toString().substring(md.getFileName().toString().indexOf("."));
				String context = praseContext(md);
				
				// 注册文章
				Long postId = ps.addPost(filename, context);

				// 保存关联
				rs.saveRelation(postId, catlogid);
			});
		} catch (Exception e) {
		}
	}

	private String praseContext(Path md) {
		String context = null;
		byte[] bs = null;
		try {
			bs = Files.readAllBytes(md);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			context = new String(bs, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String html = MDParser.renderHtml(context);
		return html;

	}

	public Path getRootLocation() {
		return rootLocation;
	}

	public void setRootLocation(Path rootLocation) {
		this.rootLocation = rootLocation;
	}

}
