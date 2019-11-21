package com.hackerrank.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hackerrank.model.DijkstraShortReach;
import com.hackerrank.util.FileUtils;

public class DijkstraShortestReachService {

	/**
	 * Run Dijkstra's shortest reach.
	 * 
	 * @param lines {@link List} - List of lines present in the file.
	 */
	public static void executeDijkstraShortestReach(List<String> lines) {
		int numberOfTestCases = Integer.valueOf(lines.get(0));
		int linePosition = 0;
		for (int i = 0; i < numberOfTestCases; i++) {
			linePosition++;
			DijkstraShortReach model = loadNodesInfos(lines, linePosition);
			int[][] edges = getEdges(model, lines);
			linePosition = model.getLastPosition();
			Map<Integer, Integer> visitedNodes = getVisitedNodes(model, edges);
			showShortestDistances(model.getNumberOfNodes(), visitedNodes, model.getStartingPosition());
		}
	}

	/**
	 * Loads basic node data according to line position.
	 * 
	 * @param lines        {@link List} - List of lines present in the file.
	 * @param linePosition integer value containing the line position that has the
	 *                     basic node data.
	 * @return {@link DijkstraShortReach} - Basic node data according to line
	 *         position.
	 */
	private static DijkstraShortReach loadNodesInfos(List<String> lines, int linePosition) {
		List<Integer> items = FileUtils.getItems(lines, linePosition);
		DijkstraShortReach model = new DijkstraShortReach();
		model.setLastPosition(linePosition);
		if (items.size() > 1) {
			model.setNumberOfNodes(items.get(0));
			model.setNumberOfEdges(items.get(1));
		}
		return model;
	}

	/**
	 * Returns the edges and their weights according to the lines of the file.
	 * 
	 * @param model {@link DijkstraShortReach} - Object containing the basic node
	 *              data.
	 * @param lines {@link List} - List of lines presents in the file.
	 * @return array containing the edges and their weights according to the lines
	 *         of the file.
	 */
	private static int[][] getEdges(DijkstraShortReach model, List<String> lines) {
		int[][] edges = getEdges(model.getNumberOfNodes());
		for (String l : lines) {
			model.setLastPosition(model.getLastPosition() + 1);
			List<Integer> list = FileUtils.getItems(lines, model.getLastPosition());
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

	/**
	 * Returns an array representing edges with their initialized weights (with
	 * value = 0).
	 * 
	 * @param size integer value containing the array size.
	 * @return an array representing edges with their initialized weights (with
	 *         value = 0).
	 */
	private static int[][] getEdges(int n) {
		int[][] edges = new int[n][n];
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				edges[row][col] = 0;
			}
		}
		return edges;
	}

	/**
	 * Returns a map containing the visited nodes and the distance (weights)
	 * traveled to them.
	 * 
	 * @param model {@link DijkstraShortReach} - Object containing the basic node
	 *              data.
	 * @param edges an array representing edges with their weights.
	 * @return {@link Map} - Map containing the visited nodes and the distance
	 *         (weights) traveled to them.
	 */
	private static Map<Integer, Integer> getVisitedNodes(DijkstraShortReach model, int[][] edges) {
		Map<Integer, Integer> visitedNodes = new HashMap<>();
		visitedNodes.put(model.getStartingPosition(), 0);
		List<Integer> nodes = new ArrayList<>();
		nodes.add(model.getStartingPosition());
		while (!nodes.isEmpty()) {
			int node = nodes.remove(0);
			for (int i = 0; i < model.getNumberOfNodes(); i++) {
				int weight = edges[node][i];
				if (weight == 0) {
					continue;
				} else {
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

	/**
	 * Displays the shortest distances traveled for each node.
	 * 
	 * @param nodes            integer value containing the number of nodes.
	 * @param visitedNodes     {@link Map} - Map containing the visited nodes and
	 *                         the distance (weights) traveled to them.
	 * @param startingPosition integer value containing the starting position.
	 */
	private static void showShortestDistances(int nodes, Map<Integer, Integer> visitedNodes, int startingPosition) {
		StringBuilder shortestDistances = new StringBuilder();
		for (int i = 0; i < nodes; i++) {
			if (i != startingPosition) {
				if (!shortestDistances.toString().isEmpty()) {
					shortestDistances.append(" ");
				}
				if (visitedNodes.containsKey(i)) {
					shortestDistances.append(String.valueOf(visitedNodes.get(i)));
				} else {
					shortestDistances.append("-1");
				}
			}
		}
		System.out.println(shortestDistances.toString());
	}

}
