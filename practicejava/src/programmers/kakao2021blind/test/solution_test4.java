package src.programmers.kakao2021blind.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.programmers.kakao2021blind.Solution_гу╫бец╫ц©Д╠щ;

class solution_test4 {
	
	Solution_гу╫бец╫ц©Д╠щ check = new Solution_гу╫бец╫ц©Д╠щ();
	@Test
	void testSolution() {
		int n = 6;
		int s = 4;
		int a = 6; int b = 2;
		int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, 
				{2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
		
		assertEquals(82, check.solution(n, s, a, b, fares));
	}

}
