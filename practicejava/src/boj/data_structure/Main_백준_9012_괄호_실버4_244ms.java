package src.boj.data_structure;

import java.util.Scanner;
import java.util.Stack;

/**Main_占쏙옙占쏙옙_9012_占쏙옙호_占실뱄옙4_244ms*/
public class Main_백준_9012_괄호_실버4_244ms {
	
	public static String solution(String s) {
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			// 占쌉뤄옙占쏙옙 占쏙옙占쌘울옙占쏙옙 i占쏙옙째 占쏙옙占� 
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(c);
			}
			
			// (占쏙옙 占쏙옙占승듸옙 )占쏙옙 占쏙옙占쏙옙 占쏙옙占�, 
			else if (stack.empty()) {
				return "NO";
			}
			// 占쌉뤄옙占쏙옙 ()占싹깍옙 (占쏙옙 占싣댐옙 )占쏙옙 占쏙옙占쏙옙占쏙옙 pop
			else {
				stack.pop();
			}
		}
		
		// 占쌥븝옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쌍다몌옙 NO 占쏙옙占쏙옙摸占� YES
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