package src.boj.greedy;

import java.util.Arrays;
import java.util.Scanner;

/** Main_백준_1339_단어수학_골드4_212ms*/
// 백준 1339 검색하여 정답 확인
/** 진짜 쉬운 방법은! 각 단어? 에 자리별로 10^n을 곱해서 제일 큰거부터 9의 값을 부여해보는 것*/
public class Main_백준_1339_단어수학_골드4_212ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 단어의 개수
		int n = sc.nextInt();
		// 26개의 알파벳을 담을 배열
		int [] alpha = new int[26];
		// 문자열을 담을 배열
		String [] srr = new String[n];
		// 단어들 입력
		for(int i=0; i<n; i++) {
			srr[i] = sc.next();
		}
		
		for(int i=0; i<n; i++) {
			int temp = (int)Math.pow(10, srr[i].length()-1);
			for(int j=0; j<srr[i].length(); j++) {
				// 문자열의 해당 자릿값에 10의 길이승만큼 곱한 것을 넣는다
				alpha[(int)(srr[i].charAt(j)-65)]+=temp;
				// 다음 자릿수를 저장하기 위해 10을 나눠준다
				temp /= 10;
			}
		}
		// 데이터 정렬, 오름 차순으로 정렬된다.
		Arrays.sort(alpha);
		// 곱할 인자 초기화
		int mult = 9;
		// 정답을 저장할 변수
		int result = 0;
		int size = alpha.length-1;
		for(int i=size; i>=0; i--) {
			// 알파벳은 26개, 우리가 저장한 값은 최대 10개니까, 범위를 벗어나면 나가라는 의미
			if(alpha[i] == 0) {
				break;
			}
			// 범위를 벗어나지 않았다면, 정답 변수에 해당 알파벳 값에 가능한 최대값을 곱한 값을 더해준다.
			result += alpha[i]*mult--;
		}
		// 정답 출력
		System.out.println(result);
		
	} // end of main
} // end of class
