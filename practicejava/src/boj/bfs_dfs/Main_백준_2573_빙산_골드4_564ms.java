package src.boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** Main_¹éÁØ_2573_ºù»ê_°ñµå4_564ms*/
public class Main_¹éÁØ_2573_ºù»ê_°ñµå4_564ms {
	
	private static class Node{
		int row, col, ices;
		public Node(int row, int col, int ices) {
			super();
			this.row = row;
			this.col = col;
			this.ices = ices;
		}
	}
	
	private static int[][] map;
	private static boolean[][] vis;
	private static int N;
	private static int M;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int years = 0;
		// ¸ðµç ÁÂÇ¥ Å½»ö
		while(true) {
			int ice = 0;
			vis = new boolean[N][M];
			for(int row=1; row<N-1; row++) {
				for(int col=1; col<M-1; col++) {
					if(map[row][col]>0 && !vis[row][col]) {
						go(row, col);
						ice++;
					}
				}
			}
			if(ice>=2) {
				System.out.println(years);
				break;
			}
			if(ice==0) {
				System.out.println(0);
				break;
			}
			years++;
		}
	}

	private static void go(int row, int col) {
		Queue<Node> change = new LinkedList<Node>();
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(row, col, 0));
		vis[row][col] = true;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int r = curr.row;
			int c = curr.col;
			int ice = 0;
			for(int i=0; i<4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				// ¹üÀ§¸¦ ¹þ¾î³µ´Ù¸é
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				if(map[nr][nc]<=0) ice++;
				else if(!vis[nr][nc] && map[nr][nc]>0) {
					q.offer(new Node(nr, nc, 0));
					vis[nr][nc] = true;
				}
			}
			change.offer(new Node(r, c, ice));
		}
		// ºù»ê »óÅÂ ¹Ù²Ù±â
		while(!change.isEmpty()) {
			Node node = change.poll();
			map[node.row][node.col] -= node.ices;
		}
	}
}












