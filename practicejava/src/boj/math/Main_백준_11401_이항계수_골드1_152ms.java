package src.boj.math;

import java.util.Scanner;

/** nCr(조합)을 페르마 소정리와 팩토리얼을 분할정복으로 구하는 방식. */
public class Main_백준_11401_이항계수_골드1_152ms {
	private static final int P = 1_000_000_007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(nCr(sc.nextInt(), sc.nextInt()));
		sc.close();
	} // end of main 
	
	private static long nCr(int N, int R) {
		if(R==0) return 1L;
		long[] fac = new long[N+1];
		fac[0] = 1;
		for (int i = 1; i <= N; i++) {
			fac[i] = fac[i-1]*i%P;
		}
		return ((fac[N]%P)*power(fac[N-R])%P*power(fac[R])%P)%P;
	} // end of nCr using fermat's little theorem
	
	private static long power(long x) {
		long res = 1L;
		x = x % P;
		long y = P-2;
		while(y>0) {
			if(y%2==1) res = (res * x) % P;
			y = y >> 1;
			x = (x*x)%P;
		}
		return res;
	} // end of power with divide & Conquer
	
} // end of class 









