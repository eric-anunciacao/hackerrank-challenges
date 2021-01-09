package com.hackerrank.challenges;

import java.util.Arrays;

import com.hackerrank.service.SparseArraysService;

public class SparseArrays {

	private static final String FILE_NAME = "sparse-arrays.txt";

	public static void main(String[] args) {
		int[] results = SparseArraysService.run(FILE_NAME);
		Arrays.stream(results).forEach(System.out::println);
	}

}
