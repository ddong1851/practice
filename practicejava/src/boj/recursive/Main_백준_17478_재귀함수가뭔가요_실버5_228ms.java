package src.boj.recursive;

import java.util.Scanner;

/** Main_백준_17478_재귀함수가뭔가요?_실버5_228ms*/
public class Main_백준_17478_재귀함수가뭔가요_실버5_228ms {
	// 계속 더해질 underbar
	static String underbar="";
	// 추가할 고정된 문자열
	final static String addbar ="____";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.close();
		// 첫 문장 호출 후 재귀함수 시작
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		recursion(n);
	}

	private static void recursion(int n) {
		// 이렇게 선언하지 않으면, 라고 답변하였지 앞 lines가 staticNum이 저장되어 줄어들지 않는다
		String lines = underbar;
		// n이 0일때 마지막 출력 후 재귀 종료
		if(n==0) {
			System.out.println(lines+"\"재귀함수가 뭔가요?\"");
			System.out.println(lines+"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			System.out.println(lines+"라고 답변하였지.");
			// 메서드 종료
			return;
		}
		// 0이 아닐 때 출력을 하고, underbar에 ____를 추가하고, 다음 재귀 호출
		System.out.println(lines + "\"재귀함수가 뭔가요?\"");
		System.out.println(lines + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
		System.out.println(lines + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
		System.out.println(lines + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
		underbar += addbar;
		recursion(n - 1);
		System.out.println(lines+"라고 답변하였지.");
	}
}
