package src.boj.floyd;

import java.io.*;
import java.util.*;

/** Main_����_2458_Ű����_���4_608ms*/
public class Main_����_2458_Ű����_���4_608ms {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		final int INF = 999_999;
		
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) Arrays.fill(map[i], INF);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken())-1;
			int p2 = Integer.parseInt(st.nextToken())-1;
			// p1 < p2 
			map[p1][p2] = 1;
		}
		
		for(int k=0; k<N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i==k || i==j) continue;
					if(map[i][j] > map[i][k] + map[k][j]) map[i][j] = map[i][k] + map[k][j];
				}
			}
		}
		
		// �� ���� �� �� �ִ� �� + �� ��尡 �� �� �ִ� �� ī����
		int go, come;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			go = come = 0;
			// i��° ��尡 �� �� �ִ� ��� �� ī����
			for (int j = 0; j < N; j++) {
				if (map[i][j] != INF)
					go++;
				if (map[j][i] != INF)
					come++;
			}
			if (go + come == N - 1)	cnt++;
		}
		System.out.println(cnt);
	} // end of main
} // end of class 









