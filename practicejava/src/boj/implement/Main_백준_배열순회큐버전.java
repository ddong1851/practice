package src.boj.implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_����_�迭��ȸť���� {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		/*
		 * ť�� 1���� �迭�� ����ؼ� Ǯ���
		 * �� ���̾ ������ ť�� ���������� �ְ�, 
		 * 3�� ������ �ϸ� 
		 * 3�� poll push�� �ݺ��ϰ�
		 * �ش� ��ȣ���� �迭�� �ִ´�
		 * 
		 * 1. 2���� �迭�� �����͸� �ʱ�ȭ�Ѵ�
		 * 2. ���������� �� ���̾ ��ȸ�Ѵ� 
		 * 3. ���̾ �ִ� �迭 ������ ť�� �ְ�, �ݺ� Ƚ����ŭ poll push�� �Ѵ�
		 * �ݺ��� �������� ���̾ ��ȸ�ϸ鼭 q.poll�� ���� �־��ش�.
		 * 4. 3�� ������ ���� ���̾���� �ٽ� �����Ѵ�.
		 * 
		 * ���� 1 ������ ���̾���� ���� ( 3x1 �� �� ���� �ߺ��ǰ� ���´� ) 
		 * 
		 * �ð� ���⵵�� O(n^2)���� �پ�� �� ����. 
		 */
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		// N*M�� ��ȸ�ϸ� ��Ȯ�� �ѹ����� ���ԵǹǷ�, ���� ������ ���� ȸ���Ѵ�.
		R = R%(N*M);
		
		// �迭 �ʱ�ȭ
		int [][] matrix = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int totalLayer = 0;
		
		// �Ѵ� ¦��
		if(N%2==0 && M%2==0) {
			totalLayer = Math.min(N, M)/2;
		}
		// �Ѵ� Ȧ��
		else if(M%2==1 && N%2==1){
			totalLayer = Math.min(N, M)/2+1;
		}
		// M�� Ȧ���� ���
		else if(M%2==1 && N%2==0) {
			if(M>N) {
				totalLayer = Math.min(N, M)/2;
			}
			else {
				totalLayer = Math.min(N, M)/2+1;
			}
		}
		// N�� Ȧ��
		else {
			if(N>M) {
				totalLayer = Math.min(N, M)/2;
			}
			else {
				totalLayer = Math.min(N, M)/2+1;
			}
		}
		int layer = 0;
		// ���̾��� �� ��ŭ ȸ��
		while(layer<totalLayer) {
			// �迭�� ��ȸ�ϸ鼭 �����͸� ������ ť
			Queue<Integer> queue = new LinkedList<Integer>();
			// ���̾��� ���� ����
			int row = layer;
			int col = layer;
			int rowrange = N-1-row;
			int colrange = M-1-col;
			// �迭 ��ȸ
			for(;col<colrange;col++) {
				queue.offer(matrix[row][col]);
			}
			for(;row<rowrange;row++) {
				queue.offer(matrix[row][col]);
			}
			for(;col>layer;col--) {
				queue.offer(matrix[row][col]);
			}
			for(;row>layer;row--) {
					queue.offer(matrix[row][col]);
			}
			
			// �ݺ� Ƚ����ŭ �տ����� ���� �ڿ� �߰��ض�
			for(int repeat=0; repeat<R; repeat++) {
				int temp = queue.poll();
				queue.offer(temp);
			}
			
			// �迭 ��ȸ
			for (; col < colrange; col++) {
				matrix[row][col] = queue.poll();
			}
			for (; row < rowrange; row++) {
				matrix[row][col] = queue.poll();
			}
			for (; col > layer; col--) {
				matrix[row][col] = queue.poll();
			}
			
			for (; row > layer; row--) {
				matrix[row][col] = queue.poll();
			}
			layer++;
		} // end of while
		
		for(int[] arr:matrix) {
			for(int a:arr) {
				bw.write(a+" ");
			}
			bw.write("\n");
		}
		
		br.close();
		bw.close();
	} // end of main
	
} // end of class 
