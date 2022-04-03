package src.boj.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/** Main_백준_12865_평범한배낭_골드5_시간초과*/
public class Main_백준_12865_평범한배낭_골드5_148ms {
	

	private static int N;
	private static int K;
	private static int[][] items;
	private static int[][] dp;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		items = new int[N+1][2];
		dp = new int[N+1][K+1]; // 0~K
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			items[i][0] = Integer.parseInt(st.nextToken());
			items[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 아이템 개수 선택
		for(int i=1; i<=N; i++) {
			// 모든 무게 확인
			for(int w=1; w<=K; w++) {
				// 현재 아이템의 무게가 확인할 무게보다 무겁다면 DP 배열 위의 값을 가져온다.
				if(items[i][0]>w) dp[i][w] = dp[i-1][w];
				// 위의 값을 그대로 가져오기 vs 현재 아이템의 가치 + 해당 아이템을 추가하여 추가하기 이전 가능 무게의 가치와의 합 
				else dp[i][w] = Math.max(items[i][1] + dp[i-1][w-items[i][0]], dp[i-1][w]);
			}
		}
		
		System.out.println(dp[N][K]);
		
		
	} // end of main 
	
} // end of class 

//10 999
//46 306
//60 311
//33 724
//18 342
//57 431
//49 288
//12 686
//89 389
//82 889
//16 289





