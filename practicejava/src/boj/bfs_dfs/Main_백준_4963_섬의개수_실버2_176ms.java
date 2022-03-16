package src.boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** Main_백준_4963_섬의개수_실버2_176ms*/
public class Main_백준_4963_섬의개수_실버2_176ms {
	
	private static class Node{
		int row, col;
		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	private static int H;
	private static int W;
	private static int[][] map;
	private static boolean[][] vis;
	private static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	private static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		String str = null;
		while(!(str=br.readLine()).equals("0 0")) {
			st = new StringTokenizer(str);
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			vis = new boolean[H][W];
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // end of for init
			
			int cnt = 0;
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(map[i][j]==1 && !vis[i][j]) {
						vis[i][j] = true;
						go(new Node(i, j));
						cnt++;
					}
				} 
			} // end of for travel
			
			sb.append(cnt).append("\n");
			
		} // end of testcases
		System.out.println(sb.toString());
	} // end of main 
	
	private static void go(Node start) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(start);
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int row = curr.row;
			int col = curr.col;
			for(int i=0; i<8; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				// 범위를 벗어났거나, 방문했거나, 바다라면
				if(nr<0 || nr>=H || nc<0 || nc>=W || vis[nr][nc] || map[nr][nc]==0) continue;
				vis[nr][nc] = true;
				q.offer(new Node(nr, nc));
			} // end of for
		} // end of while
	} // end of go
} // end of class 













