package src.boj;

import java.util.Scanner;

/**
 * Main_����_1932_�����ﰢ��_�ǹ�1_
 * @author HD
 *
 */
public class Main {
	public static int [][] triangle;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		triangle = new int[n][n];
		
		//�ﰢ�� �� �ʱ�ȭ
		for (int i = 0; i < n; i++) {
			for(int j=0; j<=i; j++) {
				triangle[i][j] = sc.nextInt();
			}
		}
		
		//�ﰢ���� �ʱ�ȭ
		for(int i=n-2; i>=0; i--) {
			for(int j=0; j<=i; j++) {
				
			}
		}
	}

}
