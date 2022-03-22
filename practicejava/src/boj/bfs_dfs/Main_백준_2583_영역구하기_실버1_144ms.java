package src.boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/** Main_백준_2583_영역구하기_실버1_144ms*/
public class Main_백준_2583_영역구하기_실버1_144ms {
	
	private static class Node{
		int row, col;
		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	private static int N;
	private static int M;
	private static int K;
	private static int[][] map;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static PriorityQueue<Integer> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			// 색칠하기
			for(int row = 0, len=y2-y1; row<len; row++) {
				for(int col=0, clen=x2-x1; col<clen; col++) {
					map[y1+row][x1+col] = 1;
				}
			}
		}
		
		for(int row=0; row<N; row++) {
			for(int col=0; col<M; col++) {
				if(map[row][col]==0) {
					bfs(row, col);
				}
			}
		}
		
		sb.append(pq.size()).append("\n");
		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append(" ");
		}
		
		System.out.println(sb.toString());
		
		
	} // end of main

	private static void bfs(int row, int col) {
		// TODO Auto-generated method stub
		
		map[row][col] = 1;
		int cnt = 1;
		
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(row, col));
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int r = curr.row;
			int c = curr.col;
			for(int i=0; i<4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc]==1) continue;
				cnt++;
				map[nr][nc]=1;
				q.offer(new Node(nr, nc));
			}
		} // end of while
		
		pq.offer(cnt);
		
	} // end of bfs
	
} // end of class 
