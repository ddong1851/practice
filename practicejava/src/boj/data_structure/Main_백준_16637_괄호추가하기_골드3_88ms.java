package src.boj.data_structure;

import java.io.*;
import java.util.*;

public class Main_����_16637_��ȣ�߰��ϱ�_���3_88ms {
	
	private static int max = Integer.MIN_VALUE;
	private static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		 * �־��� ���Ŀ�
		 * ��� ��ȣ�� �������� �� �õ��غ���
		 * 
		 * ��� �ұ�? 
		 * �ݰ� �ȴݰ� --> 
		 * ���� ��ȣ�� ���Ե� ������ ���� ����ǥ��� ����? �ϸ� �� ��
		 * �������� ���������� �ٲ㼭 ���� 
		 * 
		 * + ��ȣ �ȿ� �����ڰ� �ϳ��� ���� �Ѵ�.
		 * + ������ �켱������ ����!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		 */
		
		int N = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		
		go(0, N, arr, "", false);
		
		System.out.println(max);
		
	} // end of main 
	
	private static void go(int cnt, int N, char[] arr, String calcStr, boolean open) {
		if(cnt==N) {
			// ���� ��ȣ�� �ִٸ�
			if(open) calcStr+=")";
			// �����
			calcInfix(calcStr);
			return;
		} // end of ��������
		if(cnt%2==0) {
			// ������ ���� ��ȣ�� �����ٸ�
			if(!open) {
				// ���� ����
				go(cnt+1, N, arr, calcStr+"("+arr[cnt], true);
				// �ȿ��� ����
				go(cnt+1, N, arr, calcStr+arr[cnt], false);
			}
			// ������ ���� ��ȣ�� �־��ٸ�
			else {
				// �ݰ� ���� 
				go(cnt+1, N, arr, calcStr+arr[cnt]+")", false);
			}
		}
		// �����ڶ�� 
		else {
			go(cnt+1, N, arr, calcStr+arr[cnt], open);
		}
	} // end of go 

	
//	(	)	+	-	*
//	40	41	43	45	42	
	
	private static char[] oper 	= 	{'(', ')', '*', '+', 0, '-', 0};
	private static int[] power 	= 	{ 0,   0,   1,   1,  0,  1,  0};
	
	private static void calcInfix(String calcStr) {
		StringBuilder post = new StringBuilder();
		// 1. ����ǥ������� ����
		char curr = 0;
		for(int i=0, size=calcStr.length(); i<size; i++) {
			curr = calcStr.charAt(i);
			switch (curr) {
			case '+':
			case '-':
			case '*':
				while(!stack.isEmpty() && power[stack.peek()] >= power[curr-'(']) {
					post.append(oper[stack.pop()]);
				}
				stack.push(curr-'(');
				break;
			case '(':
				stack.push(0);
				break;
			case ')':
				while(!stack.isEmpty() && stack.peek()!=0) {
					post.append(oper[stack.pop()]);
				}
				// ( ����ֱ�
				stack.pop();
				break;
			// ���ĺ��� ��
			default:
				post.append(curr);
				break;
			}
		}
		
		while(!stack.isEmpty()) post.append(oper[stack.pop()]);
		
		int a, b;
		a = b = 0;
		char temp = 0;
		String postExpression = post.toString();
		// 2. ����ǥ��� ����
		for(int i=0, size=postExpression.length(); i<size; i++) {
			temp = postExpression.charAt(i);
			if(temp>='0' && temp<='9') stack.push(temp-'0');
			else {
				a = stack.pop();
				b = stack.pop();
				// �䱸�ϴ� ���� ����
				switch(temp) {
				case '+':
					stack.push(b+a);
					break;
				case '-':
					stack.push(b-a);
					break;
				case '*':
					stack.push(b*a);
					break;
				}
			}
		}
		
		max = Math.max(max, stack.pop());
	} // end of calc
} // end of class 










