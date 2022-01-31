package src.boj.greedy;

import java.math.BigInteger;
import java.util.Scanner;

/** Main_백준_13305_주유소_실버4_1376ms*/
public class Main_백준_13305_주유소_실버4_1376ms {
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
		
		// 최종 기름 값, 마을은 최대 1000개, 도시 간 거리 최대 10000 리터당 최대 10000
		long price = cost[0];
		// total을 BigInteger로 해야할수도 있다
		long total = price*distance[0];
		BigInteger tot = new BigInteger(String.valueOf(total));
		for(int i=1; i<n-1; i++) {
			// 현재 주유소에서의 가격
			long temp = cost[i];
			// 현재 가격과 최소 값과 비교
			price = Math.min(temp, price);
			total = price*distance[i];
			tot = tot.add(new BigInteger(String.valueOf(total)));
		}
		System.out.println(tot);
	}
}