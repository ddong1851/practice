package src.boj.djikstra;

import java.io.*;
import java.util.*;

/** Main_백준_4485_녹색옷입은애가젤다지_골드4_168ms*/
class Main_백준_4485_녹색옷입은애가젤다지_골드4_168ms{
    
    private static class Node implements Comparable<Node>{
        int row, col, val;
        public Node(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
        @Override
        public int compareTo(Node o){ // 오름차순 정렬
            return this.val - o.val;
        }
    }
    
    private static int N, row, col, nr, nc, tc;
    private static final int initVal = 999_999_999;
    private static int[][] map;
    private static int[][] paid;
    private static int[] dr = {1, 0, -1, 0};
    private static int[] dc = {0, 1, 0, -1};
    private static PriorityQueue<Node> pq = new PriorityQueue<Node>();
    private static StringBuilder sb = new StringBuilder();
    
    private static void go(){
        paid[1][1] = map[1][1];
        pq.offer(new Node(1, 1, paid[1][1]));
        
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            row = curr.row;
            col = curr.col;
            // 가장 먼저 목적지에 도달하면 종료
            if(row==N && col==N) {
            	pq.clear();
            	// 정답 만들기
            	sb.append("Problem").append(" ").append(tc++).append(":").append(" ").
            		append(paid[N][N]).append("\n");
            	return;
            }
            for(int i=0; i<4; i++){
                nr = row + dr[i];
                nc = col + dc[i];
                // 더 나은 경로가 있다면 갱신
                if(paid[nr][nc] > paid[row][col]+map[nr][nc]){
                    paid[nr][nc] = paid[row][col]+map[nr][nc];
                    pq.offer(new Node(nr, nc, paid[nr][nc]));
                } 
            } // end of for 4 direction
        } // end of while q.isEmpy
    } // end of go
    
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        tc = 1;
        // 0이 입력되면 종료한다.
        while((N = Integer.parseInt(br.readLine()))!=0){
        	// 초기화 작업, 테두리를 설치하여 배열 범위 탐색을 하지 않는다 ( Try Catch만 쓰면 시간이 어떨라나 )
            map = new int[N+2][N+2];
            paid = new int[N+2][N+2];
            Arrays.fill(map[0], initVal);
            Arrays.fill(map[N+1], initVal);
            for(int i=1; i<=N; i++){
            	map[i][0] = map[i][N+1] = initVal;
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
                // 불가능한 값으로 초기화
                Arrays.fill(paid[i], 1000000);
            }
            // 다익스트라 시작
            go();
        }
        // 정답 출력
        System.out.println(sb.toString());
    } // end of main 
} // end of class 











