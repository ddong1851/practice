package src.boj.bfs_dfs;

import java.io.*;
import java.util.*;


/*
 * 모든 벽읋 한번씩 부셔보면서 브루트포스하기엔 N, M의 크기가 너무 큰 경우
 * 3차원 배열을 사용하여 벽을 부순 경우와 부순적 없는 경우를 나눠 진행해보아라.
 * 혹은 모든 깊이 별로? 3차원 배열을 응용해서 사용해보면
 * 한번의 탐색에서 백트래킹과 같은 효과를 누릴 수 있는 장점이 있다.
 */

/** Main_백준_2206_벽부수고이동하기_골드4_876ms*/
public class Main_백준_2206_벽부수고이동하기_골드4_876ms {
	
	private static class Node{
		int row, col, depth, destroyed;
		public Node(int row, int col, int depth, int destroyed){
			this.row = row;
			this.col = col;
			this.depth = depth;
			this.destroyed = destroyed;
		}
	}
	
	private static int N;
	private static int M;
	private static char[][] map;
	private static boolean[][][] visited;
	// 우 하 좌 상 기준으로 움직이면 대각선 아래 방향 우선이니까
	private static int[] dr = {0, 1, 0, -1};
	private static int[] dc = {1, 0, -1, 0};
	
	private static void go() {
		// 방문처리
		visited[0][0][0] = visited[0][0][1] = true;
		Queue<Node> q = new LinkedList<Node>();
		// 첫 지점도 1칸으로 인정해줌
		q.offer(new Node(0, 0, 1, 0));
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int row = curr.row;
			int col = curr.col;
			// 목표지점에 도착했더라면
			if(row==N-1 && col==M-1) {
				System.out.println(curr.depth);
				return;
			}
			// 4방 탐색
			for(int i=0; i<4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				int destroyed = curr.destroyed;
				// 범위를 벗어났다면
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				// 빈칸이라면
				if(map[nr][nc]=='0') {
					// 벽을 깼건 안깼건, 방문한적이 있는 좌표인지 확인
					if(!visited[nr][nc][destroyed]) {
						visited[nr][nc][destroyed] = true;
						q.offer(new Node(nr, nc, curr.depth+1, destroyed));
					}
				}
				// 벽이라면
				else if(map[nr][nc]=='1') {
					// 이미 다른 벽을 부순적이 있다면 다음 탐색
					if(destroyed!=0) {
						continue;
					}
					// 아직 벽을 깬적이 없는 경우
					else {
						// 해당 벽을 깨고간 적이 있다고 표시
						visited[nr][nc][destroyed+1] = true;
						q.offer(new Node(nr, nc, curr.depth+1, 1));
					}
				}
			} // end of for move
		} // end of while 
		
		System.out.println(-1);
		
	} // end of go()
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M][2];
		for(int i=0; i<N; i++) {
			String temp = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		// BFS
		go();
		
	} // end of main
	
} // end of class
