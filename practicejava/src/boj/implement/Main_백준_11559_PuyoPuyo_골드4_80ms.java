package src.boj.implement;

import java.util.*;
import java.io.*;

/** Main_����_11559_PuyoPuyo_���4_132ms*/
public class Main_����_11559_PuyoPuyo_���4_80ms {
	
	private static class Node{
		int row, col;
		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	private static int row, col, nr, nc;
	private static char[][] map;
	private static boolean[][] vis;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static Queue<Node> q = new LinkedList<>();
	private static Queue<Node> team = new LinkedList<>();
	private static Queue<Node> delete = new LinkedList<>();
	private static Deque<Character> chain = new ArrayDeque<>();

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[12][];
		vis = new boolean[12][6];
		for(int i=0; i<12; i++) map[i] = br.readLine().toCharArray();
		// end of initialize
		
		/*
		 * �ѿ�ѿ� ����
		 * ��ǥ�� Ž���� ���������� ����
		 * �湮���� ���� ��ǥ �� �ѿ並 �߰��ϸ�, ���� ���� �ѿ���� BFS�� ���� ã��
		 * 4�� �̻� �߰ߵǸ� �ش� delete ť�� �����ϴ� ��� ��¥ ó�� ť�� �ֱ� ( ���ÿ� N�� �ѿ䰡 ����Ǹ� 1����� ���� )
		 * 3�� ���ϸ� delete ť ����������
		 * 
		 * �� ���� ����� �� ��¥ ó���� �ѿ� ť�� ����� ��ǥ���� ���� ó�� �� 
		 * ��ǥ ���� ( 2048 ó�� )
		 */
		
		// ������ �� ī����
		int cnt = 0;
		while(true) {
			// 1. ���������� Ž��
			for(int r=0; r<12; r++) {
				for(int c=0; c<6; c++) {
					if(map[r][c]!='.' && !vis[r][c]) {
						// 2. �湮���� ���� ��ǥ �� �ѿ� �߰� ���� �� �ѿ� BFS 
						go(r, c, map[r][c]);
					}
				}
			}
			// ó���� �ѿ䰡 ���� �� ����
			if(delete.isEmpty()) break;
			// ó���� �ѿ䰡 �ִٸ� ó�� �� �迭 ����, �湮 �迭 �ʱ�ȭ �� �۾� ����
			InitGame();
			cnt++;
		}
		
		System.out.println(cnt);
		
	} // end of main

	private static void InitGame() {
		// ��ǥ . ���� ����
		while(!delete.isEmpty()) {
			Node curr = delete.poll();
			map[curr.row][curr.col] = '.';
		}
		
		// �ٴ����� ����
		for(int c=0; c<6; c++) {
			for(int r=0; r<12; r++) {
				if(map[r][c]!='.') chain.offer(map[r][c]);
				map[r][c] = '.';
			}
			// �ٴڿ� �߰�
			row = 11;
			while(!chain.isEmpty()) {
				map[row--][c] = chain.pollLast();
			}
		}
		
		for(int i=0; i<12; i++) Arrays.fill(vis[i], false);
	}

	private static void go(int sr, int sc, char puyo) {
		// �湮 ó��
		vis[sr][sc] = true;
		q.offer(new Node(sr, sc));
		team.offer(new Node(sr, sc));
		// �� ��¥�� ������ Ȯ��
		while(!q.isEmpty()) {
			Node curr = q.poll();
			row = curr.row;
			col = curr.col;
			for(int i=0; i<4; i++) {
				nr = row + dr[i];
				nc = col + dc[i];
				// ������ ����ų� / �̹� �湮�߰ų� / ���� ���� �ƴ϶��
				if(nr<0 || nr>=12 || nc<0 || nc>=6 || vis[nr][nc] || map[nr][nc]!=puyo) continue;
				vis[nr][nc] = true;
				Node next = new Node(nr, nc);
				team.offer(next);
				q.offer(next);
			}
		}
		
		// 4�� �̻��� ���̶�� ���� ��� �߰�
		if(team.size()>=4) {
			while(!team.isEmpty()) delete.offer(team.poll());
		} 
		// 3�� ���ϸ� �׳� ������
		team.clear();
	}
	
} // end of class 







