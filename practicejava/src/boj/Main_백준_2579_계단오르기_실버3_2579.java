package src.boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Main_����_2579_��ܿ�����_�ǹ�3_2579
 * @author HD
 *
 */

public class Main_����_2579_��ܿ�����_�ǹ�3_2579 {
	static int [] dp;
	static int [] stair;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // < 300
		
		stair = new int[n+1]; // ���� <= 10000
		dp = new int[n+1];
		
		Arrays.fill(dp, -1);
		
		for(int i=1; i<=n; i++) {
			stair[i] = sc.nextInt();
		}
		sc.close();
		
		// 0�϶� 0���� �ʱ�ȭ
		dp[0] = 0;
		dp[1] = stair[1];
		if(n>=2) {
			dp[2] = stair[1] + stair[2];
		}
		// ž�ٿ����� �� �� �⺻������ �̷��� ȣ���ϰ�,
		System.out.println(recur(n));
	}
	
	/**���⿡ ���� ������ ��ȭ���� �޼���� �ۼ�*/
	private static int recur(int x) {
		if(dp[x]==-1) {
			dp[x] = Math.max(stair[x-1] + recur(x-3), recur(x-2)) + stair[x];
		}
		return dp[x];
	}
}
