package com.mcs;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.ailis.pherialize.MixedArray;
import de.ailis.pherialize.Pherialize;

public class TestRPC {
	Logger log = LoggerFactory.getLogger(TestRPC.class);

	@Test
	void test() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String str = "a:1:{i:2;a:1:{i:0;i:3;}}";
		MixedArray a = Pherialize.unserialize(str).toArray();

		a.forEach((k, v) -> {
			//k 父ID v 子ID 数组
			// log.info(k + ":");
			MixedArray children = a.getArray(k);
		});
		
		log.info(str);
		String result = Pherialize.serialize(a);
		log.info(result);
	}
}
