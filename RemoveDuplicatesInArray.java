package leetcode.leetcodes;

import org.junit.Test;

/*
 1. Given a sorted array, remove the duplicates in place 
 such that each element appear only once and return the new length.
 Do not allocate extra space for another array, 
 you must do this in place with constant memory. 

 2.Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?
 */
public class RemoveDuplicatesInArray {

	public int removeDuplicates1(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		// we use count to show the offset
		int count = 0;

		for (int i = 1; i < A.length; i++) {
			if (A[i - 1] == A[i]) {
				count++;
			} else {
				A[i - count] = A[i];
			}
		}

		return A.length - count;
	}

	public int removeDuplicates2(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int count = 0;
		int offset = 0;

		for (int i = 1; i < A.length; i++) {
			if (A[i - 1] == A[i]) {
				count++;
				if (count >= 2) {
					offset += 1;
				}
			} else {
				count = 0;
			}
			A[i - offset] = A[i];
		}
		
		
		System.out.println(A[3]);
		return A.length - offset;
	}

	@Test
	public void test() {
		int[] testArr = new int[] { 1, 1, 1, 1, 3, 3 };
		
		System.out.println(removeDuplicates2(testArr));
	}

}
