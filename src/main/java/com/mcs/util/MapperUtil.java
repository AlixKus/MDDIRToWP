package com.mcs.util;

public class MapperUtil {
	public static <T> T getMapper(Class<T> type) {
		return SessionUtil.getSession().getMapper(type);
	}
	
}
