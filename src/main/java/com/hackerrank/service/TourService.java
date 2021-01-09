package com.hackerrank.service;

import java.util.ArrayList;
import java.util.List;

import com.hackerrank.model.Tour;
import com.hackerrank.util.FileUtils;

public class TourService {

	private TourService() {
	}

	public static int run(String fileName) {
		List<String> lines = FileUtils.getAllLinesFrom(fileName);
		if (!lines.isEmpty()) {
			int n = Integer.parseInt(lines.get(0));
			List<Tour> tours = getTours(lines, n);
			return getSmallestIndexOfTruckTour(tours);
		}
		return 0;
	}

	private static List<Tour> getTours(List<String> lines, int n) {
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

	private static int getSmallestIndexOfTruckTour(List<Tour> tours) {
		int smallestIndex = 0;
		int over = 0;
		int position = 0;
		for (Tour tour : tours) {
			if (over + tour.getAmount() - tour.getDistance() < 0) {
				smallestIndex = position + 1;
				over = 0;
			} else {
				over += tour.getAmount() - tour.getDistance();
			}
			position++;
		}
		return smallestIndex;
	}
}
