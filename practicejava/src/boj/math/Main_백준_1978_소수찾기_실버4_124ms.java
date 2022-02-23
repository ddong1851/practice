package src.boj.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main_백준_1978_소수찾기_실버4_124ms {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<Integer> set = new HashSet<Integer>();
		for(int i=1; i<=1000; i++) {
			if(checkPrime(i)) set.add(i);
		}
		int cnt = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreElements()) {
			if(set.contains(Integer.parseInt(st.nextToken()))) cnt++; 
		}
		System.out.println(cnt);
	}

	private static boolean checkPrime(int num) {
		// TODO Auto-generated method stub
		if(num<2) return false;
		for(int i=2; i*i<num; i++) {
			if(num%i==0) return false;
		}
		return true;
	}
}
