package src.boj;

import java.util.Scanner;

/**
 * Main_백준_1932_정수삼각형_실버1_
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
		
		//삼각형 값 초기화
		for (int i = 0; i < n; i++) {
			for(int j=0; j<=i; j++) {
				triangle[i][j] = sc.nextInt();
			}
		}
		
		//삼각형을 초기화
		for(int i=n-2; i>=0; i--) {
			for(int j=0; j<=i; j++) {
				
			}
		}
	}

}
