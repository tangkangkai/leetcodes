package leetcode.leetcodes;

import java.util.Arrays;

import org.junit.Test;

/*
 The set [1,2,3,бн,n] contains a total of n! unique permutations.
 Given n and k, return the kth permutation sequence. 
 */
public class PermutationSequence {
	public String getPermutation(int n, int k) {
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = i + 1;
		}
		
		for(int i = 1; i < k; i++ ) {
			nextPermutation(num);
		}
			
		StringBuilder sb = new StringBuilder();
		for(int i : num) {
			sb.append(i);
		}
		return sb.toString();
	}

	/* Helper Functions */

	public void nextPermutation(int[] num) {
		int lastIndex = num.length - 1;

		for (int i = lastIndex - 1; i >= 0; i--) {
			for (int j = lastIndex; j > i; j--) {
				if (num[i] < num[j]) {
					swap(num, i, j);

					for (int m = i + 2; m <= num.length - 1; m++) {
						for (int n = m; n > i + 1 && num[n] < num[n - 1]; n--) {
							swap(num, n, n - 1);
						}
					}
					return;
				}
			}
		}

		Arrays.sort(num);
	}
	
	public void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	@Test
	public void test() {
		System.out.println(getPermutation(3, 6));
	}

}
