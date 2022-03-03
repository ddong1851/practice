package src.boj.bfs_dfs;

import java.util.*;
import java.io.*;

/** Main_����_1600_���̵ǰ��¿�����_���4_676ms*/
class Main_����_1600_���̵ǰ��¿�����_���4_676ms{
    
    private static class Node{
        int row, col, jumped;
        public Node(int row, int col, int jumped){
            this.row = row;
            this.col = col;
            this.jumped = jumped;
        }
    }
    
    private static int K, W, H;
    private static int[][] map;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int[] kr = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static int[] kc = {1, 2, 2, 1, -1, -2, -2, -1};
    
    
    private static void go(){
        
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 0));
        // �Ÿ��� ������ �迭 ( �湮 ó�� ) 
        int[][][] distance = new int[H][W][K+1];
        for(int i=0; i<K; i++) distance[0][0][i]=1;
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            int row = curr.row;
            int col = curr.col;
            int jumped = curr.jumped;
            // ���⼭ ó�� ���ϸ� �Ʒ� 2���� �ݺ������� Ȯ���� �ؾ��ϴµ�, �ߺ��� �߻��ؼ� �Ű���ϴ�.
            if(row==H-1 && col==W-1){
                // 1���� ���������ϱ� 1�� ����.
                System.out.println(distance[row][col][jumped]-1);
                return;
            }
            // ���� ��ǥ ���� Ž��
            for(int i=0; i<4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];
                // �迭�� ������ ����ų�, �̹� �湮�� ��ǥ�̰ų�, ��ֹ��� �ִ� ��ǥ���
                if(nr<0 || nr>=H || nc<0 || nc>=W || distance[nr][nc][jumped]!=0 || map[nr][nc]==1) continue;
                // �̵��� �� �ִ� ��ǥ���
                distance[nr][nc][jumped] = distance[row][col][jumped]+1;
                q.offer(new Node(nr,nc,jumped));
            } // end of move 4 dir
            // ���� Ƚ���� ���Ҵٸ�
            if(curr.jumped<K){
                // ����Ʈó�� �̵�
                for(int i=0; i<8; i++){
                    int nr = row + kr[i];
                    int nc = col + kc[i];
                    // �迭�� ������ ����ų�, �̹� �湮�� ��ǥ�̰ų�, ��ֹ��� �ִ� ��ǥ���
                    if(nr<0 || nr>=H || nc<0 || nc>=W || distance[nr][nc][jumped+1]!=0 || map[nr][nc]==1) continue;
                    // ������ ��ǥ�� ���� �����ϱ� ���� �� + 1
                    distance[nr][nc][jumped+1] = distance[row][col][jumped]+1;
                    // ������ ���·� �Ѱ���
                    q.offer(new Node(nr,nc,jumped+1));
                } // end of for knight move
            } // end of if can jump
        } // end of while q.isEmpty
        // ���������� �� �� ���ٸ�
        System.out.println(-1);
        
    } // end of go()
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        /*
		 * BFS ���� �����̴� ��ֹ��� ���� �� ���� ��ֹ��� ���� 0, 0 -> W-1, H-1 �� �����Ѵ�. 
		 * �����̰� ����Ʈó�� K�� ������ �� ���� ��, �ּ� �� ���� �̵����� ��ǥ �������� �� �� �ִ°�?
		 * class Node{row col jumped}�� ����� �����͸� �����ϰ� ���� Ƚ���� �����ִ� ��� ��ó�� �̵��� �� �ְ� �غ���
		 * 
		 * + �����ϴٺ���, �湮ó���� ���� Ƚ������ �ؾ����� �������ϴ�..
		 */
        
        // Initialize
        map = new int[H][W];
        for(int i=0; i<H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // BFS
        go();
    }
}