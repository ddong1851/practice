package src.boj.bfs_dfs;

import java.io.*;
import java.util.*;

public class Main_����_1103_����_���2_100ms {

	// �����¿�
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };
	private static int N, M, mult, ans;
	private static boolean flag = false;
	private static char[][] map;
	private static int[][] dp;

	public static void main(String[] args) throws Exception {

		/*
		 * �Դٰ��� �� �� �ִ� ������ ����� ����. --> -1 ��� �������� BFSƲ�� ����ؼ� �� ���� ������ �� �ִ��� ī��������. -->
		 * �޸� �ʰ�
		 * 
		 * �̹� �ѹ� �湮�� ��ǥ�� ���� ���� ��� ����ұ� �޸������̼��ε� ��� ����.
		 * 
		 * ������ �ߴ� DFS + DP ���..
		 * ������ ��� �ߴ��� ����� �ȳ���..... 
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][];
		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		ans = 0;
		go(0, 0, 1, new boolean[N][M]);

		System.out.println(flag ? -1 : ans);

	} // end of main

	private static void go(int row, int col, int count, boolean[][] vis) {
		// ����Ŭ�� �����Ǿ����� �������� ����. --> �ߴµ� �ð��� ���� �ʾҴ�.
		if(flag) return;
		// �ִ밪 ����
		if(ans<count) ans = count;
		// �޸������̼�
		dp[row][col] = count;
		// �� �� �ִ� ��ǥ�� �̵��Ѵ�.
		for (int i = 0; i < 4; i++) {
			mult = map[row][col] - '0';
			int nr = row + dr[i] * mult;
			int nc = col + dc[i] * mult;
			// �迭�� ������ ����ų� �����̶�� ��������.
			if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 'H') continue;
			// �̹� �湮�ߴ� �ڸ� �� �� ū �ڸ����� ���� ��ǥ�� �Ÿ���.
			if(dp[nr][nc]>dp[row][col]) continue;
			// �̹� �湮�ߴ� ��ǥ��� ����Ŭ
			if (vis[nr][nc]) {
				// ����Ŭ�̴ϱ� -1 ��ȯ
				flag = true;
				return;
			}
			vis[nr][nc] = true;
			go(nr, nc, count+1, vis);
			vis[nr][nc] = false;
		}
		// �湮 �ʱ�ȭ 
	} // end of go 

} // end of class
