package src.boj.recursive;

import java.math.BigInteger;
import java.util.Scanner;

/** Main_백준_1914_하노이탑_실버2_488ms*/
public class Main_백준_1914_하노이탑_실버2_488ms {
	
	static StringBuilder sb = new StringBuilder();
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		// n개짜리 원탑을 1번 기둥에서 2번 임시 기둥을 거쳐 3번 기둥으로 옮긴다.
		if(n<=20) {
			hanoi(n, 1, 2, 3);
			System.out.println(count);
			System.out.println(sb.toString());
		}
		else {
			System.out.println(hanoi2(n).toString());
		}
	}
	
	public static void hanoi(int n, int from, int temp, int dest) {
		if(n==0) return;
		// n-1 원탑들을 from에서 temp로 옮긴다.
		hanoi(n-1, from, dest, temp);
		// n번째 원탑을 from에서 dest로 옮긴다
		sb.append(from+" "+dest+"\n");
		// n-1 원탑을 temp에서 dest로 옮긴다
		hanoi(n-1, temp, from, dest);
		count++;
	}
	
	// 100까지 가면 long의 범위를 넘는다
	public static BigInteger hanoi2(int n) {
		if(n<=1) {
			return new BigInteger("1");
		}
		BigInteger temp = hanoi2(n-1).multiply(new BigInteger("2"));
		return temp.add(new BigInteger("1"));
	}
}
