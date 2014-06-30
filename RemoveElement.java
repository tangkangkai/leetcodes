package leetcode.leetcodes;

import org.junit.Test;

/* 
 Given an array and a value, remove all instances of that value in place and return the new length.
 The order of elements can be changed. It doesn't matter what you leave beyond the new length.  
 */
public class RemoveElement {

	public int removeElement(int[] A, int elem) {
		int offset = 0;

		for (int i = 0; i < A.length; i++) {
			if (A[i] == elem) {
				offset++;
			} else {
				A[i - offset] = A[i];
			}
		}

		return A.length - offset;
	}

	/* Helper Functions */

	@Test
	public void test() {

	}

}
