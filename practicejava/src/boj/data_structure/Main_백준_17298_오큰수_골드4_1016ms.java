 package src.boj.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main_����_17298_��ū��_���4_1016ms {
	
	// ��ū���� ���ڸ� ������ �迭
	static int[] RBN, NUMS;
	static int N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		// RBN���� �迭 ���� ����
		RBN = new int[N+1];
		// NUMS �迭�� �Էµ� ���ڸ� ����
		NUMS = new int[N+1];
		// 0�� ���� ū ���� ���� --> � ���� �̰ź��� ū �� �����Ƿ� isEmpty �˻縦 �� �ʿ䰡 ����.
		NUMS[0] = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		// ���� �迭 �ʱ�ȭ
		for(int i=1; i<=N; i++) {
			NUMS[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		
		// ó�� ���� �ְ� ����
		stack.push(0);
		stack.push(1);
		
		int idx = 2;
		while(true) {
			// ���� ���鼭 -1 �ֱ�
			// ��� �����͸� Ž���ߴٸ�
			if(idx > N) {
				// ������ ���鼭 -1�� �ʱ�ȭ
				while(!stack.isEmpty()) {
					RBN[stack.pop()] = -1;
				}
				break;
			}
			// NUMS[top] ���� �� ū ���� �´ٸ�
			if(NUMS[stack.peek()] < NUMS[idx]) {
				while(NUMS[stack.peek()] < NUMS[idx]) {
					RBN[stack.pop()] = NUMS[idx];
				}
				stack.push(idx);
			}
			// NUMS[top] ���� �� ���� ���̶�� ���ؿ� �߰�
			else {
				stack.push(idx);
			}
			idx++;
		}
		
		for(int i=1; i<=N; i++) {
			sb.append(RBN[i]).append(" ");
		}
		
		System.out.println(sb.toString());
		
	} // end of main
} // end of class
