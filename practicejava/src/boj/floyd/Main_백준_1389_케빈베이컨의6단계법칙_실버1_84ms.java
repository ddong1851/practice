package src.boj.floyd;

import java.io.*;
import java.util.*;

public class Main_백준_1389_케빈베이컨의6단계법칙_실버1_84ms {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int INF = 999_999;
		
		int[][] map = new int[N][N];
		for(int i=0; i <N; i++) Arrays.fill(map[i], INF);
		
		int a, b;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken())-1;
			b = Integer.parseInt(st.nextToken())-1;
			map[a][b] = 1;
			map[b][a] = 1; 
		}
		
		int temp;
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i==k || i==j) continue;
					temp = map[i][k] + map[k][j];
					if(map[i][j]>temp) map[i][j] = temp;
				}
			}
		}
		
		int max = INF;
		int minIdx = 0;
		int curr;
		for(int i=0; i<N; i++) {
			curr = 0;
			for(int j=0; j<N; j++) {
				if(map[i][j]==INF) continue;
				curr += map[i][j];
			}
			if(max>curr) {
				max = curr;
				minIdx = i;
			}
		}
		
		System.out.println(minIdx+1);
		
	} // end of main 
} // end of class 












