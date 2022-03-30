package src.boj.bitmasking;

import java.util.Scanner;

/** �ɺ�  Ʋ��*/
public class Main_����_1052_����_�ǹ�1_732ms {
	
	private static int K;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 1 <= N <= 10_000_000
		K = sc.nextInt(); // 1 <= K <= 1_000
		
		/*
		 * ����Ž������,
		 * N�� ���������� ǥ������ �� 1�� ������ K�� ���ϸ� ����
		 * 1�� ������ K�� ���ϰ� �ɶ����� 1�� ������
		 * 
		 * ��Ʈ����ŷ�� ���������, �����ھ��,,, 
		 */
		int cnt=0;
		while(!CountOnes(N)) {
			// �������� �����
			N++;
			cnt++;
		}
		sc.close();
		System.out.println(cnt);
	} // end of main
	
	private static boolean CountOnes(int n) {
		// TODO Auto-generated method stub
		String binary = Integer.toBinaryString(n);
		int cnt = 0;
		for(int i=0, range=binary.length(); i<range; i++) {
			if(binary.charAt(i)=='1') {
				cnt++;
			}
		}
		if(cnt<=K) return true;
		return false;
	}
	
} // end of Main