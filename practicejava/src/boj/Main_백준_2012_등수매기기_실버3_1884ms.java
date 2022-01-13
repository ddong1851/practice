package src.boj;

import java.util.Arrays;
import java.util.Scanner;
/**
 * Main_백준_2012_등수매기기_실버3_1884ms
 * @author HD
 *
 */
public class Main_백준_2012_등수매기기_실버3_1884ms {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int n = sc.nextInt();
		int [] ranks = new int[n];
		for(int i=0; i<n; i++) {
			ranks[i] = sc.nextInt();	
		}
		sc.close();
		Arrays.sort(ranks);
		//등수는 최대 500000, 개수도 500000인데, 이들의 값의 최대값이 21억보다 더 크므로 long에 저장한다.
		long count=0;
		for(int i=1; i<=n; i++) {
			count += Math.abs(i-ranks[i-1]);
		}
		System.out.println(count);
	} // end of main
} // end of class
