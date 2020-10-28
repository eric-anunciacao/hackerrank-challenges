package com.hackerrank.challenges;

import java.util.List;

import com.hackerrank.service.DynamicArrayService;
import com.hackerrank.util.FileUtils;

public class DynamicArray {

	public static void main(String[] args) {
		List<String> lines = FileUtils.getAllLinesFrom("dynamic-array.txt");
		if (!lines.isEmpty()) {
			List<Integer> items = FileUtils.getAllItemsFrom(lines, 0);
			if (items.isEmpty() || items.size() < 2) {
				throw new RuntimeException("Não foi possivel recuperar os dados da primeira linha do arquivo.");
			}
			int sequences = items.get(0);
			int queries = items.get(1);
			DynamicArrayService.executeQuery(lines, sequences, queries);
		}
	}
}
