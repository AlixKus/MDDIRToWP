package com.mcs.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionUtil {

	private static SqlSessionFactory sqlSessionFactory;

	static {
		String resource = "config/mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	private SessionUtil() {
	}

	public static SqlSession getSession() {
		return getSession(true);
	}

	public static SqlSession getSession(boolean autocommit) {
		return sqlSessionFactory.openSession(autocommit);
	}
}
