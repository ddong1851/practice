package src.boj.bitmasking;

import java.io.*;
import java.util.*;

/** Main_백준_1194_달이차오른다가자_골드1_144ms*/
public class Main_백준_1194_달이차오른다가자_골드1_144ms {
	
	public static class ME{
		int row, col;
		String keys;
		public ME(int row, int col, String keys) {
			super();
			this.row = row;
			this.col = col;
			this.keys = keys;
		}
	}
	
	private static int N, M;
	private static char[][] map;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		
		/*
		 * 탐색 문제
		 * 
		 * 빈 칸은 이동 가능
		 * # 벽, 이동 불가
		 * 열쇠 소문자, 이를 먹으면 문을 열 수 있음
		 * 문 대문자
		 * 민식이의 위치 0
		 * 출구 1
		 * 
		 * BFS?
		 * 출구인 1을 도달했을 때 턴 수를 카운트하고 종료
		 * 만약 큐가 빌 때까지 반복을 해도 찾지 못하였다면 return -1 종료
		 * 
		 * 열쇠 배열 ( 대문자를 만나면 -'A' 가 True인지 확인, 소문자를 만나면 -'a'를 true로 변경
		 * 데이터 타입을 만드는데,
		 * 
		 * 위치 row col 
		 * 먹은 열쇠 String key;
		 *
		 * 각각의 방문 처리는?
		 * 방문 배열을 들고 가기는 너무 무거운데
		 * String으로 배열을 만들고, vis[r][c].compare로? (먹은 키 값을 통해?)
		 * 
		 * 문제 1 
		 * 메모리가 터진다!
		 * 방문 처리를 다른 방법으로 해야한다.,
		 * 3차원?
		 * _ _ _ _ _ _
		 * a b c d e f 
		 * H를 위 값들의 존재 여부를 1, 0으로 매핑하고 
		 * H를 해당 값들의 십진수로 표현한다.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]=='0') 
					System.out.println(go(i, j));
			}
		}
		
	} // end of main

	private static int go(int sr, int sc) {
		// 문자열 비교를 통한 방문 체크
		// 3차원 방문 처리 0~63
		boolean [][][] vis = new boolean[64][N][M];
		map[sr][sc] = '.';
		vis[0][sr][sc] = true;
		
		Queue<ME> q = new LinkedList<>();
		q.offer(new ME(sr, sc, "000000"));
		
		int row,col,nr,nc;
		String key="";
		int moves = 1;
		while(!q.isEmpty()) {
			for(int rep=0, size = q.size(); rep<size; rep++) {
				ME curr = q.poll();
				row = curr.row;
				col = curr.col;
				key = curr.keys;
				for(int i=0; i<4; i++) {
					nr = row + dr[i];
					nc = col + dc[i];
					// 범위를 벗어나면 혹은 벽이라면 혹은 이미 갔다온 곳이라면
					if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc]=='#') continue;
					// 해당 좌표를 방문한적 있다면
					if(vis[Integer.parseInt(key, 2)][nr][nc]) continue;
					// 일단 방문 처리
					vis[Integer.parseInt(key, 2)][nr][nc] = true;
					// 목적지라면 
					if(map[nr][nc]=='1') {
						return moves;
					}
					else if(map[nr][nc]=='.') {
						q.offer(new ME(nr, nc, key));
					}
					// 소문자라면
					else if(map[nr][nc]-'a'>=0 && map[nr][nc]-'a'<6) {
						// 아직 해당 자리 열쇠가 없는 경우
						if(key.charAt(map[nr][nc]-'a')=='0') {
							StringBuilder replace = new StringBuilder(key);
							replace.setCharAt(map[nr][nc]-'a', '1');
							vis[Integer.parseInt(replace.toString(), 2)][nr][nc] = true;
							q.offer(new ME(nr, nc, replace.toString()));
						} else {
							q.offer(new ME(nr, nc, key));
						}
					}
					// 대문자라면
					else if(map[nr][nc]-'A'>=0 && map[nr][nc]-'A'<6) {
						if(key.charAt(map[nr][nc]-'A')=='0') continue; 
						q.offer(new ME(nr, nc, key));
					}
				} // end of for
			} // end of for count moves 
			moves++;
		} // end of while empty 
		// 정답 찾기 실패
		return -1;
	} // end of go
} // end of class 













