package com.mcs.model;

import lombok.Data;

@Data
public class option {
	public static final String CATEGORY = "category_children";
	public long option_id;
	public String option_name;
	public String option_value;
	public String autoload;
}
