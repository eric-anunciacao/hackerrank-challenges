package com.hackerrank.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import com.hackerrank.util.CollectionUtils;

class QuicksortServiceTest {

	@Test
	void shouldRunQuickSort() {
		List<String> expected = Arrays.asList("1 3 2 5 9 7 8", "1 2 3 5 9 7 8", "1 2 3 5 7 8 9");

		List<String> actual = QuicksortService.run("quicksort3.txt");

		assertNotNull(actual);
		assertFalse(CollectionUtils.isEmpty(actual));
		assertEquals(expected.size(), actual.size());
		IntStream.range(0, expected.size()).forEach(i -> {
			assertEquals(expected.get(i), actual.get(i));
		});
	}

}
