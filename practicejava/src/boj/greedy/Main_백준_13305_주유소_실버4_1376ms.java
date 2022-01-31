package src.boj.greedy;

import java.math.BigInteger;
import java.util.Scanner;

/** Main_����_13305_������_�ǹ�4_1376ms*/
public class Main_����_13305_������_�ǹ�4_1376ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long [] distance = new long[n-1];
		long [] cost = new long[n];
		
		for(int range=n-1, i=0; i<range; i++) {
			distance[i] = sc.nextLong();
		}
		
		for(int range=n, i=0; i<range; i++) {
			cost[i] = sc.nextLong();
		}
		sc.close();
		
		// ���� �⸧ ��, ������ �ִ� 1000��, ���� �� �Ÿ� �ִ� 10000 ���ʹ� �ִ� 10000
		long price = cost[0];
		// total�� BigInteger�� �ؾ��Ҽ��� �ִ�
		long total = price*distance[0];
		BigInteger tot = new BigInteger(String.valueOf(total));
		for(int i=1; i<n-1; i++) {
			// ���� �����ҿ����� ����
			long temp = cost[i];
			// ���� ���ݰ� �ּ� ���� ��
			price = Math.min(temp, price);
			total = price*distance[i];
			tot = tot.add(new BigInteger(String.valueOf(total)));
		}
		System.out.println(tot);
	}
}