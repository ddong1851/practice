package src.programmers.kakao2021;

import java.util.*;

public class Solution_2021īī��ä�뿬�������ͽ�_�Ÿ��α�Ȯ���ϱ� {
	
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {

		String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
				{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
				{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
		
		System.out.println(Arrays.toString(solution(places)));
	}

	public static int[] solution(String[][] places) {
		int[] answer = new int[5];

		char[][] map = new char[5][];
		boolean bk = false;

		for (int tc = 0; tc < 5; tc++) {
			answer[tc] = 1;
			bk = false;

			for (int i = 0; i < 5; i++) {
				map[i] = places[tc][i].toCharArray();
			}

			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					if(map[r][c]=='P') {
						if(!go(r, c, map)) {
							answer[tc] = 0;
							bk = true;
							break;
						} // end of if false 
					} // end of if P
				} // end of for c
				if(bk) break;
			} // end of for r

		} // end of for tc

		return answer;
	} // end of solution

	private static boolean go(int r, int c, char[][] map) {
		Queue<int[]> q = new LinkedList<int[]>();
		
		int nr, nc;
		// ��ĭ ��
		for(int i=0; i<4; i++) {
			nr = r+dr[i];
			nc = c+dc[i];
			if(nr<0 || nr>=5 || nc<0 || nc>=5) continue;
			// ��ĭ ���� ����� �ִٸ�
			if(map[nr][nc]=='P') return false;
			q.offer(new int[] {nr, nc});
		}
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int i=0; i<4; i++) {
				nr = curr[0] + dr[i];
				nc = curr[1] + dc[i];
				if(nr<0 || nr>=5 || nc<0 || nc>=5) continue;
				if(map[nr][nc]=='P') {
					// �������� �ƴϸ鼭 �� ���̺��� �� ����̸� 
					if((nr!=r || nc!=c) && map[curr[0]][curr[1]]=='O') return false;
				}
			}
		} // end of while 
		
		return true;
	} // end of go 

} // end of class
