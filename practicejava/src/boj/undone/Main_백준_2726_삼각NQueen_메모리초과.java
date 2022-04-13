package src.boj.undone;

import java.io.*;
import java.util.*;

/** 2726_삼각NQueen_메모리초과*/
public class Main_백준_2726_삼각NQueen_메모리초과 {
	
	private static int N;
	private static boolean[] leftArr, rightArr, rowArr;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		
		/*
		 * 수학적인 관계를 도출하는게 더 시간적인 효율성이 증가할 것 같다.
		 * 백트래킹은 너무 오래 걸린다.
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int get = 0;
		int TC = Integer.parseInt(br.readLine());
		for(int tc=0; tc<TC; tc++) {
			
			N = Integer.parseInt(br.readLine());
			leftArr = new boolean[N+1];
			rightArr = new boolean[N+1];
			rowArr = new boolean[N+1];
			get = (2*N+1)/3;
			sb.append(get).append("\n");
			go(1, N, new ArrayList<int[]>(), 0, get);
		} // end of for 
		
		System.out.println(sb.toString());
		
	} // end of main 

	private static boolean go(int row, int n, ArrayList<int[]> queens, int picked, int get) {
		if(picked==get) {
			for(int[] q:queens) sb.append(q[0]).append(" ").append(q[1]).append("\n");
			return true;
		}
		if(row>n) return false;
		// 해당 행의 칸 탐색
		for(int i=row; i<=N; i++) {
			for(int col=1; col<=row; col++) {
				// 1. 배치할 수 있는지 확인
				if(isQueen(i, col)) {
					putQueen(i, col, true);								// 해당 자리 배열들에 flag 값을 넣어줌
					queens.add(new int[] {i, col});						// 퀸 리스트에 추가
					if(go(i+1, n, queens, picked+1, get)) return true;	// 다음 퀸 탐색
					queens.remove(queens.size()-1);						// 퀸 리스트에서 제거
					putQueen(i, col, false);							// 해당 자리 배열들에 flag 값을 넣어줌
				}
			}
		}
		return false;
	} // end of go 
	
	private static boolean isQueen(int row, int col) {
		if(rowArr[row] || leftArr[col] || rightArr[row-col]) return false;
		return true;
	} // end of isQueen
	
	private static void putQueen(int row, int col, boolean flag) {
		rowArr[row] = leftArr[col] = rightArr[row-col] = flag;
	} // end of putQueen
	
} // end of class 










