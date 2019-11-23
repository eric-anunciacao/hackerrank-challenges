package com.hackerrank.service;

public class ArraysDSService {

	/**
	 * Returns a reverse array.
	 * 
	 * @param a array with integer values;
	 * @return a reverse array of integer values.
	 */
	public static int[] reverseArray(int[] a) {
		int n = a.length;
		int[] reverseArray = new int[n];
		for (int i = 0; i < n; i++) {
			reverseArray[i] = a[n - 1 - i];
		}
		return reverseArray;
	}
}
