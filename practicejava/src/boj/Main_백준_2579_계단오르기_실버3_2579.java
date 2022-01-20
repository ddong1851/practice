package src.boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Main_백준_2579_계단오르기_실버3_2579
 * @author HD
 *
 */

public class Main_백준_2579_계단오르기_실버3_2579 {
	static int [] dp;
	static int [] stair;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // < 300
		
		stair = new int[n+1]; // 점수 <= 10000
		dp = new int[n+1];
		
		Arrays.fill(dp, -1);
		
		for(int i=1; i<=n; i++) {
			stair[i] = sc.nextInt();
		}
		sc.close();
		
		// 0일때 0으로 초기화
		dp[0] = 0;
		dp[1] = stair[1];
		if(n>=2) {
			dp[2] = stair[1] + stair[2];
		}
		// 탑다운으로 할 때 기본적으로 이렇게 호출하고,
		System.out.println(recur(n));
	}
	
	/**여기에 내가 생각한 점화식을 메서드로 작성*/
	private static int recur(int x) {
		if(dp[x]==-1) {
			dp[x] = Math.max(stair[x-1] + recur(x-3), recur(x-2)) + stair[x];
		}
		return dp[x];
	}
}
