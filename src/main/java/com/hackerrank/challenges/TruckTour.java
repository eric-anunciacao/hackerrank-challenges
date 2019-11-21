package com.hackerrank.challenges;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.hackerrank.model.Tour;
import com.hackerrank.service.TourService;
import com.hackerrank.util.FileUtils;

public class TruckTour {

	public static void main(String[] args) {
		List<String> lines = Optional.ofNullable(FileUtils.getFileLines("truck-tour.txt"))
				.orElse(Collections.emptyList());
		if (!lines.isEmpty()) {
			int n = Integer.parseInt(lines.get(0));
			List<Tour> tours = TourService.getTours(lines, n);
			System.out.println(truckTour(tours));
		}
	}

	/**
	 * Returns an integer which will be the smallest index of the petrol pump from
	 * which we can start the tour.
	 * 
	 * @param tours {@link List} - List containing the distances traveled by the
	 *              truck.
	 * @return integer which will be the smallest index of the petrol pump from
	 *         which we can start the tour.
	 */
	private static int truckTour(List<Tour> tours) {
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
