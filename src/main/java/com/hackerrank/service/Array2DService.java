package com.hackerrank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import com.hackerrank.util.FileUtils;

public class Array2DService {

	private Array2DService() {
	}

	public static int run(String fileName) {
		List<String> lines = FileUtils.getAllLinesFrom(fileName);
		if (!lines.isEmpty()) {
			int[][] array = new int[6][6];
			IntStream.range(0, 6).forEach(i -> {
				List<Integer> items = FileUtils.getAllItemsFrom(lines, i);
				IntStream.range(0, items.size()).forEach(j -> array[i][j] = items.get(j));
			});
			return maxHourglassSum(array);
		}
		return 0;
	}

	private static int maxHourglassSum(int[][] array) {
		List<Integer> sums = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (hasHourglassIn(i, j)) {
					int[][] hourglass = getHourglassFrom(array, i, j);
					int hourglassSum = hourglassSum(hourglass);
					sums.add(hourglassSum);
				}
			}
		}
		return sums.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);
	}

	private static boolean hasHourglassIn(int row, int column) {
		return row + 3 <= 6 && column + 3 <= 6;
	}

	private static int[][] getHourglassFrom(int[][] array, int startRowPosition, int startColumnPosition) {
		int[][] hourglass = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				hourglass[i][j] = array[i + startRowPosition][j + startColumnPosition];
			}
		}
		return hourglass;
	}

	private static int hourglassSum(int[][] array) {
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i != 1 || (i == 1 && j == 1)) {
					sum += array[i][j];
				}
			}
		}
		return sum;
	}

}
