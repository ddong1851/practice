package src.boj.dp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Main_백준_1003_피보나치함수_실버3_236ms
 * @author HD
 *
 */
public class Main_백준_1003_피보나치함수_실버3_236ms {
	public static int[] zero;
	public static int[] one;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
//		초기화
		zero = new int[41];
		one = new int[41];
		zero[0] = one[1] = 1;
		zero[1] = one[0] = 0;
		
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			fibo(a);
			bw.write(zero[a]+" "+one[a]+"\n");
		}
		sc.close();
		bw.close();
	} // end of main
	
//	바텀 업으로 해결해보자.
	static void fibo(int param) throws IOException{
		for(int i=2; i<=param; i++) {
//			zero와 one의 값이 생성되지 않았다면 생성(쓸데없이 다시 연산하지 않기 위해)
			if(zero[i]==0 && one[i]==0) {
				zero[i] = zero[i-1] + zero[i-2];
				one[i] = one[i-1] + one[i-2];
			}
			else continue;
		}
	} // end of fibo method

} // end of class
