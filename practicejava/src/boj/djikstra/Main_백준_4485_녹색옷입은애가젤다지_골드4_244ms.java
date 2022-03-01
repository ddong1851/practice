package src.boj.djikstra;

import java.io.*;
import java.util.*;

/** Main_백준_4485_녹색옷입은애가젤다지_골드4_244ms*/
class Main_백준_4485_녹색옷입은애가젤다지_골드4_244ms{
    
    private static class Node implements Comparable<Node>{
        int row, col, val;
        public Node(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
        @Override
        public int compareTo(Node o){
            return this.val - o.val;
        }
    }
    
    private static int N;
    private static int[][] map;
    private static int[][] paid;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    
    private static int go(){
        paid[0][0] = map[0][0];
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(0, 0, paid[0][0]));
        
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            for(int i=0; i<4; i++){
                int nr = curr.row + dr[i];
                int nc = curr.col + dc[i];
                if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
                // 더 효율적인 경로가 있다면 갱신
                if(paid[nr][nc] > paid[curr.row][curr.col]+map[nr][nc]){
                    paid[nr][nc] = paid[curr.row][curr.col]+map[nr][nc];
                    pq.offer(new Node(nr, nc, paid[nr][nc]));
                }                
            }
        }
        return paid[N-1][N-1];
    }
    
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        
        int tc = 1;
        // 0이 입력되면 종료한다.
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N==0) break;
            map = new int[N][N];
            paid = new int[N][N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
                // 불가능한 값으로 초기화
                Arrays.fill(paid[i], 1000000);
            }
            
            // 정답 만들기
            sb.append("Problem").append(" ").append(tc++).append(":").append(" ").
                append(go()).append("\n");
        }
        // 정답 출력
        System.out.println(sb.toString());
    }
}