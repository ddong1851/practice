package src.boj.dp;

import java.util.Scanner;

/**
 * Main_백준_1932_정수삼각형_실버1_968ms
 * @author HD
 *
 */
public class Main_백준_1932_정수삼각형_실버1_968ms {
	public static int [][] triangle;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		triangle = new int[n][n];
		
		//삼각형 값 초기화
		for (int i = 0; i < n; i++) {
			for(int j=0; j<=i; j++) {
				triangle[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		//삼각형 자체를 초기화 하는데, 점화식을 사용
		for(int i=n-2; i>=0; i--) {
			for(int j=0; j<=i; j++) {
				triangle[i][j] = Math.max(triangle[i][j]+triangle[i+1][j], triangle[i][j]+triangle[i+1][j+1]); 
			}
		}
		
		System.out.println(triangle[0][0]);
	}

}
