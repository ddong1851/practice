package src.boj.dp;

import java.util.Scanner;

/**Main_백준_1149_RGB거리_실버1_292ms*/
public class Main_백준_1149_RGB거리_실버1_292ms {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] RGB = new int[n][3];
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(i==0) {
				RGB[i][0] = a;
				RGB[i][1] = b;
				RGB[i][2] = c;
			} // end of if
			else {
				RGB[i][0] = Math.min(a+RGB[i-1][1], a+RGB[i-1][2]);
				RGB[i][1] = Math.min(b+RGB[i-1][0], b+RGB[i-1][2]);
				RGB[i][2] = Math.min(c+RGB[i-1][0], c+RGB[i-1][1]);
			} // end of else
		} // end of for
		sc.close();
		
		int min = Math.min(RGB[n-1][0], Math.min(RGB[n-1][1], RGB[n-1][2]));
		
		System.out.println(min);
	} // end of main
} // end of class
