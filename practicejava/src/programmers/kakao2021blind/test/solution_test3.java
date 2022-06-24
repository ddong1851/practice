package src.programmers.kakao2021blind.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.programmers.kakao2021blind.Solution_순위검색;

class solution_test3 {

	Solution_순위검색 solution3 = new Solution_순위검색();
	
	@Test
	void testSolution() {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150",
				"cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200",
				"cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		
		int[] result = {1, 1, 1, 1, 2, 4};
		assertArrayEquals(result, solution3.solution(info, query));
	}

}
