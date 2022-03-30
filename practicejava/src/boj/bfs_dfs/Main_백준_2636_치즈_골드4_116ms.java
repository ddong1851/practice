package src.boj.bfs_dfs;

import java.io.*;
import java.util.*;

/** Main_백준_2636_치즈_골드4_116ms*/
public class Main_백준_2636_치즈_골드4_116ms {
	
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
	private static int[][] map;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		/*
		 * IDEA
		 * 
		 * 치즈의 겉 표면에 공기가 닿으면 사라질 녀석들이 된다.
		 * 
		 * BFS로 좌표를 탐색
		 * 
		 * 포인트는 치즈 외곽의 공기와 닿은 녀석들만 없애는 것 
		 * 
		 * 0,0부터 시작해서 다음 좌표가 0이면 이동하고 
		 * 1이면 외곽 치즈로 인지 --> 삭제 대상 큐에 올린 다음 
		 * 모든 탐색이 끝나면 삭제 대상 큐를 비우면서 map 갱신
		 * 
		 * + Java8로 돌리니까 116ms로 줄었다..! 
		 */
		
		N = Integer.parseInt(st.nextToken()); // <=100
		M = Integer.parseInt(st.nextToken()); // <=100
		
		map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) map[i][j] = Integer.parseInt(st.nextToken());
		} // end of initialize
		
		int [] dr = {-1, 1, 0, 0};					// 상하좌우 row 
		int [] dc = {0, 0, -1, 1};					// 상하좌우 col
		
		int size = 0; 								// 궁극적으로 모두 삭제되기 이전 몇 개의 치즈가 존재했는지 저장하는 변수
		int turn = 0; 								// 모두 삭제되는데 몇 턴이 지났는지 카운팅하는 변수
		int row, col, nr, nc; 						// 현재 좌표와 다음 좌표를 저장할 변수
		Queue<Node> q = new LinkedList<Node>(); 	// 공기 좌표를 저장하는 큐
		Queue<Node> del = new LinkedList<Node>();	// 삭제 대상 치즈를 저장하는 큐
		Node first = new Node(0, 0);				// 시작하는 좌표
		while(true) {
			q.offer(first);
			visited[0][0] = true;
			while(!q.isEmpty()) {
				Node curr = q.poll();
				row = curr.row;
				col = curr.col;
				// 4방 탐색
				for(int i=0; i<4; i++) {
					nr = row + dr[i];
					nc = col + dc[i];
					// 범위를 벗어났거나 이미 방문한 곳이라면
					if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc]) continue;
					// 방문 처리
					visited[nr][nc] = true;
					// 다음 좌표도 공기라면 탐색 큐에 추가
					if(map[nr][nc]==0) q.offer(new Node(nr, nc)); 
					// 치즈를 만났다면
					else if(map[nr][nc]==1) {
						// 삭제 대상 큐에 추가
						del.offer(new Node(nr, nc));
					}
				} // end of for 
			} // end of while empty
			// 치즈가 존재하지 않으면 종료
			if(del.isEmpty()) break;
			// 종료하는 턴일 때 갱신하지 않도록 처리 ( 마지막으로 처리할 치즈의 개수를 저장 )
			size = del.size();
			// 종료되지 않았다면, 턴, visited배열, map 갱신
			turn++;
			// 방문 배열 갱신
			initVisited(visited);
			// map 갱신
			while(!del.isEmpty()) {
				Node delete = del.poll();
				map[delete.row][delete.col] = 0;
			} // end of delete cheese
		} // end of while
		
		System.out.println(turn+"/n"+size);
		
	} // end of main
	
	// visited 배열 갱신
	private static boolean[][] initVisited(boolean[][]visited) {
		for(int i=0; i<N; i++) Arrays.fill(visited[i], false);
		return visited;
	} // end of initVisited
	
} // end of main













