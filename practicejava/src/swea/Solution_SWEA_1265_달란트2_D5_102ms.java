package src.swea;

import java.io.*;
import java.util.*;

public class Solution_SWEA_1265_¥ﬁ∂ı∆Æ2_D5_102ms {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int test = 1; test <= TC; test++) {
			st = new StringTokenizer(br.readLine());
			sb.append("#").append(test).append(" ").append(go(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0, 1)).append("\n");
		} // end of for TC

		System.out.println(sb.toString());
	} // end of main 
	
	private static long go(int N, int R, int cnt, long mult) {
		if(cnt==R) {
			return mult;
		}
		int a = N/(R-cnt);
		return go(N-a, R, cnt+1, mult*a);
	}
	
} // end of class 





