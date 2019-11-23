package com.hackerrank.service;

import java.util.List;
import java.util.stream.IntStream;

public class LeftRotationService {

	/**
	 * Perform the left rotation in array.
	 * 
	 * @param items             {@link List} - List of items.
	 * @param numberOfrotations integer value containing the number of left
	 *                          rotations
	 */
	public static void doLeftRotation(List<Integer> items, int numberOfrotations) {
		IntStream.range(0, numberOfrotations).forEach(i -> {
			items.add(items.get(0));
			items.remove(items.get(0));
		});
		System.out.println(items.toString().replaceAll("\\[", "").replaceAll(",", "").replaceAll("\\]", ""));
	}
}
