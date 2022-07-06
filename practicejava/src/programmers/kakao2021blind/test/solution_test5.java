package src.programmers.kakao2021blind.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.programmers.kakao2021blind.Solution_카드짝맞추기;

class solution_test5 {
	
	Solution_카드짝맞추기 solution = new Solution_카드짝맞추기();

	@Test
	void test() {
		int[][] board = {{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}};
		int r = 1;
		int c = 0;
		assertEquals(solution.solution(board, r, c), 14);
	}

}
