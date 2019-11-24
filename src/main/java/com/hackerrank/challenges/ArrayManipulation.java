package com.hackerrank.challenges;

import java.util.List;

import com.hackerrank.service.ArrayManipulationService;
import com.hackerrank.util.FileUtils;

public class ArrayManipulation {

	public static void main(String[] args) {
		List<String> lines = FileUtils.getFileLines("array-manipulation.txt");
		if (!lines.isEmpty()) {
			ArrayManipulationService.run(lines);
		}
	}
}
