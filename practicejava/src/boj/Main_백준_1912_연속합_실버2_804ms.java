package src.boj;

import java.util.Scanner;

/**
 * Main_백준_1912_연속합_실버2_804ms
 * @author HD
 *
 */
public class Main_백준_1912_연속합_실버2_804ms {
	public static Scanner sc = new Scanner(System.in);
	public static int max = 0;
	public static Integer [] dp = new Integer[100001];
//	각 자리별 연속합의 최대 값을 저장
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = sc.nextInt();
		
//		n개 짜리 수열의 데이터를 저장할 배열
		int [] arr = new int [n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			// DP를 위해 첫줄 데이터 다 저장
		} // end of for
		
		dp[0] = arr[0];
		max = arr[0];
		solution(arr);
		
	} // end of main
	
//	바텀 업을 이용한 DP 문제
	private static void solution(int[] arrays) {
		// TODO Auto-generated method stub
		for(int i=1; i<arrays.length; i++) {
			dp[i] = Math.max(dp[i-1]+arrays[i], arrays[i]);
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	} // end of solution
} // end of class
