package com.hackerrank.service;

import com.hackerrank.model.Node;

public class SelfBalancingTreeService {

	private SelfBalancingTreeService() {
	}

	static Node insert(Node node, int val) {
		if (node == null) {
			node = new Node();
			node.val = val;
		} else if (val < node.val) {
			node.left = insert(node.left, val);
			if (getNodeHeight(node.left) - getNodeHeight(node.right) == 2) {
				if (val < node.left.val) {
					node = rotateNodeWithLeftChild(node);
				} else {
					node = doubleRotationWithLeftChild(node);
				}
			}
		} else if (val > node.val) {
			node.right = insert(node.right, val);
			if (getNodeHeight(node.right) - getNodeHeight(node.left) == 2) {
				if (val > node.right.val) {
					node = rotateNodeWithRightChild(node);
				} else {
					node = doubleRotationWithRightChild(node);
				}
			}
		}
		int leftNodeHeight = getNodeHeight(node.left);
		int rightNodeHeight = getNodeHeight(node.right);
		node.ht = getMaxHeight(leftNodeHeight, rightNodeHeight) + 1;
		return node;
	}

	private static Node doubleRotationWithLeftChild(Node node) {
		node.left = rotateNodeWithRightChild(node.left);
		return rotateNodeWithLeftChild(node);
	}

	private static Node doubleRotationWithRightChild(Node node) {
		node.right = rotateNodeWithLeftChild(node.right);
		return rotateNodeWithRightChild(node);
	}

	private static Node rotateNodeWithRightChild(Node node) {
		Node nodeTemp = node.right;
		node.right = nodeTemp.left;
		nodeTemp.left = (node);
		int leftNodeHeight = getNodeHeight(node.left);
		int rightNodeHeight = getNodeHeight(node.right);
		node.ht = getMaxHeight(leftNodeHeight, rightNodeHeight) + 1;
		int rightNodeTempHeight = getNodeHeight(nodeTemp.right);
		nodeTemp.ht = getMaxHeight(rightNodeTempHeight, node.ht) + 1;
		return nodeTemp;
	}

	private static Node rotateNodeWithLeftChild(Node node) {
		Node nodeTemp = node.left;
		node.left = nodeTemp.right;
		nodeTemp.right = node;
		int leftNodeHeight = getNodeHeight(node.left);
		int rightNodeHeight = getNodeHeight(node.right);
		node.ht = getMaxHeight(leftNodeHeight, rightNodeHeight) + 1;
		int leftNodeTempHeight = getNodeHeight(nodeTemp.left);
		nodeTemp.ht = getMaxHeight(leftNodeTempHeight, node.ht) + 1;
		return nodeTemp;
	}

	private static int getNodeHeight(Node node) {
		return node != null ? node.ht : -1;
	}

	private static int getMaxHeight(int height1, int height2) {
		return height1 > height2 ? height1 : height2;
	}

}
