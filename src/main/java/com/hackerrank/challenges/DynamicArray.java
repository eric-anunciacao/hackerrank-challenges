package com.hackerrank.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.hackerrank.util.FileUtils;

public class DynamicArray {

	private static List<Integer> s0 = new ArrayList<>();
	private static List<Integer> s1 = new ArrayList<>();
	private static int lastAnswer = 0;

	public static void main(String[] args) {
		List<String> lines = FileUtils.getFileLines("dynamic-array.txt");
		if (!lines.isEmpty()) {
			List<Integer> items = FileUtils.getItems(lines, 0);
			if (items.isEmpty() || items.size() < 2) {
				throw new RuntimeException("Não foi possivel recuperar os dados da primeira linha do arquivo.");
			}
			int n = items.get(0);
			int q = items.get(1);
			executeQuery(lines, n, q);
		}
	}

	private static void executeQuery(List<String> lines, int n, int q) {
		IntStream.range(1, q + 1).forEach(i -> {
			List<Integer> items = FileUtils.getItems(lines, i);
			if (!items.isEmpty() && items.size() == 3) {
				int query = items.get(0);
				Integer x = items.get(1);
				Integer y = items.get(2);

				if (query == 1) {
					append(n, x, y);
				} else if (query == 2) {
					updateLastAnswer(n, x, y);
					System.out.println(lastAnswer);
				}
			}
		});
	}
	
	public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
		List<Integer> results = new ArrayList<>();
		for (List<Integer> items : queries) {
			if (!items.isEmpty() && items.size() == 3) {
				int query = items.get(0);
				Integer x = items.get(1);
				Integer y = items.get(2);
				
				if (query == 1) {
					append(n, x, y);
				} else if (query == 2) {
					updateLastAnswer(n, x, y);
					results.add(lastAnswer);
				}
			}
		}
		return results;
	}

	private static void append(Integer n, Integer x, Integer y) {
		int seqIndex = getSeqIndex(n, x);
		if (seqIndex == 0) {
			s0.add(y);
		} else if (seqIndex == 1) {
			s1.add(y);
		}
	}

	private static void updateLastAnswer(Integer n, Integer x, Integer y) {
		Integer seqIndex = getSeqIndex(n, x);
		if (seqIndex == 0) {
			lastAnswer = s0.get(y % s0.size());
		} else if (seqIndex == 1) {
			lastAnswer = s1.get(y % s1.size());
		} else {
			lastAnswer = -1;
		}
	}

	private static int getSeqIndex(Integer n, Integer x) {
		return (x ^ lastAnswer) % n;
	}

}
