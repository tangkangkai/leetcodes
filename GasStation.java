package leetcode.leetcodes;

import org.junit.Test;

/*
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas 
 * to travel from station i to its next station (i+1).
 * 
 * You begin the journey with an empty tank at one of the gas stations. 
 * 
 * Return the starting gas station's index if you can travel around the circuit once, 
 * otherwise return -1. 
 */
public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {
		for (int i = 0; i < gas.length; i++) {
			if (ifComplete(i, gas, cost))
				return i;
		}

		return -1;
	}

	/* Helper Functions */

	public boolean ifComplete(int index, int[] gas, int[] cost) {
		int gasNum = 0;
		int startingStation = index;

		if ((gasNum = gas[index] - cost[index]) < 0) {
			return false;
		} else {
			index = index == gas.length - 1 ? 0 : ++index;
		}

		while ((gasNum = gasNum + gas[index] - cost[index]) >= 0) {
			if (index == startingStation) {
				return true;
			} else {
				index = index == gas.length - 1 ? 0 : ++index;
			}
		}

		return false;

	}

	@Test
	public void test() {

	}

}
