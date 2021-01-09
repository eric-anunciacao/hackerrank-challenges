package com.hackerrank.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Array2DServiceTest {

	@Test
	void shouldReturnMaxHourglassSum() {
		assertEquals(19, Array2DService.run("2d-array.txt"));
	}

}
