package src.boj.dp;

import java.util.Scanner;

/**
 * Main_����_1932_�����ﰢ��_�ǹ�1_968ms
 * @author HD
 *
 */
public class Main_����_1932_�����ﰢ��_�ǹ�1_968ms {
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
		sc.close();
		
		//�ﰢ�� ��ü�� �ʱ�ȭ �ϴµ�, ��ȭ���� ���
		for(int i=n-2; i>=0; i--) {
			for(int j=0; j<=i; j++) {
				triangle[i][j] = Math.max(triangle[i][j]+triangle[i+1][j], triangle[i][j]+triangle[i+1][j+1]); 
			}
		}
		
		System.out.println(triangle[0][0]);
	}

}
