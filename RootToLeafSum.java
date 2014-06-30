package leetcode.leetcodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class RootToLeafSum {

	public int sumNumbers(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		return sumNumbersHelper(root, root.val, 0);
	}

	/* Helper Function */
	private int sumNumbersHelper(TreeNode node, int path, int sum) {
		if(node.left == null && node.right == null) {
			return path + sum;
		}
		
		if(node.left != null) {
			sum = sumNumbersHelper(node.left, path * 10 + node.left.val, sum);
		}
		
		if(node.right != null) {
			sum = sumNumbersHelper(node.right, path * 10 + node.right.val, sum);
		}
		
		return sum;
	}
	@Test
	public void test() {
		TreeNode root = new TreeNode(0);
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);

		root.left = t1;
		root.right = t2;
		t1.left = t3;
		t3.right = t4;

		List<TreeNode> array = new ArrayList<TreeNode>();
		array.add(t1);
		array.add(t2);
		array.add(t3);
		array.add(t4);
		array.add(t5);
		array.add(t6);
		

	}
}
