package src.boj.bfs_dfs;

import java.io.*;
import java.util.*;

public class Main_백준_17142_연구소3_골드4_256ms {
	
	private static class Node{
		int row, col;
		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	private static int N, max, safe, row, col, nr, nc;
	private static int[][] map;
	private static boolean[][] vis;
	private static ArrayList<Node> list = new ArrayList<>();
	private static Queue<Node> q = new LinkedList<Node>();
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		safe = 0;
		
		map = new int[N][N];
		vis = new boolean[N][N];
		int temp = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if(temp==2) {
					list.add(new Node(i, j));
				}
				// 안전 구역 카운팅
				else if(temp==0) safe++;
			}
		}
		// 안전 구역 개수 초기화 
		max = 10000;
		go(0, M, 0, list.size(), new ArrayList<Node>());
		
		System.out.println(max==10000?-1:max);
		
		
	} // end of main 

	private static void go(int cnt, int M, int start, int size, ArrayList<Node> virus) {
		if(cnt==M) {
			BFS(virus);
			return;
		}
		for(int i=start; i<size; i++) {
			virus.add(new Node(list.get(i).row, list.get(i).col));
			go(cnt+1, M, i+1, size, virus);
			virus.remove(virus.size()-1);
		}
	} // end of go 
	
	private static void BFS(ArrayList<Node> virus) {
		int changed = 0;
		for(Node vir:virus) {
			row = vir.row;
			col = vir.col;
			q.offer(new Node(row, col));
			vis[row][col] = true;
		}
		
		int size = 0;
		int time = 0;
		while(true) {
			if(changed==safe) {
				if(time<max) max = time;
				q.clear();
				break;
			}
			else if(q.isEmpty()) break;
			
			size = q.size();
			while(size-->0) {
				Node curr = q.poll();
				row = curr.row;
				col = curr.col;
				for(int i=0; i<4; i++) {
					nr = row + dr[i];
					nc = col + dc[i];
					// 범위를 벗어났거나 벽이거나 방문했다면
					if(nr<0 || nr>=N || nc<0 || nc>=N || map[nr][nc]==1 || vis[nr][nc]) continue;
					vis[nr][nc] = true;
					q.offer(new Node(nr, nc));
					if(map[nr][nc]==0)changed++;
				}
			} // end of while size 
			++time;
		} // end of while changed
		for(int i=0; i<N; i++) Arrays.fill(vis[i], false);
	} // end of BFS 
	
	
} // end of class 
















