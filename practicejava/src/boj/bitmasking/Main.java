package src.boj.bitmasking;

import java.util.Scanner;

/** 믈병  틀림*/
public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 1 <= N <= 10_000_000
		int K = sc.nextInt(); // 1 <= K <= 1_000
		
		/*
		 * N개의 물병을 가질 수 있다
		 * K개의 넘지 않는 비어있지 않은 물병을 만드려고 한다
		 * 
		 * 이진법을 이용하면,
		 * 1의 개수가 K개가 되기 위해 몇을 추가해야 하냐를 구하는 문제. 이건 너무 어렵다
		 * 
		 * 1의 개수가 K개 이하로 만든다 --> 계속 <<1을 해주고, <<1한 만큼이 답이다
		 */
		
		int cnt=0;
		while(CountOnes(N)>=K) {
			// 이진수로 만들기
			N++;
			cnt++;
		}
		
		System.out.println(cnt);
		
	} // end of main

	private static int CountOnes(int n) {
		// TODO Auto-generated method stub
		String binary = Integer.toBinaryString(n);
		int cnt = 0;
		for(int i=0, range=binary.length(); i<range; i++) {
			if(binary.charAt(i)=='1') {
				cnt++;
			}
		}
		return cnt;
	}
} // end of Main