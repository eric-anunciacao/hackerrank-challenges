package com.hackerrank.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import com.hackerrank.configuration.exception.FileException;

public class FileUtils {

	private static final String DELIM = " ";
	private static final String FILE_DIR = "src/main/resources/files/";

	private FileUtils() {
	}

	public static List<String> getAllLinesFrom(String fileName) {
		try (FileReader reader = new FileReader(FILE_DIR + fileName); BufferedReader br = new BufferedReader(reader)) {
			List<String> lines = new ArrayList<>();
			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
			return lines;
		} catch (IOException e) {
			throw new FileException(String.format("FileException: %s%n", e));
		}
	}

	public static List<Integer> getAllItemsFrom(List<String> lines, int position) {
		StringTokenizer tokenizer = getTokenFrom(lines, position);
		return Collections.list(tokenizer).stream().map(token -> Integer.valueOf(token.toString()))
				.collect(Collectors.toList());
	}

	public static int[] getAllItemsFrom(List<String> lines, int position, int arraySize) {
		int[] items = new int[arraySize];
		StringTokenizer token = getTokenFrom(lines, position);
		int i = 0;
		while (token.hasMoreTokens()) {
			items[i] = getIntegerValueOf(token);
			i++;
		}
		return items;
	}

	private static Integer getIntegerValueOf(StringTokenizer token) {
		try {
			return Integer.valueOf(token.nextToken());
		} catch (NumberFormatException e) {
			throw new NumberFormatException(String.format("Error converting the items: %s%n", e));
		}
	}

	private static StringTokenizer getTokenFrom(List<String> lines, int position) {
		String allItems = Optional.ofNullable(lines.get(position)).orElse("");
		return new StringTokenizer(allItems, DELIM);
	}

}
