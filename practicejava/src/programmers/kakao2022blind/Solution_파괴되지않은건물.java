package src.programmers.kakao2022blind;

public class Solution_�ı����������ǹ� {
	
	private static int[][] total;

	public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        /*
         * skill[0] 1=���� 2=ȸ��
         * 1-2 3-4 ���� 
         * skill[5] = degree, ��ŭ ����, ȸ��, 1~100 
         * 
         * �̹� ������ �־ �������� ��� �پ���.
         * ���������� �μ����� ���� �ǹ��� ������ ī���� �� ����
         * 
         * �ٸ�, �־��� ��� 250,000,000,000 ���� ������ �ؾ��ؼ� �ð� �ʰ��� �� ��
         * (1000*1000*250000)
         * => ���Ʈ�����¾ȵȴ�. 
         * �Ź� ��� ��Ҹ� �ٲٸ� �ð� �ʰ��� ����.... 
         * ��� ��ų�� �� Ž���ϰ� ���� ��� ��ҵ鿡 ���� �ջ�����
         * ���� ����� �־��� ��� ���� ���� �ʳ�.... --> �ð� �ʰ�
         * 
         * ��� row ���� ���� �������� ����
         * �� �𼭸����� ���� �ο��ϰ�... ��ĳ �ұ� -> �����ع���.. 
         */
        
        int len = skill.length;
        int br = board.length;
        int bc = board[0].length;
        
        total = new int[br+1][bc+1];
        int type, r1, c1, r2, c2, degree;
        // �� ��ų���� total ����
        for(int i=0; i<len; i++) {
        	// ��ų�� �� ���
        	type = skill[i][0];
        	r1 = skill[i][1];
        	c1 = skill[i][2];
        	r2 = skill[i][3];
        	c2 = skill[i][4];
        	degree = skill[i][5];
        	makeTotal(type, r1, c1, r2+1, c2+1, degree);
        }
        
        // �ջ�
        calcTotal(br, bc);
        
        // ���� ���� ī����
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
		// �ð� �ʰ� �ڵ�
//		for(int i=0; i<row; i++) {
//			for(int j=0; j<col; j++) {
//				// �ջ�
//				if(j==0) continue;
//				// ���� ���� ���� ���� ���Ѵ�. 
//				total[i][j] += total[i][j-1];
//			}
//		}
		
		// ������ �ڵ�, ��,�¿� ���� �ջ��Ѵ�. 
		for(int r=1; r<row; r++) {
			for(int c=0; c<col; c++) total[r][c] += total[r-1][c];
		}
		
		for(int c=1; c<col; c++) {
			for(int r=0; r<row; r++) total[r][c] += total[r][c-1];
		}
		
		
	} // end of calcTotal 

	private static void makeTotal(int type, int r1, int c1, int r2, int c2, int degree) {
		// �����̶�� -1��
		if(type==1) degree*=-1;
		
		// �ð� �ʰ� �ڵ�
//		for(int r=r1; r<=r2; r++) {
//			total[r][c1] += degree;
//			total[r][c2] -= degree;
//		}
		
		// ������ �ڵ�, �� �𼭸��� �ջ�, �̶� row+1���� �ջ��Ų��. 
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














