package src.boj.bitmasking;

import java.io.*;
import java.util.*;

/** Main_����_1194_�����������ٰ���_���1_144ms*/
public class Main_����_1194_�����������ٰ���_���1_144ms {
	
	public static class ME{
		int row, col;
		String keys;
		public ME(int row, int col, String keys) {
			super();
			this.row = row;
			this.col = col;
			this.keys = keys;
		}
	}
	
	private static int N, M;
	private static char[][] map;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		
		/*
		 * Ž�� ����
		 * 
		 * �� ĭ�� �̵� ����
		 * # ��, �̵� �Ұ�
		 * ���� �ҹ���, �̸� ������ ���� �� �� ����
		 * �� �빮��
		 * �ν����� ��ġ 0
		 * �ⱸ 1
		 * 
		 * BFS?
		 * �ⱸ�� 1�� �������� �� �� ���� ī��Ʈ�ϰ� ����
		 * ���� ť�� �� ������ �ݺ��� �ص� ã�� ���Ͽ��ٸ� return -1 ����
		 * 
		 * ���� �迭 ( �빮�ڸ� ������ -'A' �� True���� Ȯ��, �ҹ��ڸ� ������ -'a'�� true�� ����
		 * ������ Ÿ���� ����µ�,
		 * 
		 * ��ġ row col 
		 * ���� ���� String key;
		 *
		 * ������ �湮 ó����?
		 * �湮 �迭�� ��� ����� �ʹ� ���ſ
		 * String���� �迭�� �����, vis[r][c].compare��? (���� Ű ���� ����?)
		 * 
		 * ���� 1 
		 * �޸𸮰� ������!
		 * �湮 ó���� �ٸ� ������� �ؾ��Ѵ�.,
		 * 3����?
		 * _ _ _ _ _ _
		 * a b c d e f 
		 * H�� �� ������ ���� ���θ� 1, 0���� �����ϰ� 
		 * H�� �ش� ������ �������� ǥ���Ѵ�.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]=='0') 
					System.out.println(go(i, j));
			}
		}
		
	} // end of main

	private static int go(int sr, int sc) {
		// ���ڿ� �񱳸� ���� �湮 üũ
		// 3���� �湮 ó�� 0~63
		boolean [][][] vis = new boolean[64][N][M];
		map[sr][sc] = '.';
		vis[0][sr][sc] = true;
		
		Queue<ME> q = new LinkedList<>();
		q.offer(new ME(sr, sc, "000000"));
		
		int row,col,nr,nc;
		String key="";
		int moves = 1;
		while(!q.isEmpty()) {
			for(int rep=0, size = q.size(); rep<size; rep++) {
				ME curr = q.poll();
				row = curr.row;
				col = curr.col;
				key = curr.keys;
				for(int i=0; i<4; i++) {
					nr = row + dr[i];
					nc = col + dc[i];
					// ������ ����� Ȥ�� ���̶�� Ȥ�� �̹� ���ٿ� ���̶��
					if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc]=='#') continue;
					// �ش� ��ǥ�� �湮���� �ִٸ�
					if(vis[Integer.parseInt(key, 2)][nr][nc]) continue;
					// �ϴ� �湮 ó��
					vis[Integer.parseInt(key, 2)][nr][nc] = true;
					// ��������� 
					if(map[nr][nc]=='1') {
						return moves;
					}
					else if(map[nr][nc]=='.') {
						q.offer(new ME(nr, nc, key));
					}
					// �ҹ��ڶ��
					else if(map[nr][nc]-'a'>=0 && map[nr][nc]-'a'<6) {
						// ���� �ش� �ڸ� ���谡 ���� ���
						if(key.charAt(map[nr][nc]-'a')=='0') {
							StringBuilder replace = new StringBuilder(key);
							replace.setCharAt(map[nr][nc]-'a', '1');
							vis[Integer.parseInt(replace.toString(), 2)][nr][nc] = true;
							q.offer(new ME(nr, nc, replace.toString()));
						} else {
							q.offer(new ME(nr, nc, key));
						}
					}
					// �빮�ڶ��
					else if(map[nr][nc]-'A'>=0 && map[nr][nc]-'A'<6) {
						if(key.charAt(map[nr][nc]-'A')=='0') continue; 
						q.offer(new ME(nr, nc, key));
					}
				} // end of for
			} // end of for count moves 
			moves++;
		} // end of while empty 
		// ���� ã�� ����
		return -1;
	} // end of go
} // end of class 













