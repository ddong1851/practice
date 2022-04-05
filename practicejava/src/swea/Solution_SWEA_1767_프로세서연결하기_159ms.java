package src.swea;

import java.util.*;
import java.io.*;

/** Solution_SWEA_1767_프로세서연결하기_159ms */
public class Solution_SWEA_1767_프로세서연결하기_159ms {

	private static class Node {
		int row, col;

		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}

	private static int N, core, temp, min, row, col;
	private static int[][] map;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };
	private static ArrayList<Node> list;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		/*
		 * IDEA
		 * 
		 * 테두리는 전원이라 생각하면 되고 어떤 Core가 전원과 닿게 되면 연결 성공. 최대한 많은 Core를 연결하고 이때 가장 짧은 연결의
		 * 길이를 출력하자 + 선이 겹치면 안된다.
		 * 
		 * 7 <= N <= 12 1 <= C <= 12
		 * 
		 * 배열을 벗어나면 연결 성공으로 간주
		 * 
		 * 완전 탐색? 순열? 먼저 Core의 개수만큼 선택 후 완전 탐색 성공하면 max 갱신, max가 100_000(임의의 최대값)이 아닌 경우
		 * 종료
		 * --> 따지고 보니 부분 집합으로 했던 것이였다.
		 * + 가장자리의 Core를 따로 저장하고 이를 attachMap에 그냥 1로 넣기만 하고
		 * Core 개수로 카운팅 안했으면 시간이 더 줄었을 것 같다.
		 * 
		 * 시간 초과가 나지 않을까? 각각의 방향에 대해 모두 확인해야 함
		 */

		int TC = Integer.parseInt(br.readLine());
		for (int test = 1; test <= TC; test++) {

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			list = new ArrayList<Node>();
			core = 0;
			min = 100_000;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					temp = Integer.parseInt(st.nextToken());
					if (temp == 1) {
						core++;
						list.add(new Node(i, j));
					}
					map[i][j] = temp;
				}
			} // end of initialize

			for (int i = core; i >= 0; i--) {
				go(i, new boolean[core], 0, 0, new int[N][N], new ArrayList<Node>());
				if (min != 100_000)
					break;
			} // end of for pick

			sb.append("#").append(test).append(" ").append(min).append("\n");
		} // end of for TC

		System.out.println(sb.toString());

	} // end of main

	private static void go(int cnt, boolean[] chosen, int picked, int start, int[][] newMap, ArrayList<Node> Cores) {
		if (picked == cnt) {
			// 선택한 코어들 전원 연결 시도
			attachCore(newMap, Cores, cnt, 0, 0);
			return;
		} // 기저조건
		for (int i = start; i < core; i++) {
			if (chosen[i])
				continue;
			row = list.get(i).row;
			col = list.get(i).col;
			chosen[i] = true;
			newMap[row][col] = 1;
			Cores.add(new Node(row, col));
			go(cnt, chosen, picked + 1, i + 1, newMap, Cores);
			Cores.remove(Cores.size() - 1); // 최근에 추가한 코어 반납
			newMap[row][col] = 0;
			chosen[i] = false;
		} // 선택

	} // end of go

	// DFS
	private static void attachCore(int[][] attachMap, ArrayList<Node> Cores, int cnt, int length, int start) {
		// 목표 개수만큼 연결했다면 연결 길이 갱신 후 return
		if (start == cnt) {
			min = Math.min(min, length);
			return;
		} // end of 기저조건
		int r = Cores.get(start).row;
		int c = Cores.get(start).col;
		int mult = 1;
		for (int i = 0; i < 4;) {
			int nr = r + dr[i] * mult;
			int nc = c + dc[i] * mult;
			// 배열의 범위를 벗어나면 성공
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
				// 1. 선택한 줄 사용 표시
				mult--; // 벗어나기 이전까지 갱신
				for(int rep=1; rep<=mult; rep++) attachMap[r+dr[i]*rep][c+dc[i]*rep] = 1;
				// 2. 다음 DFS 
				attachCore(attachMap, Cores, cnt, length+mult, start+1);
				// 3. 선택한 줄 반납
				for(int rep=mult; rep>=1; rep--) attachMap[r+dr[i]*rep][c+dc[i]*rep] = 0;
				i++;
				mult=1;
				continue;
			}
			// 이미 다른 Core가 사용중이라면
			else if (attachMap[nr][nc] == 1) {
				i++;
				mult=1;
				continue;
			}
			mult++;
		}
	} // end of attachCore

} // end of class
//3
//7
//0 0 1 0 0 0 0
//0 0 1 0 0 0 0
//0 0 0 0 0 1 0
//0 0 0 0 0 0 0
//1 1 0 1 0 0 0
//0 1 0 0 0 0 0
//0 0 0 0 0 0 0
//9
//0 0 0 0 0 0 0 0 0
//0 0 1 0 0 0 0 0 1
//1 0 0 0 0 0 0 0 0
//0 0 0 1 0 0 0 0 0
//0 1 0 0 0 0 0 0 0
//0 0 0 0 0 0 1 0 0
//0 0 0 1 0 0 0 0 0
//0 0 0 0 0 0 0 1 0
//0 0 0 0 0 0 0 0 1
//11
//0 0 1 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0 1
//0 0 0 1 0 0 0 0 1 0 0
//0 1 0 1 1 0 0 0 1 0 0
//0 0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 1 0 0 0
//0 0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 1 0 0
//0 0 0 0 0 0 1 0 0 0 0
//0 0 0 0 0 0 0 0 0 0 0