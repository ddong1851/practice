package src.boj.implement;

import java.util.Scanner;

//백?? 1110
public class bj1110 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.close();
		
		int temp = n;
		int count = 0;
		
		while(true) {
			n = ((n%10)*10)+(((n/10)+(n%10))%10);	
			count ++;								
			if(n==temp) { 							
				System.out.println(count);
				break;
			}
		}
	}
}