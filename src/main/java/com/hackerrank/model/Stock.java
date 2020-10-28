package com.hackerrank.model;

import java.util.List;

public class Stock {

	private int numberOfPrices;
	private List<Integer> prices;
	private long profit;

	public int getNumberOfPrices() {
		return numberOfPrices;
	}

	public void setNumberOfPrices(int numberOfPrices) {
		this.numberOfPrices = numberOfPrices;
	}

	public List<Integer> getPrices() {
		return prices;
	}

	public void setPrices(List<Integer> prices) {
		this.prices = prices;
	}

	public long getProfit() {
		return profit;
	}

	public void setProfit(long profit) {
		this.profit = profit;
	}

}
