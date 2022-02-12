package src.boj.implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_배열순회큐버전 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		/*
		 * 큐와 1차원 배열을 사용해서 풀어보자
		 * 각 레이어별 값들을 큐에 순차적으로 넣고, 
		 * 3번 돌린다 하면 
		 * 3번 poll push를 반복하고
		 * 해당 번호부터 배열에 넣는다
		 * 
		 * 1. 2차원 배열에 데이터를 초기화한다
		 * 2. 순차적으로 각 레이어를 순회한다 
		 * 3. 레이어에 있는 배열 값들을 큐에 넣고, 반복 횟수만큼 poll push를 한다
		 * 반복이 끝나고나서 레이어를 순회하면서 q.poll한 값을 넣어준다.
		 * 4. 3번 과정을 다음 레이어부터 다시 진행한다.
		 * 
		 * 문제 1 마지막 레이어에서의 동작 ( 3x1 일 때 값이 중복되게 들어온다 ) 
		 * 
		 * 시간 복잡도가 O(n^2)으로 줄어들 것 같다. 
		 */
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		// N*M번 순회하면 정확히 한바퀴를 돌게되므로, 남은 나머지 값만 회전한다.
		R = R%(N*M);
		
		// 배열 초기화
		int [][] matrix = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int totalLayer = 0;
		
		// 둘다 짝수
		if(N%2==0 && M%2==0) {
			totalLayer = Math.min(N, M)/2;
		}
		// 둘다 홀수
		else if(M%2==1 && N%2==1){
			totalLayer = Math.min(N, M)/2+1;
		}
		// M만 홀수인 경우
		else if(M%2==1 && N%2==0) {
			if(M>N) {
				totalLayer = Math.min(N, M)/2;
			}
			else {
				totalLayer = Math.min(N, M)/2+1;
			}
		}
		// N만 홀수
		else {
			if(N>M) {
				totalLayer = Math.min(N, M)/2;
			}
			else {
				totalLayer = Math.min(N, M)/2+1;
			}
		}
		int layer = 0;
		// 레이어의 수 만큼 회전
		while(layer<totalLayer) {
			// 배열을 순회하면서 데이터를 저장할 큐
			Queue<Integer> queue = new LinkedList<Integer>();
			// 레이어의 시작 지점
			int row = layer;
			int col = layer;
			int rowrange = N-1-row;
			int colrange = M-1-col;
			// 배열 순회
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
			
			// 반복 횟수만큼 앞에꺼를 빼서 뒤에 추가해라
			for(int repeat=0; repeat<R; repeat++) {
				int temp = queue.poll();
				queue.offer(temp);
			}
			
			// 배열 순회
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
