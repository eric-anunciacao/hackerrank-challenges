package com.hackerrank.challenges;

import java.util.List;

import com.hackerrank.util.FileUtils;

public class ArraysDS {

	public static void main(String[] args) {
		List<String> lines = FileUtils.getFileLines("arrays-ds.txt");
		if (!lines.isEmpty()) {
			int n = Integer.parseInt(lines.get(0));
			int[] a = FileUtils.getItems(lines, 1, n);
			int[] reverseArray = reverseArray(a);
			String output = "";
			for (int i = 0; i < n; i++) {
				output += reverseArray[i] + " ";
			}
			System.out.println(output.trim());
		}
	}

	static int[] reverseArray(int[] a) {
		int n = a.length;
		int[] reverseArray = new int[n];
		for (int i = 0; i < n; i++) {
			reverseArray[i] = a[n - 1 - i];
		}
		return reverseArray;
	}
}
