package com.hackerrank.util;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class CollectionUtilsTest {

	@Test
	void shouldVerifyParametersOfList() {
		List<String> list = null;
		assertAll("collections",
				() -> assertTrue(CollectionUtils.isEmpty(list)),
				() -> assertTrue(CollectionUtils.isEmpty(Collections.emptyList())),
				() -> assertFalse(CollectionUtils.isEmpty(Arrays.asList(""))),
				() -> assertFalse(CollectionUtils.isNotEmpty(list)),
				() -> assertFalse(CollectionUtils.isNotEmpty(Collections.emptyList())),
				() -> assertTrue(CollectionUtils.isNotEmpty(Arrays.asList(""))));
	}

	@Test
	void shouldVerifyParametersOfArray() {
		String[] array = null;
		assertAll("arrays",
				() -> assertTrue(CollectionUtils.isEmpty(array)),
				() -> assertTrue(CollectionUtils.isEmpty(new Integer[] {})),
				() -> assertFalse(CollectionUtils.isEmpty(new String[] {""})));
	}
	
	@Test
	void shouldVerifyIfHasNextElement() {
		List<Integer> list = Arrays.asList(1, 2, 3);
		
		assertAll("elements",
				() -> assertFalse(CollectionUtils.hasNextAfter(null, 1)),
				() -> assertFalse(CollectionUtils.hasNextAfter(Collections.emptyList(), 1)),
				() -> assertTrue(CollectionUtils.hasNextAfter(list, 0)),
				() -> assertTrue(CollectionUtils.hasNextAfter(list, 1)),
				() -> assertFalse(CollectionUtils.hasNextAfter(list, 2)),
				() -> assertFalse(CollectionUtils.hasNextAfter(list, 3)));
	}

}
