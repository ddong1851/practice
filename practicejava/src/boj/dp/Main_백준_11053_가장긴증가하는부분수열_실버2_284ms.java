package src.boj.dp;

import java.util.Arrays;
import java.util.Scanner;
/**
 * Main_백준_11053_가장긴증가하는부분수열_실버2_284ms
 * @author HD
 *
 */
public class Main_백준_11053_가장긴증가하는부분수열_실버2_284ms {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		int [] dp = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		} // end of for_init array
		sc.close();
		
		for (int i = 0; i < dp.length; i++) {
			dp[i]=1; // 값이 있으면 무조건 1이니까 1로 초기화를 한다(방문하면)
			
			// 현재 값이 이전 값들보다 더 크고, 현재 dp 값이 이전 dp값보다 작거나 같은경우 그 값 기준으로 +1(현재 dp는 처음에 1로 초기화됨)
			for(int j=0; j<i; j++) {
				if(arr[j] < arr[i] && dp[i] <= dp[j]) {
					dp[i] = dp[j]+1;
				}
			}
		}
		
		// dp 배열의 맨끝값이 무조건 가장 큰 값이니까 이를 출력
		Arrays.sort(dp);
		System.out.println(dp[n-1]);
	} // end of main

} // end of class
