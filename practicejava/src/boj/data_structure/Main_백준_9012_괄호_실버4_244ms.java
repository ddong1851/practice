package src.boj.data_structure;

import java.util.Scanner;
import java.util.Stack;

/**Main_백준_9012_괄호_실버4_244ms*/
public class Main_백준_9012_괄호_실버4_244ms {
	
	public static String solution(String s) {
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			// 입력한 문자열의 i번째 요소 
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(c);
			}
			
			// (게 없는데 )를 받은 경우, 
			else if (stack.empty()) {
				return "NO";
			}
			// 입력이 ()니까 (가 아닌 )게 들어오면 pop
			else {
				stack.pop();
			}
		}
		
		// 반복문 이후 스택이 차있다면 NO 비었다면 YES
		if (stack.empty()) {
			return "YES";
		} 
		else {
			return "NO";
		}
	} // end of solution
	
	
 	public static void main(String[] args) {
 		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < TC; i++) {
			sb.append(solution(sc.next()));
			sb.append("\n");
		}
		sc.close();
		System.out.println(sb.toString());
	} // end if main
} // end of class