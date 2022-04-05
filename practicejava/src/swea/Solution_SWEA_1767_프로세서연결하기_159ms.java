package src.swea;

import java.util.*;
import java.io.*;

/** Solution_SWEA_1767_���μ��������ϱ�_159ms */
public class Solution_SWEA_1767_���μ��������ϱ�_159ms {

	private static class Node {
		int row, col;

		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}

	private static int N, core, temp, min, row, col;
	private static int[][] map;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };
	private static ArrayList<Node> list;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		/*
		 * IDEA
		 * 
		 * �׵θ��� �����̶� �����ϸ� �ǰ� � Core�� ������ ��� �Ǹ� ���� ����. �ִ��� ���� Core�� �����ϰ� �̶� ���� ª�� ������
		 * ���̸� ������� + ���� ��ġ�� �ȵȴ�.
		 * 
		 * 7 <= N <= 12 1 <= C <= 12
		 * 
		 * �迭�� ����� ���� �������� ����
		 * 
		 * ���� Ž��? ����? ���� Core�� ������ŭ ���� �� ���� Ž�� �����ϸ� max ����, max�� 100_000(������ �ִ밪)�� �ƴ� ���
		 * ����
		 * --> ������ ���� �κ� �������� �ߴ� ���̿���.
		 * + �����ڸ��� Core�� ���� �����ϰ� �̸� attachMap�� �׳� 1�� �ֱ⸸ �ϰ�
		 * Core ������ ī���� �������� �ð��� �� �پ��� �� ����.
		 * 
		 * �ð� �ʰ��� ���� ������? ������ ���⿡ ���� ��� Ȯ���ؾ� ��
		 */

		int TC = Integer.parseInt(br.readLine());
		for (int test = 1; test <= TC; test++) {

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			list = new ArrayList<Node>();
			core = 0;
			min = 100_000;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					temp = Integer.parseInt(st.nextToken());
					if (temp == 1) {
						core++;
						list.add(new Node(i, j));
					}
					map[i][j] = temp;
				}
			} // end of initialize

			for (int i = core; i >= 0; i--) {
				go(i, new boolean[core], 0, 0, new int[N][N], new ArrayList<Node>());
				if (min != 100_000)
					break;
			} // end of for pick

			sb.append("#").append(test).append(" ").append(min).append("\n");
		} // end of for TC

		System.out.println(sb.toString());

	} // end of main

	private static void go(int cnt, boolean[] chosen, int picked, int start, int[][] newMap, ArrayList<Node> Cores) {
		if (picked == cnt) {
			// ������ �ھ�� ���� ���� �õ�
			attachCore(newMap, Cores, cnt, 0, 0);
			return;
		} // ��������
		for (int i = start; i < core; i++) {
			if (chosen[i])
				continue;
			row = list.get(i).row;
			col = list.get(i).col;
			chosen[i] = true;
			newMap[row][col] = 1;
			Cores.add(new Node(row, col));
			go(cnt, chosen, picked + 1, i + 1, newMap, Cores);
			Cores.remove(Cores.size() - 1); // �ֱٿ� �߰��� �ھ� �ݳ�
			newMap[row][col] = 0;
			chosen[i] = false;
		} // ����

	} // end of go

	// DFS
	private static void attachCore(int[][] attachMap, ArrayList<Node> Cores, int cnt, int length, int start) {
		// ��ǥ ������ŭ �����ߴٸ� ���� ���� ���� �� return
		if (start == cnt) {
			min = Math.min(min, length);
			return;
		} // end of ��������
		int r = Cores.get(start).row;
		int c = Cores.get(start).col;
		int mult = 1;
		for (int i = 0; i < 4;) {
			int nr = r + dr[i] * mult;
			int nc = c + dc[i] * mult;
			// �迭�� ������ ����� ����
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
				// 1. ������ �� ��� ǥ��
				mult--; // ����� �������� ����
				for(int rep=1; rep<=mult; rep++) attachMap[r+dr[i]*rep][c+dc[i]*rep] = 1;
				// 2. ���� DFS 
				attachCore(attachMap, Cores, cnt, length+mult, start+1);
				// 3. ������ �� �ݳ�
				for(int rep=mult; rep>=1; rep--) attachMap[r+dr[i]*rep][c+dc[i]*rep] = 0;
				i++;
				mult=1;
				continue;
			}
			// �̹� �ٸ� Core�� ������̶��
			else if (attachMap[nr][nc] == 1) {
				i++;
				mult=1;
				continue;
			}
			mult++;
		}
	} // end of attachCore

} // end of class
//3
//7
//0 0 1 0 0 0 0
//0 0 1 0 0 0 0
//0 0 0 0 0 1 0
//0 0 0 0 0 0 0
//1 1 0 1 0 0 0
//0 1 0 0 0 0 0
//0 0 0 0 0 0 0
//9
//0 0 0 0 0 0 0 0 0
//0 0 1 0 0 0 0 0 1
//1 0 0 0 0 0 0 0 0
//0 0 0 1 0 0 0 0 0
//0 1 0 0 0 0 0 0 0
//0 0 0 0 0 0 1 0 0
//0 0 0 1 0 0 0 0 0
//0 0 0 0 0 0 0 1 0
//0 0 0 0 0 0 0 0 1
//11
//0 0 1 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0 1
//0 0 0 1 0 0 0 0 1 0 0
//0 1 0 1 1 0 0 0 1 0 0
//0 0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 1 0 0 0
//0 0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 1 0 0
//0 0 0 0 0 0 1 0 0 0 0
//0 0 0 0 0 0 0 0 0 0 0