package src.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

/** 1941 소문난 칠공주 */
public class Main {
	
	private static class Node{
		int row, col;
		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	private static char[][] map;
	private static int total;
	private static ArrayList<HashSet<Node>> list;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		 * 5x5 데이터가 들어온다.
		 * 소문난 칠공주를 구성하라
		 * 조건
		 * 1) 7명의 여학생으로 구성하라
		 * 2) 7명이 서로 가로나 세로로 인접해 있어야 한다.
		 * 3) 이다솜파가 4명 이상인 그룹만 형성할 수 있다.
		 * 
		 * -> 이다솜파가 4명 이상인가를 확인해야 하고,
		 * -> 같은 경로를 타도 안되고,
		 * -> 7명을 선택해야 한다 
		 * => 백트래킹 예제 
		 * 
		 * 1. 이동한 좌표가 Y인지 S인지 확인하여 이다솜파의 수를 counting 
		 * 2. 7명을 선택하면 return 
		 * 2.1 이때 이다솜파가 4명 이상이라면, 거쳐왔던 좌표들을 list에 추가
		 * 2.2 완전 같은 경로로 왔다면 추가 x 
		 * map외 모든 것을 매개변수로 들고 다니자
		 */
		
		map = new char[5][];
		for(int i=0; i<5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		// 경로 저장용 리스트
		list = new ArrayList<HashSet<Node>>();
		total = 0;
		go(0, 0, 0, 1, new boolean[5][5]);

		System.out.println(total);
		
	} // end of main

	// go ( row, col, Scount, picked, visited ) 
	private static void go(int row, int col, int S, int picked, boolean[][] vis) {
		
		// 방문 처리
		vis[row][col] = true;
		
		// 7명을 뽑았을 때
		if(picked==7) {
			// 이다솜파의 수 확인, 그리고 이미 해당 경로가 있는지 확인
			if(S>=4 && !sameRoute(vis)) {
				total++;
			}
			return;
		}
		// 중간에 반납이 안된 좌표들이 있다.. 해결하자
		
		// 해당 좌표가 이다솜파라면
		if(map[row][col]=='S') S++;
		// 시계방향 탐색
		int nr = row-1; int nc = col;
		if(!(nr<0 || nr>=5 || nc<0 || nc>=5) && !vis[nr][nc]) go(nr, nc, S, picked+1, vis);
		nr = row; nc = col+1;
		if(!(nr<0 || nr>=5 || nc<0 || nc>=5) && !vis[nr][nc]) go(nr, nc, S, picked+1, vis);
		nr = row+1; nc = col;
		if(!(nr<0 || nr>=5 || nc<0 || nc>=5) && !vis[nr][nc]) go(nr, nc, S, picked+1, vis);
		nr = row; nc = col-1;
		if(!(nr<0 || nr>=5 || nc<0 || nc>=5) && !vis[nr][nc]) go(nr, nc, S, picked+1, vis);
		// 반납
		vis[row][col] = false;
	}

	private static boolean sameRoute(boolean[][] vis) {
		// 방문 세트 만들기
		HashSet<Node> temp = new HashSet<>();
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(vis[i][j]) temp.add(new Node(i, j));
			}
		}
		// 모든 리스트에 대하여 검색
		for(HashSet<Node> set:list) {
			if(set.containsAll(temp)) return true;
		}
		// 새로운 경로라면 경로 추가 후 true
		list.add(temp);
		return false;
	}
	
} // end of class 
