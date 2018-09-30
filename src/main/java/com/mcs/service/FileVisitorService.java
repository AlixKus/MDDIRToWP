package com.mcs.service;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mcs.model.taxonomy;

@Service
public class FileVisitorService<T> extends SimpleFileVisitor<T> {

	@Value("${root}")
	private Path root;

	private List<String> ignores;

	Logger log = LoggerFactory.getLogger(FileVisitorService.class);

	@Autowired
	CategoryService cService;
	@Autowired
	termService tService;

	@Autowired
	FileService fService;

	public FileVisitorService() {
		ignores = new LinkedList<>();
		ignores.add(".git");
	}

	public FileVisitorService(String root, List<String> ignores) {
		this.root = Paths.get(root);
		this.ignores = ignores;
	}

	@Override
	public FileVisitResult preVisitDirectory(T dir, BasicFileAttributes attrs) throws IOException {
		if (dir instanceof Path) {
			Path p = (Path) dir;
			if (isIgnore(p))
				return FileVisitResult.SKIP_SUBTREE;

			boolean isBasDir = isBaseDir(p);
			taxonomy t;
			String name = p.getFileName().toString();
			if (isBasDir) {
				t = tService.insertTerm(name);
			} else {
				String parent = "";
				try {
					parent = p.getParent().getFileName().toString();
				} catch (Exception e) {
					log.info(name);
				}
				t = tService.insertTerm(name, parent);
			}
			cService.insertCategory(t);
		}
		return FileVisitResult.CONTINUE;
	}

	private boolean isRoot(Path path) {
		return path.equals(root);
	}

	private boolean isIgnore(Path path) {
		for (String i : ignores) {
			if (path.toAbsolutePath().toString().indexOf(i) > -1)
				return true;
		}
		return false;
	}

	private boolean isBaseDir(Path path) {
		return isRoot(path.getParent());
	}

	@Override
	public FileVisitResult visitFile(T file, BasicFileAttributes attrs) throws IOException {
		Path md = (Path) file;
		fService.insert(md);
		return FileVisitResult.CONTINUE;
	}

	public Path getRoot() {
		return root;
	}

}
