package com.mcs.md;

import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.options.MutableDataSet;

public class MDParser {

	static MutableDataSet options = new MutableDataSet();

	static Parser parser = Parser.builder(options).build();
	static HtmlRenderer renderer = HtmlRenderer.builder(options).build();

	public static String renderHtml(String md) {
		String commonmark = commonmark(md);
		Node document = parser.parse(commonmark);
		return renderer.render(document);

	}

	private static String commonmark(String md) {
		Node document = PegdownToCommonMark.PARSER.parse(md);
		return PegdownToCommonMark.RENDERER.render(document);
	}
}
