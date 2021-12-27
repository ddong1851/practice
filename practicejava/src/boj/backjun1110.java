package src.boj;

import java.util.Scanner;

//백준 1110
public class backjun1110 {
	
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
