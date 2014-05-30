package leetcode.leetcodes;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Solution {

	/*
	 * 
	 * O(n^2)
	 */
	public static int maxPoints(Point[] points) {
		HashMap<Float, Integer> map = new HashMap<Float, Integer>();
		int max = 0;
		if (points.length == 0)
			return 0;

		for (int i = 0; i < points.length; i++) {
			int duplicate = 1;
			map.clear();// it needs to cleared, or there will be duplicates
			for (int j = i + 1; j < points.length; j++) {
				// if(j==i) continue;
				System.out.println("i: " + i + " j: " + j);
				if (points[j].y == points[i].y && points[i].x == points[j].x) {
					duplicate++;
					continue;
				}
				float k = points[i].x == points[j].x ? Float.MAX_VALUE
						: (float) (points[j].y - points[i].y)
								/ (points[j].x - points[i].x);
				if (k == -0.0)
					k = (float) 0.0;
				if (map.containsKey(k)) {
					System.out.println("first" + map.get(k));
					map.put(k, map.get(k) + 1);
				} else {
					System.out.println("hera" + k);
					map.put(k, 1);
				}

			}
			// compare max in the outer loop
			if (!map.isEmpty()) {
				for (Map.Entry<Float, Integer> entry : map.entrySet()) {
					int num = entry.getValue();
					if (max < num + duplicate) {
						System.out.println(num + " " + duplicate);
						max = num + duplicate;
					}
				}
			} else {
				if (max < duplicate)
					max = duplicate;
			}

		}
		return max;
	}

	public static void main(String[] args) {
		Point elem = new Point(2, 3);
		Point elem1 = new Point(3, 3);
		Point elem2 = new Point(-5, 3);
		Point[] po = { elem, elem1, elem2 };
		System.out.println(maxPoints(po));
	}

}
