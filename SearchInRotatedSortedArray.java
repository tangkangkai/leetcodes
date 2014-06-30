package leetcode.leetcodes;

import org.junit.Test;

/*
 1.Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 You are given a target value to search. If found in the array return its index, otherwise return -1.
 You may assume no duplicate exists in the array. 

 2.	Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Write a function to determine if a given target is in the array.
 */
public class SearchInRotatedSortedArray {

	public int search1(int[] A, int target) {

		return binarySearch(A, 0, A.length - 1, target);
	}

	public boolean search(int[] A, int target) {
		int left = 0;
		int right = A.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (A[mid] == target) {
				return true;
			} else {
				if (A[left] < target && target < A[mid]) {
					right = mid - 1;
				} else if (A[mid] < target && target < A[right]) {
					left = mid + 1;
				} else {
					if (A[left] == target) {
						return true;
					} else {
						left++;
					}

					if (A[right] == target) {
						return true;
					} else {
						right--;
					}
				}

			}
		}

		return false;

	}

	/* Helper Functions */

	private int binarySearch(int[] A, int left, int right, int target) {

		while (left <= right) {
			int mid = (left + right) / 2;

			if (A[mid] == target) {
				return mid;
			} else if (A[left] <= A[mid]) {
				if (A[left] <= target && target < A[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (A[mid] < target && target <= A[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;

	}

	@Test
	public void test() {
		int[] A = new int[] { 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, };
		System.out.println(search(A, 19));

	}

}
