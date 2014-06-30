package leetcode.leetcodes;

import java.util.Arrays;

import org.junit.Test;

/*
 Implement next permutation, which rearranges numbers into 
 the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order 
 (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 ¡ú 1,3,2
 3,2,1 ¡ú 1,2,3
 1,1,5 ¡ú 1,5,1
 */
public class NextPermutation {

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

	/* Helper Functions */
	public void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	public void printArr(int[] num) {
		System.out.print("[ ");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println("]");
	}

	@Test
	public void test() {
		int[] A = { 2, 2, 7, 5, 4, 3, 2, 2, 1 };

		printArr(A);

		nextPermutation(A);

		printArr(A);
	}
}
