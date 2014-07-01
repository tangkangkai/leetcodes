package leetcode.leetcodes;

import org.junit.Test;

/*
 Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 compute how much water it is able to trap after raining. 

 */

public class TrappingRainWater {

	public int trap(int[] A) {
		if (A.length == 0) {
			return 0;
		}
		
		/* Initialize leftMax and rightMax */
		int leftMax = A[0];
		int rightMax = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] > rightMax) {
				rightMax = A[i];
			}
		}
		
		/* Get capacity of every slot */
		int capacity = 0;
		for (int i = 1; i < A.length - 1; i++) {
			int left = 0;
			int right = 0;

			if (leftMax > A[i]) {
				left = leftMax;
			} else {
				leftMax = A[i];
			}

			if (rightMax > A[i]) {
				right = rightMax;
			} else {
				int newRightMax = 0;
				for (int j = i + 1; j < A.length; j++) {
					if (A[j] > newRightMax) {
						newRightMax = A[j];
					}
				}
				rightMax = newRightMax;
			}

			int localMax = left > right ? right : left;
			capacity += localMax > A[i] ? localMax - A[i] : 0;
		}

		return capacity;
	}

	/* Helper Functions */

	@Test
	public void test() {
		System.out
				.println(trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
	}
}
