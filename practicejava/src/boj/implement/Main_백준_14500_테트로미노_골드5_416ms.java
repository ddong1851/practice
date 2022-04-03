package src.boj.implement;

import java.io.*;
import java.util.*;


public class Main_����_14500_��Ʈ�ι̳�_���5_416ms {
	
	private static int N, M;
	
	// 3���� ¦ 
	private static int[][][] dir = {
			{// ���� 
				{0, 1}, {0, 2}, {0, 3}, {1, 0}, {2, 0}, {3, 0}
			},
			{// �׸� �ð����
				{0, 1}, {1, 1}, {1, 0}
			},
			{// �����, ���� ª�� �� ������ �� --. 
				{-1, 0}, {-2, 0}, {0, 1}, {0, 1}, {0, 2}, {1, 0}, {1, 0}, {2, 0}, {0, -1}, {0, -1}, {0, -2}, {-1, 0}
			},
			{// ����� ���� 
				{-1, 0}, {-2, 0}, {0, -1}, {0, 1}, {0, 2}, {-1, 0}, {1, 0}, {2, 0}, {0, 1}, {0, -1}, {0, -2}, {1, 0}
			},
			{// �� ��� �� �� �� ��
				{0, -1}, {0, 1}, {-1, 0}, {-1, 0}, {1, 0}, {0, 1}, {0, -1}, {0, 1}, {1, 0}, {-1, 0}, {1, 0}, {0, -1}
			},
			{// ���� ���
				{-1, 0}, {-1, -1}, {-2, -1}, {0, 1}, {-1, 1}, {-1, 2}, {1, 0}, {1, 1}, {2, 1}, {0, -1}, {1, -1}, {1, -2}
			},
			{// ���� ��� ����
				{-1, 0}, {-1, 1}, {-2, 1}, {0, 1}, {1, 1}, {1, 2}, {1, 0}, {1, -1}, {2, -1}, {0, -1}, {-1, -1}, {-1, -2}
			}
	};

	private static int[][] map;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		/*
		 * ���� Ž�� ����? ��� �ϱ⿣ ���� ������ ����� �� ũ�� �ϴ�.
		 * �׷����� �ұ��ϰ� ���� Ž���� �ؾ��� �� ������, 
		 * 
		 * ��� ��ǥ�� �����ϰ�, 
		 * �ű⼭ �Ļ��Ǵ� ��� �������� ���� ��� �ִ밪 üũ
		 * 
		 * �������� BFS�� �������� �ߺ��� �����ϱ� �����
		 * DFS�� �����Ұ� ������
		 * �̴� �ä��Ǥ̸� ������.
		 * 
		 * ��� ���� ����
		 * 1. DFS
		 * 2. �� ��� �˻�?
		 * �ð���.. �ɱ�
		 * 
		 * �迭�� ����� ���� �����ϱ� ���� N+6 M+6���� ���� �غ���
		 * ������ ���̽��� ��� �ľ��ϸ鼭 �ִ밪�� ��������  ( 23�� ���̽�? )
		 */
		
		map = new int[N+6][M+6];
		for(int i=3; i<N+3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=3; j<M+3; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for(int r=3; r<N+3; r++) {
			for(int c=3; c<M+3; c++) {
				max = Math.max(max, TetrisCount(r, c));
			}
		}
		System.out.println(max);
		
	} // end of main 

	
	// �� ���� ���� ��� ������ üũ
	private static int TetrisCount(int r, int c) {
		// TODO Auto-generated method stub
		int max = 0;
		int start = map[r][c];
		for(int i=0; i<7; i++) {
			int temp = 0;
			for(int j=0, rowsize=dir[i].length; j<rowsize; ) {
				temp = start + map[r+dir[i][j][0]][c+dir[i][j++][1]] + map[r+dir[i][j][0]][c+dir[i][j++][1]] 
						+ map[r+dir[i][j][0]][c+dir[i][j++][1]];
				if(max<temp) max = temp;
			}
		}
		return max;
	} // end of TetrisCount
	
} // end of class 












