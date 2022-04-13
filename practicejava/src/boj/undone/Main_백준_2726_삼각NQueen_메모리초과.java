package src.boj.undone;

import java.io.*;
import java.util.*;

/** 2726_�ﰢNQueen_�޸��ʰ�*/
public class Main_����_2726_�ﰢNQueen_�޸��ʰ� {
	
	private static int N;
	private static boolean[] leftArr, rightArr, rowArr;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		
		/*
		 * �������� ���踦 �����ϴ°� �� �ð����� ȿ������ ������ �� ����.
		 * ��Ʈ��ŷ�� �ʹ� ���� �ɸ���.
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
		// �ش� ���� ĭ Ž��
		for(int i=row; i<=N; i++) {
			for(int col=1; col<=row; col++) {
				// 1. ��ġ�� �� �ִ��� Ȯ��
				if(isQueen(i, col)) {
					putQueen(i, col, true);								// �ش� �ڸ� �迭�鿡 flag ���� �־���
					queens.add(new int[] {i, col});						// �� ����Ʈ�� �߰�
					if(go(i+1, n, queens, picked+1, get)) return true;	// ���� �� Ž��
					queens.remove(queens.size()-1);						// �� ����Ʈ���� ����
					putQueen(i, col, false);							// �ش� �ڸ� �迭�鿡 flag ���� �־���
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










