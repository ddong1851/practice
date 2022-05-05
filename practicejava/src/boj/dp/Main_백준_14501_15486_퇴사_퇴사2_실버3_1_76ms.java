package src.boj.dp;

import java.io.*;
import java.util.*;

public class Main_����_14501_15486_���_���2_�ǹ�3_1_76ms {
	
	public static void main(String[] args) throws Exception {
		
		/*
		 * �տ��� �����ϴ°ź��� �ڿ��� �����ϴ°� �� ����.
		 * ��� �ڸ����� �����ؼ� ���� �ڸ��� ����.. �ִ븦 ��� �����ϴ�? 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+2];
		int[][] interview = new int[N+2][2];
		
		StringTokenizer st = null;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			interview[i][0] = Integer.parseInt(st.nextToken());
			interview[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int curr = 0;
		for(int i=N; i>0; i--) {
			curr = i + interview[i][0];
			// ��� ���� ����Ǵ� �����̸�, ������ ������ �� ���󰡱�
			if(curr>N+1) dp[i] = dp[i+1];
			// �̹� ������ �ϴ� �Ͱ� ���� �� �� �� ū ���� ����.
			else dp[i] = Math.max(dp[i+1], dp[curr]+interview[i][1]);
		}
		
		System.out.println(dp[1]);
		
	} // end of main 
	
} // end of class 














