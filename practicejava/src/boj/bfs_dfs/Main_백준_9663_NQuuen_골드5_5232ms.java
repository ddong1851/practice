package src.boj.bfs_dfs;

import java.util.Scanner;

/** Main_����_9663_NQuuen_���5_5232ms*/
public class Main_����_9663_NQuuen_���5_5232ms {
	
	private static int N, total;
	static int [] queens;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/* 1<=N<=15, NxN ü���ǿ� N���� ���� ���� �� �ִ� ������ */
		N = sc.nextInt();
		/*
		 * 2���� �迭�� 1���� �迭�� ���� np�� ����Ͽ� ������ �����.
		 * --> �� ����� ����ġ�⿡ ������� ������ ����.
		 * 
		 * ��������� ��Ʈ��ŷ�� ���� 
		 * �ϳ��� ����, �̰� �����ϸ� ���� ���� 
		 * ���̸� ���� �������� �Ѿ�ͼ� ����
		 * 
		 */
		total = 0;
		queens = new int[N];
		NQueens(0);
	} // end of main

	private static void NQueens(int row) {
		// TODO Auto-generated method stub
		
		if(row>=N) {
			total++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			queens[row] = i;
			if(Queen(row, i)) {
				NQueens(row+1);
			}
		}
	}

	// ���� ������, ���� �밢������ Ȯ��
	private static boolean Queen(int row, int col) {
		for(int i=0; i<row; i++) {
			if(queens[i]==col || Math.abs(row - i)==Math.abs(col - queens[i]))
				return false;
		}
		return true;
	}

} // end of class
