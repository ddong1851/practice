package src.swea;

import java.io.*;
import java.util.*;

public class Solution_SWEA_3307_최장증가부분수열_D3_176ms {
	
	private static int N, max;
	private static int[] arr, LIS;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		for (int test = 1; test <= TC; test++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			LIS = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			max = 0;
			for(int i=0; i<N; i++) {
				LIS[i] = 1;
				for(int j=0; j<i; j++) {
					if(arr[i]>arr[j] && LIS[i]<=LIS[j]) {
						LIS[i] = LIS[j] + 1;
					}
				}
				if(max<LIS[i]) max=LIS[i];
			}
			sb.append("#").append(test).append(" ").append(max).append("\n");
		} // end of for TC
		System.out.println(sb.toString());
	} // end of main 
} // end of Solution 
