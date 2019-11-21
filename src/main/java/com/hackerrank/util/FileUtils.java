package com.hackerrank.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

public class FileUtils {

	private static final String FILE_DIR = "src/main/resources/files/";

	/**
	 * Returns a list of all lines of a file.
	 * 
	 * @param fileName {@link String} - Name of file to read.
	 * @return {@link List} - List of all lines of a file.
	 */
	@SuppressWarnings("resource")
	public static List<String> getFileLines(String fileName) {
		try {
			FileReader reader = new FileReader(FILE_DIR + fileName);
			BufferedReader br = new BufferedReader(reader);
			List<String> lines = new ArrayList<>();
			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
			return lines;
		} catch (IOException e) {
			throw new RuntimeException(String.format("IOException: %s%n", e));
		}
	}

	/**
	 * Returns items presents in a given line of the file.
	 * 
	 * @param lines        {@link List} - List of lines presents in the file.
	 * @param linePosition integer value containing file line position.
	 * @return {@link List} - List of items presents in a given line of the file.
	 */
	public static List<Integer> getItems(List<String> lines, int linePosition) {
		List<Integer> items = new ArrayList<>();
		StringTokenizer token = getTokens(lines, linePosition);
		while (token.hasMoreTokens()) {
			try {
				items.add(Integer.valueOf(token.nextToken()));
			} catch (NumberFormatException e) {
				throw new NumberFormatException(String.format("Error converting the items: %s%n", e));
			}
		}
		return items;
	}

	/**
	 * Returns items presents in a given line of the file.
	 * 
	 * @param lines        {@link List} - List of lines presents in the file.
	 * @param linePosition integer value containing file line position.
	 * @param n            integer value containing the array size.
	 * @return {@link List} - List of items presents in a given line of the file.
	 */
	public static int[] getItems(List<String> lines, int linePosition, int n) {
		int[] items = new int[n];
		StringTokenizer token = getTokens(lines, linePosition);
		int i = 0;
		while (token.hasMoreTokens()) {
			try {
				items[i] = Integer.valueOf(token.nextToken());
				i++;
			} catch (NumberFormatException e) {
				throw new NumberFormatException(String.format("Error converting the items: %s%n", e));
			}
		}
		return items;
	}

	/**
	 * Returns separate items from the file line.
	 * 
	 * @param lines        {@link List} - List of lines presents in the file.
	 * @param linePosition integer value containing file line position.
	 * @return {@link StringTokenizer} - Separate items from the file line.
	 */
	private static StringTokenizer getTokens(List<String> lines, int linePosition) {
		String allItems = Optional.ofNullable(lines.get(linePosition)).orElse("");
		return new StringTokenizer(allItems, " ");
	}

}
