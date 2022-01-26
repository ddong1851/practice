package src.boj.bfs_dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


//class Node{
//	int row;
//	int col;
//	public Node(int row, int col) {
//		this.row = row;
//		this.col = col;
//	}
//	public int getRow() {
//		return row;
//	}
//	public int getCol() {
//		return col;
//	}
//}


/** Main_����_2667_������ȣ���̱�_�ǹ�1_248ms*/
public class Main_����_2667_������ȣ���̱�_�ǹ�1_248ms {
	public static int [][] graph;
	public static boolean[][] visited;
	public static int count = 0; // ������ ���� �����ϱ� ���� ����
	public static ArrayList<Integer> home = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		graph = new int[n][n];
		for(int i=0; i<n; i++) {
			String str = sc.next();
			char[] c = new char[n];
			c = str.toCharArray();
			for(int j=0; j<n; j++) {
				graph[i][j] = c[j]-'0';
			}
		}
		sc.close();
		visited = new boolean[n][n];
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				bfs(n, i, j);
			}
		}
		int[] results = new int[home.size()];
		int s = 0;
		for(int i:home) {
			results[s++] = i;
		}
		Arrays.sort(results);
		
		System.out.println(count);
		for(int i:results) {
			System.out.println(i);
		}
		
	}
	
	private static void bfs(int n, int y, int x) {
		Queue<Node> q = new LinkedList<>();
		// �ش� ��ǥ�� 0�̸� �޼��带 �����ض�
		if(graph[y][x]==0 || visited[y][x]==true) {
			return;
		}
		// ��ǥ�� �ǹ��� �ִ� ���̸�
		q.add(new Node(y, x));
		visited[y][x] = true;
		int houses = 1;
		// �����¿� Ž��
		int [][] dxy = {{-1, 0},{1, 0},{0, -1},{0, 1}};
		while(!q.isEmpty()) {
			// �湮�ϸ鼭 0���� �����, ������ ����. 
			// + ��� ��ǥ Ž���� �ؾ��ҵ�? 
			Node node = q.poll();
			int r = node.getRow();
			int c = node.getCol();
			// 4�� Ž��
			for(int i=0; i<4; i++) {
				// Ž���� ��ǥ
				int nrow = r+dxy[i][0];
				int ncol = c+dxy[i][1];
				// ��ǥ�� �׷��� ������ ����ٸ�
				if(nrow<0 || nrow>=n || ncol<0 || ncol>=n) {
					continue;
				}
				// ��ǥ�� �ǹ��� �ƴϸ� �ѱ�� Ȥ�� �̹� �湮�ߴ� �����̶��
				if(graph[nrow][ncol]==0) {
					continue;
				}
				// ���������� �ǹ��� �߰��ߴٸ�,
				if(graph[nrow][ncol]==1 && visited[nrow][ncol]==false) {
					q.add(new Node(nrow, ncol));
					visited[nrow][ncol] = true;
					graph[nrow][ncol] = 0; // �湮ó���ϰ� 0���� ��������
					houses++;
				}
				
			}
		}
		
		// ������ �����Ѵٸ�, ���� ���� ������Ű��, �� ������ StringBuffer�� �߰��Ѥ� .
		if(houses>0) {
			count++;
			home.add(houses);
		}
	}
}
