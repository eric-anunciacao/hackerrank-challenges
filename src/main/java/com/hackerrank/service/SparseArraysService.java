package com.hackerrank.service;

import java.util.List;
import java.util.stream.IntStream;

public class SparseArraysService {

	/**
	 * Execute queries to determine how many times it occurs in the list of input
	 * strings.
	 * 
	 * @param lines {@link List} - List of lines present in the file.
	 */
	public static void executeQueries(List<String> lines) {
		int numberOfStrings = Integer.valueOf(lines.get(0));
		int numberOfQueries = Integer.valueOf(lines.get(numberOfStrings + 1));
		String[] strings = new String[numberOfStrings];
		String[] queries = new String[numberOfQueries];
		IntStream.range(0, numberOfStrings).forEach(i -> strings[i] = lines.get(i + 1));
		IntStream.range(0, numberOfQueries).forEach(i -> queries[i] = lines.get(numberOfStrings + 2 + i));
		int[] results = matchingStrings(strings, queries);
		IntStream.range(0, results.length).forEach(i -> System.out.println(results[i]));
	}

	/**
	 * Returns an array of integers representing the frequency of occurrence of each
	 * query string in strings.
	 * 
	 * @param strings {@link String} - Array of strings to search.
	 * @param queries {@link String} - Array of query strings.
	 * @return an array of integers representing the frequency of occurrence of each
	 *         query string in strings.
	 */
	private static int[] matchingStrings(String[] strings, String[] queries) {
		int[] results = new int[queries.length];
		IntStream.range(0, queries.length).forEach(i -> results[i] = getNumberOfResults(strings, queries[i]));
		return results;
	}

	/**
	 * Returns the number of occurrences for the informed query.
	 * 
	 * @param strings {@link String} - Array of strings to search.
	 * @param query   {@link String} - Query that will be find in array.
	 * @return integer value containing the number of occurrences for the informed
	 *         query.
	 */
	private static int getNumberOfResults(String[] strings, String query) {
		int numberOfResults = 0;
		for (int i = 0; i < strings.length; i++) {
			if (query.equalsIgnoreCase(strings[i])) {
				numberOfResults++;
			}
		}
		return numberOfResults;
	}

}
