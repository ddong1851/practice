package src.swea;

import java.util.*;
import java.io.*;

/** Solution_SWEA_5656_��������_335ms*/
public class Solution_SWEA_5656_��������_335ms {
	
	private static class Node{
		int row, col, size;
		public Node(int row, int col, int size) {
			super();
			this.row = row;
			this.col = col;
			this.size = size;
		}
	}
	
	private static int N, W, H, max;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		/*
		 * ����..
		 * ù��°�� ������ ���� ���� ��Ʈ���鼭
		 * ����Ǹ� ������ ������ ����Ʈ�� �߰�
		 * ť���� ���鼭 ���ÿ� ���� ó��
		 * 
		 * ����Ʈ
		 * ������ ����Ʈ ����
		 * 12^4��. �ߺ�.. ����? 20736�� ������ ( 1<=N<=4 ) 
		 * ������� �����غ���
		 * ���� ���� �� ���� ���� ���� ī����
		 * 
		 * �ϳ��� �����ϰ� �ش� ���� ���� �� ���� �������� �Ѿ�°� 
		 * �ߺ��� ó���ϴµ� ���� �ӵ��� ���� �� ���� �� ����.
		 * 
		 * �迭�� ������ ������ �� ��ũ�� Ȱ������
		 * 
		 * ���� �����ϴ� �ð� ���̴� ���
		 * 1. ���� ������ ī����
		 * 1.1) ����� ���� ���� ��� ����
		 * 
		 * 2. ������ �࿡ 0�ۿ� ���ٸ� �ٷ� Continue 
		 * 
		 * 
		 */
		
		
		int TC = Integer.parseInt(br.readLine());
		for (int test = 1; test <= TC; test++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int[][] map = new int[H][W];
			
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			// �Ұ����� ������ �ʱ�ȭ
			max = 999_999;
			// �ߺ� ���� ����� + �ٲ� ���� ������ ��� �ٴϴ� �͵� �ð��� ���� �� ���� ������ ���δ�.
			go(0, map);
			
			sb.append("#").append(test).append(" ").append(max).append("\n");
		} // end of for TC

		System.out.println(sb.toString());
		
	} // end of main 


	private static void go(int cnt, int[][] newMap) {
		if(cnt==N) {
			// ���� ���� ���� ī����
			countBricks(newMap);
			return;
		} // end of ��������
		
		for(int i=0; i<W; i++) {
			// 1. ���� �迭 ����ϱ�
			int[][] clone = cloneArr(newMap);
			// 2. �迭 ���� ó��
			deleteArr(newMap, i);
			// 3. ���� ������ 
			moveBrick(newMap);
			// 4. ���� ����
			go(cnt+1, newMap);
			// 5. �迭 ����
			newMap = clone;
		}
	} // end of go


	private static int[][] cloneArr(int[][] newMap) {
		// ���� �迭 ����
		int[][] nm = new int[H][W];
		for(int i=0; i<H; i++) nm[i] = newMap[i].clone();
		return nm;
	} // end of cloneArr

	private static void moveBrick(int[][] newMap) {
		// �迭�� �ٴ����� ���� �޼���
		Deque<Node> dq = new ArrayDeque<Node>();
		for(int c=0; c<W; c++) {
			// ���� �� Ž��
			for(int r=0; r<H; r++) {
				if(newMap[r][c]!=0) dq.offer(new Node(r, c, newMap[r][c]));
				newMap[r][c] = 0;
			}
			int row = H-1;
			while(!dq.isEmpty()) {
				newMap[row--][c] = dq.pollLast().size;
			}
		}
	} // end of moveBrick


	private static void deleteArr(int[][] newMap, int selected) {
		// �迭 �����ϸ鼭 ����
		Queue<Node> q = new LinkedList<>();
		// ù��°�� ó���� ��ǥ �߰�
		for(int i=0; i<H; i++) {
			if(newMap[i][selected]!=0) {
				q.offer(new Node(i, selected, newMap[i][selected]));
				newMap[i][selected] = 0;
				break;
			}
		}
		
		// BFS 
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int row = curr.row;
			int col = curr.col;
			int size = curr.size;
			for(int i=0; i<4; i++) {
				for(int rep = 1; rep<size; rep++) {
					int nr = row + dr[i]*rep;
					int nc = col + dc[i]*rep;
					if(nr<0 || nr>=H || nc<0 || nc>=W) break;
					q.offer(new Node(nr, nc, newMap[nr][nc]));
					newMap[nr][nc] = 0;
				} // end of for repeat size
			} // end of for 4 direction
		} // end of while 	
		
	} // end of deleteArr


	private static void countBricks(int[][] newMap) {
		// ���� ���� ī����
		int count = 0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(newMap[i][j]!=0) count++;
			}
		}
		if(count<max) max=count;
	} // end of countBricks
	
} // end of class 














