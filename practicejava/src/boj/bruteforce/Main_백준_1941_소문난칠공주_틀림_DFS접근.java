package src.boj.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/** 1941 소문난 칠공주  */
public class Main_백준_1941_소문난칠공주_틀림_DFS접근 {
	
	private static class Node{
		int row, col;
		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
		public boolean equal(Node other) {
			if(this.row==other.row && this.col==other.col) return true;
			return false;
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
		 * 
		 * + DFS로 T자 검출이 안된다.
		 * 결론. 
		 * 매대변수를 들고 다녀야해서 DFS로 접근했는데, 탐색 문제는 결국 BFS로 접근해야 할거 같다.
		 * BFS를 고려해야 할거 같다.
		 */
		
		map = new char[5][];
		for(int i=0; i<5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		// 경로 저장용 리스트
		list = new ArrayList<HashSet<Node>>();
		total = 0;
		// 완전 탐색
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				int S = 0;
				boolean [][] vis = new boolean[5][5];
				vis[i][j] = true;
				if(map[i][j]=='S') S=1;
				go(i, j, S, 1, vis);
			}
		}

		System.out.println(total);
		
	} // end of main

	// go ( row, col, Scount, picked, visited ) 
	private static void go(int row, int col, int S, int picked, boolean[][] vis) {
		// 임도연파가 이미 4명 이상이라면 (3명까지만 가능하다)
		if(picked-S>=4) return;
		// 7명을 뽑았을 때
		if(picked==7) {
			// 이다솜파의 수 확인, 그리고 이미 해당 경로가 있는지 확인
			if(S>=4 && !sameRoute(vis)) {
				total++;
			}
			return;
		}
		// 시계방향 탐색
		int nr = row-1; int nc = col;
		if(!(nr<0 || nr>=5 || nc<0 || nc>=5) && !vis[nr][nc]) { 
			vis[nr][nc] = true;
			if(map[nr][nc]=='S') go(nr, nc, S+1, picked+1, vis);
			else go(nr, nc, S, picked+1, vis);
			vis[nr][nc] = false;
		}
		nr = row; nc = col+1;
		if(!(nr<0 || nr>=5 || nc<0 || nc>=5) && !vis[nr][nc]) {
			vis[nr][nc] = true;
			if(map[nr][nc]=='S') go(nr, nc, S+1, picked+1, vis);
			else go(nr, nc, S, picked+1, vis);
			vis[nr][nc] = false;
		}
		nr = row+1; nc = col;
		if(!(nr<0 || nr>=5 || nc<0 || nc>=5) && !vis[nr][nc]) {
			vis[nr][nc] = true;
			if(map[nr][nc]=='S') go(nr, nc, S+1, picked+1, vis);
			else go(nr, nc, S, picked+1, vis);
			vis[nr][nc] = false;
		}
		nr = row; nc = col-1;
		if(!(nr<0 || nr>=5 || nc<0 || nc>=5) && !vis[nr][nc]) {
			vis[nr][nc] = true;
			if(map[nr][nc]=='S') go(nr, nc, S+1, picked+1, vis);
			else go(nr, nc, S, picked+1, vis);
			vis[nr][nc] = false;
		}
	}
	
	// 증복 제거가 잘 안되고 있다.
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
		// 아래 예시에서 set은 Node라는 데이터타입을 갖고 있는데, 여기서는 아래 메서드로 잡을 수 없다
			// if(set.containsAll(temp) return true;
			if(sameSet(set, temp)) return true; 
		}
		// 새로운 경로라면 경로 추가 후 false
		list.add(temp);
		return false;
	}
	
	private static boolean sameSet(HashSet<Node> set1, HashSet<Node> set2) {
		boolean flag = false;
		for(Node node1:set1) {
			flag = false;
			for(Node node2:set2) {
				// 한번이라도 같은게 나온다면 true 
				if(node1.equal(node2)) flag = true;
			}
			if(!flag) return false;
		}
		return true;
	}
} // end of class 

/*
SSSSS
SSSSS
SSSSS
SSSSS
SSSSS
-> 3546
*/
