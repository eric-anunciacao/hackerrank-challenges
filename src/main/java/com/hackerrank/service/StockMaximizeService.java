package com.hackerrank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

import com.hackerrank.model.Stock;

public class StockMaximizeService {

	/**
	 * Returns a list of stocks from the file lines.
	 * 
	 * @param lines {@link List} - List of lines present in the file.
	 * @return {@link List} - List of stocks from the file lines.
	 */
	public static List<Stock> getStocks(List<String> lines) {
		int numberOfTestCases = Integer.valueOf(lines.get(0));
		int position = 0;
		List<Stock> stocks = new ArrayList<>();
		for (int i = 0; i < numberOfTestCases; i++) {
			Stock stock = new Stock();
			position++;
			stock.setNumberOfPrices(getNumberOfPrices(lines, position));
			position++;
			stock.setPrices(getPrices(lines, position));
			stocks.add(stock);
		}
		return stocks;
	}

	/**
	 * Returns the number of predicted prices of a stock.
	 * 
	 * @param lines    {@link List} - List of lines present in the file.
	 * @param position integer value containing the position of the number of
	 *                 predicted prices of a stock in lines list.
	 * @return integer value containing the number of predicted prices of a stock.
	 */
	private static int getNumberOfPrices(List<String> lines, int position) {
		String numberOfPrices = lines.get(position);
		try {
			return Integer.valueOf(numberOfPrices);
		} catch (NumberFormatException e) {
			throw new NumberFormatException(String.format("Error converting the number of prices: %s%n", e));
		}
	}

	/**
	 * Returns a list containing the predicted prices of a stock.
	 * 
	 * @param lines    {@link List} - List of lines present in the file.
	 * @param position integer value containing the position of predicted prices of
	 *                 a stock in lines list.
	 * @return {@link List} - List containing the predicted prices of a stock.
	 */
	private static List<Integer> getPrices(List<String> lines, int position) {
		List<Integer> prices = new ArrayList<>();
		String allPrices = Optional.ofNullable(lines.get(position)).orElse("");
		StringTokenizer token = new StringTokenizer(allPrices, " ");
		while (token.hasMoreTokens()) {
			try {
				prices.add(Integer.valueOf(token.nextToken()));
			} catch (NumberFormatException e) {
				throw new NumberFormatException(String.format("Error converting the prices: %s%n", e));
			}
		}
		return prices;
	}
}
