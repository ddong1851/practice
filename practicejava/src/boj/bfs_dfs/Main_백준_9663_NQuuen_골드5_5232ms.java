package src.boj.bfs_dfs;

import java.util.Scanner;

/** Main_백준_9663_NQuuen_골드5_5232ms*/
public class Main_백준_9663_NQuuen_골드5_5232ms {
	
	private static int N, total;
	static int [] queens;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/* 1<=N<=15, NxN 체스판에 N개의 퀸을 놓을 수 있는 가지수 */
		N = sc.nextInt();
		/*
		 * 2차원 배열을 1차원 배열로 만들어서 np를 사용하여 조합을 만든다.
		 * --> 이 방법은 가지치기에 어려움이 있을거 같다.
		 * 
		 * 재귀적으로 백트래킹을 하자 
		 * 하나의 선택, 이게 가능하면 다음 선택 
		 * 꽝이면 이전 선택으로 넘어와서 증가
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

	// 같은 열인지, 같은 대각선인지 확인
	private static boolean Queen(int row, int col) {
		for(int i=0; i<row; i++) {
			if(queens[i]==col || Math.abs(row - i)==Math.abs(col - queens[i]))
				return false;
		}
		return true;
	}

} // end of class
