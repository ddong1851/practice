package src.programmers.kakao2022blind;

public class Solution_������¹���_unsolved {
	
	private static int min, N, M;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	public static int solution(int[][] board, int[] aloc, int[] bloc) {
		
		/*
		 * ������ �� �ִ� ������ ���� ��� �ش� ���� �÷��̾�� ���� �ȴ�. 
		 * �츮�� ���ؾ� �ϴ� ���� a �÷��̾ �̰��� ��, �ּ� �����Ӽ��� ���ϴ� ���̴�. 
		 * + �� �÷��̾ ���� ���ǿ� ���� ��, a�� �����̰� ���� ������ �������, b �÷��̾�� ���� �ȴ�. 
		 * 
		 * --> ������ �̱�� �������� ���� ��, �̱�� ������ �������� �ּ��� ��츦 �����ؾ� �Ѵ�...... 
		 * ���� ����� return �ϰ�..... �𸣰ʹ�
		 */
		
		min = 999_999_999;
		N = board.length;
		M = board[0].length;
		
        // dfs?, a�� ������ ���� �� a�� �����̰�, b�� �����̴� ���� �� b�� �����δ�. 
        go(board, aloc[0], aloc[1], bloc[0], bloc[1], 0, true);
        
        // min�� ����� ���� ���ٸ� 0, �ƴϸ� min ��ȯ
        return min==999_999_999?0:min;
    } // end of solution 
	
	private static void go(int[][] board, int ar, int ac, int br, int bc, int moves, boolean aturn) {
		boolean canMove = false;
		// a�� ������ ������ ��
		if(aturn) {
			// ������ ���� ��
			if(board[ar][ac]==0) return;
			for(int i=0; i<4; i++) {
				int nr = ar + dr[i];
				int nc = ac + dc[i];
				// ������ ����ų�, ������ ���� ���
				if(nr<0 || nr>= N || nc<0 || nc>=M || board[nr][nc]==0) continue;
				// ���� ����ְ� ���� 
				board[ar][ac] = 0;
				go(board, nr, nc, br, bc, moves+1, false);
				board[ar][ac] = 1;
			} // end of for 4 dir 
		} // end of if 
		// b�� ������ ������ ��
		else {
			if(board[br][bc]==0) {
				// �ּҰ� ����
				if(min>moves) min = moves;
			}
			for(int i=0; i<4; i++) {
				int nr = br + dr[i];
				int nc = bc + dc[i];
				// �� �� �ִ� �����ΰ�
				if(nr<0 || nr>= N || nc<0 || nc>=M || board[nr][nc]==0) continue;
				canMove = true;
				board[br][bc] = 0;
				go(board, ar, ac, nr, nc, moves+1, true);
				board[br][bc] = 1;
			}
			// b�� �������� ���ߴٸ� �й�
			if(!canMove) {
				// �ּҰ� ����
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

















