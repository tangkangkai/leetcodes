package leetcode.leetcodes;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/*
 Determine if a Sudoku is valid
 The Sudoku board could be partially filled, where empty cells are filled with the character '.'
 A valid Sudoku board (partially filled) is not necessarily solvable. 
 Only the filled cells need to be validated. 
 */
public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		Set<Character> set1 = new HashSet<>();
		Set<Character> set2 = new HashSet<>();
		for (int i = 0; i < 9; i++) {
			setUp(set1);
			setUp(set2);
			for (int j = 0; j < 9; j++) {
				char num;
				// Each row must have the numbers 1-9 occuring just once.
				if ((num = board[i][j]) != '.') {
					if (set1.contains(num)) {
						set1.remove(num);
					} else {
						return false;
					}
				}
				// Each column must have the numbers 1-9 occuring just once.
				if ((num = board[j][i]) != '.') {
					if (set2.contains(num)) {
						set2.remove(num);
					} else {
						return false;
					}
				}
			}
		}

		// the numbers 1-9 must occur just once in each of the 9 sub-boxes of
		// the grid.
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int m = i * 3;
				int n = j * 3;
				setUp(set1);
				for (int k = m; k < m + 3; k++) {
					for (int l = n; l < n + 3; l++) {
						char num;
						if ((num = board[k][l]) == '.')
							continue;
						if (set1.contains(num)) {
							set1.remove(num);
						} else {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	/* Helper Functions */
	public void setUp(Set<Character> set) {
		for (int i = 1; i <= 9; i++) {
			set.add((char) ('0' + i));
		}
	}

	@Test
	public void test() {
		System.out.println((char) ('0' + 1));
	}

}
