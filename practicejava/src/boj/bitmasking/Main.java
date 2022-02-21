package src.boj.bitmasking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 20304 비밀번호 제작*/
public class Main {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 비밀번호의 최대값 0 <= N <= 1_000_000
		int M = Integer.parseInt(br.readLine()); // 로그인이 시도된 비밀번호 개수 1 <= M <= 100_000
		
		/*
		 * 안전도 계산 
		 * ex ) 3은 0011 8은 1000 두 이진법은 각 3자리가 다르므로 3이다
		 * 
		 * 출력 안전도가 제일 높은 비밀번호의 안전도를 출력하라
		 */
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			
		}
		
	}
}
