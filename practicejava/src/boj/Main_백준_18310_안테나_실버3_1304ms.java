package src.boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Main_백준_18310_안테나_실버3_1304ms <br>
 * 딱 1개의 안테나를 구하는 문제에서는 가운데 위치한 안테나가 가장 효율이 좋다. 
 * 다만 여러개의 통신국을 설치할 때는 다르게 문제에 접근해야 한다. 
 * @author HD
 *
 */
// 가운데 위치한 집을 출력하면 끝인 문제다.
public class Main_백준_18310_안테나_실버3_1304ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int [] houses = new int[n];
		
		for (int i = 0; i < houses.length; i++) {
			houses[i] = sc.nextInt();
		}
		
		Arrays.sort(houses);
		
		int center = n%2==0?n/2-1:n/2;
		System.out.println(houses[center]);
	}
}
