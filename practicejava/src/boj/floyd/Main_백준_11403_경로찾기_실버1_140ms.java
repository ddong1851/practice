package src.boj.floyd;

import java.io.*;
import java.util.*;

public class Main_백준_11403_경로찾기_실버1_140ms {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		final int INF = 999_999;
		
		int[][] map = new int[N][N];
		
		StringTokenizer st = null;
		int temp = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if(temp==0) map[i][j] = INF;
			}
		}
		
		for(int via=0; via<N; via++) {
			for(int from=0; from<N; from++) {
				for(int to=0; to<N; to++) {
					if(from==via) continue;
					temp = map[from][via]+map[via][to];
					if(map[from][to] > temp) map[from][to] = 1;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(map[i][j]==INF?0:map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	} // end of main 
} // end of class 
