package src.jungol.figure;

import java.util.Scanner;

/**Main_����_1339_���ڻﰢ��2_423ms*/
public class Main_����_1339_���ڻﰢ��2_423ms {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		// ����� �Է¹��� ����
		int n = sc.nextInt();
		if(n<=0 || n>100 || n%2==0) {
			System.out.println("INPUT ERROR");
			return;
		}
		
		// 2���� �迭�� �����, �ش� �迭�� ���� ���� ����
		int r = n/2; // ���� ���̴� ������ ����
		char [][] figure = new char[n][r+1];
		// �迭�� �� ���� �ʱⰪ
		char p = 'A';
		
		// ���� ���� ��ŭ �ݺ� 
		for(int i=0; i<=r; i++) {
			// ��� ������ +2�� �ñ� ������ 2*i, �׸��� Ȧ���� ����� ���� +1
			int range = 2*i+1;
			for(int j=0;j<range;j++) {
				//		����	   ����
				figure[r-i+j][r-i] = p++;
				// ����� �� ���ĺ� ������ ����� A�� �ʱ�ȭ
				if(p>'Z') p='A';
			}
		}
		
		// ���
		for(char[] c:figure) {
			for(char a:c) {
				sb.append(a+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
		/*
		 * 
		 * 	  5	 
		 *    6 2
		 *    7 3 1
		 *	  8	4 
		 *    9
		 * 
		 */
		
		
	}

}
