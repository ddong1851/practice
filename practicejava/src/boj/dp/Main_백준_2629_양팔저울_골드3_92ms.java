package src.boj.dp;
import java.io.*;
import java.util.*;

public class Main_����_2629_��������_���3_92ms {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		/*
		 * ���� == �������� ���� �� ������ �ȴ�.
		 * ���� �� ���ٸ� false 
		 * 
		 * ���� �̼���..���� �����°� �� �� �ְڴµ� �ð��� ������ ����.
		 * 
		 * DP ���̺��� ���� �����غ��� (�Ⱦ��� ���� ���ٰ� �ð� ������) (�ִ� 30���� ����� ������ ������ �ϴµ�) 
		 * + ó�� �־��� �߷� ���� �� �ִ� �ִ밪�� 15000�̴�.
		 * 
		 * 
		 * DP ���̺��� ����� ������ ����
		 * ���� + ����, ����-���� true ? 
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
				// ���� ���� ���� dp ���̺��� true�� ��� 
				if(dp[i][j]) {
					// ���� Ž���ϰ� �ִ� �߿� ���ų� �� ������ ���Ը� Ȯ�����̶�� �� �͵� �߰�
//					���� 
//					if(j<=weights[i]) dp[k][weights[i]-j] = true;
					dp[k][Math.abs(weights[i]-j)] = true; // Ʋ�ȴ� ���� -> ������ �� ������ �ݴ��ʿ� ������ �ø��� ������ ���Ը� �� �� �����ϱ� ���밪
					dp[k][j] = true;
					dp[k][weights[i]+j] = true;
				}
			} // end of for j
		} // end of for 
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int check = 0;
		for(int i=0; i<M; i++) {
			// Ȯ���� ���� ����
			check = Integer.parseInt(st.nextToken());
			// ó�� �־��� ���� �ѹ������� 15000�� ���� �� ����
			if(check>15000) sb.append("N").append(" ");
			else {
				sb.append(dp[N][check]?"Y":"N").append(" ");
			} // end of else 
		} // end of for 
		
		System.out.println(sb.toString());
		
	} // end of main 

} // end of class 