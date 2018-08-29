package com.mcs.md;

import com.vladsch.flexmark.formatter.internal.Formatter;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.profiles.pegdown.Extensions;
import com.vladsch.flexmark.profiles.pegdown.PegdownOptionsAdapter;
import com.vladsch.flexmark.util.options.DataHolder;
import com.vladsch.flexmark.util.options.MutableDataSet;

public class PegdownToCommonMark {
	static final DataHolder OPTIONS = PegdownOptionsAdapter.flexmarkOptions(Extensions.ALL);

	static final MutableDataSet FORMAT_OPTIONS = new MutableDataSet();
	static {
		// copy extensions from Pegdown compatible to Formatting
		FORMAT_OPTIONS.set(Parser.EXTENSIONS, OPTIONS.get(Parser.EXTENSIONS));
	}

	static final Parser PARSER = Parser.builder(OPTIONS).build();
	static final Formatter RENDERER = Formatter.builder(FORMAT_OPTIONS).build();
}
