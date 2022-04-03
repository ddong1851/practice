package src.boj.dp;

import java.util.*;
import java.io.*;

/** Main_����_10844_�����ܼ�_�ǹ�1_112ms*/
public class Main_����_10844_�����ܼ�_�ǹ�1_112ms {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		/*
		 * ���� ���� 0�̸� 1 �ϳ��� �������� ����
		 * ���� ���� 9��� 8 �ϳ��� �������� ����
		 * �������� ��� �� -1, +1 �� �������� ���´�.
		 * �̸� ���� ��� ��츦 �����ϸ� �� �� ����.
		 * 
		 * + ������ ���� ���� ��ġ�� ������ ���� �˻��� ���� �˾ҳ׿�..
		 */
		
		// 1~9�� �����ϴ� ��� ������ Ȯ��
		int[][] dp = new int[n+2][10];
		for(int i=1; i<=9; i++) dp[1][i] = 1;
		
		for(int i=2; i<=n; i++) {
			for(int j=0; j<=9; j++) {
				if(j==0) dp[i][j] = dp[i-1][1];
				else if(j==9) dp[i][j] = dp[i-1][8];
				else dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
				dp[i][j]%=1_000_000_000;
			}
		}
		
		int total = 0;
		for(int i=0; i<=9; i++) {
			total=(total+dp[n][i])%1_000_000_000;
		}
		
		System.out.println(total);
		
		
	} // end of main 
	
	
} // end of class 















