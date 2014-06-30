package leetcode.leetcodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/*
 Given an array S of n integers, are there elements a, b, c in S 
 such that a + b + c = 0? 
 Find all unique triplets in the array which gives the sum of zero. 
 (a,b,c) must be in non-descending order.
 The solution set must not contain duplicate triplets.
 */
public class ThreeSum {

	List<List<Integer>> sumList;
	Set<List<Integer>> set;
	List<Integer> list;

	public List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		sumList = new ArrayList<>();
		set = new HashSet<>();
		for (int i = 0; i < num.length - 3; i++) {
			// if the element is the same with the next one, simply continue;

			int first = num[i];

			int j = i + 1;
			int k = num.length - 1;

			while (j < k) {
				int second = num[j];
				int third = num[k];
				int result = first + second + third;
				if (result == 0) {
					list = new ArrayList<>();
					list.add(first);
					list.add(second);
					list.add(third);
					set.add(list);
					j++;
					k--;
				} else {
					if (result < 0) {
						j++;
					} else {
						k--;
					}
				}
			}

		}
		sumList.addAll(set);
		return sumList;
	}

	/* Helper Functions */
	@Test
	public void test() {
		int[] s = { -1, 0, 1, 2, -1, -4 , -1, 2};
		List<List<Integer>> threeSum = threeSum(s);

		for (List<Integer> list : threeSum) {
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}

	}
}
