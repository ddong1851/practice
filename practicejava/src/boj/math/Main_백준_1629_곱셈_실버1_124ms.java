package src.boj.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_����_1629_����_�ǹ�1_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		/*
		 * �ڿ��� A�� B�� ���� ���� C�� ���� �������� ����ض�
		 * 
		 * �������� ����غ���
		 * A^B = CQ + R
		 * 10^11 = (10+2)Q + R
		 * 
		 * ������ ������
		 * � �������� A�� ���� ���� B�� �־��� �� ������ �����ϴ� ����Q�� R�� �����Ѵ�
		 * A = B*Q + R
		 * �̷��� ���� ǥ���� �� A mod B = R�̶�� ����
		 * (A*B) mod C = ( A mod C * B mod C) mod C�� ����
		 * 
		 * A^B mod C = ((A mod C)^B) mod C �� ����.
		 * �� ������ �̿��Ͽ� ���� ������ ���� 2^90 mod 13�� ���� ������ �� �� �ִ�.
		 * 
		 * 
		 * 10^3%12 = (10mod12 * 10^2mod12)*mod12
		 * 		   = (10mod12)*((10mod12*10mod12)*mod12)*mod12
		 * 
		 * 
		 * �� ����� ���� ������ ���� ������ �� ���� �����÷��찡 �߻��Ѵ� ( 2147483646 2147483646 2147483647 )
		 * 
		 * (A+B)modC = (AmodC + BmodC)modC 
		 * (A-B)modC = (AmodC - BmodC)modC
		 * + 
		 * 
		 */
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		
		System.out.println(mod(A, B, C));
		
	}
	
//	// ����
//	private static long mod(long A, long B, long C) {
//		if(B==1) {
//			return A%C;
//		}
//		
//		return (A%C)*mod(A, B-1, C)%C;
//	}
	
	// �����Բ� ���� �����ϴ�,, 
	private static long mod(long A, long B, long C) {
		if(B==0) {
			return 1;
		}
		if(B==1) {
			return A%C;
		}
		
		// �̷��� 2�辿 ���̸鼭 �����ؾ� ���� Ƚ���� O(n)���� O(logN)���� �پ���..
		long remainder = mod(A,B/2,C);
		
		return (B%2==0)?(remainder*remainder)%C:((remainder*remainder)%C*A)%C;
	}
}