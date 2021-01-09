package com.hackerrank.service;

import java.util.List;

import com.hackerrank.util.FileUtils;

public class ArraysDSService {

	private ArraysDSService() {
	}

	public static String run(String fileName) {
		StringBuilder output = new StringBuilder();
		List<String> lines = FileUtils.getAllLinesFrom(fileName);
		if (!lines.isEmpty()) {
			int arraySize = Integer.parseInt(lines.get(0));
			int[] array = FileUtils.getAllItemsFrom(lines, 1, arraySize);
			int[] reverseArray = reverseArray(array);
			for (int i = 0; i < arraySize; i++) {
				output.append(reverseArray[i]).append(" ");
			}
		}
		return output.toString().trim();
	}

	private static int[] reverseArray(int[] array) {
		int n = array.length;
		int[] reverseArray = new int[n];
		for (int i = 0; i < n; i++) {
			reverseArray[i] = array[n - 1 - i];
		}
		return reverseArray;
	}
}
