package com.mcs.model;

import lombok.Data;

@Data
public class term {
	private Long termId;

	private String name;

	private String slug;

	private Long termGroup = 0L;

}