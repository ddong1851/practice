package src.boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/** 스도쿠 문제*/
public class Main_백준_2580_스도쿠_골드4_536ms {
	
	private static int[][] map;
	private static ArrayList<int[]> list;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 0의 위치를 저장하는 리스트
		list = new ArrayList<int[]>();
		// 판 초기화
		map = new int[9][9];
		
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<9; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				
				if(num==0) {
					list.add(new int[] {i, j});
				}
				
			} // end of for col 
		} // end of for row 
		
		solveSudoku(0);
		
	} // end of main
	
	private static void solveSudoku(int cnt) {
		// 모든 0을 채운 경우
		if(cnt>=list.size()) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
			System.exit(0);
		}
		for(int i=0; i<9; i++) {
			int[] point = list.get(cnt);
			int key = i+1;
			if(!checkAvailable(point[0], point[1], key)) continue;
			map[point[0]][point[1]] = key;
			solveSudoku(cnt+1);
			map[point[0]][point[1]] = 0;
		}
		return;
	}

	// 가로, 세로, 네모를 보고 가능한 숫자인지 판단
	private static boolean checkAvailable(int row, int col, int key){
		// 가로 세로 확인
		for(int i=0; i<9; i++) {
			if(map[i][col]==key || map[row][i]==key) {
				return false;
			}
		}
		// 네모 확인 
		// 1-3 4-6 7-9 // 바운더리
		if(row%3==0) {
			for (int i = row; i < row + 3; i++) {
				if (col % 3 == 0) {
					for (int j = col; j < col + 3; j++) {
						if (map[i][j] == key)
							return false;
					}
				} else if (col % 3 == 1) {
					for (int j = col - 1; j < col + 2; j++) {
						if (map[i][j] == key)
							return false;
					}
				} else {
					for (int j = col - 2; j < col + 1; j++) {
						if (map[i][j] == key)
							return false;
					}
				}
			}
		}
		else if(row%3==1) {
			for(int i=row-1; i<row+2; i++) {
				if(col%3==0) {
					for(int j=col; j<col+3; j++) {
						if(map[i][j]==key) return false;
					}
				}
				else if(col%3==1) {
					for(int j=col-1; j<col+2; j++) {
						if(map[i][j]==key) return false;
					}
				}
				else {
					for(int j=col-2; j<col+1; j++) {
						if(map[i][j]==key) return false;
					}
				}
			}
		}
		else {
			for(int i=row-2; i<row+1; i++) {
				if(col%3==0) {
					for(int j=col; j<col+3; j++) {
						if(map[i][j]==key) return false;
					}
				}
				else if(col%3==1) {
					for(int j=col-1; j<col+2; j++) {
						if(map[i][j]==key) return false;
					}
				}
				else {
					for(int j=col-2; j<col+1; j++) {
						if(map[i][j]==key) return false;
					}
				}
			}
		}
		return true;
	}
	
} // end of class
