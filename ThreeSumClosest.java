package leetcode.leetcodes;

import java.util.Arrays;

import org.junit.Test;

/*
 Given an array S of n integers, find three integers in S such that 
 the sum is closest to a given number, target. 
 Return the sum of the three integers. 
 You may assume that each input would have exactly one solution.
 */
public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int minDiff = Integer.MAX_VALUE;
		int finalSum = 0;
		int sum;

		for (int i = 0; i < num.length; i++) {

			// if there is less then three elements ahead, break
			if (num.length - i < 3)
				break;

			int first = num[i];

			int j = i + 1, k = num.length - 1;
			while (j < k) {
				sum = first + num[j] + num[k];
				int diff;
				if ((diff = Math.abs(sum - target)) < minDiff) {
					minDiff = diff;
					finalSum = sum;
				}

				if (sum < target) {
					j++;
				} else {
					k--;
				}
			}
		}

		return finalSum;
	}

	/* Helper Functions */
	@Test
	public void test() {
		int[] A = { -1, 2, 1, -4 };
		System.out.println(threeSumClosest(A, 1));
	}
}
