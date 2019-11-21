package com.hackerrank.model;

public class Node {

	public int val;
	public int ht;
	public Node left;
	public Node right;
	
	public Node() {
		left = new Node();
		right = new Node();
	}
}
