package src.boj.dp;

import java.io.*;
import java.util.*;

public class Main_백준_11722_가장긴감소하는부분수열_실버2_104ms {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] LDS = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int max = 0;
		for(int i=0; i<n; i++) {
			LDS[i] = 1;
			for(int j=0; j<i; j++) {
				if(arr[j] > arr[i] && LDS[i] <= LDS[j]) LDS[i] = LDS[j] + 1;
			}
			if(max<LDS[i]) max = LDS[i];
		}
		
		System.out.println(max);
		
	}
}
