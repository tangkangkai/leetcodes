package leetcode.leetcodes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.junit.Test;

/*
 * 1.Given two words (start and end), and a dictionary, 
 * find the length of shortest transformation sequence from start to end, such that: 
 * 
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 */

public class WordLadder {
	private int minLength = 0;

	public int ladderLength(String start, String end, Set<String> dict) {

		if (start == null || end == null || start.equals(end)) {
			return 0;
		}

		HashSet<String> set = new HashSet<>();

		// Use DFS
		// DFS(start, end, dict, 1, set);

		// Use BFS
		return BFS(start, end, dict);
	}

	private class pNode {
		int length;
		String word;

		public pNode(int length, String word) {
			this.length = length;
			this.word = word;
		}
	}

	private int BFS(String start, String end, Set<String> dict) {
		HashMap<String, Boolean> visited = new HashMap<>();
		Queue<pNode> queue = new LinkedList<>();

		queue.add(new pNode(1, start));
		int length = 0;
		while (queue.size() != 0) {
			pNode node = queue.poll();
			visited.put(node.word, true);
			if (node.word.equals(end)) {
				return node.length;
			}

			length = node.length;
			for (int i = 0; i < start.length(); i++) {
				StringBuilder sb = new StringBuilder(node.word);
				for (char c = 'a'; c <= 'z'; c++) {
					sb.setCharAt(i, c);
					String word = sb.toString();
					if (visited.get(word) == null && dict.contains(word)) {
						queue.add(new pNode(length + 1, word));
					}
				}
			}

		}

		return length;

	}

	private void DFS(String start, String end, Set<String> dict, int length,
			HashSet<String> visited) {
		visited.add(start);

		for (int i = 0; i < start.length(); i++) {
			StringBuilder sb = new StringBuilder(start);
			for (char c = 'a'; c <= 'z'; c++) {
				if (c == start.charAt(i)) {
					continue;
				}

				sb.setCharAt(i, c);
				String word = sb.toString();

				if (word.equals(end)) {
					if (minLength == 0 || 1 + length < minLength) {
						minLength = length + 1;
					}
				} else {
					if (dict.contains(word) && !visited.contains(word)) {
						DFS(word, end, dict, length + 1, visited);
					}
				}
			}

		}
		visited.remove(start);
	}

	@Test
	public void test() {
		Set<String> set = new HashSet<>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");

		System.out.println(ladderLength("hit", "cog", set));
	}
}
