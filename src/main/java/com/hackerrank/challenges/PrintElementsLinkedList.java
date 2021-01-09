package com.hackerrank.challenges;

import java.util.List;

import com.hackerrank.service.PrintElementsLinkedListService;

public class PrintElementsLinkedList {

	private static final String FILE_NAME = "print-the-elements-of-a-linked-list.txt";

	public static void main(String[] args) {
		List<Integer> results = PrintElementsLinkedListService.run(FILE_NAME);
		results.stream().forEach(System.out::println);
	}
}
