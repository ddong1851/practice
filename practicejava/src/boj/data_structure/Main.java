package src.boj.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = 0;
		int mult = 1;
		Stack<Character> stack = new Stack<>();
		char[] arr = br.readLine().toCharArray();
		for(int i=0, len=arr.length; i<len; i++) {
			if(arr[i]=='(') {
				stack.push('(');
				mult*=2;
			}
			else if(arr[i]=='[') {
				stack.push('[');
				mult*=3;
			}
			else if(arr[i]==')') {
				// 스택이 비었거나 짝이 안맞을 때
				if(stack.isEmpty() || stack.peek()!='(') {
					System.out.println(0);
					return;
				}
				else {
					total += mult;
					while(++i<len) {
						if(arr[i]==')') {
							if(stack.pop()=='(') mult/=2;
							else {
								System.out.println(0);
								return;
							}
						}
						else if(arr[i]==']'){
							if(stack.pop()=='[') mult/=3;
							else {
								System.out.println(0);
								return;
							}
						}
						else if(arr[i]=='('){
							mult*=2;
							break;
						}
						else {
							mult*=3;
							break;
						}
					}
				}
			}
			else {
				if(stack.isEmpty() || stack.peek()!='(') {
					System.out.println(0);
					return;
				}
				else {
					total += mult;
					while(++i<len) {
						if(arr[i]==')') {
							if(stack.pop()=='(') mult/=2;
							else {
								System.out.println(0);
								return;
							}
						}
						else if(arr[i]==']'){
							if(stack.pop()=='[') mult/=3;
							else {
								System.out.println(0);
								return;
							}
						}
						else if(arr[i]=='('){
							mult*=2;
							break;
						}
						else {
							mult*=3;
							break;
						}
					}
				}
			}
		} // end of for 
		
		System.out.println(total);
	}
}
