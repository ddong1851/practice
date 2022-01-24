package src.jungol.figure;

import java.util.Scanner;

/** Main_정올_1314_문자사각형2_309ms */
public class Main_정올_1314_문자사각형2_309ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		char [][] figure = new char[n][n];
		
		
		char p = 'A';
		int range = 0;
		for(int i=0; i<n; i++) {
			if(i%2==0) {
				for(int j=0;j<n;j++) {
					figure[j][i] = p++;
					if(p>'Z') p='A';
				}				
			}
			if(i%2==1) {
				for(int j=n-1; j>=0; j--) {
					figure[j][i] = p++;
					if(p>'Z') p='A';
				}
			}
		}
		
		for(char[] f:figure) {
			for(char c:f) {
				System.out.print(c+" ");
			}
			System.out.println();
		}
		
		
		/*
		 * 
		 * 1 8 9  16
		 * 2 7 10 15
		 * 3 6 11 14
		 * 4 5 12 13
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		
	}
}
