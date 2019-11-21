package com.hackerrank.challenges;

import com.hackerrank.model.Node;

public class SelfBalancingTree {

	/**
	 * Inserts a value into the tree and perform the necessary rotations to ensure
	 * that it remains balanced.
	 * 
	 * @param node {@link Node} - Node to be balanced.
	 * @param val  integer value of the node.
	 * @return {@link Node} - balanced node.
	 */
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

	/**
	 * Performs a double rotation using the left child.
	 * 
	 * @param node {@link Node} - Node to be rotated.
	 * @return {@link Node} - Node rotated from the given parameter.
	 */
	private static Node doubleRotationWithLeftChild(Node node) {
		node.left = rotateNodeWithRightChild(node.left);
		return rotateNodeWithLeftChild(node);
	}

	/**
	 * Performs a double rotation using the right child.
	 * 
	 * @param node {@link Node} - Node to be rotated.
	 * @return {@link Node} - Node rotated from the given parameter.
	 */
	private static Node doubleRotationWithRightChild(Node node) {
		node.right = rotateNodeWithLeftChild(node.right);
		return rotateNodeWithRightChild(node);
	}

	/**
	 * Rotate the node with the right child.
	 * 
	 * @param node {@link Node} - Node to be rotated.
	 * @return {@link Node} - Node rotated from the given parameter.
	 */
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

	/**
	 * Rotate the node with the left child.
	 * 
	 * @param node {@link Node} - Node to be rotated.
	 * @return {@link Node} - Node rotated from the given parameter.
	 */
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

	/**
	 * Returns the node height (height of a Null node is -1).
	 * 
	 * @param node {@link Node} - Node where you should read the height.
	 * @return integer value containing the node height.
	 */
	private static int getNodeHeight(Node node) {
		return node != null ? node.ht : -1;
	}

	/**
	 * Returns the max height between the two values entered.
	 * 
	 * @param height1 integer value containing the height to be checked.
	 * @param height2 integer value containing another height to be checked.
	 * @return integer value containing the max height between the two values.
	 */
	private static int getMaxHeight(int height1, int height2) {
		return height1 > height2 ? height1 : height2;
	}
}
