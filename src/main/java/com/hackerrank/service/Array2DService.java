package com.hackerrank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Array2DService {

	/**
	 * Returns the max value of hourglass sum.
	 * 
	 * @param array - 2D array containing integer values.
	 * @return integer value containing the max value of hourglass sum.
	 */
	public static int hourglassSum(int[][] array) {
		List<Integer> sums = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (hasHourglass(i, j)) {
					sums.add(getSum(getHourglass(array, i, j)));
				}
			}
		}
		return sums.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);
	}

	/**
	 * Verify if exists a hourglass in this "row" and "column" position of 2d array.
	 * 
	 * @param row    integer value containing the row position.
	 * @param column integer value containing the column position.
	 * @return <tt>true</tt> if exists a hourglass in this "row" and "column"
	 *         position of 2d array.
	 */
	private static boolean hasHourglass(int row, int column) {
		return row + 3 <= 6 && column + 3 <= 6;
	}

	/**
	 * Returns the sum of a hourglass.
	 * 
	 * @param array - 2D array containing integer values.
	 * @return integer value containing the sum of a hourglass.
	 */
	private static int getSum(int[][] array) {
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i != 1 || (i == 1 && j == 1)) {
					sum += array[i][j];
				}
			}
		}
		return sum;
	}

	/**
	 * Returns a 2D array based in a row and column positions informed.
	 * 
	 * @param array               - 2D array containing integer values.
	 * @param startRowPosition    integer value containing the initial row position
	 *                            of a 2D array that will be returned.
	 * @param startColumnPosition integer value containing the initial column
	 *                            position of a 2D array that will be returned.
	 * @return 2D array based in a row and column positions informed.
	 */
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
