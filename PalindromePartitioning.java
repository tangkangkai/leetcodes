package leetcode.leetcodes;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/*
 * 1.Given a string s, partition s such that every substring of the partition is a palindrome. 
 * Return all possible palindrome partitioning of s. 
 * 
 * 2.Given a string s, partition s such that every substring of the partition is a palindrome. 
 * Return the minimum cuts needed for a palindrome partitioning of s. 
 * 
 */

public class PalindromePartitioning {

	public List<List<String>> partition(String s) {
		List<List<String>> resultList = new LinkedList<>();
		if (s == null || s.length() == 0) {
			return new LinkedList<List<String>>();
		} else if (s.length() == 1) {
			List<String> list = new LinkedList<>();
			list.add(s);
			resultList.add(list);
			return resultList;
		} else {
			for (int i = 1; i <= s.length(); i++) {
				String first = s.substring(0, i);
				if (isPalindrome(first)) {
					List<List<String>> remainList = partition(s.substring(i));
					if (remainList.size() == 0) {
						List<String> ls = new LinkedList<String>();
						ls.add(first);
						resultList.add(ls);
					}
					for (List<String> lst : remainList) {
						lst.add(0, first);
						resultList.add(lst);
					}
				}
			}
		}

		return resultList;
	}

	public int minCut(String s) {
		int length = s.length();
		int[] minCut = new int[length];
		boolean[][] isPalindrome = new boolean[length][length];

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length - i; j++) {
				int k = j + i;
				if (j == k) {
					isPalindrome[j][k] = true;
				} else if (i == 1) {
					isPalindrome[j][k] = s.charAt(j) == s.charAt(k);
				} else {

					isPalindrome[j][k] = s.charAt(j) == s.charAt(k) ? isPalindrome[j + 1][k - 1]
							: false;
				}
			}
		}

		for (int i = 0; i < length; i++) {
			if (isPalindrome[0][i]) {
				minCut[i] = 0;
			} else {
				int count = length;
				for (int j = 0; j < i; j++) {
					if (isPalindrome[j + 1][i] == true && minCut[j] + 1 < count) {
						count = minCut[j] + 1;
					}
				}
				minCut[i] = count;
			}
		}

		return minCut[length - 1];
	}

	/* Helper Functions */
	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}

		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}

		return true;
	}

	@Test
	public void test() {
		String s = "ab";
		System.out.println(minCut(s));
	}

}
