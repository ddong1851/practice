package src.programmers.kakao2022blind;

import java.util.*;

public class Solution_��ô�ȸ {

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
		 * ����?�� ����ؼ� ���� ���� �� �ִ� ���� ����Ʈ�� ��� ������. 
		 * 
		 * �̶� ���̰� �ִ�� ������ �� �ִ밪�� �����ϰ�, 
		 * ���� �ִ�� ���� ���� ���� ���� ������ �� ���� ������ �� ���� ���� ����Ʈ�� ����
		 */
		
		int[] answer = { -1 };
		opp = info;
		max = 0;
		// ������ 0~10 
		go(0, 0, n, new int[11]);
		return max == 0 ? answer : my_best;
	} // end of solution

	private static void go(int cnt, int start, int limit, int[] score) {
		if (cnt == limit) {
			enemy = me = 0;
			// ���� �ջ�
			for (int i = 0; i < 11; i++) {
				// ���� �� ���� ���� ���
				if (opp[i] < score[i])
					me += (10 - i);
				// ��밡 ���� �����ϰų�, �� ���� ������ �� + ��뵵 0�� �ƴ� ���� �ջ�
				else if (opp[i] != 0)
					enemy += (10 - i);
			}
			diff = me - enemy;
			// ���̰� ���� �ִ뺸�� �� ū ��� ����
			if (diff > max) {
				max = diff;
				// clone���ϸ�.. �� ȥ�� �ٲ����� 
				my_best = score.clone();
			} else if (diff!=0 && diff == max && hasLower(score)) {
				// ���� ���̿� max�� ������ ��, �� ���� ������ �� ���� ���� ����Ʈ�� ����
				my_best = score.clone();
			}
			return;
		} // end of ��������

		// ����?
		for (int i = start; i < 11; i++) {
			// ��뺸�� �ϳ��� �� ������ ��
			if (score[i] > opp[i])
				continue;
			score[i]++;
			go(cnt+1, i, limit, score);
			score[i]--;
		}

	} // end of go

	// ����Ʈ�� ���ڸ�, �� ���� �������� ��
	private static boolean hasLower(int[] score) {
		boolean res = false;
		for (int i = 10; i >= 0; i--) {
			// �� ����Ʈ�� ���� �ٸ� ��
			if (score[i] != my_best[i]) {
				if (score[i] > my_best[i])
					res = true;
				break;
			}
		}
		return res;
	} // end of hasLower

}
