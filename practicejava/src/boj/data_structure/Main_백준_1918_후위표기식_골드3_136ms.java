package src.boj.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/** Main_����_1918_����ǥ���_���3_136ms*/
public class Main_����_1918_����ǥ���_���3_136ms {
	
	//								  40 41   42  43   45     47
	//							      (   )   *   +     -     /  
	private static int[] priority = { 0,  0,  2,  1, 0, 1, 0, 2};
	private static char[] oper = 	{'(',')','*','+',0,'-',0,'/'};
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		/*
		 * stack�� �����ڸ� �׾Ƶΰ�, �ڽź��� �켱������ ���� �����ڸ� ������ pop����
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
				// �� �κ��̶�, �켱�������� ()�� 0���� �ٲٴϱ� �����ߴ�. + ��ȣ�� ��� ���Ѵ�.
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
				// ( ����ֱ�
				stack.pop();
				break;
			// ���ĺ��� ��
			default:
				sb.append(curr);
				break;
			}
		}
		
		// ���� ����
		while(!stack.isEmpty()) {
			sb.append(oper[stack.pop()]);
		}
		
		System.out.println(sb.toString());
		
	} // end of main
} // end of class














