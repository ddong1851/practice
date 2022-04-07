package src.boj.dp;

import java.io.*;
import java.util.*;

public class Main_백준_12015_가장긴증가하는부분수열2_골드2_460ms {
	
	private static int[] LIS;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		/*
		 * 이진탐색을 이용한 LIS를 하면
		 * LIS[]에 저장된 값들 중 
		 * LIS[] < arr[i] <= LIS[k] 인 부분을 찾아서
		 * LIS[k] = arr[i] 로 갱신한다.
		 * 이는, k개 연속인 LIS를 이루는 최소값을 저장하는 행동이다.
		 * 
		 */
		
		int[] arr = new int[N];
		LIS = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int len = 0;
		int idx = 0;
		for (int i = 0; i < N; i++) {
			// 탐색할 숫자가 이전 값보다 크면 저장
			if(arr[i] > LIS[len]) {
				// 길이+1 에 해당 값 저장
				LIS[++len] = arr[i];
			}
			// 새로운 값이 num 수열의 최솟값과 최대값 사이에 있는 값이라면 이진탐색을 통해 기존 값 갱신
			else {
				idx = binarySearch(0, len, arr[i]);
				LIS[idx] = arr[i];
			}
		}
		// 모든 탐색이 끝나고 LEN의 길이가 전체 LIS의 최대값이 된다.
		System.out.println(len);
		
	} // end of main 

	private static int binarySearch(int low, int high, int key) {
		int mid = 0;
		while(low<high) {
			mid = (low+high)/2;
			if(LIS[mid] < key) low = mid+1;
			else high = mid;
		}
		return high;
	}
	
} // end of class 








