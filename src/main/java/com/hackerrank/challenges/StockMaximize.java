package com.hackerrank.challenges;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.hackerrank.model.Stock;
import com.hackerrank.service.StockMaximizeService;
import com.hackerrank.util.FileUtils;

public class StockMaximize {

	public static void main(String[] args) {
		List<String> lines = Optional.ofNullable(FileUtils.getFileLines("stock-max.txt"))
				.orElse(Collections.emptyList());
		if (!lines.isEmpty()) {
			List<Stock> stocks = StockMaximizeService.getStocks(lines);
			stocks.stream().forEach(s -> {
				s.setProfit(getProfit(s.getPrices()));
				System.out.println(s.getProfit());
			});
		}
	}

	/**
	 * Returns the maximum achievable profit for reported prices.
	 * 
	 * @param prices {@link List} - List of predicted stock prices.
	 * @return integer value containing maximum achievable profit.
	 */
	private static long getProfit(List<Integer> prices) {
		long bought = 0;
		long quantityPurchased = 0;
		long sold = 0;
		boolean sell = false;
		for (int i = 0; i < prices.size(); i++) {
			Integer currentPrice = prices.get(i);
			if (hasNext(prices, i)) {
				int nextPosition = i + 1;
				Integer nextPrice = prices.get(nextPosition);
				if (hasHigherPrice(prices, currentPrice, nextPosition)) {
					bought += currentPrice;
					quantityPurchased++;
				} else if (currentPrice > nextPrice && quantityPurchased > 0) {
					sell = true;
				}
			} else if (quantityPurchased > 0) {
				sell = true;
			}

			if (sell) {
				sold += quantityPurchased * currentPrice;
				quantityPurchased = 0;
				sell = false;
			}
		}
		return sold - bought;
	}

	/**
	 * Verify if the next element in the list exists.
	 * 
	 * @param list     {@link List} - List of objects to be checked.
	 * @param position integer value containing the current position to be compared
	 *                 to list size.
	 * @return <tt>true</tt> if the next element exists.
	 */
	@SuppressWarnings("rawtypes")
	private static boolean hasNext(List list, int position) {
		return list.size() > position + 1;
	}

	/**
	 * Returns if there is a price higher than the current price.
	 * 
	 * @param prices       {@link List} - List of predicted stock prices.
	 * @param currentPrice integer value containing current price.
	 * @param position     integer value containing the position of the last
	 *                     verified price.
	 * @return <tt>true</tt> if there is a price higher than the current price.
	 */
	private static boolean hasHigherPrice(List<Integer> prices, int currentPrice, int position) {
		for (int i = position; i < prices.size(); i++) {
			if (currentPrice < prices.get(i)) {
				return true;
			}
		}
		return false;
	}
}
