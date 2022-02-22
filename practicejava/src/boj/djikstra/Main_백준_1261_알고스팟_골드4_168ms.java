package src.boj.djikstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** Main_백준_1261_알고스팟_골드4_168ms*/
public class Main_백준_1261_알고스팟_골드4_168ms {
	
	private static class Node{
		int row;
		int col;
		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	private static int[][] map;
	private static int[][] distance;
	private static int N;
	private static int M;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	private static void go(int row, int col) {
		
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(row, col));
		distance[row][col] = 0;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int cr = curr.row;
			int cc = curr.col;
			for(int i=0; i<4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				// 범위를 벗어났다면 이동
				if(nr<1 || nr>=N+1 || nc<1 || nc>=M+1) continue;
				// 부신 벽 갯수 갱신
				int wall = 0;
				if(map[nr][nc]==1) wall=1;
				if(distance[nr][nc]==-1 || distance[nr][nc]>distance[cr][cc]+wall) { 
					distance[nr][nc] = distance[cr][cc]+wall;
					// 좌표이동
					q.offer(new Node(nr, nc));
				}
			} // end of for direction
			
		} // end of while isEmpty
		
	} // end of method

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		/* 
		 * (1,1)에서 (N,M)까지 가는데 몇개의 벽을 뚫어야 하는지  
		 * 
		 * 재귀를 사용해서 깬 벽의 수를 카운팅하자
		 * distance 배열을 만들고
		 * 초기화되지 않았거나 더 작은 값이 들어오면 값을 갱신하자
		 */
		
		map = new int[N+2][M+2];
		distance = new int[N+2][M+2];
		for(int i=0; i<=N; i++) {
			Arrays.fill(distance[i], -1);
		}
		// map 초기화
		for(int i=1; i<=N; i++) {
			char[] arr = br.readLine().toCharArray();
			for(int j=1; j<=M; j++) {
				map[i][j] = arr[j-1]-'0';
			}
		}
		
		go(1, 1);
		
		System.out.println(distance[N][M]);
		
		
	} // end of main

} // end of class


