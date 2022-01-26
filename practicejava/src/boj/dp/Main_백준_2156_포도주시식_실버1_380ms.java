package src.boj.dp;

import java.util.Scanner;

/**
 * Main_백준_2156_포도주시식_실버1_380ms
 * @author HD
 *
 */
public class Main_백준_2156_포도주시식_실버1_380ms {
	private static int [] wine;
	private static int [] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		wine = new int[n+1];
		dp = new int[n+1];
		
		for (int i = 1; i <=n; i++) {
			wine[i] = sc.nextInt();
		}
		
//		top down 방식으로 해보자.
		dp[1] = wine[1];
//		n이 2개 이상일 때 두개를 더 한 값으로 초기화
		if(n>1)
			dp[2] = wine[1]+wine[2];	
		
		for(int i=3; i<=n; i++){
			dp[i] = Math.max(Math.max(wine[i]+dp[i-2], wine[i]+wine[i-1]+dp[i-3]), dp[i-1]);
		}
		
		System.out.println(dp[n]);
	}
}
