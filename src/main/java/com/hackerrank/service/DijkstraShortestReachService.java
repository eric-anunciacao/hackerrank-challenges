package com.hackerrank.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hackerrank.model.DijkstraShortReach;
import com.hackerrank.util.FileUtils;

public class DijkstraShortestReachService {

	private DijkstraShortestReachService() {
	}

	public static List<String> run(String fileName) {
		List<String> lines = FileUtils.getAllLinesFrom(fileName);
		if (!lines.isEmpty()) {
			return shortestDistances(lines);
		}
		return Collections.emptyList();
	}

	private static List<String> shortestDistances(List<String> lines) {
		List<String> distances = new ArrayList<>();
		int numberOfTestCases = Integer.parseInt(lines.get(0));
		int linePosition = 0;
		for (int i = 0; i < numberOfTestCases; i++) {
			linePosition++;
			DijkstraShortReach model = loadNodesInfosOf(lines, linePosition);
			int[][] edges = edgesWithTheirWeights(model, lines);
			linePosition = model.getLastPosition();
			Map<Integer, Integer> visitedNodes = getVisitedNodesWithDistanceTraveled(model, edges);
			String shortestDistances = shortestDistances(model.getNumberOfNodes(), visitedNodes,
					model.getStartingPosition());
			distances.add(shortestDistances);
		}
		return distances;
	}

	private static DijkstraShortReach loadNodesInfosOf(List<String> lines, int linePosition) {
		List<Integer> items = FileUtils.getAllItemsFrom(lines, linePosition);
		DijkstraShortReach model = new DijkstraShortReach();
		model.setLastPosition(linePosition);
		if (items.size() > 1) {
			model.setNumberOfNodes(items.get(0));
			model.setNumberOfEdges(items.get(1));
		}
		return model;
	}

	private static int[][] edgesWithTheirWeights(DijkstraShortReach model, List<String> lines) {
		int[][] edges = initializeEdges(model.getNumberOfNodes());
		for (String l : lines) {
			model.setLastPosition(model.getLastPosition() + 1);
			List<Integer> list = FileUtils.getAllItemsFrom(lines, model.getLastPosition());
			if (list.size() == 3) {
				int weight = list.get(2);
				int n = list.get(0) - 1;
				int m = list.get(1) - 1;
				if (edges[n][m] == 0 || weight < edges[n][m]) {
					edges[n][m] = weight;
					edges[m][n] = weight;
				}
			} else if (list.size() == 1) {
				model.setStartingPosition(list.get(0) - 1);
				break;
			}
		}
		return edges;
	}

	private static int[][] initializeEdges(int n) {
		int[][] edges = new int[n][n];
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				edges[row][col] = 0;
			}
		}
		return edges;
	}

	private static Map<Integer, Integer> getVisitedNodesWithDistanceTraveled(DijkstraShortReach model, int[][] edges) {
		Map<Integer, Integer> visitedNodes = new HashMap<>();
		visitedNodes.put(model.getStartingPosition(), 0);
		List<Integer> nodes = new ArrayList<>();
		nodes.add(model.getStartingPosition());
		while (!nodes.isEmpty()) {
			int node = nodes.remove(0);
			for (int i = 0; i < model.getNumberOfNodes(); i++) {
				int weight = edges[node][i];
				if (weight != 0) {
					weight += visitedNodes.get(node);
					if (!visitedNodes.containsKey(i) || visitedNodes.get(i) > weight) {
						visitedNodes.put(i, weight);
						nodes.add(i);
					}
				}
			}
		}
		return visitedNodes;
	}

	private static String shortestDistances(int nodes, Map<Integer, Integer> visitedNodes, int startingPosition) {
		StringBuilder shortestDistances = new StringBuilder();
		for (int i = 0; i < nodes; i++) {
			if (i != startingPosition) {
				if (visitedNodes.containsKey(i)) {
					shortestDistances.append(String.valueOf(visitedNodes.get(i)));
				} else {
					shortestDistances.append("-1");
				}
				shortestDistances.append(" ");
			}
		}
		return shortestDistances.toString().trim();
	}

}
