package src.boj.dp;

import java.io.*;
import java.util.*;

/** Main_����_17070_�������ű��1_���5_84ms*/
public class Main_����_17070_�������ű��1_���5_84ms {
	
	private static int N;
	private static int[][] map;
	private static int[][][] DP;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		/*
		 * IDEA
		 * 
		 * ��� ��ǥ���� �ٸ� ��ǥ�� �� �� �ִ� �� 3���� ��� �� ���� 
		 * ��, ���ο��� �ٷ� 90���� ���� �� ����
		 *  
		 * �밢���� �̾��� �� 3������ �� ����
		 * ���η� �̾��� �� �밢�� ���θ� ����
		 * ���η� �̾��� �� �밢�� ���θ� ����
		 * 
		 * 3���� DP ���̺�? 
		 * ���η� �̾����Ÿ� ���� ĭ + �밢���� ����� �� 
		 * ���η� �����Ÿ� �밢�� + ���� ����
		 * �밢���̸� 3��� ��� �ջ�
		 * 0 ���� 1 ���� 2 �밢 
		 * 
		 * ���̸� �׳� ������ ����
		 * + ���� ��ǥ�� 1�̸� ���ŵ� ���ϰ� ����
		 */
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		DP = new int[3][N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(map[1][i]==1) break; 
			DP[0][1][i] = 1;
		}
		
		for(int i=2; i<=N; i++) {
			for(int j=3; j<=N; j++) {
				// ��ĭ�� ���� ���
				if(map[i][j]==0) {
					if(map[i][j-1]!=1) DP[0][i][j] = DP[0][i][j-1]+DP[2][i][j-1];
					if(map[i-1][j]!=1) DP[1][i][j] = DP[1][i-1][j]+DP[2][i-1][j];
					if(map[i-1][j]!=1 && map[i][j-1]!=1 && map[i-1][j-1]!=1)
						DP[2][i][j] = DP[0][i-1][j-1] + DP[1][i-1][j-1] + DP[2][i-1][j-1];
				} 
			}
		}
		
		
		System.out.println(DP[0][N][N]+DP[1][N][N]+DP[2][N][N]);
		
	} // end of main 
} // end of class 












