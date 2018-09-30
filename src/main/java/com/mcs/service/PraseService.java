package com.mcs.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.stereotype.Service;

import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.formatter.internal.Formatter;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.profiles.pegdown.Extensions;
import com.vladsch.flexmark.profiles.pegdown.PegdownOptionsAdapter;
import com.vladsch.flexmark.util.options.DataHolder;
import com.vladsch.flexmark.util.options.MutableDataSet;

@Service
public class PraseService {

	MutableDataSet options = new MutableDataSet();
	Parser parser = Parser.builder(options).build();
	HtmlRenderer renderer = HtmlRenderer.builder(options).build();
	DataHolder OPTIONS = PegdownOptionsAdapter.flexmarkOptions(Extensions.ALL);
	MutableDataSet FORMAT_OPTIONS = new MutableDataSet();
	Parser PARSER = Parser.builder(OPTIONS).build();
	Formatter RENDERER = Formatter.builder(FORMAT_OPTIONS).build();

	public PraseService() {
		FORMAT_OPTIONS.set(Parser.EXTENSIONS, OPTIONS.get(Parser.EXTENSIONS));
	}

	public String renderHtml(String md) {
		String commonmark = commonmark(md);
		Node document = parser.parse(commonmark);
		return renderer.render(document);

	}

	private String commonmark(String md) {
		Node document = PARSER.parse(md);
		return RENDERER.render(document);
	}

	public String praseContext(Path md) {
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
		String html = renderHtml(context);
		return html;

	}

}
