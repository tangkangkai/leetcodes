package leetcode.leetcodes;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MaxPointsOnLine {

	public int maxPointsUsingMap(Point[] points) {
		int maxCount = 0;
		int length = points.length;

		if (length == 0)
			return 0;

		for (int i = 0; i < length; i++) {
			int count = 0; // Max for each point
			int sameCount = 0;

			// create a map for the specified point
			Map<Double, Integer> map = new HashMap<Double, Integer>();
			for (int j = 0; j < length; j++) {
				
				if(j == i) continue;

				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					sameCount += 1;
					continue;
				}

				double slope = slope(points[i], points[j]);
				if (slope == -0.0) {
					slope = 0.0;
				}

				if (map.containsKey(slope)) {
					int num = map.get(slope);
					map.put(slope, ++num);
				} else {
					map.put(slope, 1);
				}
			}

			// traverse the map to get the max num
			for (Double d : map.keySet()) {
				if (map.get(d) > count)
					count = map.get(d);
			}
			if (count + sameCount > maxCount)
				maxCount = count + sameCount;
		}

		return maxCount + 1;
	}

	public int maxPoints(Point[] points) {
		if (points.length < 3) {
			return points.length;
		}

		Point[] leftPoints = new Point[points.length - 1];
		for (int j = 0, i = 1; i < points.length; i++, j++) {
			leftPoints[j] = points[i];
		}
		int max = 0;

		for (int i = 1; i < points.length; i++) {
			int count = 0;
			for (int j = 0; j < points.length; j++) {
				if (ifOnline(points[0], points[i], points[j])) {
					count++;
				}
				System.out.println("i: " + i + "  j: " + j + "  count: "
						+ count);
			}

			if (count > max) {
				max = count;
			}
		}

		return Math.max(max, maxPoints(leftPoints));
	}

	public double slope(Point p1, Point p2) {
		if (p1.x == p2.x) {
			return Double.MAX_VALUE;
		} else {
			return (double)(p2.y - p1.y) / (p2.x - p1.x);
		}

	}

	public boolean ifOnline(Point lp1, Point lp2, Point testPoint) {
		if (testPoint.x == lp1.x && testPoint.y == lp1.y
				|| testPoint.y == lp2.y && testPoint.x == lp2.x) {
			return true;
		}

		if (lp1.x == lp2.x) {
			return lp1.x == testPoint.x;
		}

		if (lp1.x == testPoint.x || lp2.x == testPoint.x) {
			return lp1.x == lp2.x;
		}

		return (double)(lp2.y - lp1.y) / (lp2.x - lp1.x) == (double)(testPoint.y - lp1.y)
				/ (testPoint.x - lp1.x);
	}

	@Test
	public void test() {
		System.out.println(maxPointsUsingMap(new Point[] { new Point(1, 1),
				new Point(1, 1), new Point(2, 2), new Point(2, 2) }));
		// (84,250),(0,0),(1,0),(0,-70),(0,-70),(1,-1),(21,10),(42,90),(-42,-230)
		System.out.println(maxPointsUsingMap(new Point[] {new Point(84, 250),
				new Point(0, 0), new Point(1, 0), new Point(0, -70),
				new Point(0, -70), new Point(1, -1), new Point(21, 10),
				new Point(42, 90), new Point(-42, -230) }));

	}

	@Test
	public void test1() {
		double d1 = 0.0;
		double d2 = -0.0;

		float f1 = 0.0f;
		float f2 = -0.0f;

		int i1 = 0;
		int i2 = 0;

		System.out.println(f1 == f2);
	}
}

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Point p = (Point) obj;
		if (this.x == p.x && this.y == p.y) {
			return true;
		}
		return false;
	}

}