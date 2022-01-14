package src.boj;

import java.util.Scanner;

/**
 * Main_����_1912_������_�ǹ�2_804ms
 * @author HD
 *
 */
public class Main_����_1912_������_�ǹ�2_804ms {
	public static Scanner sc = new Scanner(System.in);
	public static int max = 0;
	public static Integer [] dp = new Integer[100001];
//	�� �ڸ��� �������� �ִ� ���� ����
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = sc.nextInt();
		
//		n�� ¥�� ������ �����͸� ������ �迭
		int [] arr = new int [n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			// DP�� ���� ù�� ������ �� ����
		} // end of for
		
		dp[0] = arr[0];
		max = arr[0];
		solution(arr);
		
	} // end of main
	
//	���� ���� �̿��� DP ����
	private static void solution(int[] arrays) {
		// TODO Auto-generated method stub
		for(int i=1; i<arrays.length; i++) {
			dp[i] = Math.max(dp[i-1]+arrays[i], arrays[i]);
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	} // end of solution
} // end of class
