package com.hackerrank.challenges;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.hackerrank.service.QuicksortService;
import com.hackerrank.util.FileUtils;

public class QuicksortInPlace {

	public static void main(String[] args) {
		List<String> lines = Optional.ofNullable(FileUtils.getFileLines("quicksort3.txt"))
				.orElse(Collections.emptyList());
		if (!lines.isEmpty()) {
			int n = Integer.parseInt(lines.get(0));
			int[] ar = FileUtils.getItems(lines, 1, n);
			QuicksortService.runQuickSort(ar, 0, n - 1);
		}
	}
}
