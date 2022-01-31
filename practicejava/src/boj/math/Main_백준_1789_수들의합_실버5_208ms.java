package src.boj.math;

import java.util.Scanner;

/** Main_백준_1789_수들의합_실버5_208ms*/
public class Main_백준_1789_수들의합_실버5_208ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		sc.close();
		
		long l = 1;
		while(true) {
			long temp = ((long)Math.pow(l, 2)+l)/2;
			if(temp>n) {
				break;
			}
			l++;
		}
		System.out.println(l-1);
	}
}
