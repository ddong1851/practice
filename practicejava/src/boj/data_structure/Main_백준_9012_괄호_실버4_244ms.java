package src.boj.data_structure;

import java.util.Scanner;
import java.util.Stack;

/**Main_����_9012_��ȣ_�ǹ�4_244ms*/
public class Main_백준_9012_괄호_실버4_244ms {
	
	public static String solution(String s) {
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			// �Է��� ���ڿ��� i��° ��� 
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(c);
			}
			
			// (�� ���µ� )�� ���� ���, 
			else if (stack.empty()) {
				return "NO";
			}
			// �Է��� ()�ϱ� (�� �ƴ� )�� ������ pop
			else {
				stack.pop();
			}
		}
		
		// �ݺ��� ���� ������ ���ִٸ� NO ����ٸ� YES
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