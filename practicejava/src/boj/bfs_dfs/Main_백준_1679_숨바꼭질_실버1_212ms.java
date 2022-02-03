package src.boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/** Main_백준_1679_숨바꼭질_실버1_212ms*/
public class Main_백준_1679_숨바꼭질_실버1_212ms {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 수빈이의 위치
		int n = Integer.parseInt(st.nextToken());
		// 동생의 위치
		int k = Integer.parseInt(st.nextToken());
		// 가능한 모든 좌표, 0~100000
		int [] position = new int[100001];
		
		// 이동 가능 방향, 가로 방향 1, -1, *2 
		// 가로 좌표를 저장하는 배열을 만들고, 해당 배열에 도달하는데 걸리는 시간을 각 좌표에 min을 사용하여 저장하자
		if(n==k) {
			System.out.println(0);
			System.exit(0);
		}
		else {
			solution(n, k, position);
		}
	} // end of main

	private static void solution(int n, int k, int[] position) {
		// TODO Auto-generated method stub
		// 시작, 첫 좌표에서의 좌, 우, x2의 이동을 각각 할건데, 이후로 모든 좌표에 대해 -1, 1, x2를 진행하고, 소요 시간을 계산하자
		Deque<Integer> deque = new ArrayDeque<Integer>();
		boolean [] visited = new boolean[100001];
		deque.add(n);
		position[n]=0;
		visited[n] = true;
		// 어떤 조건에 값을 큐에 넣을것인가?, 일단 덮어쓰는 식으로 연산하자!(처음 닿는 곳이라면 가장 빨리 갈 수 있는거 아닌가
		while(!deque.isEmpty()) {
			// 3방 탐색, 
			int x = deque.poll();
			for(int i=0; i<3; i++) {
				int nx = x;
				// 좌표 이동 후 k가 아니라면 큐에 추가
				if(i==0) {
					nx++;
				}
				else if(i==1) {
					nx--;
				}
				else {
					nx*=2;
				}
				// 범위를 벗어났다면
				if(nx<0 || nx>=100001) {
					continue;
				}
				// 방문된 좌표라면
				if(visited[nx]==true) {
					continue;
				}
				// 미방문되었다면
				if(position[nx]==0 && visited[nx]==false) {
					position[nx] = position[x]+1;
					deque.add(nx);
					visited[nx] = true;
					if(nx==k) {
						System.out.println(position[nx]);
						System.exit(0);
					}
				}
			}
		} // end of while 
	} // end of solution
} // end of class


