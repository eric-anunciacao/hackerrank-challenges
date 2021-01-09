package com.hackerrank.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import com.hackerrank.util.FileUtils;

public class DynamicArrayService {

	private static List<List<Integer>> sequences = new ArrayList<>();
	private static int lastAnswer = 0;

	private DynamicArrayService() {
	}

	public static List<Integer> run(String fileName) {
		List<String> lines = FileUtils.getAllLinesFrom(fileName);
		if (!lines.isEmpty()) {
			List<Integer> items = FileUtils.getAllItemsFrom(lines, 0);
			if (!items.isEmpty() && items.size() == 2) {
				int sequences = items.get(0);
				int queries = items.get(1);
				return executeQuery(lines, sequences, queries);
			}
		}
		return Collections.emptyList();
	}

	private static List<Integer> executeQuery(List<String> lines, int numberOfSequences, int numberOfQueries) {
		List<Integer> results = new ArrayList<>();
		initializeSequences(numberOfSequences);
		IntStream.range(1, numberOfQueries + 1).forEach(i -> {
			List<Integer> items = FileUtils.getAllItemsFrom(lines, i);
			if (!items.isEmpty() && items.size() == 3) {
				int query = items.get(0);
				Integer index = items.get(1);
				Integer valueToAdd = items.get(2);

				if (query == 1) {
					append(numberOfSequences, index, valueToAdd);
				} else if (query == 2) {
					updateLastAnswer(numberOfSequences, index, valueToAdd);
					results.add(lastAnswer);
				}
			}
		});
		return results;
	}

	private static void initializeSequences(int numberOfSequences) {
		IntStream.range(0, numberOfSequences).forEach(i -> sequences.add(new ArrayList<>()));
	}

	private static void append(int numberOfSequences, Integer index, Integer valueToAdd) {
		int sequenceIndex = sequenceIndexOf(numberOfSequences, index);
		sequences.get(sequenceIndex).add(valueToAdd);
	}

	private static void updateLastAnswer(int numberOfSequences, Integer index, Integer valueToAdd) {
		int sequenceIndex = sequenceIndexOf(numberOfSequences, index);
		lastAnswer = sequences.get(sequenceIndex).get(valueToAdd % sequences.get(sequenceIndex).size());
	}

	private static int sequenceIndexOf(int numberOfSequences, Integer index) {
		return (index ^ lastAnswer) % numberOfSequences;
	}
}
