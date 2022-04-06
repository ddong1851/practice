package src.swea;

import java.io.*;
import java.util.*;

public class Solution_SWEA_5643_키순서_2229ms {
	
	private static int N, M, cnt, p1, p2, temp, go, come;
	private static int INF = 999_999_999;
	private static int[][] map;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		/*
		 * IDEA
		 * 
		 * 그래프를 만들어서.... 
		 * 각 노드를 선택하여 
		 * 본인 위의 노드 수 + 본인 아래 노드 수 + 본인 = 전체 노드 수라면 자신의 등수를 아는 노드가 된다
		 * 
		 * --> 그래프를 이용하는 문제인데
		 * 특정 노드로 올 수 있는 지점의 수 + 특정 노드에서 갈 수 있는 지점의 수 = 전체 노드 - 1개 ==> 정답이 된다.
		 * 
		 * 플로이드 워샬을 이용하자
		 * table을 보고, 본인에게 올 수 있는 노드의 수 + 본인이 갈 수 있는 노드의 수 = N - 1이면 등수를 안다.
		 * 
		 * 다익스트라를 사용하면 모든 노드에 대해 각각 다 연산하면서 
		 * int[] vis = [0, 0, 0, 0, 0, 0] 
		 * 위 배열에서 i 좌표 방문 성공하면 vis[i]+1 하고, 
		 * 모든 탐색이 끝나고 vis[i]의 값이 N-1이면 성공으로 간주.
		 */
		
		int TC = Integer.parseInt(br.readLine());
		for (int test = 1; test <= TC; test++) {
			
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			cnt = 0;
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) Arrays.fill(map[i], INF);
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				p1 = Integer.parseInt(st.nextToken())-1;
				p2 = Integer.parseInt(st.nextToken())-1;
				// p1 < p2 
				map[p1][p2] = 1;
			}
			
			// 플로이드 워샬
			temp = 0;
			for(int k=0; k<N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(i==k || i==j) continue;
						temp = map[i][k] + map[k][j];
						if(map[i][j] > temp) map[i][j] = temp;
					}
				}
			}
			
			// 각 노드로 올 수 있는 수 + 각 노드가 갈 수 있는 수 카운팅
			for(int i=0; i<N; i++) {
				go = come = 0;
				// i번째 노드가 갈 수 있는 노드 수 카운팅
				for(int j=0; j<N; j++) {
					if(map[i][j]!=INF) go++;
					if(map[j][i]!=INF) come++;
				}
				if(go+come==N-1) cnt++;
			}
			
			sb.append("#").append(test).append(" ").append(cnt).append("\n");
			
		} // end of for TC

		System.out.println(sb.toString());
		
	} // end of main 
	
} // end of class 

//1
//6
//6
//1 5
//3 4
//5 4
//4 2
//4 6
//5 2







