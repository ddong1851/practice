package src.swea;

import java.io.*;
import java.util.*;

public class Solution_SWEA_4014_활주로건설_147ms {
	
	private static int N, X, count, height, uproad;
	private static int[][] map;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		/*
		 * IDEA
		 * 
		 * 백준의 경사로 문제와 유사
		 * 다만, 한쪽으로만 갈 수 있는게 아니고 양 쪽으로 경사로를 설치할 수 있음.
		 * + 배열 범위 밖으로 나갔을 때 경사로 설치가 끝나지 않으면 안됨
		 * 
		 * row 나 col이 0 인 모든 좌표에서 수행해보자
		 * 오르막인 경우가 올 수 있으니까 오르막은 계속 카운팅하고
		 */

		int TC = Integer.parseInt(br.readLine());
		for (int test = 1; test <= TC; test++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			count = 0;
			for(int i=0; i<N; i++) {
				if(go(0, i, new int[] {1, 0})) count++;
				if(go(i, 0, new int[] {0, 1})) count++;
			}
		
			sb.append("#").append(test).append(" ").append(count).append("\n");
		} // end of for TC
		System.out.println(sb.toString());
		
		
	} // end of main 
	
	private static boolean go(int sr, int sc, int[] dir) {
		height = map[sr][sc];
		uproad = 1;
		for(int i=1; i<N; i++) {
			sr += dir[0];
			sc += dir[1];
			// 2층 이상 차이가 나면
			if(Math.abs(height-map[sr][sc])>=2) return false;
			else if(height==map[sr][sc]) uproad++; // 오르막 카운팅 
			else {
				// 오르막 설치라면
				if(map[sr][sc]-height>0) {
					if(uproad<X) return false;
					else {
						uproad = 1;
						height = map[sr][sc];
					}
				} 
				// 내리막 설치라면
				else {
					// 내리막을 설치하면 배열 범위를 벗어나는지
					if(i+X>N) return false;
					else {
						// X-1번 설치 가능한지 확인
						for(int j=1; j<X; j++) {
							sr += dir[0];
							sc += dir[1];
							i++;
							// 내리막 설치 높이 기준 평지가 X 개 나와야함
							if(height - map[sr][sc] != 1) {
								return false;
							}
						} // end of for
						height = map[sr][sc];
						uproad = 0;
					} // end of else 
				} // end of else 
			} // end of else down
		} // end of for 
		return true;
	} // end of go
	
} // end of class 




//1
//9 4
//4 4 3 3 3 3 2 2 2 
//4 4 3 3 1 1 2 2 3 
//3 3 2 2 1 1 1 1 2 
//1 1 1 1 1 1 1 1 1 
//1 1 1 1 1 1 1 1 1 
//2 2 1 1 1 1 1 1 1 
//2 2 1 1 1 1 1 1 1 
//2 2 2 2 2 2 1 1 1 
//3 3 3 3 2 2 2 2 1 

//1
//6 2
//3 3 3 2 1 1
//3 3 3 2 2 1
//3 3 3 3 3 2
//2 2 3 2 2 2
//2 2 3 2 2 2
//2 2 2 2 2 2







