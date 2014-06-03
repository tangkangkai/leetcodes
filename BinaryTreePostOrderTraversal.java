package leetcode.leetcodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;

/*
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * (Using Stack for iteration)
 */
public class BinaryTreePostOrderTraversal {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	List<Integer> list = new ArrayList<Integer>();

	public List<Integer> postorderTraversalIteration(TreeNode root) {
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<>();
		Map<TreeNode, Integer> map = new HashMap<>();
		TreeNode tn;
		stack.push(root);

		while (stack.size() != 0) {
			tn = stack.peek();
			if (map.get(tn) == null) {
				if (tn.left == null && tn.right == null) {
					list.add(tn.val);
					stack.pop();
				} else if (tn.left == null) {
					stack.push(tn.right);
				} else if (tn.right == null) {
					stack.push(tn.left);
				} else {
					stack.push(tn.right);
					stack.push(tn.left);
				}
				map.put(tn, 1);
			} else {
				list.add(tn.val);
				stack.pop();
			}

		}
		return list;
	}

	public List<Integer> postorderTraversalRecursion(TreeNode root) {
		if (root == null)
			return list;
		postorderTraversalRecursion(root.left);
		postorderTraversalRecursion(root.right);
		list.add(root.val);

		return list;
	}

	@Test
	public void test() {
		TreeNode root = new TreeNode(3);
		TreeNode node2 = new TreeNode(1);
		root.left = node2;
		node2.left = new TreeNode(2);
		List<Integer> list = postorderTraversalIteration(root);

		for (int i : list) {
			System.out.print(i + " ");
		}
	}

}
