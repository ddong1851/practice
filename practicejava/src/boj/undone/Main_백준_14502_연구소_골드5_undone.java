package src.boj.undone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

/** Main_백준_14502_연구소_골드5_undone*/
public class Main_백준_14502_연구소_골드5_undone {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] graph = new int[R][C];
		boolean[][] visited = new boolean[R][C];
		
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				int temp = Integer.parseInt(st.nextToken());
				graph[i][j] = temp;
				
			}
		}
		
	}
}

class Node{
	int row;
	int col;
	public Node(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
}