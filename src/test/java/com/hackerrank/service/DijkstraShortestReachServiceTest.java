package com.hackerrank.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import com.hackerrank.util.CollectionUtils;

class DijkstraShortestReachServiceTest {

	@Test
	void shouldReturnShortestDistances() {
		List<String> expected = Arrays.asList("10 16 8 -1");

		List<String> actual = DijkstraShortestReachService.run("dijkstrashortreach.txt");

		assertNotNull(actual);
		assertFalse(CollectionUtils.isEmpty(actual));
		assertEquals(expected.size(), actual.size());
		IntStream.range(0, expected.size()).forEach(i -> {
			assertEquals(expected.get(i), actual.get(i));
		});
	}

}
