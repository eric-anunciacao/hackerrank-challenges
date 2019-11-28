package com.hackerrank.challenges;

import java.util.List;

import com.hackerrank.service.PrintElementsLinkedListService;
import com.hackerrank.util.FileUtils;

public class PrintElementsLinkedList {

	public static void main(String[] args) {
		List<String> lines = FileUtils.getFileLines("print-the-elements-of-a-linked-list.txt");
		if (!lines.isEmpty()) {
			PrintElementsLinkedListService.printElements(lines);
		}
	}
}
