package src.boj.math;

import java.io.*;
import java.util.*;

public class Main_백준_13977_이항계수와쿼리_골드1_572ms {
	
	private static final long P = 1_000_000_007;
	
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());
		
		int N, K;
		long[] fac = new long[4000001];
		fac[0] = 1;
		for(int i=1; i<=4000000; i++) {
			fac[i] = fac[i-1]*i%P;
		}
		
		for(int t=0; t<TC; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			sb.append(nCr(N, K, fac)).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}

	private static long nCr(int n, int r, long[] fac) {
		if(r==0) return 1L;
		return ((fac[n]%P)*power(fac[n-r])%P*power(fac[r])%P)%P;
	}

	private static long power(long x) {
		long res = 1L;
		x = x%P;
		long y = P-2;
		while(y>0) {
			if(y%2==1) res=(res*x)%P;
			y = y>>1;
			x = (x*x)%P;
		}
		return res;
	}
}
