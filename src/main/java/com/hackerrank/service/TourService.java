package com.hackerrank.service;

import java.util.ArrayList;
import java.util.List;

import com.hackerrank.model.Tour;
import com.hackerrank.util.FileUtils;

public class TourService {

	/**
	 * Returns to the list of truck tours.
	 * 
	 * @param lines {@link List} - List of lines present in the file.
	 * @param n     integer value containing the number of petrol pumps.
	 * @return {@link List} - List containing the distances traveled by the truck.
	 */
	public static List<Tour> getTours(List<String> lines, int n) {
		List<Tour> tours = new ArrayList<>();
		for (int i = 1; i < n; i++) {
			List<Integer> items = FileUtils.getAllItemsFrom(lines, i);
			Tour tour = new Tour();
			tour.setAmount(items.get(0));
			tour.setDistance(items.get(1));
			tours.add(tour);
		}
		return tours;
	}
}
