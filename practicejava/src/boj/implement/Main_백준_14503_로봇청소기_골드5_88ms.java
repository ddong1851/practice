package src.boj.implement;

import java.io.*;
import java.util.*;

public class Main_����_14503_�κ�û�ұ�_���5_88ms {
	
	// �� �� �� ��
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		/*
		 * 1. ���� ��ġ û��
		 * 2.1 ���� ��ġ �ٷ� ���ʿ� û������ ���� �� ������ �ִٸ� ���� ȸ�� �� ��ĭ ���� �� 1��, ������� ���ٸ� ���� ������ ȸ��,,
		 * 2.2 ���� 4�� ȸ���ߴµ� û���� ������ ���ٸ� ���� ( ���� �ٷ� ������ ���̸� �۵��� ���� )
		 * 
		 * BFS? Ʋ�� �����ϸ鼭 �־��� ������� ��������.
		 */
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		
		int[] cleaner = new int[3];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<3; i++) cleaner[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		go(cleaner, map, N, M);
		
	} // end of main 

	private static void go(int[] cleaner, int[][] map, int N, int M) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(cleaner);
		
		int[] curr = new int[3];
		int row, col, dir, nr, nc;
		boolean found = false;
		int cnt = 0;
		while(!q.isEmpty()) {
			curr = q.poll();
			row = curr[0];
			col = curr[1];
			dir = curr[2];
			found = false;
			// 1. ���� ��ġ û��
			if(map[row][col]==0) {
				map[row][col] = 2;
				cnt++;
			}
			// 2.1 ������ ĭ Ž��
			for(int i=1; i<=4; i++) {
				dir = (dir+3)%4;
				nr = row + dr[dir];
				nc = col + dc[dir];
				// ������ ����ų� ���̶�� 
				if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc]!=0) continue;
				// ������ ��ǥ�� û���� ��ǥ�� ã�� ���
				found = true;
				q.offer(new int[] {nr, nc, dir});
				break;
			} // end of for 
			// 2.2 û���� ĭ�� ã�� ���߰�, ��ĭ�� ���� �ƴ� ��� �����ض�
			if(!found && map[row+dr[(dir+2)%4]][col+dc[(dir+2)%4]] != 1) {
				q.offer(new int[] {row+dr[(dir+2)%4], col+dc[(dir+2)%4], dir});
			}
		} // end of while 
		
		System.out.println(cnt);
		
	} // end of go
	
} // end of class 




