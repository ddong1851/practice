package src.boj.djikstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** Main_����_1261_�˰���_���4_168ms*/
public class Main_����_1261_�˰���_���4_168ms {
	
	private static class Node{
		int row;
		int col;
		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	private static int[][] map;
	private static int[][] distance;
	private static int N;
	private static int M;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	private static void go(int row, int col) {
		
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(row, col));
		distance[row][col] = 0;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int cr = curr.row;
			int cc = curr.col;
			for(int i=0; i<4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				// ������ ����ٸ� �̵�
				if(nr<1 || nr>=N+1 || nc<1 || nc>=M+1) continue;
				// �ν� �� ���� ����
				int wall = 0;
				if(map[nr][nc]==1) wall=1;
				if(distance[nr][nc]==-1 || distance[nr][nc]>distance[cr][cc]+wall) { 
					distance[nr][nc] = distance[cr][cc]+wall;
					// ��ǥ�̵�
					q.offer(new Node(nr, nc));
				}
			} // end of for direction
			
		} // end of while isEmpty
		
	} // end of method

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		/* 
		 * (1,1)���� (N,M)���� ���µ� ��� ���� �վ�� �ϴ���  
		 * 
		 * ��͸� ����ؼ� �� ���� ���� ī��������
		 * distance �迭�� �����
		 * �ʱ�ȭ���� �ʾҰų� �� ���� ���� ������ ���� ��������
		 */
		
		map = new int[N+2][M+2];
		distance = new int[N+2][M+2];
		for(int i=0; i<=N; i++) {
			Arrays.fill(distance[i], -1);
		}
		// map �ʱ�ȭ
		for(int i=1; i<=N; i++) {
			char[] arr = br.readLine().toCharArray();
			for(int j=1; j<=M; j++) {
				map[i][j] = arr[j-1]-'0';
			}
		}
		
		go(1, 1);
		
		System.out.println(distance[N][M]);
		
		
	} // end of main

} // end of class


