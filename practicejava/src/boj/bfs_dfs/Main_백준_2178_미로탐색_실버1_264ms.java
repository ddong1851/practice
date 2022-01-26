package src.boj.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Main_����_2178_�̷�Ž��_�ǹ�1_264ms
 * @author HD
 *
 */
public class Main_����_2178_�̷�Ž��_�ǹ�1_264ms {
	public static void main(String[] args) {
		// Ǯ�� ��� BFS�� ���� 4�� Ž���� �غ��� + ��ǥ������ �ִ� �Ÿ��� ���ϱ� ���ؼ� ���� ��ǥ = ���� ��ǥ + 1 �� �Ѵ�.
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int [][] maze = new int[n][m];
		for(int i=0; i<n; i++) {
			String str = sc.next();
			char [] c = new char[m];
			c = str.toCharArray();
			for(int j=0; j<m; j++) {
				maze[i][j] = c[j]-'0';
			}
		}
		sc.close();
		
		boolean [][] visited = new boolean[n][m];
		// �� �� ��ǥ�� ����ϸ�, ���� ������ �� ������ ���̶� ������ ��µȴ�.
		System.out.println(bfs(0, 0, maze, visited, n, m));
		
		
	} // end of main

	private static int bfs(int r, int c, int[][] maze, boolean[][] visited, int n, int m) {
		// TODO Auto-generated method stub
		
		// ť�� x, y ��ǥ�� �ֱ� ���� node��� ������ Ÿ���� �����Ѵ�.
		Queue<Node> q = new LinkedList<>();
		// ť�� ���� ������ �߰��Ѵ�.
		q.add(new Node(c, r));
		// ���� ������ �湮 ǥ���Ѵ�.
		visited[c][r] = true;
		// ���� �¿� ���� ����	��		��		��		��
		int [][] dxy = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			// 4�� Ž��
			for(int i=0; i<4; i++) {
				// ���� ��ǥ Ž��
				int nc = node.getCol() + dxy[i][0];
				int nr = node.getRow() + dxy[i][1];
				// ������ ����ٸ� ���� ���� Ž��
				if(nc<0 || nc>=n || nr<0 || nr>=m) {
					continue;
				}
				// �ش� ��ǥ�� �� �� ���� ���̶�� �ٸ� ���� Ž��
				if(maze[nc][nr]==0) {
					continue;
				}
				// �ش� ��ǥ�� �̵� ������ 1�̶��, �ش� ��ǥ�� ť�� �ְ�, �׷����� ���� �ϳ� ������Ų��.
				if(maze[nc][nr]==1 && visited[nc][nr] == false) {
					maze[nc][nr] = maze[node.getCol()][node.getRow()] + 1;
					// �湮 ó��
					visited[nc][nr] = true;
					// �ش� ��ǥ�� ť�� �ִ´�
					q.add(new Node(nc, nr));
				}
			}
		}
		
		// �� �� ���� ��ȯ
		return maze[n-1][m-1];
		
	} // end of bfs
} // end of class

//class Node{
//	int col;
//	int row;
//	
//	public Node(int col, int row) {
//		this.col = col;
//		this.row = row;
//	}
//
//	public int getRow() {
//		return row;
//	}
//	public int getCol() {
//		return col;
//	}
//	
//}
