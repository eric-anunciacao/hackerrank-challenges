package com.hackerrank.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import com.hackerrank.util.CollectionUtils;

class DynamicArrayServiceTest {

	@Test
	void shouldExecuteQuery() {
		List<Integer> expected = Arrays.asList(855677723, 75865401, 763845832, 75865401, 709571211, 645102173,
				112869154, 763845832, 449768243, 757848208, 91038209, 205970905, 783321829, 372160176, 384358662,
				67467208, 935143105, 384358662, 309720694, 138234911);

		List<Integer> actual = DynamicArrayService.run("dynamic-array.txt");

		assertNotNull(actual);
		assertFalse(CollectionUtils.isEmpty(actual));
		assertEquals(expected.size(), actual.size());
		IntStream.range(0, expected.size()).forEach(i -> {
			assertEquals(expected.get(i), actual.get(i));
		});
	}

}
