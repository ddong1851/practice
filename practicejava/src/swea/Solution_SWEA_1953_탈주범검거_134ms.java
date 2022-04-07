package src.swea;

import java.io.*;
import java.util.*;

public class Solution_SWEA_1953_Ż�ֹ��˰�_134ms {

	private static class Node{
		int row, col;
		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}

	private static int N, M, R, C, Time, max, row, col, nr, nc, size, type;
	private static int[][] map;
	private static boolean[][] visiting;
	private static Queue<Node> q = new LinkedList<>();
	private static int [][] dr = {
			{},
			{-1, 1, 0, 0}, 	// �����¿�
			{-1, 1, 0, 0},	// �� ��
			{0, 0, 0, 0},	// �� ��
			{-1, 0, 0, 0},	// �� ��
			{0, 1, 0, 0},	// �� ��
			{0, 1, 0, 0},	// �� ��
			{-1, 0, 0, 0}	// �� ��
	};
	private static int [][] dc = {
			{},
			{0, 0, -1, 1},
			{0, 0, 0, 0}, 
			{0, 0, -1, 1},
			{0, 0, 0, 1},
			{0, 0, 0, 1},
			{0, 0, -1, 0},
			{0, 0, -1, 0}
	};
	private static int [][] types = { // �� �� �� �� �����ӿ� ���� ������ ����
			{1, 2, 5, 6},	// ��
			{1, 2, 4, 7},	// ��
			{1, 3, 4, 5},	// ��
			{1, 3, 6, 7}	// ��
	};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		for (int test = 1; test <= TC; test++) {

			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			Time = Integer.parseInt(st.nextToken());

			visiting = new boolean[N][M];
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			max = 0;
			go();

			sb.append("#").append(test).append(" ").append(max).append("\n");
		} // end of for TC
		System.out.println(sb.toString());

	} // end of main

	private static void go() {
		q.offer(new Node(R, C));
		visiting[R][C] = true;
		max++;
		--Time;

		while (!q.isEmpty()) {
			if(Time--==0) {
				q.clear();
				break;
			} // end of if Time
			size = q.size();
			while (size-- > 0) {
				Node curr = q.poll();
				row = curr.row;
				col = curr.col;
				// �ͳ� Ÿ�Կ� ���� �ٸ��� ������
				type = map[row][col];
				for(int i=0; i<4; i++) {
					nr = row + dr[type][i];
					nc = col + dc[type][i];
					// ������ ����ų� ������ ��ǥ�� Ž���ϰų� ������ �ͳ��� �ƴϰų� �̹� �Ÿ��� ������ ���
					if(nr < 0 || nr >= N || nc < 0 || nc >= M || (nr==row && nc==col) || !TubeAble(i, map[nr][nc]) || 
							visiting[nr][nc]) continue;
					q.offer(new Node(nr, nc));
					visiting[nr][nc] = true;
					max++;
				}
			} // end of while pq size 
		} // end of while pq 
	} // end of go

	private static boolean TubeAble(int dir, int check) {
		for(int i=0; i<4; i++) {
			if(types[dir][i]==check) return true;
		}
		return false;
	} // end of checkTube

} // end of class















