package com.mcs.model;

import lombok.Data;

@Data
public class taxonomy {
	private Long termTaxonomyId;

	private Long termId;

	private String taxonomy = "category";

	private Long parent = 0L;

	private Long count = 0L;

	private String description = "";
}