package src.jungol.figure;

import java.util.Arrays;
import java.util.Scanner;

/** Main_정올_1338_문자삼각형1_*/
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		char [][] figure = new char[n][n];
		// 반칸으로 채움
		for(char[] c:figure) {
			Arrays.fill(c, ' ');
		}
		
		// 계속 제자리에 초기화되고 있다.
		char p = 'A';
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				figure[j][n-j-1] =p++;
				if(p>'Z') p='A';
			}
		}
		
		
		
		for(char[] c:figure) {
			for(char a:c) {
				System.out.print(a);
			}
			System.out.println();
		}
		
		
		/*
		 * ex. n=5
		 * 				공백	출력
		 * 			*	4	1
		 * 		  * *	3	2
		 * 		* * *	2	3
		 * 	  * * * *	1	4
		 *  * * * * *	0	5
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
	}
}	
