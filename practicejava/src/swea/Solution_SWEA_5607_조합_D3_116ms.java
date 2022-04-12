package src.swea;

import java.util.*;
import java.io.*;

/** Solution_SWEA_5607_조합_D3_116ms */
public class Solution_SWEA_5607_조합_D3_116ms {

	private static int N, R;
	private static final int P = 1_234_567_891;
//	private static final int P = 1_000_000_007;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		long[] fac = new long[1000001];
		fac[0] = 1;
		for (int i = 1; i <= 1000000; i++) {
			fac[i] = fac[i - 1] * i % P;
		}
		
		int TC = Integer.parseInt(br.readLine());
		for (int test = 1; test <= TC; test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			sb.append("#").append(test).append(" ").append(R==0?1:nCr(N, R, fac)).append("\n");
		} // end of for TC
		System.out.println(sb.toString());
	} // end of main

	private static long nCr(int n, int r, long[] fac) {
		if (r == 0)
			return 1L;
		// (n!modP)x((n-r)!^(P-2)modP)x(r!^(P-2)modP)modP
		return (fac[n] % P * power(fac[r], P - 2, P) % P * power(fac[n - r], P - 2, P) % P) % P;
	} // end of nCr by Fermat's little theorem

	private static long power(long x, long y, long p) {
		long res = 1L;
		x = x % p;
		while (y > 0) {
			if (y % 2 == 1)
				res = (res * x) % p;
			y = y >> 1;
			x = (x * x) % p;
		}
		return res;
	} // 분할정복을 통한 거듭제곱

} // end of class
