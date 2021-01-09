package com.hackerrank.challenges;

import java.util.List;

import com.hackerrank.service.JavaStackService;

public class JavaStack {

	private static final String FILE_NAME = "java-stack.txt";

	public static void main(String[] args) {
		List<Boolean> results = JavaStackService.run(FILE_NAME);
		results.stream().forEach(System.out::println);
	}
	
}
