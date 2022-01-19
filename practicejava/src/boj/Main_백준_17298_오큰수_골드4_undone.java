 package src.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.Arrays;


/**
 * Main_����_17298_��ū��_���4_
 * @author HD
 *
 */
//�ð� ���� 1��, 512MB, 

//stack�� �ε����� �����ϰ� �غ���.
public class Main_����_17298_��ū��_���4_undone {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// ����
		Stack<Integer> stack = new Stack<>();
		// NGE ������ ����� �迭
		int [] NGE = new int[n];
		// int�� �����͸� ������ data
		int [] data = new int[n];
		String [] str = br.readLine().split(" ");
		
		//���� �迭�� �� �ִ´�.
		for(int i=0; i<n; i++) {
			data[i] = Integer.parseInt(str[i]);
		}
		
		// NGE�迭�� -1�� �ʱ�ȭ
		Arrays.fill(NGE,-1);
		
		
		// 0��° �ε����� ���ÿ� �ִ´�.
		stack.push(0);
		int idx = 0;
		// ������ ������� ���� �� ��� �ݺ�
		while(!stack.isEmpty()) {
			// ���� ������ temp ����, �������� ù��° �����ͷ� �ʱ�ȭ�Ѵ�. 
			int temp = data[idx++];
			// ���� �񱳴���� ���̶�, ������ �� �� idx ���̶� ��
			for(int j=idx; j<idx; j++) {
				stack.push(idx);
				if(temp<data[stack.peek()]) {
					
				}
				
			}
			stack.pop();
		} // end of while
		
		for(int i:NGE) {
			System.out.print(i+" ");
		}
		/*
TC
4
9 5 4 8
		 */
		br.close();
	} // end of main
} // end of class
