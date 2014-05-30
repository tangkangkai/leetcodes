package leetcode.leetcodes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.junit.Test;

/*
 * 
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as 
 * a binary tree in which the depth of the two subtrees of every node
 * never differ by more than 1. 
 */

class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;

	TreeNode(int x) {
		this.val = x;
	}
}

public class BalancedBinaryTree {
	Map<TreeNode, Boolean> map = new HashMap<>();

	public boolean ifBalanced(TreeNode root) {
		if (map.containsKey(root)) {
			return map.get(root);
		}
		if (root == null) {
			return true;
		} else {
			if (ifBalanced(root.left) && ifBalanced(root.right)) {
				if (Math.abs(depth(root.left) - depth(root.right)) > 1) {
					return false;
				} else {
					return true;
				}
			} else {
				return false;
			}
		}
	}

	public int depth(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return 1 + Math.max(depth(root.left), depth(root.right));
		}
	}

	@Test
	public void test() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);

		n1.right = n2;
		n2.right = n3;

		System.out.println(ifBalanced(n1));

	}

}
