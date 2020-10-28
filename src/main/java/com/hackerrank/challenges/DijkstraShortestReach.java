package com.hackerrank.challenges;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.hackerrank.service.DijkstraShortestReachService;
import com.hackerrank.util.FileUtils;

public class DijkstraShortestReach {

	public static void main(String[] args) {
		List<String> lines = Optional.ofNullable(FileUtils.getAllLinesFrom("dijkstrashortreach.txt"))
				.orElse(Collections.emptyList());
		if (!lines.isEmpty()) {
			DijkstraShortestReachService.executeDijkstraShortestReach(lines);
		}
	}

}
