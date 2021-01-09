package com.hackerrank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

import com.hackerrank.model.Stock;
import com.hackerrank.util.CollectionUtils;
import com.hackerrank.util.FileUtils;

public class StockMaximizeService {

	private StockMaximizeService() {
	}

	public static List<Long> run(String fileName) {
		List<Long> results = new ArrayList<>();
		List<String> lines = FileUtils.getAllLinesFrom(fileName);
		if (!lines.isEmpty()) {
			List<Stock> stocks = getStocks(lines);
			stocks.stream().forEach(s -> {
				s.setProfit(getMaximumAchievableProfitOf(s.getPrices()));
				results.add(s.getProfit());
			});
		}
		return results;
	}

	private static long getMaximumAchievableProfitOf(List<Integer> prices) {
		long bought = 0;
		long quantityPurchased = 0;
		long sold = 0;
		boolean sell = false;
		for (int i = 0; i < prices.size(); i++) {
			Integer currentPrice = prices.get(i);
			if (CollectionUtils.hasNextAfter(prices, i)) {
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

	private static boolean hasHigherPrice(List<Integer> prices, int currentPrice, int position) {
		for (int i = position; i < prices.size(); i++) {
			if (currentPrice < prices.get(i)) {
				return true;
			}
		}
		return false;
	}

	private static List<Stock> getStocks(List<String> lines) {
		int numberOfTestCases = Integer.parseInt(lines.get(0));
		int position = 0;
		List<Stock> stocks = new ArrayList<>();
		for (int i = 0; i < numberOfTestCases; i++) {
			Stock stock = new Stock();

			position++;
			int numberOfPredictedPrices = getNumberOfPredictedPrices(lines, position);
			stock.setNumberOfPrices(numberOfPredictedPrices);

			position++;
			List<Integer> prices = getPredictedPrices(lines, position);
			stock.setPrices(prices);

			stocks.add(stock);
		}
		return stocks;
	}

	private static int getNumberOfPredictedPrices(List<String> lines, int position) {
		String numberOfPrices = lines.get(position);
		try {
			return Integer.valueOf(numberOfPrices);
		} catch (NumberFormatException e) {
			throw new NumberFormatException(String.format("Error converting the number of prices: %s%n", e));
		}
	}

	private static List<Integer> getPredictedPrices(List<String> lines, int position) {
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
