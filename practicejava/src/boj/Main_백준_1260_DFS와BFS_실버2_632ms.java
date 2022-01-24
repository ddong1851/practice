package src.boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/** Main_����_1260_DFS��BFS_�ǹ�2_632ms*/
public class Main_����_1260_DFS��BFS_�ǹ�2_632ms {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// ������ ���� 
		int n = sc.nextInt();
		// ������ ����
		int m = sc.nextInt();
		// ������ ��ȣ
		int v = sc.nextInt();
		
		// ���� ����� ������ n�� �϶� n*n �迭�� ���� �� �ִ�. ��ĭ�� �������� ���� 1~n���� ���� ����
		int [][] graph = new int[n+1][n+1];
		boolean[] visited  = new boolean[n+1];
		
		for(int i=1; i<=m; i++) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			graph[row][col] = 1;
			graph[col][row] = 1;
		}
		sc.close();
		
		// �׷���, �湮 ����, ���� ����, ���� ���� �湮 ;
		dfs(graph, visited, v);
		System.out.println();
		Arrays.fill(visited, false);
		bfs(graph, visited, v);
	}

	// DFS�� ����� ȣ��
	// �׷���, �湮 ����, ������, flag
	private static void dfs(int[][] graph, boolean[] visited, int v) {
		// TODO Auto-generated method stub
		// �ش� ���� �湮 ǥ��
		visited[v] = true;
		System.out.print(v+" ");
		// 1~n���� Ž��, ����� ������������ Ž��
		for(int i=1; i<=graph.length-1; i++) {
			if(graph[v][i] == 1 && visited[i] == false) {
				dfs(graph, visited, i);
			}
		}
	}
	
	// BFS�� DFS�� ���� ����� ���������� while�� ť�� �̿�
	private static void bfs(int[][] graph, boolean[] visited, int v) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<>();
		int n = graph.length-1;
		
		// ���� ���� �ֱ�
		queue.add(v);
		// �ش� ���� �湮 ó��
		visited[v] = true;
		
		// ť�� �������� �ݺ�
		while(!queue.isEmpty()) {
			// ���� ������ ������, ������ ������ �湮ó��, �̶� ������ ���� 
			v = queue.poll();
			System.out.print(v+" ");
			
			// �ش� ������ ����� ���� Ž�� 
			for(int i=1; i<=n; i++) {
				// ����� �����̰�, �湮 ó���� ���� �ʾҴٸ�
				if(graph[v][i] == 1 && visited[i] == false) {
					// ť�� �ش� ������ �ְ� �湮 ó�� + ť�ϱ� ������� ���� �����ڳ�
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
}












