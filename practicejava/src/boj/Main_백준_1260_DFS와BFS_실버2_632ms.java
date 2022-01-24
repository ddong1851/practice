package src.boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/** Main_백준_1260_DFS와BFS_실버2_632ms*/
public class Main_백준_1260_DFS와BFS_실버2_632ms {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 정점의 개수 
		int n = sc.nextInt();
		// 간선의 개수
		int m = sc.nextInt();
		// 정점의 번호
		int v = sc.nextInt();
		
		// 인접 행렬은 정점이 n개 일때 n*n 배열로 만들 수 있다. 한칸을 증가시켜 정점 1~n까지 쓰게 하자
		int [][] graph = new int[n+1][n+1];
		boolean[] visited  = new boolean[n+1];
		
		for(int i=1; i<=m; i++) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			graph[row][col] = 1;
			graph[col][row] = 1;
		}
		sc.close();
		
		// 그래프, 방문 여부, 시작 정점, 시작 지점 방문 ;
		dfs(graph, visited, v);
		System.out.println();
		Arrays.fill(visited, false);
		bfs(graph, visited, v);
	}

	// DFS는 재귀적 호출
	// 그래프, 방문 여부, 시작점, flag
	private static void dfs(int[][] graph, boolean[] visited, int v) {
		// TODO Auto-generated method stub
		// 해당 정점 방문 표시
		visited[v] = true;
		System.out.print(v+" ");
		// 1~n까지 탐색, 연결된 정점기준으로 탐색
		for(int i=1; i<=graph.length-1; i++) {
			if(graph[v][i] == 1 && visited[i] == false) {
				dfs(graph, visited, i);
			}
		}
	}
	
	// BFS는 DFS와 구현 방식은 동일하지만 while과 큐를 이용
	private static void bfs(int[][] graph, boolean[] visited, int v) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<>();
		int n = graph.length-1;
		
		// 시작 정점 넣기
		queue.add(v);
		// 해당 정점 방문 처리
		visited[v] = true;
		
		// 큐가 빌때까지 반복
		while(!queue.isEmpty()) {
			// 맨위 정점을 꺼내고, 인접한 정점들 방문처리, 이때 작은거 먼저 
			v = queue.poll();
			System.out.print(v+" ");
			
			// 해당 정점과 연결된 정점 탐색 
			for(int i=1; i<=n; i++) {
				// 연결된 정점이고, 방문 처리가 되지 않았다면
				if(graph[v][i] == 1 && visited[i] == false) {
					// 큐에 해당 정점을 넣고 방문 처리 + 큐니까 작은놈들 먼저 나오겠네
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
}












