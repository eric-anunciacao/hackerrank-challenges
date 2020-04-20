package com.hackerrank.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Stock {

	private int numberOfPrices;

	private List<Integer> prices;

	private long profit;
}
