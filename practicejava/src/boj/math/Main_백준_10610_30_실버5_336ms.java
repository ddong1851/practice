package src.boj.math;

import java.util.Arrays;
import java.util.Scanner;

/** Main_����_10610_30_�ǹ�5_336ms*/
// �׸��� �˰���
// 3�� ����� Ư¡! ��� �ڸ����� ���� 3�� ����̴�, ���� ���� 10�� ������� �ϰ�, 3�� ������� �Ѵ�
public class Main_����_10610_30_�ǹ�5_336ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		
		// ���ڸ����� 
		if(n.length()<=1) {
			System.out.println(-1);
			System.exit(0);
		}
		sc.close();
		// char �迭 ���� ���� �����ϰ� �ϱ�
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
