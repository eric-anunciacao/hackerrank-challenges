package com.hackerrank.util;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.hackerrank.configuration.exception.FileException;

class FileUtilsTest {

	@Test
	void shouldReturnAllLinesFromFile() {
		List<String> lines = FileUtils.getAllLinesFrom("array-manipulation.txt");

		assertNotNull(lines);
		assertEquals("4000 30000", lines.get(0));
	}

	@Test
	void shouldReturnErrorWhenFilenameIsNull() {
		FileException exception = assertThrows(FileException.class, () -> {
			FileUtils.getAllLinesFrom(null);
		});

		assertNotNull(exception);
		System.out.println(exception.getMessage());
		assertEquals(
				"FileException: java.io.FileNotFoundException: src/main/resources/files/null (No such file or directory)\n",
				exception.getMessage());
	}

	@Test
	void shouldReturnAllItemsFromFirstLine() {
		List<String> lines = FileUtils.getAllLinesFrom("array-manipulation.txt");
		List<Integer> items = FileUtils.getAllItemsFrom(lines, 0);

		assertAll("items",
				() -> assertNotNull(items),
				() -> assertFalse(items.isEmpty()),
				() -> assertEquals(4000, items.get(0)),
				() -> assertEquals(30000, items.get(1)));
	}
	
	@Test
	void shouldReturnEmptyListWhenLinesAreNull() {
		List<Integer> items = FileUtils.getAllItemsFrom(null, 0);
		
		assertAll("items",
				() -> assertNotNull(items),
				() -> assertTrue(items.isEmpty()));
	}

	@Test
	void shouldReturnArrayOfItemsFromFirstLine() {
		List<String> lines = FileUtils.getAllLinesFrom("arrays-ds.txt");
		int n = Integer.parseInt(lines.get(0));
		int[] array = FileUtils.getAllItemsFrom(lines, 1, n);

		assertAll("array",
				() -> assertNotNull(array),
				() -> assertEquals(4, array.length),
				() -> assertEquals(1, array[0]),
				() -> assertEquals(4, array[1]),
				() -> assertEquals(3, array[2]),
				() -> assertEquals(2, array[3]));
	}
	
	@Test
	void shouldReturnEmptyArrayWhenLinesAreNull() {
		int[] array = FileUtils.getAllItemsFrom(null, 0, 0);
		
		assertAll("array",
				() -> assertNotNull(array),
				() -> assertEquals(0, array.length));
	}

}
