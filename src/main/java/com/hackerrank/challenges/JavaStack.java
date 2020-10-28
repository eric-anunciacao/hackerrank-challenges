package com.hackerrank.challenges;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;

import com.hackerrank.util.FileUtils;

public class JavaStack {

	private static Map<Character, Character> patterns;

	public static void main(String[] args) {
		loadPatterns();
		List<String> lines = Optional.ofNullable(FileUtils.getAllLinesFrom("java-stack.txt"))
				.orElse(Collections.emptyList());
		if (!lines.isEmpty()) {
			lines.stream().forEach(l -> System.out.println(isBalanced(l)));
		}
	}

	/**
	 * Load string patterns.
	 */
	private static void loadPatterns() {
		patterns = new HashMap<Character, Character>();
		patterns.put(')', '(');
		patterns.put(']', '[');
		patterns.put('}', '{');
	}

	/**
	 * Returns if the string is balanced according to the rules:
	 * 
	 * <pre>
	 * 	1. if it is an empty string;
	 * 	2. if A and B are correct, AB is correct;
	 * 	3. if A is correct, (A) and {A} and [A] are also correct.
	 * </pre>
	 * 
	 * @param line {@link String} - Line of the file that should be checked.
	 * @return <tt>true</tt> if the string is balanced.
	 */
	private static boolean isBalanced(String line) {
		if (line.isEmpty()) {
			return true;
		}

		Stack<Character> stack = new Stack<Character>();
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
