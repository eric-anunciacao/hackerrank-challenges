package com.hackerrank.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import com.hackerrank.model.SinglyLinkedList;
import com.hackerrank.model.SinglyLinkedListNode;
import com.hackerrank.util.FileUtils;

public class PrintElementsLinkedListService {

	private PrintElementsLinkedListService() {
	}

	public static List<Integer> run(String fileName) {
		List<String> lines = FileUtils.getAllLinesFrom(fileName);
		if (!lines.isEmpty()) {
			return getLinkedList(lines);
		}
		return Collections.emptyList();
	}

	private static List<Integer> getLinkedList(List<String> lines) {
		int numberOfItems = Integer.parseInt(lines.get(0));
		SinglyLinkedList linkedList = new SinglyLinkedList();
		IntStream.range(0, numberOfItems).forEach(i -> linkedList.insertNode(Integer.parseInt(lines.get(i + 1))));
		return getLinkedListFrom(linkedList.head);
	}

	private static List<Integer> getLinkedListFrom(SinglyLinkedListNode head) {
		List<Integer> results = new ArrayList<>();
		results.add(head.data);
		while (head.next != null) {
			results.add(head.next.data);
			head = head.next;
		}
		return results;
	}
}
