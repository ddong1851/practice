package src.boj.implement;

import java.io.*;
import java.util.*;

/** Main_����_14499_�ֻ���������_���4_140ms*/
public class Main_����_14499_�ֻ���������_���4_140ms {
	
	private static int N;
	private static int M;
	private static int[][] map;
	private static int[] dice;
	private static int[][] movedice = {
			{0},
			{2, 1, 5, 0, 4, 3},
			{3, 1, 0, 5, 4, 2},
			{1, 5, 2, 3, 0, 4},
			{4, 0, 2, 3, 5, 1}
	};
	// 0 �� �� �� ��  oper 1~4�� ��Ī
	private static int[] dr = {0, 0, 0, -1, 1};
	private static int[] dc = {0, 1, -1, 0, 0};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		// ���� �ʱ�ȭ
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// ó���� 0���� �ʱ�ȭ
		dice = new int[6];
		int[] copydice = new int[6];
		
		// �̵� ���
		int oper = 0;
		int nr, nc;
		nr = nc = 0;
		dice[0] = map[row][col]; // ù ������ �ٴ� ����
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			oper = Integer.parseInt(st.nextToken());
			// 1. �ֻ��� �̵�
			nr = row + dr[oper];
			nc = col + dc[oper];
			// ���� üũ
			if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
			// �ֻ��� ����
			for(int rep=0; rep<6; rep++) copydice[rep] = dice[rep];
			// �ֻ��� �� ����
			for(int d=0; d<6; d++) {
				dice[d] = copydice[movedice[oper][d]];
			}
			// 2. �ٴڸ��� 0�� �ƴϸ� ����
			if(map[nr][nc]!=0) {
				dice[0] = map[nr][nc];
				map[nr][nc] = 0;
			}
			// �� ������ ���� ��¥ �ð� ���ȳ׿�...
			else map[nr][nc] = dice[0];
			// 3. �ֻ��� ���� ���
			sb.append(dice[5]).append("\n");
			// 4. �ֻ��� ��ǥ �̵�
			row = nr;
			col = nc;
		}
		// ���� ���
		System.out.println(sb.toString());
	} // end of main
	
} // end of class 
