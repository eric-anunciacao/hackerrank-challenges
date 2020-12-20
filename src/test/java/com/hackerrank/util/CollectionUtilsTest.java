package com.hackerrank.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class CollectionUtilsTest {

	@Test
	void shouldVerifyParameters() {
		assertAll("collections",
				() -> assertTrue(CollectionUtils.isEmpty(null)),
				() -> assertTrue(CollectionUtils.isEmpty(Collections.emptyList())),
				() -> assertFalse(CollectionUtils.isEmpty(Arrays.asList(""))));
	}

}
