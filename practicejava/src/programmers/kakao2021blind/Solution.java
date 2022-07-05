package src.programmers.kakao2021blind;
import java.util.*;

public class Solution {

    private class Node{
        int row, col, moves;
        public Node(int row, int col, int moves) {
            this.row = row;
            this.col = col;
            this.moves = moves;
        }
    }

    public int[][] globalBoard;
    public int[] cardNums;
    public int[] dr = {-1, 1, 0, 0};
    public int[] dc = {0, 0, -1, 1};
    public int startRow, startCol, countPair, minMoves;

    public int solution(int[][] board, int r, int c) {

        /*
        BFS, DFS ��� ������ �� ����.
        Enter �� Ŭ���ؼ� ī�带 �����µ�, �ʿ���� ¦�� ���߸� �ȵǴϱ�
        ī�带 �̴� ������ ���� �����ϰ�
        �ش� ī�忡 �������� ���� Enter �� Ŭ���ؼ� �����´�.

        �湮 ó���� � ī�带 �߰��ϸ� �ʱ�ȭ �ؾ��Ѵ�.

        --> ����? �� ���� ī�带 �̴� ������ �����ϰ�,
        BFS �� ������ ������ �ּ� ���� ī�����ϰ�,
        �ּ� ���� �ѱ� ��� break ����. (4x4�ϱ� ���� ���� �ʾƵ� �ɵ�)

         */

        // board, ������, min ���� ���� �ʱ�ȭ
        globalBoard = board;
        startRow = r;
        startCol = c;
        minMoves = 100_000_000;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        // 1. ī�� ¦�� �� ������ ī����
        countPair = 0;
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(board[i][j]!=0 && !pq.contains((Integer)board[i][j])){
                	pq.offer(board[i][j]);
                }
            }
        }

        countPair = pq.size();
        cardNums = new int[countPair];
        
        for(int i=0; i<countPair; i++) cardNums[i] = pq.poll();
        
        // 2. ī�� �̴� ���� ���ϱ�
        makePairOrder(0, new int[countPair], new boolean[countPair]);


        return minMoves;
    } // end of solution

    private void makePairOrder(int picked, int[] order, boolean[] using) {

        if(picked== countPair){
            // 3. �ش� �������� ����� Ű ������ �ҿ�Ǿ����� ī����
            int moveCount = countMovesInOrder(startRow, startCol, order);
            // 4. min �� ����
            if(minMoves >moveCount) minMoves = moveCount;
            return;
        } // end of if

        for(int i = 0; i< countPair; i++){
            if(using[i]) continue;
            using[i] = true;
            order[picked] = cardNums[i];
            makePairOrder(picked+1, order, using);
            using[i] = false;
        } // end of for

    } // end of makePairOrder

    private int countMovesInOrder(int sr, int sc, int[] order) {

        int moves = 0;
        int row, col, nrow, ncol;

        int[][] board = new int[4][4];
        for(int i=0; i<4; i++) board[i] = globalBoard[i].clone();

        boolean[][] visited = new boolean[4][4];
        Queue<Node> q = new LinkedList<>();

        for(int targetIndex=0; targetIndex<countPair; targetIndex++){
            // 2�� �ݺ� ( ¦�̴ϱ� )
            for(int repeat=0; repeat<2; repeat++){

                // ������ �������� ���
                visited[sr][sc] = true;
                q.offer(new Node(sr, sc, 0));

                while (!q.isEmpty()){

                    Node curr = q.poll();
                    row = curr.row;
                    col = curr.col;
                    // Ÿ�� �����̶��
                    if(board[row][col]==order[targetIndex]) {
                        // Enter ���� ����
                        moves += curr.moves+1;
                        sr = row;
                        sc = col;
                        break;
                    }

                    // ��ĭ�� �̵�
                    for(int dir=0; dir<4; dir++){
                        nrow = row + dr[dir];
                        ncol = col + dc[dir];
                        // ������ ����ų� �湮 ���� ���
                        if(nrow<0 || nrow>3 || ncol<0 || ncol>3|| visited[nrow][ncol]) continue;
                        visited[nrow][ncol] = true;
                        q.offer(new Node(nrow,ncol,curr.moves+1));
                    }

                    // ctrl + �̵�
                    for(int dir=0; dir<4; dir++){
                        Node next = ctrlMove(row, col, dir, board);
                        nrow = next.row;
                        ncol = next.col;
                        if(visited[nrow][ncol]) continue;
                        visited[nrow][ncol] = true;
                        q.offer(new Node(nrow, ncol, curr.moves+1));
                    }

                } // end of while

                // board ����
                board[sr][sc] = 0;

                // �湮 �迭, ť ����
                for(int i=0; i<4; i++) Arrays.fill(visited[i], false);
                q.clear();

            } // end of for pair

        } // end of for orders

        return moves;
    } // end of countMovesInOrder

    private Node ctrlMove(int row, int col, int dir, int[][] board) {
        // ���� ��ĭ ����
        row+=dr[dir];
        col+=dc[dir];

        // ������ ����� ���� ��
        while(row>=0 && row<4 && col>=0 && col<4){
            // ���� ī�尡 �ִٸ� �������
            if(board[row][col]!=0) return new Node(row, col, 0);
            row+=dr[dir];
            col+=dc[dir];
        }
        
        // ������ ����� �� while ������ ���°Ŷ� �ϳ� �����Ѵ�. 
        return new Node(row-dr[dir], col-dc[dir], 0);
    } // end of ctrlMove


} // end of class

