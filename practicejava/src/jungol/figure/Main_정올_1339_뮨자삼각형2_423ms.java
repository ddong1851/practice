package src.jungol.figure;

import java.util.Scanner;

/**Main_정올_1339_뮨자삼각형2_423ms*/
public class Main_정올_1339_뮨자삼각형2_423ms {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		// 상수를 입력받을 변수
		int n = sc.nextInt();
		if(n<=0 || n>100 || n%2==0) {
			System.out.println("INPUT ERROR");
			return;
		}
		
		// 2차원 배열을 만들고, 해당 배열에 값을 넣을 예정
		int r = n/2; // 열의 길이는 높이의 절반
		char [][] figure = new char[n][r+1];
		// 배열에 들어갈 값의 초기값
		char p = 'A';
		
		// 가로 길이 만큼 반복 
		for(int i=0; i<=r; i++) {
			// 출력 개수가 +2씩 늘기 때문에 2*i, 그리고 홀수개 출력을 위한 +1
			int range = 2*i+1;
			for(int j=0;j<range;j++) {
				//		가변	   고정
				figure[r-i+j][r-i] = p++;
				// 출력할 때 알파벳 범위를 벗어나면 A로 초기화
				if(p>'Z') p='A';
			}
		}
		
		// 출력
		for(char[] c:figure) {
			for(char a:c) {
				sb.append(a+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
		/*
		 * 
		 * 	  5	 
		 *    6 2
		 *    7 3 1
		 *	  8	4 
		 *    9
		 * 
		 */
		
		
	}

}
