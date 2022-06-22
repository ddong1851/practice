package src.programmers.kakao2022;

import java.util.*;

public class Solution_k진수에서소수개수구하기 {
	
	public static void main(String[] args) {
		int n = 1000000;
		int k = 2;
		System.out.println(solution(n, k));
	}
	
	public static int solution(int n, int k) {
        String toN = Integer.toString(n, k);
        StringTokenizer st = new StringTokenizer(toN, "0");
        int prime = 0;
        while(st.hasMoreTokens()) {
        	String check = st.nextToken();
        	if(!check.equals("1") && isPrime(Long.parseLong(check))) prime++;
        }
        
        return prime;
    } // end of solution 
	
	// 최악의 경우 33억? 정도 순사적으로 탐색해야 함.
	private static boolean isPrime(Long check) {
		if(check==2) return true;
		for(int i=2; i<=Math.sqrt(check); i++) {
			if(check%i==0) return false;
		}
		return true;
	} // end of isPrime
	
	
} 
