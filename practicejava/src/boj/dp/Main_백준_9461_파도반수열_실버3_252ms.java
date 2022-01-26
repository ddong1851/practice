package src.boj.dp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
/**
 * Main_백준_파도반수열_9461_실버3_252ms
 * @author HD
 *
 */
public class Main_백준_9461_파도반수열_실버3_252ms {
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//	100을 넣었을 때 값이 int의 범위를 벗어남
	public static long [] dp = new long[101];;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			bw.write(solution(a)+"\n");
		}
		sc.close();
		bw.close();
	}
	
	private static long solution(int param) {		
		for(int i=3; i<=param; i++) {
			if(dp[i]!=0) {
				continue;
			} else {
				dp[i] = dp[i-2] + dp[i-3];
			}
		}
		return dp[param];
	}
}
