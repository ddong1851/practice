package src.boj.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

/** Main_����_14719_����_���5_144ms*/
public class Main_����_14719_����_���5_144ms {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		/*
		 * stack�� �̿��Ͽ� ���̸� �����ϰ�, ����� ���� �� ����
		 * �Է� �����鼭 ���������� �ѹ� Ž���ϰ�
		 * �迭�� �� �߰��� �� max�� ������ �������� �ѹ� Ž���Ѵ�.
		 */
		
		int[] arr = new int[W];
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		int maxIdx = 0;
		int total = 0;
		
		// �Է� �����鼭 �����ʿ������� Ž��
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<W; i++) {
			int wall = Integer.parseInt(st.nextToken());
			arr[i] = wall;
			// ���� max���� �� ���� ���� ���´ٸ�
			if(wall<max) {
				stack.push(wall);
			}
			// ���� max���� �� ū ���� ���´ٸ� 
			else {
				// total ����
				while(!stack.isEmpty()) total += max - stack.pop();
				// max�� ����
				max = wall;
				maxIdx = i;
			}
		}
		
		// ó������ ���� ��ǥ���� ���� �� ���ʺ��� maxIndex���� �ٽ� �ѹ� Ž��
		if(!stack.isEmpty()) {
			// ���� stack�� �ִ� ��� ����ְ�
			stack.clear();
			// max�� �ʱ�ȭ
			max = 0; 
			// ������������ Ž��
			for(int i=W-1; i>=maxIdx; i--) {
				int wall = arr[i];
				// �������� ���� ū ������ ���� ���� ������ stack�� �߰�
				if(wall<max) {
					stack.push(wall);
				}
				// ������ �ִ� ������ ũ�ų� ���� ���� �´ٸ� ( �ᱹ maxIdx���� �������Ѵ� ) 
				else {
					while(!stack.isEmpty()) total += max-stack.pop();
					max = wall;
				}
			}
		}
		// ���� ���
		System.out.println(total);
		
	} // end of main
} // end of class












