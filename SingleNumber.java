package leetcode.leetcodes;

import org.junit.Test;

/*
 * 	Given an array of integers, every element appears twice except for one. Find that single one.
 * Using XOR
 * 
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * Get each bit number of the binay number, add them and divide by three 
 */
public class SingleNumber {

	public int singleNumberInDouble(int[] A) {
		int result = A[0];
		for (int i = 1; i < A.length; i++) {
			result ^= A[i];
		}
		return result;
	}

	public int singleNumberInTriple(int[] A) {
		int number = 0;
		int base = 1;
		for (int i = 0; i < 32; i++) {
			int sum = 0;
			int bitComparator = base << i;
			for (int j = 0; j < A.length; j++) {
				sum += (A[j] & bitComparator) == 0 ? 0 : 1;
			}

			sum %= 3;
			number |= sum << i;
			System.out.println("sum : " + sum + " number: " + number);
		}
		return number;
	}

	/* Helper Function */

	// public int getBitNumber(String original, int bit) {
	// int length = original.length();
	//
	// if (bit > length - 1) {
	// return 0;
	// }
	//
	// return Character.getNumericValue(original.charAt(length - 1 - bit));
	//
	// }

	@Test
	public void test() {
		String s = "-2";
		int parseInt = Integer.parseInt(s);
		System.out.println(parseInt);
	}
}
