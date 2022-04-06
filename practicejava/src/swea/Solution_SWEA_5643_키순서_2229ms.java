package src.swea;

import java.io.*;
import java.util.*;

public class Solution_SWEA_5643_Ű����_2229ms {
	
	private static int N, M, cnt, p1, p2, temp, go, come;
	private static int INF = 999_999_999;
	private static int[][] map;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		/*
		 * IDEA
		 * 
		 * �׷����� ����.... 
		 * �� ��带 �����Ͽ� 
		 * ���� ���� ��� �� + ���� �Ʒ� ��� �� + ���� = ��ü ��� ����� �ڽ��� ����� �ƴ� ��尡 �ȴ�
		 * 
		 * --> �׷����� �̿��ϴ� �����ε�
		 * Ư�� ���� �� �� �ִ� ������ �� + Ư�� ��忡�� �� �� �ִ� ������ �� = ��ü ��� - 1�� ==> ������ �ȴ�.
		 * 
		 * �÷��̵� ������ �̿�����
		 * table�� ����, ���ο��� �� �� �ִ� ����� �� + ������ �� �� �ִ� ����� �� = N - 1�̸� ����� �ȴ�.
		 * 
		 * ���ͽ�Ʈ�� ����ϸ� ��� ��忡 ���� ���� �� �����ϸ鼭 
		 * int[] vis = [0, 0, 0, 0, 0, 0] 
		 * �� �迭���� i ��ǥ �湮 �����ϸ� vis[i]+1 �ϰ�, 
		 * ��� Ž���� ������ vis[i]�� ���� N-1�̸� �������� ����.
		 */
		
		int TC = Integer.parseInt(br.readLine());
		for (int test = 1; test <= TC; test++) {
			
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			cnt = 0;
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) Arrays.fill(map[i], INF);
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				p1 = Integer.parseInt(st.nextToken())-1;
				p2 = Integer.parseInt(st.nextToken())-1;
				// p1 < p2 
				map[p1][p2] = 1;
			}
			
			// �÷��̵� ����
			temp = 0;
			for(int k=0; k<N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(i==k || i==j) continue;
						temp = map[i][k] + map[k][j];
						if(map[i][j] > temp) map[i][j] = temp;
					}
				}
			}
			
			// �� ���� �� �� �ִ� �� + �� ��尡 �� �� �ִ� �� ī����
			for(int i=0; i<N; i++) {
				go = come = 0;
				// i��° ��尡 �� �� �ִ� ��� �� ī����
				for(int j=0; j<N; j++) {
					if(map[i][j]!=INF) go++;
					if(map[j][i]!=INF) come++;
				}
				if(go+come==N-1) cnt++;
			}
			
			sb.append("#").append(test).append(" ").append(cnt).append("\n");
			
		} // end of for TC

		System.out.println(sb.toString());
		
	} // end of main 
	
} // end of class 

//1
//6
//6
//1 5
//3 4
//5 4
//4 2
//4 6
//5 2







