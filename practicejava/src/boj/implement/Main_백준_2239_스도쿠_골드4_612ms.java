package src.boj.implement;

import java.io.*;
import java.util.*;

public class Main_백준_2239_스도쿠_골드4_612ms {
	
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
		 * 백트래킹 사용
		 * 1~9 중 한 수를 넣을 때
		 * 가로, 세로, 네모를 확인하여 가능한 값인지 확인
		 * 0을 위에서부터 차례대로 넣으면 
		 * 처음으로 나온 값이 정답
		 * 
		 * 스도쿠를 완성하면 return true 하면서 종료
		 * 
		 * ++ 모든 행의 1~9의 숫자 사용 여부를 확인하는 row[10][10]
		 * ++ 모든 열의 1~9의 숫자 사용 여부를 확인하는 col[10][10];
		 * ++ 네모안에 1~9의 숫자 사용 여부를 확인하는 square[10][10]을 만들고
		 * 처음에 값을 입력받을 때 각 자리에 오는 값을 true로 변경해준다.
		 * 이 방법을 사용하면 확인할 때 1~9를 다 보는게 아닌, 원하는 값만 넣고 확인할 수 있다.
		 * --> 시간은 300? 
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
			// 정답 출력
			printMap(map);
			return true;
		} // end of 기저조건
		// 1~9 시도
		for(int i=1; i<=9; i++) {
			// 1. 가로 세로 네모 확인
			if(checkSudoku(list.get(cnt), i, map)) {
				// 2. 배열 반영
				map[list.get(cnt).row][list.get(cnt).col] = i;
				// 3. 다음 칸 
				if(go(cnt+1, size, map)) return true;
				// 4. 배열 원복
				map[list.get(cnt).row][list.get(cnt).col] = 0;
			}
		} // end of for
		return false;
	} // end of go
	
	private static boolean checkSudoku(Node curr, int key, int[][] map) {
		// 1. 가로 세로 확인
		for(int i=0; i<9; i++) {
			if(map[i][curr.col]==key || map[curr.row][i]==key) return false;
		}
		
		// 2. 네모 확인
		int row = 3*(curr.row/3);
		int col = 3*(curr.col/3);
		for(int i=row; i<row+3; i++) {
			for(int j=col; j<col+3; j++) {
				if(map[i][j]==key) return false;
			}
		}
		
		// 3. 가능
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






















