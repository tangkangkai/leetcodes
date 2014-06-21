package leetcode.leetcodes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/*
 * Given two words (start and end), and a dictionary, 
 * find the length of shortest transformation sequence from start to end, such that: 
 * 
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 */

public class WordLadder {

	public int ladderLength(String start, String end, Set<String> dict) {

		if (end.equals(start)) {
			return 1;
		}

		if (differentWord(start, end) == 1) {
			return 2;
		}

		Map<String, Integer> depthMap = new HashMap<>();// Key:string ,
														// Value:depth
		Set<String> prevStrings = new HashSet<>();
		Set<String> currStrings = new HashSet<>();

		for (String str : dict) {
			if (differentWord(start, str) == 1) {
				if (differentWord(str, end) == 1) {
					return 3;
				}
				depthMap.put(str, 2);
				prevStrings.add(str);
			}
		}

		if (prevStrings.size() == 0) {
			return 0;
		}

		while (dict.size() != 0) {
			currStrings = new HashSet<>();

			for (String str : prevStrings) {
				dict.remove(str);
			}

			for (String str : prevStrings) {
				int depth = depthMap.get(str);
				for (String dictStr : dict) {
					if (differentWord(str, dictStr) == 1) {
						if (differentWord(dictStr, end) == 1) {
							return depth + 2;
						}
						depthMap.put(dictStr, depth + 1);
						currStrings.add(dictStr);
					}
				}
			}

			prevStrings = currStrings;
		}

		return 0;
	}

	/* Helper Functions */

	public int differentWord(String s1, String s2) {
		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i))
				count++;
		}

		return count;
	}

	@Test
	public void test() {
		Set<String> set = new HashSet<>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		
		

		System.out.println(differentWord("hat", "dot"));

		System.out.println(ladderLength("hit", "cog", set));
	}

}
