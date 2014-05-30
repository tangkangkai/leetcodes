package leetcode.leetcodes;

import java.util.Stack;

import org.junit.Test;

public class ReverseString {
	public String reverseString(String s) {
		Stack<String> stack = new Stack<String>();
		String[] split = s.trim().replaceAll(" +", " ").split(" ");
		for (String string : split) {
			stack.push(string.replaceAll(" ", ""));
		}
		int size = stack.size();
		String returnString = "";
		for (int i = 0; i < size; i++) {
			if (stack.size() != 1) {
				returnString += stack.pop() + " ";
			} else {
				returnString += stack.pop();
			}
		}
		return returnString;
	}

	@Test
	public void test() {
		System.out.println(reverseString("the sky is blue"));
		System.out.println(reverseString("the    sky is    blue"));
	}

	@Test
	public void replaceAllTest() {
		String s = "the    sky is    blue";
		String[] split = s.trim().replaceAll(" +", " ").split(" ");
		System.out.println(split.length);
		for (String str : split) {
			if (str == " ") {
				System.out.println("haha");
				continue;
			}
			System.out.print(str.replaceAll(" ", "") + "*");
		}
	}
}
