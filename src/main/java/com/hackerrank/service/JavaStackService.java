package com.hackerrank.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.hackerrank.util.FileUtils;

public class JavaStackService {

	private static Map<Character, Character> patterns;

	private JavaStackService() {
	}

	public static List<Boolean> run(String fileName) {
		List<Boolean> results = new ArrayList<>();
		loadPatterns();
		List<String> lines = FileUtils.getAllLinesFrom(fileName);
		if (!lines.isEmpty()) {
			lines.stream().map(JavaStackService::isBalanced).forEach(results::add);
		}
		return results;
	}

	private static void loadPatterns() {
		patterns = new HashMap<>();
		patterns.put(')', '(');
		patterns.put(']', '[');
		patterns.put('}', '{');
	}

	private static boolean isBalanced(String line) {
		if (line.isEmpty()) {
			return true;
		}

		Stack<Character> stack = new Stack<>();
		for (Character c : line.toCharArray()) {
			if (!stack.isEmpty() && stack.peek().equals(patterns.get(c))) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}

		return stack.isEmpty();
	}
}
