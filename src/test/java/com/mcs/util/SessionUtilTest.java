package com.mcs.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SessionUtilTest {

	@BeforeAll
	static void init() throws ClassNotFoundException {
		Class.forName("com.mcs.util.SessionUtil");
	}

	@Test
	void testGetSession() {
		SqlSession session = SessionUtil.getSession();
		assertNotNull(session);
		session.close();
	}

}
