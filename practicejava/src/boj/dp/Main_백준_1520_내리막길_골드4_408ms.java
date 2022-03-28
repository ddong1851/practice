package src.boj.dp;

import java.io.*;
import java.util.*;

/** Main_����_1520_��������_���4_408ms*/
public class Main_����_1520_��������_���4_408ms {
	
	private static int max = 10001;
	private static int N, M, nr, nc;
	private static int[][] map;
	private static int[][] dp;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		/*
		 * 1,1 ----> N, M���� ���� ���� ������ ī����
		 * �����¿� 4�������� �̵� ����
		 * ��ǥ �̵��� ���� ��ǥ�� ���� ���� ��ǥ�� ������ �� �۾ƾ� �Ѵ�.
		 * ������ �� ���� ��ǥ�θ� �̵��ϴ� �湮 üũ�� ���� �� �ʿ� ����.
		 * 
		 * BFS�� �õ�, �޸� �ʰ�
		 * ++ ����ġ�⸦ �� �ϴ���, �ٸ� ����� �����غ��ƾ� �Ѵ�.
		 * �ȵǴ� ���� �ݺ��ؼ� ���� ��� ������
		 * 
		 * boolean ������ �ΰ�, 4���� �� �Ұ��� ������ max�� �ʱ�ȭ - �޸� �ʰ�
		 * 
		 * DFS - �ð� �ʰ�, ����ġ�⸦ �� �ϸ� �� ��?
		 * �̹� Ž���� ��ǥ �ߺ� Ž������ �ʰ� �ϱ� ��ĳ?
		 * 
		 * ���� �˻����� DP ���°� ���� ���� �Ȱ��� �߽��ϴ�.. 
		 * Ž���� ����� ���� ���θ� �����ϴ� ����� �����߾��µ�,, DP�� ���Ἥ ��Ǯ�� �־��׿�..! 
		 */
		
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+2][M+2];
		dp = new int[N+2][M+2];
		for(int i=0; i<=N+1; i++) Arrays.fill(dp[i], -1);
		
		Arrays.fill(map[0], max);
		Arrays.fill(map[N+1], max);
		for(int i=1; i<=N; i++) {
			map[i][0] = map[i][M+1] = max;
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(go(1, 1));
		
	} // end of main

	private static int go(int row, int col) {
		// ��ǥ ���� �����ϸ� ��� �ϳ� �߰�
		if(row==N && col==M) return 1;
		// �̹� �湮�� ���
		if(dp[row][col]!=-1) return dp[row][col];
		
		dp[row][col] = 0;
		// �� �� �� �� Ž��
		for(int i=0; i<4; i++) {
			nr = row + dr[i];
			nc = col + dc[i];
			// ������ ��ǥ�� ���� ��ǥ�� �̵�
			if(map[nr][nc]<map[row][col]) 
				dp[row][col] += go(nr, nc);
		}
		// ���ο� ��ǥ������ ����
		return dp[row][col];
	}
} // end of class 
