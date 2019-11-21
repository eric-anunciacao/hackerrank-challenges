package com.hackerrank.challenges;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.hackerrank.util.FileUtils;

public class DynamicArray {

	private static List<Integer> s0 = new ArrayList<>();
	private static List<Integer> s1 = new ArrayList<>();

	public static void main(String[] args) {
		List<String> lines = FileUtils.getFileLines("dynamic-array.txt");
		if (!lines.isEmpty()) {
			List<Integer> items = FileUtils.getItems(lines, 0);
			if (items.isEmpty() || items.size() < 2) {
				throw new RuntimeException("Não foi possivel recuperar os dados da primeira linha do arquivo.");
			}
			int n = items.get(0);
			int q = items.get(1);
			int lastAnswer = 0;

//			IntStream.range(1, q).forEach(i -> {
//				
//			});
			
//			List<Integer> results = getResults(n, )
		}
	}

	private static void append(int lastAnswer, int n, int x, int y) {
		int seqIndex = getSeqIndex(lastAnswer, n, x);
		if (seqIndex == 0) {
			s0.add(y);
		} else if (seqIndex == 1) {
			s1.add(y);
		}
	}

	private static int getLastAnswer(int lastAnswer, int n, int x, int y) {
		int seqIndex = getSeqIndex(lastAnswer, n, x);
		if (seqIndex == 0) {
			return y % s1.size();
		} else if (seqIndex == 1) {
			return y % s0.size();
		}
		return -1;
	}

	private static int getSeqIndex(int lastAnswer, int n, int x) {
		return (x ^ lastAnswer) % n;
	}

}
