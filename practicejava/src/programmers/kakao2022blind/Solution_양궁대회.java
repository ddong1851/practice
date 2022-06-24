package src.programmers.kakao2022blind;

import java.util.*;

public class Solution_양궁대회 {

	private static int[] opp;
	private static int[] my_best;
	private static int enemy, me, diff, max;

	public static void main(String[] args) {
//		int n = 5;
//		int[] info = {2,1,1,1,0,0,0,0,0,0,0};
//		int n = 1;
//		int[] info = {1,0,0,0,0,0,0,0,0,0,0};
		int n = 9;
		int[] info = { 0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1 };

		System.out.println(Arrays.toString(solution(n, info)));
	}

	public static int[] solution(int n, int[] info) {
		
		/*
		 * 조합?을 사용해서 내가 만들 수 있는 점수 리스트를 모두 만들어본다. 
		 * 
		 * 이때 차이가 최대로 벌어질 때 최대값을 갱신하고, 
		 * 기존 최대와 적과 나의 점수 차가 동일할 때 낮은 점수를 더 많이 맞춘 리스트로 갱신
		 */
		
		int[] answer = { -1 };
		opp = info;
		max = 0;
		// 점수는 0~10 
		go(0, 0, n, new int[11]);
		return max == 0 ? answer : my_best;
	} // end of solution

	private static void go(int cnt, int start, int limit, int[] score) {
		if (cnt == limit) {
			enemy = me = 0;
			// 점수 합산
			for (int i = 0; i < 11; i++) {
				// 내가 더 많이 맞춘 경우
				if (opp[i] < score[i])
					me += (10 - i);
				// 상대가 나와 동일하거나, 더 많이 맞췄을 때 + 상대도 0이 아닐 때만 합산
				else if (opp[i] != 0)
					enemy += (10 - i);
			}
			diff = me - enemy;
			// 차이가 기존 최대보다 더 큰 경우 갱신
			if (diff > max) {
				max = diff;
				// clone안하면.. 지 혼자 바뀌어버림 
				my_best = score.clone();
			} else if (diff!=0 && diff == max && hasLower(score)) {
				// 기존 차이와 max가 동일할 때, 더 낮은 점수를 더 많이 맞춘 리스트로 갱신
				my_best = score.clone();
			}
			return;
		} // end of 기저조건

		// 조합?
		for (int i = start; i < 11; i++) {
			// 상대보다 하나만 더 많으면 됨
			if (score[i] > opp[i])
				continue;
			score[i]++;
			go(cnt+1, i, limit, score);
			score[i]--;
		}

	} // end of go

	// 리스트의 끝자리, 즉 낮은 점수부터 비교
	private static boolean hasLower(int[] score) {
		boolean res = false;
		for (int i = 10; i >= 0; i--) {
			// 두 리스트의 값이 다를 때
			if (score[i] != my_best[i]) {
				if (score[i] > my_best[i])
					res = true;
				break;
			}
		}
		return res;
	} // end of hasLower

}
