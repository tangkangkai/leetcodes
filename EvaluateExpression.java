package leetcode.leetcodes;

import java.util.Stack;

import org.junit.Test;

public class EvaluateExpression {
	public int eval(String[] tokens) {
		String operators = "+-*/";
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < tokens.length; i++) {
			String op = tokens[i];
			if (operators.contains(op)) {
				if (stack.size() < 2) {
					System.out.println("ERROR");
					return 0;
				} else {
					Integer i1 = stack.pop();
					Integer i2 = stack.pop();

					if (op == "+") {
						stack.push(i1 + i2);
					} else if (op == "-") {
						stack.push(i2 - i1);
					} else if (op == "*") {
						stack.push(i1 * i2);
					} else {
						
						stack.push(i2 / i1);
					}
				}
			} else {
				stack.push(Integer.valueOf(op));
			}
		}

		return stack.pop();
	}

	@Test
	public void test() {
		String[] s = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
		System.out.println(eval(s));
	}
}
