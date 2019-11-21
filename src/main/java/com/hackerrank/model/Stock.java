package com.hackerrank.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class Stock {

	@Getter
	@Setter
	private int numberOfPrices;

	@Getter
	@Setter
	private List<Integer> prices;

	@Getter
	@Setter
	private long profit;
}
