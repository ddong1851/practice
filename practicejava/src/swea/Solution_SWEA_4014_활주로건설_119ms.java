package src.swea;

import java.io.*;
import java.util.*;
 
public class Solution_SWEA_4014_활주로건설_119ms {
     
    private static int N, X, count, height, uproad, downroad;
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
         * 내리막이 온 경우 down_road로 확인
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
        // 첫 높이 저장
        height = map[sr][sc];
        // 내리막 오르막 카운팅 
        downroad = uproad = 0;
        uproad++; // 오르막은 미리 쌓아둠
        for(int i=1; i<N; i++) {
            sr += dir[0];
            sc += dir[1];
            // 2층 이상 차이가 나는 경우
            if(Math.abs(height-map[sr][sc])>=2) return false;
            else {
                // 1. 같은 층
                if(height == map[sr][sc]) {
                    if(downroad>0) downroad--;   // 내리막 설치중이면 내리막 설치
                    else uproad++;                  // 평지면 오르막길 설치를 위한 카운팅 
                }
                // 2. 오르막
                else if(map[sr][sc]>height) {
                    if(uproad < X) return false; // 오르막 설치하기 부족한 경우
                    else {                                  // 오르막 설치
                        uproad = 1;
                        height = map[sr][sc];
                    }
                }
                // 3. 내리막
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












