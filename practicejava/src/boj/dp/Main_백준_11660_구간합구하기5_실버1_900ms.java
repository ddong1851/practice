package src.boj.dp;

import java.io.*;
import java.util.*;

/** Main_백준_11660_구간합구하기5_실버1_900ms*/
public class Main_백준_11660_구간합구하기5_실버1_900ms {
	private static int[][] map;
	
	private static int go(int sr, int sc, int dr, int dc) {
		/*
		 * -----
		 * | A	|
		 * |____|
		 * | B|C|
		 * -----
		 * C를 구하기 위해 큰 전체 합에서 -(A+B-중복)
		 */
		return map[dr][dc] - map[dr][sc-1] - map[sr-1][dc] + map[sr-1][sc-1];
	}

	public static void main(String[] args) throws Exception{
		
		/*
		 * 배열을 입력 받을 때 
		 * 행마다의 구간합으로 미리 저장 (위 +왼 + 본인)
		 * 필요할 때 합을 꺼내 쓴다.
		 * 
		 * 중복된 영역 중 가장 깊은 곳을 한번 빼준다. 
		 * 
		 * 누적합 만드는 방식
		 * 위 + 왼 - 중복 대각선 + 본인
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        map = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                // 위 왼쪽 해당 값 - 대각선을 모두 더한 누적합을 해당 좌표로 지정
            	map[i][j] = map[i-1][j] + map[i][j-1] - map[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            sb.append(go(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 
            		Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
        }
        
        System.out.println(sb.toString());
		
	}
}