package src.programmers.kakao2021blind.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.programmers.kakao2021blind.Solution_�޴�������;

class solution_test2 {
	
	Solution_�޴������� testSolution = new Solution_�޴�������();

	@Test
	void test() {
//		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//		int[] course = {2,3,4};
//		String[] result = {"AC", "ACDE", "BCFG", "CDE"};
//		String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//		int[] course = {2,3,5};
//		String[] result = {"ACD", "AD", "ADE", "CD", "XYZ"};
		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = {2, 3, 4};
		String[] result = {"WX", "XY"};
		assertArrayEquals(result, testSolution.solution(orders, course));
	}

}
