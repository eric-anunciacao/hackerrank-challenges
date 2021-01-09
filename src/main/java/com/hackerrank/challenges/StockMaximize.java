package com.hackerrank.challenges;

import java.util.List;

import com.hackerrank.service.StockMaximizeService;

public class StockMaximize {

	private static final String FILE_NAME = "stock-max.txt";

	public static void main(String[] args) {
		List<Long> results = StockMaximizeService.run(FILE_NAME);
		results.stream().forEach(System.out::println);
	}

}
