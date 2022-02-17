package src.boj.bitmasking;

import java.util.Scanner;

/** �ɺ�  Ʋ��*/
public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 1 <= N <= 10_000_000
		int K = sc.nextInt(); // 1 <= K <= 1_000
		
		/*
		 * N���� ������ ���� �� �ִ�
		 * K���� ���� �ʴ� ������� ���� ������ ������� �Ѵ�
		 * 
		 * �������� �̿��ϸ�,
		 * 1�� ������ K���� �Ǳ� ���� ���� �߰��ؾ� �ϳĸ� ���ϴ� ����. �̰� �ʹ� ��ƴ�
		 * 
		 * 1�� ������ K�� ���Ϸ� ����� --> ��� <<1�� ���ְ�, <<1�� ��ŭ�� ���̴�
		 */
		
		int cnt=0;
		while(CountOnes(N)>=K) {
			// �������� �����
			N++;
			cnt++;
		}
		
		System.out.println(cnt);
		
	} // end of main

	private static int CountOnes(int n) {
		// TODO Auto-generated method stub
		String binary = Integer.toBinaryString(n);
		int cnt = 0;
		for(int i=0, range=binary.length(); i<range; i++) {
			if(binary.charAt(i)=='1') {
				cnt++;
			}
		}
		return cnt;
	}
} // end of Main