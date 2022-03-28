package src.boj.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


/** Main_����_11559_PuyoPuyo_���4*/
public class Main {
	// ��ǥ
	private static char[][] map;
	// �湮 ����
	private static boolean[][] vis;
	// ó���� Ǫ���� ��ǥ�� ����
	private static Queue<int[]> puyo = new LinkedList<>();
	// ���� ó���� ��ũ
	private static Deque<Character> dq = new ArrayDeque<>();
	// Ž���� ��ǥ�� �����ϴ� ť
	private static Queue<int[]> q = new LinkedList<>();
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[12][];
		
		for (int i = 0; i < 12; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		/*
		 * �ݺ��� Top Layer���� ����. ( Ǫ�䰡 �����ϴ� Top Data )
		 * �� �Ͽ��� ����Ǿ� ������ Ǫ����� ť�� �����ϰ�, ( Ǫ�並 ���ϴ� ���� BFS�� Ž�� )
		 * 
		 * ���� �� ��ĳ? 
		 * ���پ� �����?
		 * ��ũ�� �����
		 */
		
		int turn = 0;
		boolean success = false;
		boolean line = false;
		while(true) {
			vis = new boolean[12][6];
			success = false;
			//1. map ��ü�� ���鼭 Ȯ��, �Ʒ����� ����
			for(int i=11; i>=0; i--) {
				line = false;
				for (int j = 0; j < 6; j++) {
					if(map[i][j]!='.' && !vis[i][j]) {
						line = true;
						if(go(i, j, map[i][j]))
							success = true;
					}
				}
				// �ش� �ٺ��� �� . �̸� Ž�� ����
				if(!line) break;
			}
			// ���� ����, �ش� �Ͽ� ���Ⱑ �߻��� ���� ���ٸ�
			if(!success) break;
			// 2. ���� ó��
			updateMap();
			// ������� �ʾҴٸ� turn ����
			turn++;
		} 
		System.out.println(turn);
	} // end of main 
	
	private static void updateMap() {
		// �� �پ� ����, �Ʒ��� ����
		for(int i=0; i<6; i++) {
			for(int j=11; j>=0; j--) {
				if(map[j][i]!='.') dq.offer(map[j][i]);
				map[j][i] = '.';
			}
			for(int j=11; j>=0; j--) {
				if(!dq.isEmpty()) map[j][i] = dq.poll();
				else break;
			}
		}
	} // end of updateMap

	private static boolean go(int sr, int sc, char color) {
		vis[sr][sc] = true;
		q.offer(new int[] {sr, sc});
		puyo.offer(new int[] {sr, sc});
		// ���� ¦ ã��
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int row = curr[0];
			int col = curr[1];
			for(int i=0; i<4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				// ������ ����ų�, ���� ���� �ƴ϶�� ���� Ž��
				if(nr<0 || nr>=12 || nc<0 || nc>=6 || map[nr][nc]!=color) continue;
				if(vis[nr][nc]) continue;
				// �湮 ó��
				vis[nr][nc] = true;
				q.offer(new int[] {nr, nc});
				puyo.offer(new int[] {nr, nc});
			}
		}
		int size = puyo.size();
		// 4�� �̻��̶�� ����
		if(size>=4) {
			while(!puyo.isEmpty()) {
				int[] curr = puyo.poll();
				map[curr[0]][curr[1]] = '.';
			}
			return true;
		}
		// 4�� ���϶��
		else {
			puyo.clear();
			return false;
		}
	} // end of go method 
} // end of class 







