package src.boj.bfs_dfs;

import java.io.*;
import java.util.*;

public class Main_����_13460_����Ż��2_���1_556ms {
	
	private static class Node{
		int row, col;
		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
		public boolean compare(Node o) {
			if(this.row==o.row && this.col==o.col) return true;
			return false;
		}
	}
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static char[][] map;
	private static boolean Rflag, Bflag;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Queue<Node> Red = new LinkedList<>();
		Queue<Node> Blue = new LinkedList<>();
		
		boolean[][][][] vis = new boolean[N][M][N][M];
		
		map = new char[N][];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				if(map[i][j] == 'R') {
					Red.offer(new Node(i, j));
					map[i][j] = '.';
				} else if(map[i][j] == 'B') {
					Blue.offer(new Node(i, j));
					map[i][j] = '.';
				} 
			} // end of for column
		} // end of initialize 
		
		
		int ans = -1;
		int row, col;
		// 10�� ���� �ݺ�
		for(int rep=1; rep<=10; rep++) {
			for(int s=0, size=Red.size(); s<size; s++) {
				Node red = Red.poll();
				Node blue = Blue.poll();
				// 4�������� ����
				for(int i=0; i<4; i++) {
					Rflag = Bflag = false;
					// �ش� ���� ����, �迭�� ���� �� ������ �� ���� ������, �ٸ� ������ ���� ��� ���� ���� �ʰ� �ϱ� ����
					// ���� ���� ����
					row = red.row;
					col = red.col;
					// ����ĭ�� ���� �ƴ϶�� ��������.
					while(map[row+dr[i]][col+dc[i]]!='#') {
						row += dr[i];
						col += dc[i];
						// ���ۿ� ���ٸ�
						if(map[row][col]=='O') {
							Rflag = true;
							break;
						}
					}
					Node nextR = new Node(row, col);
					
					row = blue.row;
					col = blue.col;
					// ����ĭ�� ���� �ƴ϶�� ��������.
					while(map[row+dr[i]][col+dc[i]]!='#') {
						row += dr[i];
						col += dc[i];
						// ���ۿ� ���ٸ�
						if(map[row][col]=='O') {
							Bflag = true;
							break;
						}
					}
					Node nextB = new Node(row, col);
					
					// �Ķ� ������ ���� ���� ��� �ڸ� ����
					if(!Bflag) {
						// �Ķ� ������ �ȵ��� ���� ������ �� ���
						if(Rflag) break;
						// ���� ĭ���� �̵��ϰԵ� ���
						if(nextR.compare(nextB)) {
							// ���� ���� �켱
							if((i==0 && red.row<blue.row) || (i==1 && red.row>blue.row)
									|| (i==2 && red.col<blue.col) || (i==3 && red.col>blue.col)) {
								nextB = new Node(nextB.row-dr[i], nextB.col-dc[i]);
							}
							// �Ķ� ���� �켱
							else {
								nextR = new Node(nextR.row-dr[i], nextR.col-dc[i]);
							}
						}
						// 4���� �湮 ó���� ���⼭ �����ϸ� �ȴ�.
						
						
						// ������ ����
						Red.offer(nextR);
						Blue.offer(nextB);
					}
				} // end of 4 direction 
				// ���� ������ �� ��� �ݺ� Ż��
				if(Rflag && !Bflag) break;
			} // end of while Empty
			// ���� ������ ���ۿ� ������ ��� Ż��
			if(Rflag && !Bflag) {
				ans = rep;
				break;
			}
		} // end of for repeat 10 times
		
		System.out.println(ans);
		
	} // end of main
	
} // end of class























