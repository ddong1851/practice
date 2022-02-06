package src.boj.math;

import java.util.Scanner;

/** Main_����_1929_�Ҽ����ϱ�_�ǹ�2_588ms*/
public class Main_����_1929_�Ҽ����ϱ�_�ǹ�2_588ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int M = sc.nextInt();
		int N = sc.nextInt();

		for(int i=M; i<=N; i++) {
			if(checkPrime(i)) sb.append(i).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static boolean checkPrime(int num) {
		if(num < 2) {
			return false;
		}
		for(int i=2; i*i<=num; i++) {
			if(num%i==0) return false;
		}
		return true;
	}
}
