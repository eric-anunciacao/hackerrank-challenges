package com.hackerrank.challenges;

import java.util.List;

import com.hackerrank.service.LeftRotationService;
import com.hackerrank.util.FileUtils;

public class ArrayLeftRotation {

	public static void main(String[] args) {
		List<String> lines = FileUtils.getFileLines("array-left-rotation.txt");
		if (!lines.isEmpty()) {
			List<Integer> items = FileUtils.getItems(lines, 0);
			if (!items.isEmpty() && items.size() == 2) {
				int d = items.get(1);
				items = FileUtils.getItems(lines, 1);
				LeftRotationService.doLeftRotation(items, d);
			}
		}
	}
}
