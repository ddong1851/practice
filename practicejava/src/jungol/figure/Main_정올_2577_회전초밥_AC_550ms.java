package src.jungol.figure;

import java.io.*;
import java.util.*;

public class Main_정올_2577_회전초밥_AC_550ms {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		/*
		 * IDEA
		 * 
		 * 중복되는 칸들을 매번 새로 선택하고 보는 것보다
		 * 맨 앞 한칸을 빼고 맨 뒤에 새로 읽을 접시를 보는게 좋다
		 * 
		 * 초밥을 읽을 때(?) 쿠폰 초밥을 포함하는지 안하는지를 확인하고
		 * 포함하지 않는다면 쿠폰 초밥 추가 ( +1 ) 
		 * 
		 * 슬라이딩 윈도우로 풀면 되는 문제
		 */
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());
		
		go(arr, N, d, k, c);
		
	} // end of main 

	private static void go(int[] arr, int N, int d, int k, int c) {
		int max = 0;
		int count = 0;
		int[] using = new int[d+1];
		
		Queue<Integer> q = new LinkedList<>();
		// 초기 상태 체크
		int start = 0;
		for(int i=0; i<k; i++) {
			if(using[arr[start]]++==0) 
				count++;
			q.offer(arr[start++]);
		}
		
		max = count;
		if(using[c]==0) max++;
		if(max==k+1) {
			System.out.println(k+1);
			return;
		}
		
		// i에서 시작하는 모든 가지수 확인
		for(int i=1; i<N; i++) {
			// 1. 첫번째꺼 뺴기
			if(--using[q.poll()]==0) --count;
			// 2. 맨 끝에 새로운 초밥 추가
			if((using[arr[(i+k-1)%N]]++)==0) count++;
			q.offer(arr[(i+k-1)%N]);
			// 3. 쿠폰 초밥 추가 여부 확인
			if(using[c]==0) count++; // 종류 추가 
			// 4. 최대 초밥 종류 수 갱신 
			if(max<count) max = count; 
			// 5. 쿠폰이 있었다면 뺴기
			if(using[c]==0) count--;
			// 6. 만약 초밥 종류 수가 k+1이면 무조건 최대니까 종료
			if(max == k+1) break;
		}
		System.out.println(max);
	}
	
} // end of class