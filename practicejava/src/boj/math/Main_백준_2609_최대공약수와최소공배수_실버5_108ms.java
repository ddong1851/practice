package src.boj.math;

import java.util.Scanner;

public class Main_백준_2609_최대공약수와최소공배수_실버5_108ms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		sc.close();
		
		int res = GCD(A, B);
		System.out.println(res);
		System.out.println(A*B/res);
		
	} // end of main 
	
	private static int GCD(int a, int b) {
		while(b!=0) {
			int r = a%b;
			a = b;
			b = r;
		}
		return a;
	}

} // end of class 







