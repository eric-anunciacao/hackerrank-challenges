package com.hackerrank.service;

import java.util.List;
import java.util.stream.IntStream;

import com.hackerrank.model.SinglyLinkedList;
import com.hackerrank.model.SinglyLinkedListNode;

public class PrintElementsLinkedListService {

	/**
	 * Reads the lines of file to print the integer data for each element of the
	 * linked list.
	 * 
	 * @param lines {@link List} - List of lines present in the file.
	 */
	public static void printElements(List<String> lines) {
		int numberOfItems = Integer.parseInt(lines.get(0));
		SinglyLinkedList linkedList = new SinglyLinkedList();
		IntStream.range(0, numberOfItems).forEach(i -> {
			linkedList.insertNode(Integer.parseInt(lines.get(i + 1)));
		});
		printLinkedList(linkedList.head);
	}

	/**
	 * Print the integer data for each element of the linked list.
	 * 
	 * @param head {@link SinglyLinkedListNode} - Linked list mounted from the file
	 *             reading.
	 */
	private static void printLinkedList(SinglyLinkedListNode head) {
		System.out.println(head.data);
		while (head.next != null) {
			System.out.println(head.next.data);
			head = head.next;
		}
	}
}
