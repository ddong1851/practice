package src.programmers.kakao2022blind;

public class Solution_사라지는발판_unsolved {
	
	private static int min, N, M;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	public static int solution(int[][] board, int[] aloc, int[] bloc) {
		
		/*
		 * 움직일 수 있는 발판이 없는 경우 해당 턴의 플레이어는 지게 된다. 
		 * 우리가 구해야 하는 것은 a 플레이어가 이겼을 때, 최소 움직임수를 구하는 것이다. 
		 * + 두 플레이어가 같은 발판에 있을 때, a가 움직이고 나서 발판이 사라지면, b 플레이어는 지게 된다. 
		 * 
		 * --> 무조건 이기는 발판으로 갔을 때, 이기는 수에서 움직임이 최소인 경우를 저장해야 한다...... 
		 * 승패 결과를 return 하고..... 모르것당
		 */
		
		min = 999_999_999;
		N = board.length;
		M = board[0].length;
		
        // dfs?, a가 움직일 턴일 떄 a를 움직이고, b가 움직이는 턴일 때 b를 움직인다. 
        go(board, aloc[0], aloc[1], bloc[0], bloc[1], 0, true);
        
        // min이 변경된 적이 없다면 0, 아니면 min 반환
        return min==999_999_999?0:min;
    } // end of solution 
	
	private static void go(int[][] board, int ar, int ac, int br, int bc, int moves, boolean aturn) {
		boolean canMove = false;
		// a가 움직일 차례일 때
		if(aturn) {
			// 발판이 없을 때
			if(board[ar][ac]==0) return;
			for(int i=0; i<4; i++) {
				int nr = ar + dr[i];
				int nc = ac + dc[i];
				// 범위를 벗어났거나, 발판이 없는 경우
				if(nr<0 || nr>= N || nc<0 || nc>=M || board[nr][nc]==0) continue;
				// 발판 비워주고 다음 
				board[ar][ac] = 0;
				go(board, nr, nc, br, bc, moves+1, false);
				board[ar][ac] = 1;
			} // end of for 4 dir 
		} // end of if 
		// b가 움직일 차례일 때
		else {
			if(board[br][bc]==0) {
				// 최소값 갱신
				if(min>moves) min = moves;
			}
			for(int i=0; i<4; i++) {
				int nr = br + dr[i];
				int nc = bc + dc[i];
				// 갈 수 있는 발판인가
				if(nr<0 || nr>= N || nc<0 || nc>=M || board[nr][nc]==0) continue;
				canMove = true;
				board[br][bc] = 0;
				go(board, ar, ac, nr, nc, moves+1, true);
				board[br][bc] = 1;
			}
			// b가 움직이지 못했다면 패배
			if(!canMove) {
				// 최소값 갱신
				if(min>moves) min = moves;
			}
		} // end of else 
	} // end of go 




	public static void main(String[] args) {
		int[][] board = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
		int[] aloc = {1, 0};
		int[] bloc = {1, 2};
		
		System.out.println(solution(board, aloc, bloc));
		
	} // end of main 
	
} // end of class 

















