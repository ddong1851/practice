package src.boj;

import java.io.*;
import java.util.*;

/** Main_백준_2146_다리만들기_골드3_172ms*/
public class Main_백준_2146_다리만들기_골드3_172ms {
    
    private static class Node{
        int row, col;
        public Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
    /** 지도의 크기 N, 출력할 최소값 min*/
    private static int N, min;
    /** 좌표 저장용 배열*/
    private static int[][] map, distance;
    /** 상하좌우 row*/
    private static int[] dr = {-1, 1, 0, 0};
    /** 상하좌우 col*/
    private static int[] dc = {0, 0, -1, 1};
    
    // method for BFS
    private static int go(int sr, int sc, int islandNum){        
        // Queue for BFS
    	distance[sr][sc] = 0; // 시작지점 초기화
        Queue<Node> island = new LinkedList<Node>();
        island.offer(new Node(sr, sc));
        
        // queue for finding other island
        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(sr, sc));
        
        
        // 1. 구역 구분하기
        while(!island.isEmpty()) {
        	Node curr = island.poll();
            int row = curr.row;
            int col = curr.col;
            // start 4 direction
            for(int i=0; i<4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];
                if(map[nr][nc]==1 && distance[nr][nc]!=0) {
                	map[nr][nc] = islandNum;
                	distance[nr][nc] = 0;
                	island.offer(new Node(nr, nc));
                	q.offer(new Node(nr, nc));
                }
            } // end of for 4 dir 
        } // end of localize
        
        // 2. 구역에서 다른 구역까지 거리 구하기
        // start BFS
        while(!q.isEmpty()){
            Node curr = q.poll();
            int row = curr.row;
            int col = curr.col;
            // start 4 direction
             for(int i=0; i<4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];
                // 배열 밖 or 같은 구역이라면( 같은 구역은 이미 큐에 있음 ) + 최단거리 이상의 범위를 둘러보지 않기
                if(map[nr][nc]==-1 || map[nr][nc]==islandNum || (distance[nr][nc]!=1000000 && distance[nr][nc]>min)) continue;
                // 현재 최단거리보다 더 가까운 거리에 섬을 발견했다면
                if(map[nr][nc]!=0) {
                	return distance[row][col];
                }
                else if(distance[nr][nc]>distance[row][col]+1) {
                	// 바다라면
                	distance[nr][nc] = distance[row][col]+1;
                	q.offer(new Node(nr, nc));
                }
            } // end of for 4 dir 
        } // end of while
        return min;
    } // end of go()
    
    
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // start init
        N = Integer.parseInt(br.readLine());
        min = 9999999;
        // 테두리를 설치한다
        map = new int[N+2][N+2];
        distance = new int[N+2][N+2];
        for(int i=0; i<=N+1; i++) Arrays.fill(distance[i], 1000000);
        
        Arrays.fill(map[0], -1);
        Arrays.fill(map[N+1], -1);
        
        StringTokenizer st = null;
        for(int i=1; i<=N; i++){
            map[i][0] = map[i][N+1] = -1;
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } 
        // end of Initialize
        
        // start find island
        int island = 1;
        for(int i=1; i<=N+1; i++){
            for(int j=1; j<=N+1; j++){
                if(map[i][j]==1) {
                    // start BFS 
                	map[i][j] = ++island;
                    min = Math.min(min, go(i, j, island));
                }
            }
        }
        // end of find island
        
        // print answer
        System.out.println(min); 
        return;
        
	} // end of main
} // end of class 