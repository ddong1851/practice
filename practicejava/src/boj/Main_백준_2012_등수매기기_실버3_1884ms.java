package src.boj;

import java.util.Arrays;
import java.util.Scanner;
/**
 * Main_����_2012_����ű��_�ǹ�3_1884ms
 * @author HD
 *
 */
public class Main_����_2012_����ű��_�ǹ�3_1884ms {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int n = sc.nextInt();
		int [] ranks = new int[n];
		for(int i=0; i<n; i++) {
			ranks[i] = sc.nextInt();	
		}
		sc.close();
		Arrays.sort(ranks);
		//����� �ִ� 500000, ������ 500000�ε�, �̵��� ���� �ִ밪�� 21�ﺸ�� �� ũ�Ƿ� long�� �����Ѵ�.
		long count=0;
		for(int i=1; i<=n; i++) {
			count += Math.abs(i-ranks[i-1]);
		}
		System.out.println(count);
	} // end of main
} // end of class
