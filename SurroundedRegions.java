package leetcode.leetcodes;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/*
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region. 
 */
public class SurroundedRegions {
	int xlen;
	int ylen;
	boolean[][] visited;
	boolean[][] notSurrounded;

	public void solve(char[][] board) {
		if(board.length == 0) {
			return;
		}
		
		xlen = board.length;
		ylen = board[0].length;

		// to see if the point had been visited yet.
		// f : not visited, t : visited
		visited = new boolean[xlen][ylen];

		// to see if the point is surely not surrounded
		// f : not sure, t : not surrounded by 'x'
		notSurrounded = new boolean[xlen][ylen];

		// set of groups of points that are 'O' and surrounded by 'X'
		Set<Set<RegionPoint>> surroundedGroups = new HashSet<>();

		for (int i = 0; i < xlen; i++) {
			for (int j = 0; j < ylen; j++) {
				if (!visited[i][j]) {
					visited[i][j] = true;

					if (board[i][j] == 'O') {
						if (onEdge(i, j)) {
							notSurrounded[i][j] = true;
						} else {
							Set<RegionPoint> group = new HashSet<>();
							group.add(new RegionPoint(i, j));
							if (isSurrounded(i + 1, j, group, board)
									&& isSurrounded(i - 1, j, group, board)
									&& isSurrounded(i, j - 1, group, board)
									&& isSurrounded(i, j + 1, group, board)) {
								surroundedGroups.add(group);
							}
						}
					}
				}
			}
		}
		for(Set<RegionPoint> set : surroundedGroups) {
			for(RegionPoint p : set) {
				board[p.x][p.y] = 'X';
			}
		}

	}

	/* Helper Function */

	private boolean isSurrounded(int i, int j, Set<RegionPoint> group, char board[][]) {
		visited[i][j] = true;
		
		if(board[i][j] == 'X') {
			return true;
		}
		
		if(onEdge(i, j)) {
			notSurrounded[i][j] = true;
			return false;
		} else {
			boolean isSurr = (visited[i][j+1] ? !notSurrounded[i-1][j] : isSurrounded(i-1, j, group, board)) &&
							 (visited[i][j-1] ? !notSurrounded[i][j-1] : isSurrounded(i, j-1, group, board)) &&
							 (visited[i+1][j] ? !notSurrounded[i+1][j] : isSurrounded(i + 1, j, group, board)) &&
							 (visited[i-1][j] ? !notSurrounded[i][j+1] : isSurrounded(i, j + 1, group, board));
			
			
			if(isSurr) {
				group.add(new RegionPoint(i, j));
			} else {
				notSurrounded[i][j] = true;
			}
			return isSurr;
		}
	}

	private boolean onEdge(int i, int j) {
		// TODO Auto-generated method stub
		if (i == 0 || i == xlen - 1 || j == 0 || j == ylen - 1)
			return true;
		return false;
	}

	@Test
	public void test() {
//		char[] board1 = new char[]{'x', 'o', 'x', 'x'};
//		char[] board2 = new char[]{'o', 'x', 'o', 'x'};
//		char[] board3 = new char[]{'x', 'o', 'x', 'o'};
//		char[] board4 = new char[]{'o', 'x', 'o', 'x'};	
//		char[] board5 = new char[]{'x', 'o', 'x', 'o'};	
//		char[] board6 = new char[]{'o', 'x', 'o', 'x'};	
		
		char[] board1 = new char[]{'O', 'X', 'X', 'O', 'X'};
		char[] board2 = new char[]{'X', 'O', 'O', 'X', 'O'};
		char[] board3 = new char[]{'X', 'O', 'X', 'O', 'X'};
		char[] board4 = new char[]{'O', 'X', 'O', 'O', 'O'};
		char[] board5 = new char[]{'X', 'X', 'O', 'X', 'O'};
		char[][] board = new char[][]{board1, board2, board3, board4, board5};
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		solve(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}

class RegionPoint {
	int x;
	int y;

	public RegionPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
