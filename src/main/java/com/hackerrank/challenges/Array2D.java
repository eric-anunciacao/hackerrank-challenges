package com.hackerrank.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Array2D {

	public static void main(String[] args) {
		int[][] array = new int[6][6];
		array[0][0] = 1;
		array[0][1] = 1;
		array[0][2] = 1;
		array[0][3] = 0;
		array[0][4] = 0;
		array[0][5] = 0;

		array[1][0] = 0;
		array[1][1] = 1;
		array[1][2] = 0;
		array[1][3] = 0;
		array[1][4] = 0;
		array[1][5] = 0;

		array[2][0] = 1;
		array[2][1] = 1;
		array[2][2] = 1;
		array[2][3] = 0;
		array[2][4] = 0;
		array[2][5] = 0;

		array[3][0] = 0;
		array[3][1] = 0;
		array[3][2] = 2;
		array[3][3] = 4;
		array[3][4] = 4;
		array[3][5] = 0;

		array[4][0] = 0;
		array[4][1] = 0;
		array[4][2] = 0;
		array[4][3] = 2;
		array[4][4] = 0;
		array[4][5] = 0;

		array[5][0] = 0;
		array[5][1] = 0;
		array[5][2] = 1;
		array[5][3] = 2;
		array[5][4] = 4;
		array[5][5] = 0;
		System.out.println(hourglassSum(array));
	}

	static int hourglassSum(int[][] arr) {
		List<Integer> sums = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (hasHourglass(i, j)) {
					sums.add(getSum(getHourglass(arr, i, j)));
				}
			}
		}
		return sums.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);
	}

	private static boolean hasHourglass(int i, int j) {
		return i + 3 <= 6 && j + 3 <= 6;
	}

	private static int getSum(int[][] array) {
		int sum = 0;
		int row = 0;
		int column = 0;
		for (int i = 0; i < 3; i++) {
			row++;
			column = 0;
			for (int j = 0; j < 3; j++) {
				column++;
				if (row != 2 || (row == 2 && column == 2)) {
					sum += array[i][j];
				}
			}
		}
		return sum;
	}

	private static int[][] getHourglass(int[][] array, int startRowPosition, int startColumnPosition) {
		int[][] hourglass = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				hourglass[i][j] = array[i + startRowPosition][j + startColumnPosition];
			}
		}
		return hourglass;
	}
}
