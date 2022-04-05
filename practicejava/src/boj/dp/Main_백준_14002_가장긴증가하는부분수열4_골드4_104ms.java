package src.boj.dp;

import java.io.*;
import java.util.*;

public class Main_백준_14002_가장긴증가하는부분수열4_골드4_104ms {
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] LIS = new int[n];
		int[] path = new int[n];
		Arrays.fill(path, -1);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		/*
		 * 포인트 
		 * 경로를 -1로 초기화하고, 
		 * 보통 max = 0으로 초기화를 하는데
		 * n==1이면 
		 * max = 1로 바꾸고 출력 
		 */
		
		
		if(n==1) {
			System.out.println(1);
			System.out.println(arr[0]);
		}
		else {
			int max=0;
			int maxIndex = 0;
			for (int i = 0; i < n; i++) {
				LIS[i] = 1;
				for (int j = 0; j < i; j++) {
					if(arr[i]>arr[j] && LIS[i] <= LIS[j]) {
						LIS[i] = LIS[j] + 1;
						path[i] = j;
					}
					if(max<LIS[i]) {
						max = LIS[i];
						maxIndex = i;
					}
				}
			}
			
			String answer = "";
			System.out.println(max);
			while(path[maxIndex]!=-1) {
				answer = arr[maxIndex] + " " + answer;
				maxIndex = path[maxIndex];
			}
			answer = arr[maxIndex] + " " + answer;
			System.out.println(answer);
		}
		
	} // end of main 
	
} // end of class 







