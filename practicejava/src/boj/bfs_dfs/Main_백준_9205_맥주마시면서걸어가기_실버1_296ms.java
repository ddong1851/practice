package src.boj.bfs_dfs;

import java.io.*;
import java.util.*;

/** Main_백준_9205_맥주마시면서걸어가기_실버1_296ms*/
public class Main_백준_9205_맥주마시면서걸어가기_실버1_296ms {
	
	private static int N, dis;
	private static ArrayList<int[]> points = new ArrayList<>();
	private static boolean[][] floyd;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		/*
		 * 플로이드로 해보자.
		 * 먼저 각 점에서 다른 점으로 갈 수 있는 경우를 거리를 통해 저장하고,
		 * 서로 연결된 지점으로 갈 수 있는 부분은 플로이드로 하자.
		 */
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc=0; tc<TC; tc++) {
			
			N = Integer.parseInt(br.readLine());
			// 집 편의점들 페스티벌 위치 입력받기
			for(int i=0; i<N+2; i++) {
				st = new StringTokenizer(br.readLine());
				points.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
			
			floyd = new boolean[N+2][N+2];
			
			// 1. 각 점 연결
			for(int i=0; i<N+2; i++) {
				for(int j=0; j<N+2; j++) {
					if(i==j) continue;
					dis = distance(points.get(i), points.get(j));
					if(dis<=1000) floyd[i][j] = true;
				}
			}
			
			// 2. 플로이드
			for(int k=0; k<N+2; k++) {
				for(int i=0; i<N+2; i++) {
					for(int j=0; j<N+2; j++) {
						if(i==k) continue;
						if(floyd[i][k] && floyd[k][j]) floyd[i][j] = true;
					}
				}
			}
			
			// 집에서 페스티벌장으로 갈 수 있는가?
			sb.append(floyd[0][N+1]?"happy":"sad").append("\n");
			// 재사용을 위한 비워주기
			points.clear();
		} // end of for 
		
		System.out.println(sb.toString());
		
	} // end of main 
	
	private static int distance(int[] p1, int[] p2) {
		return Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]);
	} // end of distance
	
} // end of class 






