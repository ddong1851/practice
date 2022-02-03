package src.boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** Main_백준_11724_연결요소의개수_실버2_540ms*/
public class Main_백준_11724_연결요소의개수_실버2_540ms {
	static boolean[]visited;
	static int[][] graph;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// 좌표가 6개면 1~6까지 사용할 수 있도록
		graph = new int[n+1][n+1];
		// 그냥 모든 row 좌표들에 대한 탐색 
		visited = new boolean[n+1];
		
		// 연결된 간선 입력을 통한 그래프 초기화
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			graph[row][col]=1;
			graph[col][row]=1;
		}
		br.close();
		
		// 1이 있는 좌표들에 한하여 DFS를 통한 탐색
		int count = 0;
		// 모든 좌표들에 대해 탐색 시작
		for(int i=1; i<=n; i++) {
			if(visited[i]==false) {
				count+=DFS(n, i);
			}
		}
		System.out.println(count);
	}

	
	private static int DFS(int n, int row) {
		// TODO Auto-generated method stub
		// 이미 방문했다면
		if(visited[row]) {
			return 0;
		}
		visited[row] = true;
		for(int i=1; i<=n; i++) {
			// 연결된 좌표라면 DFS 실시
			if(graph[row][i]==1) {
				DFS(n, i);
			}
		}
		// 연결된 요소들의 개수를 더하게 한다
		return 1;
	}
}
