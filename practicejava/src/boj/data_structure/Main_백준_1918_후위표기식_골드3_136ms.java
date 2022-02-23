package src.boj.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/** Main_백준_1918_후위표기식_골드3_136ms*/
public class Main_백준_1918_후위표기식_골드3_136ms {
	
	//								  40 41   42  43   45     47
	//							      (   )   *   +     -     /  
	private static int[] priority = { 0,  0,  2,  1, 0, 1, 0, 2};
	private static char[] oper = 	{'(',')','*','+',0,'-',0,'/'};
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		/*
		 * stack에 연산자를 쌓아두고, 자신보다 우선순위가 높은 연산자를 만나면 pop하자
		 */
		
		String str = br.readLine();
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0; i<str.length(); i++) {
			char curr = str.charAt(i);
			switch (curr) {
			case '+':
			case '-':
			case '*':
			case '/':
				// 이 부분이랑, 우선순위에서 ()를 0으로 바꾸니까 성공했다. + 괄호는 고려 안한다.
				while(!stack.isEmpty() && priority[stack.peek()] >= priority[curr-'(']) {
					sb.append(oper[stack.pop()]);
				}
				stack.push(curr-'(');
				break;
			case '(':
				stack.push(0);
				break;
			case ')':
				while(!stack.isEmpty() && stack.peek()!=0) {
					sb.append(oper[stack.pop()]);
				}
				// ( 비워주기
				stack.pop();
				break;
			// 알파벳일 때
			default:
				sb.append(curr);
				break;
			}
		}
		
		// 스택 비우기
		while(!stack.isEmpty()) {
			sb.append(oper[stack.pop()]);
		}
		
		System.out.println(sb.toString());
		
	} // end of main
} // end of class














