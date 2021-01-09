package com.hackerrank.service;

import java.util.List;
import java.util.stream.IntStream;

import com.hackerrank.util.FileUtils;

public class LeftRotationService {

	private LeftRotationService() {
	}

	public static String run(String fileName) {
		List<String> lines = FileUtils.getAllLinesFrom(fileName);
		if (!lines.isEmpty()) {
			List<Integer> items = FileUtils.getAllItemsFrom(lines, 0);
			if (!items.isEmpty() && items.size() == 2) {
				int numOfRotations = items.get(1);
				int position = 1;
				items = FileUtils.getAllItemsFrom(lines, position);
				return doLeftRotationIn(items, numOfRotations);
			}
		}
		return "";
	}

	private static String doLeftRotationIn(List<Integer> items, int numberOfrotations) {
		IntStream.range(0, numberOfrotations).forEach(i -> {
			items.add(items.get(0));
			items.remove(0);
		});
		return items.toString().replaceAll("\\[", "").replaceAll(",", "").replaceAll("\\]", "");
	}
}
