package src.boj.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Main_백준_1149_수리공항승_실버3_212ms
 * @author HD
 *
 */
public class Main_백준_1449_수리공항승_실버3_212ms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//		물이 새는 곳 n, 테이프의 길이 L
		int n = sc.nextInt(); int l = sc.nextInt();
//		물이 새는 곳의 위치를 받을 배열
		int [] data = new int[n];
		for (int i = 0; i < n; i++) {
			data[i] = sc.nextInt();
		} // end of for 
		sc.close();
		
//		배열 오름차순 정렬
		Arrays.sort(data);
//		배열 간격간 차이를 합산하여 저장할 배열 
		int [] difference = new int[n-1];
		for(int i=0; i<n-1; i++) {
			difference[i] = data[i+1] - data[i];
		} // end of for
//		테이프의 길이와 배열을 넣고 개수를 출력하는 메서드
		solution(l, difference);
	} // end of main
	
	static void solution(int tape, int[] arr) {
//		한 곳만 구멍이 뚫려도 테이프가 필요하니 count=1; 
		int count=1; int tlen = 0;
//		차이 배열의 개수만큼 반복문을 돌린다. 
		for(int i=0; i<arr.length; i++) {
			tlen += arr[i];
			if(tlen>=tape) {
				count++;
				tlen=0;
				continue;
			}
		}
		System.out.println(count);
	} // end of solution

} // end of class
