package com.hackerrank.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class DijkstraShortReach {

	private int startingPosition;

	private int lastPosition;

	private int numberOfNodes;

	private int numberOfEdges;
}
