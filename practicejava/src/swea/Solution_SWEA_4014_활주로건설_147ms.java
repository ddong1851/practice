package src.swea;

import java.io.*;
import java.util.*;

public class Solution_SWEA_4014_Ȱ�ַΰǼ�_147ms {
	
	private static int N, X, count, height, uproad;
	private static int[][] map;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		/*
		 * IDEA
		 * 
		 * ������ ���� ������ ����
		 * �ٸ�, �������θ� �� �� �ִ°� �ƴϰ� �� ������ ���θ� ��ġ�� �� ����.
		 * + �迭 ���� ������ ������ �� ���� ��ġ�� ������ ������ �ȵ�
		 * 
		 * row �� col�� 0 �� ��� ��ǥ���� �����غ���
		 * �������� ��찡 �� �� �����ϱ� �������� ��� ī�����ϰ�
		 */

		int TC = Integer.parseInt(br.readLine());
		for (int test = 1; test <= TC; test++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			count = 0;
			for(int i=0; i<N; i++) {
				if(go(0, i, new int[] {1, 0})) count++;
				if(go(i, 0, new int[] {0, 1})) count++;
			}
		
			sb.append("#").append(test).append(" ").append(count).append("\n");
		} // end of for TC
		System.out.println(sb.toString());
		
		
	} // end of main 
	
	private static boolean go(int sr, int sc, int[] dir) {
		height = map[sr][sc];
		uproad = 1;
		for(int i=1; i<N; i++) {
			sr += dir[0];
			sc += dir[1];
			// 2�� �̻� ���̰� ����
			if(Math.abs(height-map[sr][sc])>=2) return false;
			else if(height==map[sr][sc]) uproad++; // ������ ī���� 
			else {
				// ������ ��ġ���
				if(map[sr][sc]-height>0) {
					if(uproad<X) return false;
					else {
						uproad = 1;
						height = map[sr][sc];
					}
				} 
				// ������ ��ġ���
				else {
					// �������� ��ġ�ϸ� �迭 ������ �������
					if(i+X>N) return false;
					else {
						// X-1�� ��ġ �������� Ȯ��
						for(int j=1; j<X; j++) {
							sr += dir[0];
							sc += dir[1];
							i++;
							// ������ ��ġ ���� ���� ������ X �� ���;���
							if(height - map[sr][sc] != 1) {
								return false;
							}
						} // end of for
						height = map[sr][sc];
						uproad = 0;
					} // end of else 
				} // end of else 
			} // end of else down
		} // end of for 
		return true;
	} // end of go
	
} // end of class 




//1
//9 4
//4 4 3 3 3 3 2 2 2 
//4 4 3 3 1 1 2 2 3 
//3 3 2 2 1 1 1 1 2 
//1 1 1 1 1 1 1 1 1 
//1 1 1 1 1 1 1 1 1 
//2 2 1 1 1 1 1 1 1 
//2 2 1 1 1 1 1 1 1 
//2 2 2 2 2 2 1 1 1 
//3 3 3 3 2 2 2 2 1 

//1
//6 2
//3 3 3 2 1 1
//3 3 3 2 2 1
//3 3 3 3 3 2
//2 2 3 2 2 2
//2 2 3 2 2 2
//2 2 2 2 2 2







