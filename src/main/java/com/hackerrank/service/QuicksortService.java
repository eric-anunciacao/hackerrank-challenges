package com.hackerrank.service;

public class QuicksortService {

	/**
	 * Runs Quicksort Algorithm implementation.
	 * 
	 * @param ar    array of integers that must be ordered.
	 * @param begin integer value containing the starting position to be considered
	 *              for array ordering.
	 * @param end   integer value containing the final position to be considered for
	 *              array ordering.
	 */
	public static void runQuickSort(int[] ar, int begin, int end) {
		if (begin < end) {
			int partitionIndex = partition(ar, begin, end);
			String output = "";
			for (int i = 0; i < ar.length; i++) {
				output += ar[i] + " ";
			}
			System.out.println(output);
			runQuickSort(ar, begin, partitionIndex - 1);
			runQuickSort(ar, partitionIndex + 1, end);
		}
	}

	/**
	 * Takes the last element as the pivot, checks each element and swaps it before
	 * the pivot if its value is smaller.
	 * 
	 * @param ar    array of integers that must be ordered.
	 * @param begin integer value containing the starting position to be considered
	 *              for array ordering.
	 * @param end   integer value containing the final position to be considered for
	 *              array ordering.
	 * @return integer value containing the final pivot position.
	 */
	private static int partition(int ar[], int begin, int end) {
		int pivot = ar[end];
		int i = (begin - 1);
		for (int j = begin; j < end; j++) {
			if (ar[j] <= pivot) {
				i++;
				int swap = ar[i];
				ar[i] = ar[j];
				ar[j] = swap;
			}
		}
		int swap = ar[i + 1];
		ar[i + 1] = ar[end];
		ar[end] = swap;
		return i + 1;
	}
}
