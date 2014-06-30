package leetcode.leetcodes;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/* Given an unsorted array of integers, 
 * find the length of the longest consecutive elements sequence. 
 */
public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] num) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < num.length; i++) {
			set.add(num[i]);
		}

		int maxLength = 0;
		for (int i : num) {
			if (set.contains(i)) {
				int length = 0;
				
				/* forward */
				length += consecutiveNum(set, i, 1);
				
				/* backward */
				length += consecutiveNum(set, i, -1);
				
				/* self */
				length += 1;
				set.remove(i);
				
				maxLength = Math.max(length, maxLength);
			}
		}

		return maxLength;
	}

	/* Helper Function */

	private int consecutiveNum(Set<Integer> set, int num, int step) {
		int len = 0;
		num += step;

		while (set.contains(num)) {
			set.remove(num);
			len++;
			num += step;
		}
		return len;
	}
	@Test
	public void test() {
		System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
	}
}
