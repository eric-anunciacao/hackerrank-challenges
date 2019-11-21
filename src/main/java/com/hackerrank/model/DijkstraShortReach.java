package com.hackerrank.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class DijkstraShortReach {

	@Getter
	@Setter
	private int startingPosition;
	
	@Getter
	@Setter
	private int lastPosition;

	@Getter
	@Setter
	private int numberOfNodes;

	@Getter
	@Setter
	private int numberOfEdges;
}
