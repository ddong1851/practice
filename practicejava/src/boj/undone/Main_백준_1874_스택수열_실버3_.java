package src.boj.undone;

import java.util.Scanner;
import java.util.Stack;

/** Main_백준_1874_스택수열_실버3_*/
public class Main_백준_1874_스택수열_실버3_ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Stack<Integer> num = new Stack<>();
		Stack<Character> oper = new Stack<>();
		
		int addNum = 1;
		for(int i=0; i<n; i++) {
			int in = sc.nextInt();
			// 첫 숫자가 아닌 경우
			if(i!=0) {
				// 이전 값이 현재 값보다 더 큰 경우
				// 빼야한다
				if(num.peek()>in) {
					
				}
				else {
					
				}
			}
			// 첫 숫자에 대해 무조건적인 추가
			else {
				for(int j=1; j<=in; j++) {
					num.add(addNum++);
					oper.add('+');
				}
			}
		}
		sc.close();
		
		for(char c:oper) {
			System.out.println(c);
		}
	}
}
