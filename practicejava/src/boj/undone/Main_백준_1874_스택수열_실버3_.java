package src.boj.undone;

import java.util.Scanner;
import java.util.Stack;

/** Main_����_1874_���ü���_�ǹ�3_*/
public class Main_����_1874_���ü���_�ǹ�3_ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Stack<Integer> num = new Stack<>();
		Stack<Character> oper = new Stack<>();
		
		int addNum = 1;
		for(int i=0; i<n; i++) {
			int in = sc.nextInt();
			// ù ���ڰ� �ƴ� ���
			if(i!=0) {
				// ���� ���� ���� ������ �� ū ���
				// �����Ѵ�
				if(num.peek()>in) {
					
				}
				else {
					
				}
			}
			// ù ���ڿ� ���� ���������� �߰�
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
