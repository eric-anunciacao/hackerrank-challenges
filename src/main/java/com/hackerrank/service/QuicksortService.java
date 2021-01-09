package com.hackerrank.service;

import java.util.ArrayList;
import java.util.List;

import com.hackerrank.util.FileUtils;

public class QuicksortService {

	private static List<String> results = new ArrayList<>();

	private QuicksortService() {
	}

	public static List<String> run(String fileName) {
		List<String> lines = FileUtils.getAllLinesFrom(fileName);
		if (!lines.isEmpty()) {
			int numberOfItems = Integer.parseInt(lines.get(0));
			int[] array = FileUtils.getAllItemsFrom(lines, 1, numberOfItems);
			runQuickSort(array, 0, numberOfItems - 1);
		}
		return results;
	}

	private static void runQuickSort(int[] array, int begin, int end) {
		if (begin < end) {
			int partitionIndex = partitionIndex(array, begin, end);
			extractResultFrom(array);
			runQuickSort(array, begin, partitionIndex - 1);
			runQuickSort(array, partitionIndex + 1, end);
		}
	}

	private static int partitionIndex(int[] array, int begin, int end) {
		int pivot = array[end];
		int i = begin - 1;
		for (int j = begin; j < end; j++) {
			if (array[j] <= pivot) {
				i++;
				int swap = array[i];
				array[i] = array[j];
				array[j] = swap;
			}
		}
		int swap = array[i + 1];
		array[i + 1] = array[end];
		array[end] = swap;
		return i + 1;
	}

	private static void extractResultFrom(int[] array) {
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			output.append(array[i]).append(" ");
		}
		results.add(output.toString().trim());
	}
}
