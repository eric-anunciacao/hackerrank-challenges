package com.hackerrank.service;

import java.util.List;
import java.util.stream.IntStream;

import com.hackerrank.util.FileUtils;

public class ArrayManipulationService {

	private ArrayManipulationService() {
	}

	public static long run(String fileName) {
		List<String> lines = FileUtils.getAllLinesFrom(fileName);
		if (!lines.isEmpty()) {
			List<Integer> items = FileUtils.getAllItemsFrom(lines, 0);
			if (items.size() == 2) {
				return maxValueOfArrayManipulation(lines, items);
			}
		}
		return 0;
	}

	private static long maxValueOfArrayManipulation(List<String> lines, List<Integer> items) {
		int arraySize = items.get(0);
		int numOfOperations = items.get(1);
		int[][] queries = new int[numOfOperations][3];
		IntStream.range(0, numOfOperations).forEach(i -> {
			List<Integer> itemsAux = FileUtils.getAllItemsFrom(lines, i + 1);
			IntStream.range(0, 3).forEach(j -> queries[i][j] = itemsAux.get(j));
		});
		return maxValueOfResultingArray(arraySize, queries);
	}

	private static long maxValueOfResultingArray(int arraySize, int[][] queries) {
		long[] array = new long[arraySize + 1];
		for (int i = 0; i < queries.length; i++) {
			int startingPosition = queries[i][0] - 1;
			int lastPosition = queries[i][1];
			long val = queries[i][2];
			array[startingPosition] += val;
			array[lastPosition] -= val;
		}

		return maxValueOf(array);
	}

	private static long maxValueOf(long[] array) {
		long maxVal = 0;
		long sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
			maxVal = Math.max(maxVal, sum);
		}
		return maxVal;
	}
}
