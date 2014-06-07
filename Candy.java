package leetcode.leetcodes;

import org.junit.Test;

/*
 *  There are N children standing in a line. Each child is assigned a rating value.
 *  You are giving candies to these children subjected to the following requirements:
 *  Each child must have at least one candy.
 *  Children with a higher rating get more candies than their neighbors.
 *  What is the minimum candies you must give? 
 */
public class Candy {

	public int candy(int[] ratings) {

		int count = 0;
		int[] candies = new int[ratings.length];
		int leftHandStand = 1;
		int rightHandStand = 1;

		// from left to right
		candies[0] = 1;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				leftHandStand++;
				candies[i] = leftHandStand;
			} else {
				leftHandStand = candies[i] = 1;
			}
		}

		// from right to left
		candies[ratings.length - 1] = Math.max(1, candies[ratings.length - 1]);
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				rightHandStand++;
				candies[i] = Math.max(rightHandStand, candies[i]);
			} else {
				rightHandStand = candies[i] = Math.max(1, candies[i]);
			}
		}

		for (int i = 0; i < ratings.length; i++) {
			count += candies[i];
		}

		return count;
	}

	/* Helper Function */
	// boolean test(int[] ratings, int[] candies) {
	//
	// for (int i = 0; i < ratings.length - 1; i++) {
	// if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1])
	// return false;
	// }
	//
	// for (int i = ratings.length - 1; i > 0; i--) {
	// if (ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1])
	// return false;
	// }
	//
	// return true;
	// }

	@Test
	public void test() {
		System.out.println(candy(new int[] { 58, 21, 72, 77, 48, 9, 38, 71, 68,
				77, 82, 47, 25, 94, 89, 54, 26, 54, 54, 99, 64, 71, 76, 63, 81,
				82, 60, 64, 29, 51, 87, 87, 72, 12, 16, 20, 21, 54, 43, 41, 83,
				77, 41, 61, 72, 82, 15, 50, 36, 69, 49, 53, 92, 77, 16, 73, 12,
				28, 37, 41, 79, 25, 80, 3, 37, 48, 23, 10, 55, 19, 51, 38, 96,
				92, 99, 68, 75, 14, 18, 63, 35, 19, 68, 28, 49, 36, 53, 61, 64,
				91, 2, 43, 68, 34, 46, 57, 82, 22, 67, 89 }));
	}
}
