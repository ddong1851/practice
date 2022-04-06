package src.boj.floyd;

import java.io.*;
import java.util.*;

/** Main_백준_9205_맥주마시면서걸어가기_실버1_*/
public class Main {
	
	private static int N;
	private static final int INF = 999_999_999;
	private static int[][] map;
	private static ArrayList<int[]> list;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc<TC; tc++) {
			
			N = Integer.parseInt(br.readLine());
			// 방문 가능 여부 map 
			map = new int[N+2][N+2];
			list = new ArrayList<>();
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				// x, y 좌표 입력
				list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
			
			// 첫번째 map 초기화
			initMap();
			
			
		}
		
		System.out.println(sb.toString());
		
	} // end of main 

	private static void initMap() {
		for(int i=0; i<N; i++) {
			Arrays.fill(map[i], INF);
		}
		
		
		
	} // end of initMap
	
	
	
} // end of class 















