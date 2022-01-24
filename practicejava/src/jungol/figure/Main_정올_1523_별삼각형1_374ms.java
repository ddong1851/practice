package src.jungol.figure;

import java.util.Scanner;

/** Main_정올_1523_별삼각형1_374ms*/
public class Main_정올_1523_별삼각형1_374ms {
	
	static char star = '*';
	
	static void type1(int n) {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(star);
			}
			System.out.println();
		}
	}
	
	
	static void type2(int n) {
		for(int i=n-1; i>=0; i--) {
			for(int j=i; j>=0; j--) {
				System.out.print(star);
			}
			System.out.println();
		}
	}
	
	
	static void type3(int n) {
		for(int i=1; i<=n; i++) {
			for(int j=n-i; j>0; j--) {
				System.out.print(" ");
			}
			for(int j=0;j<2*i-1;j++) {
				System.out.print(star);
			}
			System.out.println();
		}
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		if(n<=0 || n>100 || m<1 || m>4) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		switch (m) {
		case 1:
			type1(n);
			break;
		case 2:
			type2(n);
			break;
		case 3:
			type3(n);
			break;
		}
		
		
	}
}
