package src.boj.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


/** Main_백준_11559_PuyoPuyo_골드4*/
public class Main {
	// 좌표
	private static char[][] map;
	// 방문 여부
	private static boolean[][] vis;
	// 처리할 푸요의 좌표를 저장
	private static Queue<int[]> puyo = new LinkedList<>();
	// 연쇄 처리용 데크
	private static Deque<Character> dq = new ArrayDeque<>();
	// 탐색할 좌표를 저장하는 큐
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
		 * 반복은 Top Layer부터 돈다. ( 푸요가 존재하는 Top Data )
		 * 한 턴에서 연쇄되어 없어질 푸요들을 큐에 저장하고, ( 푸요를 구하는 것은 BFS로 탐색 )
		 * 
		 * 내릴 때 어캐? 
		 * 한줄씩 떙기기?
		 * 데크로 떙기기
		 */
		
		int turn = 0;
		boolean success = false;
		boolean line = false;
		while(true) {
			vis = new boolean[12][6];
			success = false;
			//1. map 전체를 돌면서 확인, 아래에서 부터
			for(int i=11; i>=0; i--) {
				line = false;
				for (int j = 0; j < 6; j++) {
					if(map[i][j]!='.' && !vis[i][j]) {
						line = true;
						if(go(i, j, map[i][j]))
							success = true;
					}
				}
				// 해당 줄부터 쭉 . 이면 탐색 종료
				if(!line) break;
			}
			// 종료 조건, 해당 턴에 연쇄가 발생한 적이 없다면
			if(!success) break;
			// 2. 연쇄 처리
			updateMap();
			// 종료되지 않았다면 turn 증가
			turn++;
		} 
		System.out.println(turn);
	} // end of main 
	
	private static void updateMap() {
		// 한 줄씩 갱신, 아래로 당기기
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
		// 같은 짝 찾기
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int row = curr[0];
			int col = curr[1];
			for(int i=0; i<4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				// 범위를 벗어나거나, 같은 색이 아니라면 다음 탐색
				if(nr<0 || nr>=12 || nc<0 || nc>=6 || map[nr][nc]!=color) continue;
				if(vis[nr][nc]) continue;
				// 방문 처리
				vis[nr][nc] = true;
				q.offer(new int[] {nr, nc});
				puyo.offer(new int[] {nr, nc});
			}
		}
		int size = puyo.size();
		// 4개 이상이라면 갱신
		if(size>=4) {
			while(!puyo.isEmpty()) {
				int[] curr = puyo.poll();
				map[curr[0]][curr[1]] = '.';
			}
			return true;
		}
		// 4개 이하라면
		else {
			puyo.clear();
			return false;
		}
	} // end of go method 
} // end of class 







