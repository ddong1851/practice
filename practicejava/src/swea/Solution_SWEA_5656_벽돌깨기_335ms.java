package src.swea;

import java.util.*;
import java.io.*;

/** Solution_SWEA_5656_벽돌깨기_335ms*/
public class Solution_SWEA_5656_벽돌깨기_335ms {
	
	private static class Node{
		int row, col, size;
		public Node(int row, int col, int size) {
			super();
			this.row = row;
			this.col = col;
			this.size = size;
		}
	}
	
	private static int N, W, H, max;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		/*
		 * 연쇄..
		 * 첫번째로 구슬에 닿은 곳을 터트리면서
		 * 연쇄되며 터지는 곳들을 리스트에 추가
		 * 큐에서 빼면서 동시에 연쇄 처리
		 * 
		 * 포인트
		 * 연쇄할 포인트 지정
		 * 12^4승. 중복.. 조합? 20736개 가지수 ( 1<=N<=4 ) 
		 * 순서대로 연쇄해보기
		 * 연쇄 종료 후 남은 벽돌 개수 카운팅
		 * 
		 * 하나를 선택하고 해당 연쇄 진행 후 다음 선택으로 넘어가는게 
		 * 중복을 처리하는데 좋아 속도를 줄일 수 있을 것 같다.
		 * 
		 * 배열을 땅으로 내리는 건 데크를 활용하자
		 * 
		 * 내가 생각하는 시간 줄이는 방법
		 * 1. 벽돌 개수를 카운팅
		 * 1.1) 변경된 벽돌 개수 들고 가기
		 * 
		 * 2. 선택한 행에 0밖에 없다면 바로 Continue 
		 * 
		 * 
		 */
		
		
		int TC = Integer.parseInt(br.readLine());
		for (int test = 1; test <= TC; test++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int[][] map = new int[H][W];
			
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			// 불가능한 값으로 초기화
			max = 999_999;
			// 중복 순열 만들기 + 바뀐 벽돌 개수를 들고 다니는 것도 시간을 줄일 수 있을 것으로 보인다.
			go(0, map);
			
			sb.append("#").append(test).append(" ").append(max).append("\n");
		} // end of for TC

		System.out.println(sb.toString());
		
	} // end of main 


	private static void go(int cnt, int[][] newMap) {
		if(cnt==N) {
			// 남은 벽돌 개수 카운팅
			countBricks(newMap);
			return;
		} // end of 기저조건
		
		for(int i=0; i<W; i++) {
			// 1. 원본 배열 기억하기
			int[][] clone = cloneArr(newMap);
			// 2. 배열 연쇄 처리
			deleteArr(newMap, i);
			// 3. 벽돌 내리기 
			moveBrick(newMap);
			// 4. 다음 조합
			go(cnt+1, newMap);
			// 5. 배열 복구
			newMap = clone;
		}
	} // end of go


	private static int[][] cloneArr(int[][] newMap) {
		// 원본 배열 복사
		int[][] nm = new int[H][W];
		for(int i=0; i<H; i++) nm[i] = newMap[i].clone();
		return nm;
	} // end of cloneArr

	private static void moveBrick(int[][] newMap) {
		// 배열을 바닥으로 당기는 메서드
		Deque<Node> dq = new ArrayDeque<Node>();
		for(int c=0; c<W; c++) {
			// 세로 줄 탐색
			for(int r=0; r<H; r++) {
				if(newMap[r][c]!=0) dq.offer(new Node(r, c, newMap[r][c]));
				newMap[r][c] = 0;
			}
			int row = H-1;
			while(!dq.isEmpty()) {
				newMap[row--][c] = dq.pollLast().size;
			}
		}
	} // end of moveBrick


	private static void deleteArr(int[][] newMap, int selected) {
		// 배열 연쇄하면서 갱신
		Queue<Node> q = new LinkedList<>();
		// 첫번째로 처리할 좌표 추가
		for(int i=0; i<H; i++) {
			if(newMap[i][selected]!=0) {
				q.offer(new Node(i, selected, newMap[i][selected]));
				newMap[i][selected] = 0;
				break;
			}
		}
		
		// BFS 
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int row = curr.row;
			int col = curr.col;
			int size = curr.size;
			for(int i=0; i<4; i++) {
				for(int rep = 1; rep<size; rep++) {
					int nr = row + dr[i]*rep;
					int nc = col + dc[i]*rep;
					if(nr<0 || nr>=H || nc<0 || nc>=W) break;
					q.offer(new Node(nr, nc, newMap[nr][nc]));
					newMap[nr][nc] = 0;
				} // end of for repeat size
			} // end of for 4 direction
		} // end of while 	
		
	} // end of deleteArr


	private static void countBricks(int[][] newMap) {
		// 벽돌 개수 카운팅
		int count = 0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(newMap[i][j]!=0) count++;
			}
		}
		if(count<max) max=count;
	} // end of countBricks
	
} // end of class 














