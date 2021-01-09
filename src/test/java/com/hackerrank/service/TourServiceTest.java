package com.hackerrank.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TourServiceTest {

	@Test
	void shouldReturnSmallestIndexOfTruckTour() {
		int expected = 573;

		int actual = TourService.run("truck-tour.txt");

		assertEquals(expected, actual);
	}

}
