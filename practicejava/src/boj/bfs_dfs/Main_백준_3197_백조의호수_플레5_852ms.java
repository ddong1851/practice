package src.boj.bfs_dfs;

import java.io.*;
import java.util.*;

public class Main_백준_3197_백조의호수_플레5_852ms {
	
	private static class Point{
		int row, col;
		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N+2][M+2];
		boolean[][] vis = new boolean[N+2][M+2];
		Point[] swan = new Point[2];
		Queue<Point> water = new LinkedList<>();
		Queue<Point> next = new LinkedList<>();
		Queue<Point> q = new LinkedList<>();
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		int cnt = 0;
		String temp = "";
		for(int i=1; i<=N; i++) {
			temp = br.readLine();
			for(int j=1, k=0; j<=M; j++, k++) {
				map[i][j] = temp.charAt(k);
				if(map[i][j] == 'L') {
					swan[cnt++] = new Point(i, j);
				}
				if(map[i][j] != 'X') {
					water.offer(new Point(i, j));
				}
			}
		} // end of for initialize
		
		q.offer(swan[0]);
		vis[swan[0].row][swan[0].col] = true;
		
		int row, col, nr, nc;
		Point curr = null;
		cnt = 0;
		boolean isMet = false;
		while(true) {
			while(!q.isEmpty()) {
				curr = q.poll();
				row = curr.row;
				col = curr.col;
				// 짝꿍을 만났다면 종료
				if(row==swan[1].row && col==swan[1].col) {
					isMet = true;
					break;
				}
				for(int i=0; i<4; i++) {
					nr = row+dr[i];
					nc = col+dc[i];
					// 테두리를 만난다면 or 이미 방문했다면
					if(map[nr][nc]=='\u0000' || vis[nr][nc]) continue;
					vis[nr][nc] = true;
					// 빙판을 만나면, 여기서 중복을 야기한다...
					if(map[nr][nc]=='X') {
						next.offer(new Point(nr, nc));
						continue;
					}
					q.offer(new Point(nr, nc));
				}
			} // end of while swan 
			if(isMet) break;
			// 탐색에 실패했다면 다음 탐색할 좌표 추가 후 빙판 녹이기
			cnt++;
			// 현재 물 큐에 있는 놈들만 탐색
			for(int rep=0, size=water.size(); rep<size; rep++) {
				curr = water.poll();
				row = curr.row;
				col = curr.col;
				for(int i=0; i<4; i++) {
					nr = row+dr[i];
					nc = col+dc[i];
					if(map[nr][nc]=='\u0000') continue;
					if(map[nr][nc]=='X') {
						map[nr][nc]='.';
						water.offer(new Point(nr, nc));
					}
				} // end of for 
			} // end of while water 
			// 다음 탐색할 좌표들도 바다로 바꿔주면서 추가
			while(!next.isEmpty()) {
				Point p = next.poll();
				map[p.row][p.col] = '.';
				q.offer(p);
			} // end of while next
		} // end of while 
		
		System.out.println(cnt);
		
		
	} // end of main
	
} // end of class 













