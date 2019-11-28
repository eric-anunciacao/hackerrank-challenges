package com.hackerrank.service;

import java.util.List;
import java.util.stream.IntStream;

import com.hackerrank.util.FileUtils;

public class ArrayManipulationService {

	/**
	 * Execute the array manipulation and return the maximum value in the resulting
	 * array.
	 * 
	 * @param lines {@link List} - List of lines present in the file.
	 */
	public static void run(List<String> lines) {
		List<Integer> items = FileUtils.getItems(lines, 0);
		if (items.size() == 2) {
			int arraySize = items.get(0);
			int numOfOperations = items.get(1);
			int[][] queries = new int[numOfOperations][3];
			IntStream.range(0, numOfOperations).forEach(i -> {
				List<Integer> itemsAux = FileUtils.getItems(lines, i + 1);
				IntStream.range(0, 3).forEach(j -> queries[i][j] = itemsAux.get(j));
			});
			System.out.println(ArrayManipulationService.arrayManipulation(arraySize, queries));
		}
	}

	/**
	 * Returns the maximum value in the resulting array.
	 * 
	 * @param arraySize integer value containing array size.
	 * @param queries   array of integer values containing the queries.
	 * @return long value containing the maximum value in the resulting array.
	 */
	private static long arrayManipulation(int arraySize, int[][] queries) {
		long array[] = new long[arraySize + 1];
		long maxVal = 0;
		long sum = 0;
		for (int i = 0; i < queries.length; i++) {
			int startingPosition = queries[i][0] - 1;
			int lastPosition = queries[i][1];
			long val = queries[i][2];
			array[startingPosition] += val;
			array[lastPosition] -= val;
		}

		for (int i = 0; i < array.length; i++) {
			sum += array[i];
			maxVal = Math.max(maxVal, sum);
		}
		return maxVal;
	}
}
