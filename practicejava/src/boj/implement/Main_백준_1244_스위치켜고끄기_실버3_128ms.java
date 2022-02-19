package src.boj.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1244_스위치켜고끄기_실버3_128ms{
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine())+1;
		
		int[] switches = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<N; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		switches[0] = 100;
		int students = Integer.parseInt(br.readLine());
		
		for(int i=0; i<students; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int key = Integer.parseInt(st.nextToken());
			remote(gender, key, switches, N);
		}
		
		// 정답 출력
		printAnswer(switches, N);
		
	} // end of main

	private static void printAnswer(int[] switches, int N) {
		StringBuilder sb = new StringBuilder();
		if(N<=20) {
			for(int i=1; i<N; i++) {
				sb.append(switches[i]).append(" ");
			}
		} 
		else {
			int repeat = (N-1)/20;
			for(int i=0; i<repeat; i++) {
				for(int start = i*20+1, end = start+20, j=start; j<end; j++) {
					sb.append(switches[j]).append(" ");
				}
				sb.append("\n");
			}
			for(int start = 20*repeat+1, i=start; i<N; i++) {
				sb.append(switches[i]).append(" ");
			}
		}
		System.out.println(sb.toString());
	}

	private static void remote(int gender, int key, int[] switches, int length) {
		// 남자일 때
		if(gender==1) {
			int add = key;
			while(key<length) {
				// 비트 반전
				switches[key] = Math.abs(switches[key]-1);
				key+=add;
			}
		}
		// 여자일 때
		else {
			// 첫번째 자리는 무조건 바꾸기
			switches[key] = Math.abs(switches[key]-1);;
			int left = key-1; int right = key+1;
			while(true) {
				// 범위를 벗어나면 혹은 왼쪽 오른쪽이 불일치하면 벗어나기
				if((left<1 || right >= length) || switches[left]!=switches[right]) break;
				// 좌우 바꾸기
				int num = Math.abs(switches[left]-1);;
				switches[left--] = switches[right++] = num;
			}
		}
	}
} // end of class 


//42
//0 1 0 1 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//1
//1 6
