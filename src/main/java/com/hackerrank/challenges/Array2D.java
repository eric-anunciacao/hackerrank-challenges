package com.hackerrank.challenges;

import java.util.List;
import java.util.stream.IntStream;

import com.hackerrank.service.Array2DService;
import com.hackerrank.util.FileUtils;

public class Array2D {

	public static void main(String[] args) {
		List<String> lines = FileUtils.getAllLinesFrom("2d-array.txt");
		if (!lines.isEmpty()) {
			int[][] array = new int[6][6];
			IntStream.range(0, 6).forEach(i -> {
				List<Integer> items = FileUtils.getAllItemsFrom(lines, i);
				IntStream.range(0, items.size()).forEach(j -> array[i][j] = items.get(j));
			});
			System.out.println(Array2DService.hourglassSum(array));
		}
	}
}
