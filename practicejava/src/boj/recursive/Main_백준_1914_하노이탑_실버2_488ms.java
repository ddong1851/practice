package src.boj.recursive;

import java.math.BigInteger;
import java.util.Scanner;

/** Main_����_1914_�ϳ���ž_�ǹ�2_488ms*/
public class Main_����_1914_�ϳ���ž_�ǹ�2_488ms {
	
	static StringBuilder sb = new StringBuilder();
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		// n��¥�� ��ž�� 1�� ��տ��� 2�� �ӽ� ����� ���� 3�� ������� �ű��.
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
		// n-1 ��ž���� from���� temp�� �ű��.
		hanoi(n-1, from, dest, temp);
		// n��° ��ž�� from���� dest�� �ű��
		sb.append(from+" "+dest+"\n");
		// n-1 ��ž�� temp���� dest�� �ű��
		hanoi(n-1, temp, from, dest);
		count++;
	}
	
	// 100���� ���� long�� ������ �Ѵ´�
	public static BigInteger hanoi2(int n) {
		if(n<=1) {
			return new BigInteger("1");
		}
		BigInteger temp = hanoi2(n-1).multiply(new BigInteger("2"));
		return temp.add(new BigInteger("1"));
	}
}
