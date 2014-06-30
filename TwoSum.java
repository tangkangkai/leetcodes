package leetcode.leetcodes;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/*
 Given an array of integers, find two numbers such that they add up to a specific target number.
 The function twoSum should return indices of the two numbers such that they add up to the target, 
 where index1 must be less than index2. 
 Please note that your returned answers (both index1 and index2) are not zero-based.

 */
public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		int len = numbers.length;
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < len; i++) {
			int val = numbers[i];
			set.add(val);
		}

		for (int i = 0; i < len; i++) {
			int goal = target - numbers[i];

			if (set.contains(goal)) {
				for (int j = i + 1; j < len; j++) {
					if(j != i && numbers[j] == goal) {
						return new int[]{i + 1, j + 1};
					}
				}
			}
		}
		
		
		return null;
	}

	/* Helper Functions */

	@Test
	public void test() {

	}
}
