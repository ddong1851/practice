package src.jungol.figure;

import java.util.Scanner;

/**Main_정올_1291_구구단_379ms*/
public class Main_정올_1291_구구단_379ms {
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = 0;
		int e = 0;
		
		while(true) {
			s = sc.nextInt();
			e = sc.nextInt();
			if(s>=2 && s<=9 && e>=2 && e<=9) break;
			else System.out.println("INPUT ERROR!");
		}
		
		sc.close();
		if(s==e) {
			for(int i=1; i<=9; i++) {
				String str = String.format("%d * %d = %2d\n", s, i, s*i);
				sb.append(str);
			}
		}
		else if(s>e) {
			downwords(s, e);
		}
		else {
			upwords(s, e);
		}
		
		System.out.println(sb.toString());
		
	}
	
	static void upwords(int start, int end) {
		for(int i=1; i<=9; i++) {
			for(int s=start; s<=end; s++) {
				String str = String.format("%d * %d = %2d   ", s, i, s*i);
				sb.append(str);
			}
			sb.append("\n");
		}
	}
	
	static void downwords(int start, int end) {
		for(int i=1; i<=9; i++) {
			for(int s=start; s>=end; s--) {
				String str = String.format("%d * %d = %2d   ", s, i, s*i);
				sb.append(str);
			}
			sb.append("\n");
		}
	}
}
