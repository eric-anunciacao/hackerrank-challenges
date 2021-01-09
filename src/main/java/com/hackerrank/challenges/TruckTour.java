package com.hackerrank.challenges;

import com.hackerrank.service.TourService;

public class TruckTour {

	private static final String FILE_NAME = "truck-tour.txt";

	public static void main(String[] args) {
		System.out.println(TourService.run(FILE_NAME));
	}

}
