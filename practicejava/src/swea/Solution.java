package src.swea;

import java.io.*;
import java.util.*;

public class Solution {
	
	private static class Shark{
		int row, col, hp;
		public Shark(int row, int col, int hp) {
			super();
			this.row = row;
			this.col = col;
			this.hp = hp;
		}
	}
	
	private static int N, M, K, row, col, d, p;
	private static int[][] map;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st  = null;
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N+2][N+2];
			Arrays.fill(map[0], 999999);
			Arrays.fill(map[N+1], 999999);
			for(int i=1; i<=N; i++) {
				map[i][0] = map[i][N+1] = 999999;
			}
			
			st = new StringTokenizer(br.readLine());
			Shark baby = new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), K);
			
			st = new StringTokenizer(br.readLine());
			Shark target = new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				row = Integer.parseInt(st.nextToken());
				col = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken());
				p = Integer.parseInt(st.nextToken());
				paint();
			} // end of initialize map 
			
//			for(int[] mps: map) {
//				System.out.println(Arrays.toString(mps));
//			}
			
			sb.append("#").append(tc).append(" ").append(go()).append("\n");
		} // end of for 
		System.out.println(sb.toString());
	} // end of main 

	private static int go() {
		int ans = -1;
		
		
		
		
		return ans;
	} // end of go 

	private static void paint() {
		for (int rep = d; rep >= 0; rep--) {
			if(rep==0) {
				paintMap(d-rep, col);
			} else {
				paintMap(d-rep, col+rep);
				paintMap(d-rep, col-rep);
			}
		}
	} // end of paint 

	private static void paintMap(int size, int sc) {
		if(sc<1 || sc>N) return;
		int sr = row-size;
		int er = row+size;
		for(int i=sr; i<=er; i++) {
			if(i<1 || i>N) continue;
			map[i][sc]+=p;
		} 
	} // end of paintMap 

	
} // end of class 

//1
//5 1 1
//4 4
//4 5
//5 5 1 1








