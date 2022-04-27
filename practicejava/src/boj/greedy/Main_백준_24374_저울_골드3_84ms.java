package src.boj.greedy;

import java.io.*;
import java.util.*;

public class Main_백준_24374_저울_골드3_84ms {
	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] weights = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			weights[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(weights);
		int check = 0;
		for(int w:weights) {
			if(check+1 < w) break;
			check+=w;
		}
		// 누적합 방식을 사용한 예제
		// 11234라는 값이 주어졌다고 가정하자
		// 우선 확인해야 할 값은, 현재 찾고자하는 값인, 즉 누접합 + 1인 값.
		// 왜냐하면 구할 수 없는 값들 중 최솟값은
		// 구할 수 있는 값+1 중 구할 수 없는 값일 때이기 때문이다.
		System.out.println(check+1);
	} // end of main
	
} // end of class 








