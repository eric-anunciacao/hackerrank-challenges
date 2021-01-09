package com.hackerrank.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import com.hackerrank.util.CollectionUtils;
import com.hackerrank.util.FileUtils;
import com.hackerrank.util.StringUtils;

public class SparseArraysService {

	private SparseArraysService() {
	}

	public static int[] run(String fileName) {
		List<String> lines = FileUtils.getAllLinesFrom(fileName);
		if (!lines.isEmpty()) {
			return getNumberOfOccursForQueries(lines);
		}
		return new int[0];
	}

	private static int[] getNumberOfOccursForQueries(List<String> lines) {
		int numberOfStrings = Integer.parseInt(lines.get(0));
		String[] strings = getStringsFrom(lines, numberOfStrings);
		String[] queries = getQueriesFrom(lines, numberOfStrings);
		return matchingStrings(strings, queries);
	}

	private static String[] getStringsFrom(List<String> lines, int numberOfStrings) {
		String[] strings = new String[numberOfStrings];
		IntStream.range(0, numberOfStrings).forEach(i -> strings[i] = lines.get(i + 1));
		return strings;
	}

	private static String[] getQueriesFrom(List<String> lines, int numberOfStrings) {
		int numberOfQueries = Integer.parseInt(lines.get(numberOfStrings + 1));
		String[] queries = new String[numberOfQueries];
		IntStream.range(0, numberOfQueries).forEach(i -> queries[i] = lines.get(numberOfStrings + 2 + i));
		return queries;
	}

	private static int[] matchingStrings(String[] strings, String[] queries) {
		int[] results = new int[queries.length];
		IntStream.range(0, queries.length).forEach(i -> results[i] = getNumberOfResultsForQuery(strings, queries[i]));
		return results;
	}

	private static int getNumberOfResultsForQuery(String[] strings, String query) {
		if (CollectionUtils.isEmpty(strings) || StringUtils.isEmpty(query)) {
			return 0;
		}
		return (int) Arrays.stream(strings).filter(s -> s.equalsIgnoreCase(query)).count();
	}

}
