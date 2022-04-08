package src.boj.implement;

import java.io.*;
import java.util.*;

public class Main_����_15685_�巡��Ŀ��_���4_84ms {

	private static int C, R, D, T;
	private static int[][] path;
	private static boolean[][] map = new boolean[101][101];
	private static int[] dr = { 0, -1, 0, 1 };
	private static int[] dc = { 1, 0, -1, 0 };
	private static int[] power = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024 };

	public static void main(String[] args) throws Exception {
		
		/*
		 * �巡�� Ŀ��,,,,
		 * ������ �Դ� ��θ� 90���� ��� �̵��ϸ� �ȴ�...
		 * ���� ���� ��� ��� ��������,,,,
		 * 
		 * ������ ã�´�.. �����ϴ� ������ �ִٸ� BFS�� ? 
		 * 
		 * �𸣰��� �׳� ��� �����ϴ°� ���� �� 
		 * �����ߴ� ��ε� ( ���� ) �����ϰ� �� ������ 90���� ȸ���ؼ� ����
		 * ���� �ֱٿ� �߰��� ������� �ݴ�� ����
		 * 0 - 0 1 -  0 1 2 1 - 0 1 2 1 2 3 2 1 - .....  
		 * 
		 * path �迭�� ����غ���
		 * �̸� ��θ� �����ص���
		 * 4�������� �� 1024�� �̵������� ��������
		 * �׸��� 2^n(����) ��ŭ�� �̵�
		 * 
		 * ���ٸ� Ȯ���ϸ� 
		 * �������� +1�� �ϸ� �ȴ� ( �׳� for�� ���� �� �� �����ص��� ) 
		 * 
		 * + �Է����� �־����� ���� ���ڸ� ����� �ʴ´�
		 * 
		 */

		path = new int[4][1024];
		for (int i = 0; i < 4; i++)
			path[i][0] = i;

		int start = 0;
		int end = 0;
		for (int i = 1; i <= 10; i++) {
			start = power[i] - 1;
			end = power[i - 1];
			for (int j = start; j >= end; j--) {
				for (int dir = 0; dir < 4; dir++) {
					path[dir][j] = (path[dir][start - j] + 1) % 4;
				}
			}
		} // ��� ����

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			T = Integer.parseInt(st.nextToken());
			go(C, R, D, T);
		}

		System.out.println(countSquare());

	} // end of main

	private static int countSquare() {
		int count = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i][j + 1] && map[i + 1][j + 1] && map[i + 1][j])
					count++;
			}
		}
		return count;
	} // end of countSquare

	private static void go(int sc, int sr, int dir, int type) {
		int end = power[type];
		map[sr][sc] = true;
		for (int i = 0; i < end; i++) {
			sr += dr[path[dir][i]];
			sc += dc[path[dir][i]];
			map[sr][sc] = true;
		} // end of for
	} // end of go

} // end of class
