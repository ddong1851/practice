package src.boj.implement;

import java.io.*;
import java.util.*;

public class Main_백준_14890_경사로_골드3_96ms {
	
	private static int N, X;
    private static int[][] map;
 
    public static void main(String[] args) throws Exception{
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
             
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)	map[i][j] = Integer.parseInt(st.nextToken());
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			if (go(0, i, new int[] { 1, 0 })) count++;
			if (go(i, 0, new int[] { 0, 1 })) count++;
		}
        
		System.out.println(count);
         
    } // end of main 
     
    private static boolean go(int sr, int sc, int[] dir) {
        int height = map[sr][sc];
        int uproad;
		int downroad = uproad = 0;
        uproad++; // 오르막은 미리 쌓아둠
        for(int i=1; i<N; i++) {
            sr += dir[0];
            sc += dir[1];
            if(Math.abs(height-map[sr][sc])>=2) return false;
            else {
                if(height == map[sr][sc]) {
                    if(downroad>0) downroad--;   // 내리막 설치중이면 내리막 설치
                    else uproad++;               // 평지면 오르막길 설치를 위한 카운팅 
                }
                else if(map[sr][sc]>height) {
                    if(uproad < X) return false; // 오르막 설치하기 부족한 경우
                    else {                       // 오르막 설치
                        uproad = 1;				 
                        height = map[sr][sc];
                    }
                }
                else {
                    if(downroad>0) return false; // 내리막 설치중이였다면
                    else {                       // 내리막 설치
                        height = map[sr][sc];
                        downroad = X-1;
                        uproad = 0;				 // 내리막이 시작되었으니 0으로 
                    }
                }
            } // end of else 
        } // end of for
        if(downroad>0) return false;             // 아직 내리막 설치중인데 끝났다면
        return true;
    } // end of go
} // end of class 












