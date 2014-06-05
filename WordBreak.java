package leetcode.leetcodes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/*
 * 1.Given a string s and a dictionary of words dict, 
 * determine if s can be segmented into a 
 * space-separated sequence of one or more dictionary words. 
 * 
 * 2. Given a string s and a dictionary of words dict, add spaces in s to construct a sentence 
 * where each word is a valid dictionary word.
 * Return all such possible sentences. 
 */

public class WordBreak {

	public boolean wordBreak1(String s, Set<String> dict) {
		if (s.length() == 0) {
			return false;
		}

		boolean table[][] = new boolean[s.length()][s.length()];

		// table[i][j] : if s.substring(i, j + 1) can be segmented by dict
		for (int i = 0; i < s.length(); i++) {
			table[i][i] = dict.contains(s.substring(i, i + 1));
		}

		for (int dist = 1; dist < s.length(); dist++) {
			for (int i = 0; i < s.length() - dist; i++) {
				int j = i + dist;
				if (dict.contains(s.substring(i, j + 1))) {
					table[i][j] = true;
				} else {
					for (int k = i; k < j; k++) {
						if (table[i][k] && table[k + 1][j]) {
							table[i][j] = true;
						}
					}
				}

			}

		}
		return table[0][s.length() - 1];
	}

	public List<String> wordBreak2(String s, Set<String> dict) {
		List<String> list = new ArrayList<String>();

		if (wordBreak1(s, dict)) {
			for (String word : dict) {
				if (word.equals(s)) {
					list.add(word);
				} else {
					if (s.startsWith(word)
							&& wordBreak1(s.substring(word.length()), dict)) {
						List<String> subList = wordBreak2(
								s.substring(word.length()), dict);
						for (String subString : subList) {
							list.add(word + " " + subString);
						}
					}
				}
			}
		}
		return list;
	}

	/* Helper function */

	@Test
	public void test() {
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");

		String s = "catsanddog";
		// dict.add("aa");
		// dict.add("aaa");
		// dict.add("aaaa");
		// dict.add("aaaaa");
		// dict.add("aaaaaa");
		// dict.add("aaaaaaa");
		// dict.add("aaaaaaaa");
		// dict.add("aaaaaaaaa");
		// dict.add("aaaaaaaaaa");
		// String s =
		// "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

		// System.out.println(s.substring(s.length()).length());

		List<String> list = wordBreak2(s, dict);

		for (String ss : list) {
			System.out.println(ss);
		}

	}
}
