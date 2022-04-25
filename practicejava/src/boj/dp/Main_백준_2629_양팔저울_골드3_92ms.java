package src.boj.dp;
import java.io.*;
import java.util.*;

public class Main_백준_2629_양팔저울_골드3_92ms {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		/*
		 * 왼쪽 == 오른쪽을 만들 수 있으면 된다.
		 * 만들 수 없다면 false 
		 * 
		 * 선택 미선택..으로 돌리는건 할 수 있겠는데 시간이 터질거 같다.
		 * 
		 * DP 테이블을 만들어서 접근해보자 (안쓰고 조합 쓰다가 시간 터진다) (최대 30개로 만드는 조합을 만들어야 하는데) 
		 * + 처음 주어진 추로 만들 수 있는 최대값은 15000이다.
		 * 
		 * 
		 * DP 테이블을 만드는 조건이 뭘까
		 * 이전 + 현재, 현재-이전 true ? 
		 */
		
		int N = Integer.parseInt(br.readLine());
		int[] weights = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			weights[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[][] dp = new boolean[N+1][15001];
		for(int i=0, k=1; i<N; i++, k++) {
			for(int j=0; j<=15000; j++) {
				if(weights[i]==j) dp[k][j] = true;
				// 현재 무게 위에 dp 테이블이 true인 경우 
				if(dp[i][j]) {
					// 현재 탐색하고 있는 추와 같거나 더 가벼운 무게를 확인중이라면 뺀 것도 추가
//					기존 
//					if(j<=weights[i]) dp[k][weights[i]-j] = true;
					dp[k][Math.abs(weights[i]-j)] = true; // 틀렸던 이유 -> 음수일 때 저울을 반대쪽에 저울을 올리는 것으로 무게를 알 수 있으니까 절대값
					dp[k][j] = true;
					dp[k][weights[i]+j] = true;
				}
			} // end of for j
		} // end of for 
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int check = 0;
		for(int i=0; i<M; i++) {
			// 확인할 추의 무게
			check = Integer.parseInt(st.nextToken());
			// 처음 주어진 추의 총무게합이 15000을 넘을 수 없다
			if(check>15000) sb.append("N").append(" ");
			else {
				sb.append(dp[N][check]?"Y":"N").append(" ");
			} // end of else 
		} // end of for 
		
		System.out.println(sb.toString());
		
	} // end of main 

} // end of class 