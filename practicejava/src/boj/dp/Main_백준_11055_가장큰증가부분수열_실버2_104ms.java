package src.boj.dp;

import java.io.*;
import java.util.*;

/** Main_백준_11055_가장큰증가부분수열_실버2_104ms*/
public class Main_백준_11055_가장큰증가부분수열_실버2_104ms {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] LIS = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int max = arr[0];
		for(int i=0; i<N; i++) {
			LIS[i] = arr[i];
			for(int j=0; j<i; j++) {
				if(arr[j] < arr[i]) {
					if(LIS[i] < LIS[j]+arr[i]) LIS[i] = LIS[j] + arr[i];
				}
				if(max<LIS[i]) max = LIS[i];
			}
		}
		System.out.println(max);
	} // end of main 
} // end of class 











