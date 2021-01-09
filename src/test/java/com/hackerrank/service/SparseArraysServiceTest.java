package com.hackerrank.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

class SparseArraysServiceTest {

	@Test
	void shouldExecuteQueries() {
		int[] expected = new int[] { 1, 3, 4, 3, 2 };

		int[] actual = SparseArraysService.run("sparse-arrays.txt");

		assertNotNull(actual);
		assertEquals(expected.length, actual.length);
		IntStream.range(0, expected.length).forEach(i -> {
			assertEquals(expected[i], actual[i]);
		});
	}

}
