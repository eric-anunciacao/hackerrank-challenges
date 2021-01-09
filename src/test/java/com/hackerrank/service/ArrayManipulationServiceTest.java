package com.hackerrank.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayManipulationServiceTest {

	@Test
	void shouldReturnMaxValueOfArrayManipulation() {
		assertEquals(7542539201L, ArrayManipulationService.run("array-manipulation.txt"));
	}

}
