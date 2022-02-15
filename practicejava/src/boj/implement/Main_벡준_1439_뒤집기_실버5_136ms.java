package src.boj.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_벡준_1439_뒤집기_실버5_136ms {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		 * 0인지 1인지 계속 비교, 이전 값을 기억하고 있는다
		 * 비트 마스킹으로 풀어도 되고, 하나씩 이전값과 비교하여
		 * 몇개의 연속된 문자열이 있는지 본다. 더 적은 것을 바꿔주면 됨
		 */
		
		char[] ch = br.readLine().toCharArray();
		int[] count = new int[2];
		char last = ch[0];
		for(int i=1; i<ch.length; i++) {
			if(last != ch[i]) {
				count[last-'0']++;
				last = ch[i];
			}
		}
		count[last - '0']++;
		System.out.println(Math.min(count[0], count[1]));
		
	} // end of main
} // end of Main
