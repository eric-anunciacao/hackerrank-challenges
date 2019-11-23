package com.hackerrank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.hackerrank.util.FileUtils;

public class DynamicArrayService {

	private static List<List<Integer>> seq = new ArrayList<>();
	private static int lastAnswer = 0;

	/**
	 * Execute a query that should be performed on one of the lists.
	 * 
	 * @param lines           {@link List} - List of lines presents in the file.
	 * @param sequences       integer value containing the number of sequences.
	 * @param numberOfQueries integer value containing the number of queries that
	 *                        must be performed.
	 */
	public static void executeQuery(List<String> lines, int sequences, int numberOfQueries) {
		initializateSeqList(sequences);
		IntStream.range(1, numberOfQueries + 1).forEach(i -> {
			List<Integer> items = FileUtils.getItems(lines, i);
			if (!items.isEmpty() && items.size() == 3) {
				int query = items.get(0);
				Integer x = items.get(1);
				Integer y = items.get(2);

				if (query == 1) {
					append(sequences, x, y);
				} else if (query == 2) {
					updateLastAnswer(sequences, x, y);
					System.out.println(lastAnswer);
				}
			}
		});
	}

	/**
	 * Method that was submited to hackerrank challenge.
	 * 
	 * @param sequences integer value containing the number of sequences.
	 * @param queries   {@link List} - List of queries that must be performed.
	 * @return {@link List} - List of all answers.
	 */
	public static List<Integer> dynamicArray(int sequences, List<List<Integer>> queries) {
		initializateSeqList(sequences);
		List<Integer> results = new ArrayList<>();
		for (List<Integer> items : queries) {
			if (!items.isEmpty() && items.size() == 3) {
				int query = items.get(0);
				Integer x = items.get(1);
				Integer y = items.get(2);

				if (query == 1) {
					append(sequences, x, y);
				} else if (query == 2) {
					updateLastAnswer(sequences, x, y);
					results.add(lastAnswer);
				}
			}
		}
		return results;
	}

	/**
	 * Initialize all items of the seqList.
	 * 
	 * @param sequences integer value containing the number of sequences.
	 */
	private static void initializateSeqList(int sequences) {
		IntStream.range(0, sequences).forEach(i -> seq.add(new ArrayList<>()));
	}

	/**
	 * Append the Integer y to sequence "seq".
	 * 
	 * @param sequences integer value containing the number of sequences.
	 * @param x         {@link Integer} - number that will be used to get the index
	 *                  of "seq" list.
	 * @param y         {@link Integer} - number that will be added to the "seq"
	 *                  list.
	 */
	private static void append(int sequences, Integer x, Integer y) {
		seq.get(getSeqIndex(sequences, x)).add(y);
	}

	/**
	 * Update the value of lastAnswer in the inner list of "seq" list.
	 * 
	 * @param sequences integer value containing the number of sequences.
	 * @param x         {@link Integer} - number that will be used to get the index
	 *                  of "seq" list.
	 * @param y         {@link Integer} - number that will be added to the "seq"
	 *                  list.
	 */
	private static void updateLastAnswer(int sequences, Integer x, Integer y) {
		int seqIndex = getSeqIndex(sequences, x);
		lastAnswer = seq.get(seqIndex).get(y % seq.get(seqIndex).size());
	}

	/**
	 * Returns the index that will be used to find the inner list of the "seq" list.
	 * 
	 * @param sequences integer value containing the number of sequences.
	 * @param x         {@link Integer} - number that will be used to get the index
	 *                  of "seq" list.
	 * @return integer value containing the index that will be used to find the
	 *         inner list of the "seq" list.
	 */
	private static int getSeqIndex(int sequences, Integer x) {
		return (x ^ lastAnswer) % sequences;
	}
}
