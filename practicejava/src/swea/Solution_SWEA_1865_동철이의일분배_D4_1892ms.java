package src.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1865_동철이의일분배_D4_1892ms {
	
	private static int N;
	private static double answer;
	private static double[][] P;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st  = null;
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			
			N = Integer.parseInt(br.readLine());
			P = new double[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					P[i][j] = Integer.parseInt(st.nextToken())/100.0;
				}
			}
			
			answer = 0;
			go(0, 1.0000000, new boolean[N]);
			sb.append("#").append(tc).append(" ").append(String.format("%.6f", answer*100)).append("\n");
		} // end of for 
		
		System.out.println(sb.toString());
		
	} // end of main

	private static void go(int cnt, double per, boolean[] bs) {
		if(cnt==N) {
			answer = per;
			return;
		} // end of 기저조건
		for(int i=0; i<N; i++) {
			if(!bs[i]) {
				double nextPer = per*P[cnt][i];
				if(nextPer==0 || nextPer<answer) continue; // 집계 확률이 정답 확률보다 적은 경우
				bs[i] = true;
				go(cnt+1, nextPer, bs);
				bs[i] = false;
			}
		}
	} // end of go 
} // end of class 














