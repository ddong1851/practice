package src.boj.dp;

import java.io.*;
import java.util.*;

public class Main_백준_11404_플로이드_골드4_340ms {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		final int INF = 999_999_999; // 비용의 최대 100_000 도시의 수 100 --> 100_000_000 이 비용의 최대
		
		int[][] DP = new int[N][N];
		for(int i=0; i<N; i++) Arrays.fill(DP[i], INF);
		
		StringTokenizer st = null;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken())-1;
			int col = Integer.parseInt(st.nextToken())-1;
			int E = Integer.parseInt(st.nextToken());
			if(DP[row][col]>E) DP[row][col] = E;
		}
		
		// Floyd 
		for(int k=0; k<N; k++) {
			for(int from=0; from<N; from++) {
				for(int to=0; to<N; to++) {
					if(from==to || from==k) continue;
					if(DP[from][to] > DP[from][k] + DP[k][to]) DP[from][to] = DP[from][k] + DP[k][to];
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(DP[i][j]==INF) DP[i][j] = 0;
				sb.append(DP[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	} // end of main 
	
	
} // end of class 









