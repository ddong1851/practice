package src.swea;

import java.io.*;
import java.util.*;

public class Solution_SWEA_5604_구간합_D4_104ms {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		/*
		 * 구간합 구하는 문제
		 * 8 12 가 주어지면 
		 * 8 + 9 + 1 + 0 + 1 + 1 + 1 + 2 = 23 을 출력. 이런식으로 진행해야 한다.
		 * 수는 최대 10^15승의 값이 온다 => long 타입 사용
		 * 연산을 10^15승하면 무조건 터진다
		 * 
		 * 자리수만큼 modulo 10 하자
		 * 
		 * 수들 간의 관계식을 도출해야 한다.
		 * https://www.slideshare.net/Baekjoon/baekjoon-online-judge-1019
		 * https://tv.naver.com/v/22678458
		 * 풀이 참고
		 * 
		 * 해석
		 * 끝자리를 0~9로 매핑하면서 
		 * modulo 10을 반복하며 0~9가 몇번 나왔는지 카운팅을 한다.
		 * 
		 */
		
		long A, B, ans, rowCnt, mult;
		long[] nums = new long[10];
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			mult = 1;
			while(A<=B) {
				// A의 끝 수를 0으로 맞추기 위한 작업
				for(; A%10!=0 && A<=B; A++) {
					parse(A, nums, mult);
				}
				// B의 끝 수를 9로 맞추기 위한 작업
				for(; B%10!=9 && A<=B; B--) {
					parse(B, nums, mult);
				}
				// 짜투리 처리 시 범위를 벗어나버리면
				if(A>B) break;
				// 0~9까지의 row를 처리한다. --> row의 수만큼 추가
				A/=10;
				B/=10;
				rowCnt = B-A+1;
				for(int i=0; i<10; i++) {
					nums[i]+=rowCnt*mult;
				}
				mult*=10;
			} // end of while 
			
			// 총합 계산, 0은 곱하면 0이니까 빼고
			ans = 0;
			for(int i=1; i<10; i++) {
				ans += i*nums[i];
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			Arrays.fill(nums, 0);
		}
		
		System.out.println(sb.toString());
		
	} // end of main 
	
	private static void parse(long x, long[] nums, long add) {
		while(x>0) {
			nums[(int)(x%10)]+=add;
			x/=10;
		}
	} // end of parse ( 짜투리 처리 ) 

} // end of class 











