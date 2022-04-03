package src.boj.djikstra;

import java.io.*;
import java.util.*;

/** Main_����_4485_����������ְ�������_���4_168ms*/
class Main_����_4485_����������ְ�������_���4_168ms{
    
    private static class Node implements Comparable<Node>{
        int row, col, val;
        public Node(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
        @Override
        public int compareTo(Node o){ // �������� ����
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
            // ���� ���� �������� �����ϸ� ����
            if(row==N && col==N) {
            	pq.clear();
            	// ���� �����
            	sb.append("Problem").append(" ").append(tc++).append(":").append(" ").
            		append(paid[N][N]).append("\n");
            	return;
            }
            for(int i=0; i<4; i++){
                nr = row + dr[i];
                nc = col + dc[i];
                // �� ���� ��ΰ� �ִٸ� ����
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
        // 0�� �ԷµǸ� �����Ѵ�.
        while((N = Integer.parseInt(br.readLine()))!=0){
        	// �ʱ�ȭ �۾�, �׵θ��� ��ġ�Ͽ� �迭 ���� Ž���� ���� �ʴ´� ( Try Catch�� ���� �ð��� ��� )
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
                // �Ұ����� ������ �ʱ�ȭ
                Arrays.fill(paid[i], 1000000);
            }
            // ���ͽ�Ʈ�� ����
            go();
        }
        // ���� ���
        System.out.println(sb.toString());
    } // end of main 
} // end of class 











