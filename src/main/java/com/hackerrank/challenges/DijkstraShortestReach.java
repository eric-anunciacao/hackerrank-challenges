package com.hackerrank.challenges;

import java.util.List;

import com.hackerrank.service.DijkstraShortestReachService;

public class DijkstraShortestReach {

	private static final String FILE_NAME = "dijkstrashortreach.txt";

	public static void main(String[] args) {
		List<String> distances = DijkstraShortestReachService.run(FILE_NAME);
		distances.stream().forEach(System.out::println);
	}

}
