package src.boj.implement;

import java.io.*;
import java.util.*;

public class Main_����_2239_������_���4_612ms {
	
	private static class Node{
		int row, col;
		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	private static ArrayList<Node> list;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		 * IDEA
		 * ��Ʈ��ŷ ���
		 * 1~9 �� �� ���� ���� ��
		 * ����, ����, �׸� Ȯ���Ͽ� ������ ������ Ȯ��
		 * 0�� ���������� ���ʴ�� ������ 
		 * ó������ ���� ���� ����
		 * 
		 * ������ �ϼ��ϸ� return true �ϸ鼭 ����
		 * 
		 * ++ ��� ���� 1~9�� ���� ��� ���θ� Ȯ���ϴ� row[10][10]
		 * ++ ��� ���� 1~9�� ���� ��� ���θ� Ȯ���ϴ� col[10][10];
		 * ++ �׸�ȿ� 1~9�� ���� ��� ���θ� Ȯ���ϴ� square[10][10]�� �����
		 * ó���� ���� �Է¹��� �� �� �ڸ��� ���� ���� true�� �������ش�.
		 * �� ����� ����ϸ� Ȯ���� �� 1~9�� �� ���°� �ƴ�, ���ϴ� ���� �ְ� Ȯ���� �� �ִ�.
		 * --> �ð��� 300? 
		 */
		
		
		int[][] map = new int[9][9];
		list = new ArrayList<Node>();
		String temp = "";
		for(int i=0; i<9; i++) {
			temp = br.readLine();
			for(int j=0; j<9; j++) {
				map[i][j] = temp.charAt(j)-'0';
				if(map[i][j]==0) list.add(new Node(i, j));
			}
		}
		
		go(0, list.size(), map);
		
	} // end of main 

	private static boolean go(int cnt, int size, int[][] map) {
		if(cnt==size) {
			// ���� ���
			printMap(map);
			return true;
		} // end of ��������
		// 1~9 �õ�
		for(int i=1; i<=9; i++) {
			// 1. ���� ���� �׸� Ȯ��
			if(checkSudoku(list.get(cnt), i, map)) {
				// 2. �迭 �ݿ�
				map[list.get(cnt).row][list.get(cnt).col] = i;
				// 3. ���� ĭ 
				if(go(cnt+1, size, map)) return true;
				// 4. �迭 ����
				map[list.get(cnt).row][list.get(cnt).col] = 0;
			}
		} // end of for
		return false;
	} // end of go
	
	private static boolean checkSudoku(Node curr, int key, int[][] map) {
		// 1. ���� ���� Ȯ��
		for(int i=0; i<9; i++) {
			if(map[i][curr.col]==key || map[curr.row][i]==key) return false;
		}
		
		// 2. �׸� Ȯ��
		int row = 3*(curr.row/3);
		int col = 3*(curr.col/3);
		for(int i=row; i<row+3; i++) {
			for(int j=col; j<col+3; j++) {
				if(map[i][j]==key) return false;
			}
		}
		
		// 3. ����
		return true;
	} // end of check
	
	private static void printMap(int[][] map) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	} // end of print
	
	
} // end of class 






















