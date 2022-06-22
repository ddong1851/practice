package src.boj.search;

import java.io.*;
import java.util.*;

/** 나무자르기*/
public class Main_백준_2805_나무자르기_실버3_480ms {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int maxH = 0;
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(maxH<arr[i]) maxH = arr[i];
		}
		
		int mid, minH;
		minH = 0;
		long left = 0;
		
		while(minH<maxH) {
			mid = (minH+maxH)/2;
			left = 0;
			for(int i=0; i<N; i++) {
				if(arr[i]>mid) {
					left+= arr[i]-mid;
				}
			}
			if(left<M) maxH = mid;
			else minH = mid + 1;
		}
		
		System.out.println(minH-1);

	}
}
