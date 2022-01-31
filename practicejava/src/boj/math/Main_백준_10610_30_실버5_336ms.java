package src.boj.math;

import java.util.Arrays;
import java.util.Scanner;

/** Main_백준_10610_30_실버5_336ms*/
// 그리디 알고리즘
// 3의 배수의 특징! 모든 자릿수의 합이 3의 배수이다, 나의 접근 10의 배수여야 하고, 3의 배수여야 한다
public class Main_백준_10610_30_실버5_336ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		
		// 한자리수면 
		if(n.length()<=1) {
			System.out.println(-1);
			System.exit(0);
		}
		sc.close();
		// char 배열 역순 정렬 간단하게 하기
		char[] srr = n.toCharArray();
		Arrays.sort(srr);
		if(srr[0]!='0'){
			System.out.println(-1);
			System.exit(0);
		}
		int count=0;
		for(int size = n.length(), i=0; i<size; i++) {
			count+=(int)(srr[i]-'0');
		}
		if(count%3!=0) {
			System.out.println(-1);
			System.exit(0);
		}
		StringBuilder sb = new StringBuilder(String.valueOf(srr));
		String temp = sb.reverse().toString();
		System.out.println(temp);
	}
}
