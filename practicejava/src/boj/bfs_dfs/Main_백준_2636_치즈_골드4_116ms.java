package src.boj.bfs_dfs;

import java.io.*;
import java.util.*;

/** Main_����_2636_ġ��_���4_116ms*/
public class Main_����_2636_ġ��_���4_116ms {
	
	private static class Node{
		int row, col;
		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	private static int N;
	private static int M;
	private static int[][] map;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		/*
		 * IDEA
		 * 
		 * ġ���� �� ǥ�鿡 ���Ⱑ ������ ����� �༮���� �ȴ�.
		 * 
		 * BFS�� ��ǥ�� Ž��
		 * 
		 * ����Ʈ�� ġ�� �ܰ��� ����� ���� �༮�鸸 ���ִ� �� 
		 * 
		 * 0,0���� �����ؼ� ���� ��ǥ�� 0�̸� �̵��ϰ� 
		 * 1�̸� �ܰ� ġ��� ���� --> ���� ��� ť�� �ø� ���� 
		 * ��� Ž���� ������ ���� ��� ť�� ���鼭 map ����
		 * 
		 * + Java8�� �����ϱ� 116ms�� �پ���..! 
		 */
		
		N = Integer.parseInt(st.nextToken()); // <=100
		M = Integer.parseInt(st.nextToken()); // <=100
		
		map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) map[i][j] = Integer.parseInt(st.nextToken());
		} // end of initialize
		
		int [] dr = {-1, 1, 0, 0};					// �����¿� row 
		int [] dc = {0, 0, -1, 1};					// �����¿� col
		
		int size = 0; 								// �ñ������� ��� �����Ǳ� ���� �� ���� ġ� �����ߴ��� �����ϴ� ����
		int turn = 0; 								// ��� �����Ǵµ� �� ���� �������� ī�����ϴ� ����
		int row, col, nr, nc; 						// ���� ��ǥ�� ���� ��ǥ�� ������ ����
		Queue<Node> q = new LinkedList<Node>(); 	// ���� ��ǥ�� �����ϴ� ť
		Queue<Node> del = new LinkedList<Node>();	// ���� ��� ġ� �����ϴ� ť
		Node first = new Node(0, 0);				// �����ϴ� ��ǥ
		while(true) {
			q.offer(first);
			visited[0][0] = true;
			while(!q.isEmpty()) {
				Node curr = q.poll();
				row = curr.row;
				col = curr.col;
				// 4�� Ž��
				for(int i=0; i<4; i++) {
					nr = row + dr[i];
					nc = col + dc[i];
					// ������ ����ų� �̹� �湮�� ���̶��
					if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc]) continue;
					// �湮 ó��
					visited[nr][nc] = true;
					// ���� ��ǥ�� ������ Ž�� ť�� �߰�
					if(map[nr][nc]==0) q.offer(new Node(nr, nc)); 
					// ġ� �����ٸ�
					else if(map[nr][nc]==1) {
						// ���� ��� ť�� �߰�
						del.offer(new Node(nr, nc));
					}
				} // end of for 
			} // end of while empty
			// ġ� �������� ������ ����
			if(del.isEmpty()) break;
			// �����ϴ� ���� �� �������� �ʵ��� ó�� ( ���������� ó���� ġ���� ������ ���� )
			size = del.size();
			// ������� �ʾҴٸ�, ��, visited�迭, map ����
			turn++;
			// �湮 �迭 ����
			initVisited(visited);
			// map ����
			while(!del.isEmpty()) {
				Node delete = del.poll();
				map[delete.row][delete.col] = 0;
			} // end of delete cheese
		} // end of while
		
		System.out.println(turn+"/n"+size);
		
	} // end of main
	
	// visited �迭 ����
	private static boolean[][] initVisited(boolean[][]visited) {
		for(int i=0; i<N; i++) Arrays.fill(visited[i], false);
		return visited;
	} // end of initVisited
	
} // end of main













