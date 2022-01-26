package src.boj.bfs_dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


//class Node{
//	int row;
//	int col;
//	public Node(int row, int col) {
//		this.row = row;
//		this.col = col;
//	}
//	public int getRow() {
//		return row;
//	}
//	public int getCol() {
//		return col;
//	}
//}


/** Main_백준_2667_단지번호붙이기_실버1_248ms*/
public class Main_백준_2667_단지번호붙이기_실버1_248ms {
	public static int [][] graph;
	public static boolean[][] visited;
	public static int count = 0; // 단지의 수를 저장하기 위한 변수
	public static ArrayList<Integer> home = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		graph = new int[n][n];
		for(int i=0; i<n; i++) {
			String str = sc.next();
			char[] c = new char[n];
			c = str.toCharArray();
			for(int j=0; j<n; j++) {
				graph[i][j] = c[j]-'0';
			}
		}
		sc.close();
		visited = new boolean[n][n];
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				bfs(n, i, j);
			}
		}
		int[] results = new int[home.size()];
		int s = 0;
		for(int i:home) {
			results[s++] = i;
		}
		Arrays.sort(results);
		
		System.out.println(count);
		for(int i:results) {
			System.out.println(i);
		}
		
	}
	
	private static void bfs(int n, int y, int x) {
		Queue<Node> q = new LinkedList<>();
		// 해당 좌표가 0이면 메서드를 종료해라
		if(graph[y][x]==0 || visited[y][x]==true) {
			return;
		}
		// 좌표가 건물이 있는 곳이면
		q.add(new Node(y, x));
		visited[y][x] = true;
		int houses = 1;
		// 상하좌우 탐색
		int [][] dxy = {{-1, 0},{1, 0},{0, -1},{0, 1}};
		while(!q.isEmpty()) {
			// 방문하면서 0으로 만들고, 개수를 센다. 
			// + 모든 좌표 탐색도 해야할듯? 
			Node node = q.poll();
			int r = node.getRow();
			int c = node.getCol();
			// 4방 탐색
			for(int i=0; i<4; i++) {
				// 탐색할 좌표
				int nrow = r+dxy[i][0];
				int ncol = c+dxy[i][1];
				// 좌표가 그래프 범위를 벗어난다면
				if(nrow<0 || nrow>=n || ncol<0 || ncol>=n) {
					continue;
				}
				// 좌표가 건물이 아니면 넘기기 혹은 이미 방문했던 구역이라면
				if(graph[nrow][ncol]==0) {
					continue;
				}
				// 정상적으로 건물을 발견했다면,
				if(graph[nrow][ncol]==1 && visited[nrow][ncol]==false) {
					q.add(new Node(nrow, ncol));
					visited[nrow][ncol] = true;
					graph[nrow][ncol] = 0; // 방문처리하고 0으로 만들어버림
					houses++;
				}
				
			}
		}
		
		// 단지가 존재한다면, 단지 수를 증가시키고, 집 갯수를 StringBuffer에 추가한ㄷ .
		if(houses>0) {
			count++;
			home.add(houses);
		}
	}
}
