package leetcode;

import java.util.LinkedList;

import org.junit.Test;

/*
 * Given an input string, reverse the string word by word.

 *	For example,
 *	Given s = "the sky is blue",
 *	return "blue is sky the".
 */
public class ReverseString {

	public String reverseWords(String s) {
		LinkedList<String> list = new LinkedList<>();
		int index = 0; // traverse through String s
		String string = "";// get temperoal string which is a word
		while (index < s.length()) {
			char character = s.charAt(index);
			if (character != ' ') {
				string += character;
			} else {
				if (string.length() != 0) {
					list.addFirst(string);
					string = "";
				}
			}
			index++;
		}
		// if the string ends, and string is not null, add it to linkedlist as
		// well
		if (string.length() != 0) {
			list.addFirst(string);
		}
		String finalString = "";
		if (list.size() > 0) {
			finalString += list.get(0);
			for (int i = 1; i < list.size(); i++) {
				finalString += " " + list.get(i);
			}
		}
		return finalString;
	}

	@Test
	public void test1() {
		String s = "the sky is blue";
		System.out.println(reverseWords(s));
	}
}
