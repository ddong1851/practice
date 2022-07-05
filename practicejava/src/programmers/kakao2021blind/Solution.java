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
        BFS, DFS 모두 가능할 것 같다.
        Enter 를 클릭해서 카드를 뒤집는데, 필요없는 짝을 들추면 안되니까
        카드를 뽑는 순서를 먼저 결정하고
        해당 카드에 도착했을 때만 Enter 를 클릭해서 뒤집는다.

        방문 처리는 어떤 카드를 발견하면 초기화 해야한다.

        --> 순열? 을 통해 카드를 뽑는 순서를 결정하고,
        BFS 로 각각을 뒤집는 최소 수를 카운팅하고,
        최소 값을 넘길 경우 break 하자. (4x4니까 굳이 하지 않아도 될듯)

         */

        // board, 시작점, min 전역 변수 초기화
        globalBoard = board;
        startRow = r;
        startCol = c;
        minMoves = 100_000_000;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        // 1. 카드 짝이 몇 개인지 카운팅
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
        
        // 2. 카드 뽑는 순서 정하기
        makePairOrder(0, new int[countPair], new boolean[countPair]);


        return minMoves;
    } // end of solution

    private void makePairOrder(int picked, int[] order, boolean[] using) {

        if(picked== countPair){
            // 3. 해당 순서에서 몇번의 키 선택이 소요되었는지 카운팅
            int moveCount = countMovesInOrder(startRow, startCol, order);
            // 4. min 값 갱신
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
            // 2번 반복 ( 짝이니까 )
            for(int repeat=0; repeat<2; repeat++){

                // 시작점 기준으로 출발
                visited[sr][sc] = true;
                q.offer(new Node(sr, sc, 0));

                while (!q.isEmpty()){

                    Node curr = q.poll();
                    row = curr.row;
                    col = curr.col;
                    // 타겟 지점이라면
                    if(board[row][col]==order[targetIndex]) {
                        // Enter 까지 포함
                        moves += curr.moves+1;
                        sr = row;
                        sc = col;
                        break;
                    }

                    // 한칸씩 이동
                    for(int dir=0; dir<4; dir++){
                        nrow = row + dr[dir];
                        ncol = col + dc[dir];
                        // 밤위를 벗어나거나 방문 했을 경우
                        if(nrow<0 || nrow>3 || ncol<0 || ncol>3|| visited[nrow][ncol]) continue;
                        visited[nrow][ncol] = true;
                        q.offer(new Node(nrow,ncol,curr.moves+1));
                    }

                    // ctrl + 이동
                    for(int dir=0; dir<4; dir++){
                        Node next = ctrlMove(row, col, dir, board);
                        nrow = next.row;
                        ncol = next.col;
                        if(visited[nrow][ncol]) continue;
                        visited[nrow][ncol] = true;
                        q.offer(new Node(nrow, ncol, curr.moves+1));
                    }

                } // end of while

                // board 비우기
                board[sr][sc] = 0;

                // 방문 배열, 큐 비우기
                for(int i=0; i<4; i++) Arrays.fill(visited[i], false);
                q.clear();

            } // end of for pair

        } // end of for orders

        return moves;
    } // end of countMovesInOrder

    private Node ctrlMove(int row, int col, int dir, int[][] board) {
        // 먼저 한칸 증가
        row+=dr[dir];
        col+=dc[dir];

        // 범위를 벗어나지 않을 때
        while(row>=0 && row<4 && col>=0 && col<4){
            // 만약 카드가 있다면 멈취야함
            if(board[row][col]!=0) return new Node(row, col, 0);
            row+=dr[dir];
            col+=dc[dir];
        }
        
        // 범위를 벗어났을 때 while 문에서 나온거라 하나 빼야한다. 
        return new Node(row-dr[dir], col-dc[dir], 0);
    } // end of ctrlMove


} // end of class

