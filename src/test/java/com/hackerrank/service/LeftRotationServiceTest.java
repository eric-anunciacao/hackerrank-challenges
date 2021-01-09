package com.hackerrank.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LeftRotationServiceTest {

	@Test
	void shouldDoLeftRotation() {
		assertEquals("5 1 2 3 4", LeftRotationService.run("array-left-rotation.txt"));
	}

}
