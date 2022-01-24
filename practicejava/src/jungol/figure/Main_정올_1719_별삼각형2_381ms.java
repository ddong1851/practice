package src.jungol.figure;

import java.util.Scanner;

/**Main_정올_1719_별삼각형2_381ms*/
public class Main_정올_1719_별삼각형2_381ms {
	
	static char star = '*';
	
	static void type1(int n) {
		int range = 0;
		int mid = n/2+1;
		for(int i=1; i<=n; i++) {
			if(i<=mid) {
				range = i;
			}
			else {
				range = n-i+1;
			}
			for(int j=0; j<range; j++) {
				System.out.print(star);
			}
			System.out.println();
		}
		
	}
	
	static void type2(int n) {
		int mid = n/2+1;
		int space = 0;
		int numStar = 0;
		for(int i=0; i<n; i++) {
			if(i<mid) {
				space =  mid - i-1;
				numStar = i+1;
			}
			else {
				space = i - mid + 1;
				numStar = 2*mid - i - 1;
			}
			for(int j=0;j<space;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<numStar;j++) {
				System.out.print(star);
			}
			System.out.println();
		}
	}
	
	static void type3(int n) {
		int mid = n/2 + 1;
		int space = 0;
		int numStar = 0;
		for(int i=0; i<n; i++) {
			if(i<mid) {
				space = i;
				numStar = n - 2*i;
			}
			else {
				space = n - i -1;
				numStar = n - 2 * space;
			}
			for(int j=0;j<space;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<numStar;j++) {
				System.out.print(star);
			}
			System.out.println();
		}
	}
	
	static void type4(int n) {
		int space = 0;
		int numStar = 0;
		int mid = n/2+1;
		for(int i=0; i<n; i++) {
			if(i<mid) {
				space = i;
				numStar = mid - i;
			}
			else {
				space = mid -1 ;
				numStar = i - mid + 2;
			}
			for(int j=0; j<space; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<numStar; j++) {
				System.out.print(star);
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(n<0 || n>=101 || n%2==0 || m<=0 || m>=5) {
			System.out.println("INPUT ERROR!");
			System.exit(0);
		}
		
		switch(m) {
		case 1:
			type1(n);
			break;
		case 2:
			type2(n);
			break;
		case 3:
			type3(n);
			break;
		case 4:
			type4(n);
			break;
		}
	}
}
