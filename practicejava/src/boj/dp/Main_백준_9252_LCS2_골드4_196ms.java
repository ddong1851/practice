package src.boj.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/** Main_����_9252_LCS2_���4_196ms*/
public class Main_����_9252_LCS2_���4_196ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		int r = s2.length();
		int c = s1.length();
		int[][] LCS = new int[r+1][c+1];
		
		for(int row=1; row<=r; row++) {
			for(int col=1; col<=c; col++) {
				if(s2.charAt(row-1)==s1.charAt(col-1)) {
					LCS[row][col] = LCS[row-1][col-1] + 1;
				}
				else {
					LCS[row][col] = Math.max(LCS[row-1][col], LCS[row][col-1]);
				}
			}
		}
		// LCS�� �ִ� ���̸� ����
		int len = LCS[r][c];
		sb.append(len).append("\n");
		if(len==0) {
			System.out.println(sb.toString());
			System.exit(0);
		}
		Stack<Character> stack = new Stack<>();
		// LCS Ž���ϸ鼭 ����� ������ �ֱ�, ������ �߰��� ���� ��, ���� �������� �Ȱ��� ����������
		while(r>=1 && c>=1) {
			// ���� ���� ���� ���� ��ġ�ϴ� ��� �������� �̵�
			if(LCS[r][c]==LCS[r][c-1]) {
				c--;
			}
			// ���� ���� �� ���� ������ ���� �̵�
			else if(LCS[r][c]==LCS[r-1][c]){
				r--;
			}
			// ��, ���� ���� �ʴٸ� �밢���� �̵�
			else {
				stack.push(s1.charAt(c-1));
				r--; c--;
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb.toString());
	}
}
