package src.boj.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/** Main_����_2504_��ȣ�ǰ�_�ǹ�2_128ms*/
public class Main_����_2504_��ȣ�ǰ�_�ǹ�2_128ms {
	public static void main(String[] args) throws Exception{
		
		/*
		 * ��ȣ���� ���ÿ� �װ�,
		 * �ݴ� ��ȣ�� ������ �� 
		 * 1. stack�� �������
		 * 2. ¦�� �´��� ��
		 * 3. �ջ��� �ʿ������� Ȯ��
		 * 
		 * �ݺ��� ���� �� ������ ������� �ʴٸ� ��𼱰� ¦�� ���� �ʴ� ���̱� ������ 0�� ���
		 * 
		 * ���� 
		 * ó������ temp.length�� ����Ͽ�, Ȧ���� �����ϴ� ��ĵ� ���� �� ����.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = 0;
		int mult = 1;
		// flag ���� ��� �ݴ� ��ȣ�� �����ؼ� ���� ���, �ش� ������ ���� ���� ������ ���� �Ǵ�
		// ex ( ( ( ) ) ) ( 
	    //          T     F ù��° �ݴ� ��ȣ���� ���� ���ϰ�, flag�� T�� �д�. �ٽ� ���� ��ȣ�� ���� �� F�� ��ȯ�Ѵ�.
		boolean added = false;
		Stack<Character> stack = new Stack<>();
		String temp = br.readLine();
		for(int i=0, len=temp.length(); i<len; i++) {
			if(temp.charAt(i)=='(') {
				added = false;
				mult*=2;
				stack.push('(');
			}
			else if(temp.charAt(i)=='[') {
				added = false;
				mult*=3;
				stack.push('[');
			}
			else if(temp.charAt(i)==')') {
				// ������ ����ų� ¦�� ���� �ʴ� ���
				if(stack.isEmpty() || stack.peek()!='(') {
					System.out.println(0);
					return;
				}
				// ������ ���� �ʾҰ�, ¦�� �´� ���
				else if(!stack.isEmpty() && stack.pop()=='('){
					// ���� �ջ����� �Ǵ�
					if(!added) {
						total+=mult;
						added = true;
					}
					mult/=2;
				}
			}
			else {
				// ������ ����ų� ¦�� ���� �ʴ� ���
				if(stack.isEmpty() || stack.peek()!='[') {
					System.out.println(0);
					return;
				}
				// ������ ���� �ʾҰ�, ¦�� �´� ���
				else if(!stack.isEmpty() && stack.pop()=='['){
					if(!added) {
						total+=mult;
						added = true;
					}
					mult/=3;
				}
			}
		} // end of for
		if(stack.isEmpty()) System.out.println(total);
		else System.out.println(0);
	}
}
