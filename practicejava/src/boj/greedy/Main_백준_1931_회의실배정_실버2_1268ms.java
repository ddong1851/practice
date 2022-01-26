package src.boj.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/** Main_백준_1931_회의실배정_실버2_1268ms*/
public class Main_백준_1931_회의실배정_실버2_1268ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		// 회의 시간을 저장할 배열
		int [][] time = new int[n][2];
		
		
		// 회의 시간 배정
		for(int i=0; i<n; i++) {
			time[i][0] = sc.nextInt();
			time[i][1] = sc.nextInt();
		}
		sc.close();
		
		// 끝 시간 기준 정렬
		Arrays.sort(time, new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[1]==o2[1]) {
					return o1[0]-o2[0];
				}
				else {
					return o1[1]-o2[1];
				}
			}			
		});
		
		
		// 가장 이른 시점에서 시작하여, 다음 회의 시간이 시작하는 시간이 이전 회의가 끝나는 시간과 같거나 더 크면, 
		// 끝나는 시간을 재정의하고, count를 증가시킨다.
		int count = 1;
		int end = time[0][1];
		for(int i=1; i<n; i++) {
			int start = time[i][0];
			if(end<=start) {
				end = time[i][1];
				count++;
			}
		}
		System.out.println(count);
	}
}	
