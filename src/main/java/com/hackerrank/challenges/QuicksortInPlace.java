package com.hackerrank.challenges;

import java.util.List;

import com.hackerrank.service.QuicksortService;

public class QuicksortInPlace {

	private static final String FILE_NAME = "quicksort3.txt";

	public static void main(String[] args) {
		List<String> results = QuicksortService.run(FILE_NAME);
		results.stream().forEach(System.out::println);
	}

}
