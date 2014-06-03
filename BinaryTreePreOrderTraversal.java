package leetcode.leetcodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/*
 * Given a binary tree, return the preorder traversal of its nodes' values.
 */

public class BinaryTreePreOrderTraversal {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	List<Integer> list = new ArrayList<>();

	public List<Integer> preorderTraversalIteration(TreeNode root) {
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode tn;
		stack.push(root);

		while (stack.size() != 0) {
			tn = stack.pop();
			list.add(tn.val);
			
			if (tn.right != null) {
				stack.push(tn.right);
			}
			
			if (tn.left != null) {
				stack.push(tn.left);
			}
			
		}
		return list;
	}

	public List<Integer> preorderTraversalRecursion(TreeNode root) {
		if (root == null)
			return list;

		list.add(root.val);
		preorderTraversalRecursion(root.left);
		preorderTraversalRecursion(root.right);

		return list;
	}
	
	@Test
	public void test() {
		TreeNode root = new TreeNode(3);
		TreeNode node2 = new TreeNode(1);
		root.left = node2;
		node2.left = new TreeNode(2);
		List<Integer> list = preorderTraversalIteration(root);

		for (int i : list) {
			System.out.print(i + " ");
		}
	}
}
