package src.swea;

import java.io.*;
import java.util.*;

public class Solution_SWEA_1249_보급로_D4_141ms {

	private static class Node implements Comparable<Node> {
		int row, col, weight;

		public Node(int row, int col, int weight) {
			super();
			this.row = row;
			this.col = col;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}
	
	// 하 우 좌 상 우선
	private static int[] dr = { 1, 0, 0, -1 };
	private static int[] dc = { 0, 1, -1, 0 };
	private static int[][] dist;
	private static int[][] map;
	private static boolean[][] vis;
	private static int N, row, col, nr, nc;
	private static String temp;
	private static PriorityQueue<Node> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		for (int test = 1; test <= TC; test++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				temp = br.readLine();
				for(int j=0; j<N; j++) map[i][j] = temp.charAt(j)-'0';
			}
			sb.append("#").append(test).append(" ").append(go(map)).append("\n");
		} // end of for TC

		System.out.println(sb.toString());

	} // end of main

	private static int go(int[][] map) {
		vis = new boolean[N][N];
		vis[0][0] = true;
		dist = new int[N][N];
		for(int i=0; i<N; i++) {
			Arrays.fill(dist[i], 999_999); // 어차피 90000이 한계
		}
		dist[0][0] = 0;
		pq.offer(new Node(0, 0, 0));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			row = curr.row;
			col = curr.col;
			if(row==N-1 && col == N-1) {
				pq.clear();
				break;
			}
			for(int i=0; i<4; i++) {
				nr = row + dr[i];
				nc = col + dc[i];
				if(nr<0 || nr>=N || nc<0 || nc>=N || vis[nr][nc] || dist[nr][nc] <= curr.weight + map[nr][nc]) continue;
				dist[nr][nc] = curr.weight + map[nr][nc];
				pq.offer(new Node(nr, nc, dist[nr][nc]));
			}
		}
		return dist[N-1][N-1];
	}
} // end of class












