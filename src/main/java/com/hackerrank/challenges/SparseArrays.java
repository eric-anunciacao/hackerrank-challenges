package com.hackerrank.challenges;

import java.util.List;

import com.hackerrank.service.SparseArraysService;
import com.hackerrank.util.FileUtils;

public class SparseArrays {

	public static void main(String[] args) {
		List<String> lines = FileUtils.getAllLinesFrom("sparse-arrays.txt");
		if (!lines.isEmpty()) {
			SparseArraysService.executeQueries(lines);
		}
	}
}
