package src.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Result{
	public int start;
	public int cnt;
	public Result(int start, int cnt) {
		super();
		this.start = start;
		this.cnt = cnt;
	}
}

public class Solution_SWEA_1861_정사각형방_D4_536ms {
	
	static int N;
	static int max;
	static Result result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int testcase=1; testcase<=TC; testcase++) {
			N = Integer.parseInt(br.readLine());
			max = 0;
			result = new Result(0, 0);
			int[][] graph = new int[N][N];
			// 좌표 초기화
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int len = st.countTokens();
				for(int j=0; j<len; j++) {
					int num = Integer.parseInt(st.nextToken());
					graph[i][j] = num;
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					DFS(graph, i, j, 1, graph[i][j]);
					}
				}
			sb.append("#").append(testcase).append(" ").append(result.start).append(" ").append(result.cnt).append("\n");
		} // end of for testcase
		System.out.println(sb.toString());
	}

	private static void DFS(int[][] graph, int row, int col, int rooms, int input) {
		if(rooms==max) {
			max = rooms;
			int start = Math.min(input, result.start);
			result = new Result(start, max);
		}
		
		if(rooms>max) {
			max = rooms;
			result = new Result(input, max);
		}
		
		int [] dc = {0, 0, -1, 1};
		int [] dr = {-1, 1, 0, 0};
		
		for(int i=0; i<4; i++) {
			
			int nr = row + dr[i];
			int nc = col + dc[i];
			if(nr<0 || nr>=N || nc<0 || nc>=N) {
				continue;
			}
			if(graph[nr][nc]!=graph[row][col]+1) {
				continue;
			}
			if(graph[nr][nc]==graph[row][col]+1) {
				DFS(graph, nr, nc, rooms+1, input);
			}
		}
	}
}