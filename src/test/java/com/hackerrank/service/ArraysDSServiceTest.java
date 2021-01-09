package com.hackerrank.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArraysDSServiceTest {

	@Test
	void shouldRevertArray() {
		assertEquals("2 3 4 1", ArraysDSService.run("arrays-ds.txt"));
	}

}
