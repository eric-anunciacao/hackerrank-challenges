package com.hackerrank.challenges;

import java.util.List;

import com.hackerrank.service.ArraysDSService;
import com.hackerrank.util.FileUtils;

public class ArraysDS {

	public static void main(String[] args) {
		List<String> lines = FileUtils.getAllLinesFrom("arrays-ds.txt");
		if (!lines.isEmpty()) {
			int n = Integer.parseInt(lines.get(0));
			int[] a = FileUtils.getAllItemsFrom(lines, 1, n);
			int[] reverseArray = ArraysDSService.reverseArray(a);
			String output = "";
			for (int i = 0; i < n; i++) {
				output += reverseArray[i] + " ";
			}
			System.out.println(output.trim());
		}
	}
}
