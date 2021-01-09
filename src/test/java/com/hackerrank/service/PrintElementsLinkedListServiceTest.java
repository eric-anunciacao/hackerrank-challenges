package com.hackerrank.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import com.hackerrank.util.CollectionUtils;

class PrintElementsLinkedListServiceTest {

	@Test
	void shouldPrintElementsFromLinkedList() {
		List<Integer> expected = Arrays.asList(16, 13);

		List<Integer> actual = PrintElementsLinkedListService.run("print-the-elements-of-a-linked-list.txt");

		assertNotNull(actual);
		assertFalse(CollectionUtils.isEmpty(actual));
		assertEquals(expected.size(), actual.size());
		IntStream.range(0, expected.size()).forEach(i -> {
			assertEquals(expected.get(i), actual.get(i));
		});

	}

}
