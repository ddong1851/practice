package src.boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** Main_백준_2468_안전지대_실버1_284ms*/

// 배운점 안전지대의 개수를 출력해라! 하는 문제는 BFS가 무조건 유리하다 return 1로 한개씩만 증가
public class Main_백준_2468_안전지대_실버1_284ms {
	
	static int n;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0,- 1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		graph = new int[n][n];
		
		int maxHeight=0;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j] > maxHeight) {
					maxHeight =graph[i][j];
				}
			}
		}
		
		// 최대 높이+1 까지만 탐색하여 불필요한 연산 줄이기
		int max =0;
		for(int height=0; height<maxHeight+1; height++) {
			// 다음 높이를 구할때마다 count와 방문 여부를 초기화한다
			visited = new boolean[n][n];
			int cnt=0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					// 방문하지 않고 의미 있는 값이라면
					if(!visited[i][j] && graph[i][j] > height){
						cnt+=dfs(i,j,height); // 해당 안전영역 탐색 시작
					}
				}
			}
			// 최대 영역 개수 갱신
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}
	// 안전 영역 DFS탐색
	static int dfs(int x, int y, int height) {
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x +dx[i];
			int ny = y +dy[i];
			
			if(nx<0 || ny<0 || nx>=n || ny >=n) continue;
			if(visited[nx][ny]) continue;
			if(graph[nx][ny]> height) {
				dfs(nx,ny, height);
			}
		}
		// 무조건 1을 반환해서 안전지대가 1개씩 증가
		return 1;
	}
}
