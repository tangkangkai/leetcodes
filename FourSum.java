package leetcode.leetcodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/*
 Given an array S of n integers, 
 are there elements a, b, c, and d in S such that 
 a + b + c + d = target? 
 Find all unique quadruplets in the array which gives the sum of target

 Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ¡Ü b ¡Ü c ¡Ü d)
 The solution set must not contain duplicate quadruplets.
 */
public class FourSum {
	List<List<Integer>> sumList;
	int target;

	public List<List<Integer>> fourSum(int[] num, int target) {
		// Initialization
		sumList = new ArrayList<>();
		this.target = target;

		if (num == null || num.length < 4) {
			return sumList;
		}

		Arrays.sort(num);

		for (int i = 0; i < num.length; i++) {
			int first = num[i];
			if (i != 0 && first == num[i - 1])
				continue;
			if (num.length - i < 4)
				break;
			threeSum(num, i + 1, first);
		}
		return sumList;
	}

	/* Helper Functions */
	private void threeSum(int[] num, int startIndex, int first) {
		// key : value on arr, value : #
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list;

		// Initialize map
		for (int i = startIndex; i < num.length; i++) {
			int val = num[i];
			if (map.get(val) != null) {
				map.put(val, map.get(val) + 1);
			} else {
				map.put(val, 1);
			}
		}

		for (int i = startIndex; i < num.length; i++) {
			int second = num[i];
			map.put(second, map.get(second) - 1);
			if (i != startIndex && second == num[i - 1])
				continue;

			for (int j = i + 1; j < num.length; j++) {
				int third = num[j];
				if (j != i + 1 && third == num[j - 1])
					continue;
				int fourth = this.target - first - second - third;
				if (fourth >= third && map.containsKey(fourth)) {
					if (fourth == third && map.get(fourth) < 2)
						continue;
					list = new ArrayList<>();
					list.add(first);
					list.add(second);
					list.add(third);
					list.add(fourth);
					sumList.add(list);
				}
			}
		}
	}

	@Test
	public void test() {
		// int[] A = { 1, 0, -1, 0, -2, 2 };
		int[] A = { 0, 0, 0, 0 };

		for (List<Integer> list : fourSum(A, 0)) {
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}

	}

}
