package com.hackerrank.challenges;

import java.util.List;

import com.hackerrank.service.DynamicArrayService;

public class DynamicArray {

	private static final String FILE_NAME = "dynamic-array.txt";

	public static void main(String[] args) {
		List<Integer> results = DynamicArrayService.run(FILE_NAME);
		results.stream().forEach(System.out::println);
	}

}
