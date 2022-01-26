package src.boj.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/** Main_백준_2606_바이러스_실버3_240ms*/
public class Main_백준_2606_바이러스_실버3_240ms {
	
	static int count = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int [][] graph = new int[n+1][n+1];
		
		for(int i=1;i<=m; i++) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			graph[row][col] = 1;
			graph[col][row] = 1;
		}
		sc.close();
		
		boolean[] visited = new boolean[n+1];
		int v = 1;
		
		bfs(graph, visited, v);
		System.out.println(count);
	}

	private static void bfs(int[][] graph, boolean[] visited, int v) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(v);
		visited[v]=true;
		
		int range = graph.length-1;
		
		while(!queue.isEmpty()) {
			v = queue.poll();
			
			for(int i=1; i<=range; i++) {
				if(graph[v][i]==1 && visited[i]==false) {
					queue.add(i);
					visited[i]=true;
					count++;
				}
			}
		}
	}
}
