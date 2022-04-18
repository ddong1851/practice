package src.boj.bfs_dfs;

import java.io.*;
import java.util.*;

public class Main_����_3197_������ȣ��_�÷�5_852ms {
	
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
				// ¦���� �����ٸ� ����
				if(row==swan[1].row && col==swan[1].col) {
					isMet = true;
					break;
				}
				for(int i=0; i<4; i++) {
					nr = row+dr[i];
					nc = col+dc[i];
					// �׵θ��� �����ٸ� or �̹� �湮�ߴٸ�
					if(map[nr][nc]=='\u0000' || vis[nr][nc]) continue;
					vis[nr][nc] = true;
					// ������ ������, ���⼭ �ߺ��� �߱��Ѵ�...
					if(map[nr][nc]=='X') {
						next.offer(new Point(nr, nc));
						continue;
					}
					q.offer(new Point(nr, nc));
				}
			} // end of while swan 
			if(isMet) break;
			// Ž���� �����ߴٸ� ���� Ž���� ��ǥ �߰� �� ���� ���̱�
			cnt++;
			// ���� �� ť�� �ִ� ��鸸 Ž��
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
			// ���� Ž���� ��ǥ�鵵 �ٴٷ� �ٲ��ָ鼭 �߰�
			while(!next.isEmpty()) {
				Point p = next.poll();
				map[p.row][p.col] = '.';
				q.offer(p);
			} // end of while next
		} // end of while 
		
		System.out.println(cnt);
		
		
	} // end of main
	
} // end of class 













