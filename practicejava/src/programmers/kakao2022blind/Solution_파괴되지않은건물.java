package src.programmers.kakao2022blind;

public class Solution_파괴되지않은건물 {
	
	private static int[][] total;

	public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        /*
         * skill[0] 1=공격 2=회복
         * 1-2 3-4 범위 
         * skill[5] = degree, 얼만큼 공격, 회복, 1~100 
         * 
         * 이미 망가져 있어도 내구도는 계속 줄어든다.
         * 최종적으로 부셔지지 않은 건물의 개수를 카운팅 후 리턴
         * 
         * 다만, 최악의 경우 250,000,000,000 번의 연산을 해야해서 시간 초과가 날 것
         * (1000*1000*250000)
         * => 브루트포스는안된다. 
         * 매번 모든 요소를 바꾸면 시간 초과가 난다.... 
         * 모든 스킬을 다 탐색하고 나서 모든 요소들에 대해 합산하자
         * 현재 방식은 최악의 경우 위와 같지 않나.... --> 시간 초과
         * 
         * 모든 row 마다 값을 지정하지 말고
         * 각 모서리에만 값을 부여하고... 어캐 할까 -> 참고해버림.. 
         */
        
        int len = skill.length;
        int br = board.length;
        int bc = board[0].length;
        
        total = new int[br+1][bc+1];
        int type, r1, c1, r2, c2, degree;
        // 각 스킬마다 total 갱신
        for(int i=0; i<len; i++) {
        	// 스킬의 각 요소
        	type = skill[i][0];
        	r1 = skill[i][1];
        	c1 = skill[i][2];
        	r2 = skill[i][3];
        	c2 = skill[i][4];
        	degree = skill[i][5];
        	makeTotal(type, r1, c1, r2+1, c2+1, degree);
        }
        
        // 합산
        calcTotal(br, bc);
        
        // 최종 총합 카운팅
        for(int i=0; i<br; i++) {
        	for(int j=0; j<bc; j++) {
//        		board[i][j] += total[i][j];
//        		if(board[i][j]>0) answer++;
        		if(board[i][j] + total[i][j]>0) answer++;
        	}
        }
        
        return answer;
        
    } // end of solution 
	
	private static void calcTotal(int row, int col) {
		// 시간 초과 코드
//		for(int i=0; i<row; i++) {
//			for(int j=0; j<col; j++) {
//				// 합산
//				if(j==0) continue;
//				// 이전 값에 현재 값을 더한다. 
//				total[i][j] += total[i][j-1];
//			}
//		}
		
		// 참고한 코드, 상,좌에 대해 합산한다. 
		for(int r=1; r<row; r++) {
			for(int c=0; c<col; c++) total[r][c] += total[r-1][c];
		}
		
		for(int c=1; c<col; c++) {
			for(int r=0; r<row; r++) total[r][c] += total[r][c-1];
		}
		
		
	} // end of calcTotal 

	private static void makeTotal(int type, int r1, int c1, int r2, int c2, int degree) {
		// 공격이라면 -1배
		if(type==1) degree*=-1;
		
		// 시간 초과 코드
//		for(int r=r1; r<=r2; r++) {
//			total[r][c1] += degree;
//			total[r][c2] -= degree;
//		}
		
		// 참고한 코드, 각 모서리에 합산, 이때 row+1까지 합산시킨다. 
		total[r1][c1] += degree;
		total[r1][c2] -= degree;
		total[r2][c1] -= degree;
		total[r2][c2] += degree;
		
	} // end of makeTotal 


	public static void main(String[] args) {
//		int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
//		int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
		int[][] board = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] skill = {{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}};
		
		System.out.println(solution(board, skill));
	} // end of main 
	
} // end of class 














