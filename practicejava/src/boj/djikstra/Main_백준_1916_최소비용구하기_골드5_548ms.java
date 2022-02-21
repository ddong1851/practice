package src.boj.djikstra;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 방문처리를 갱신된 distance값으로 활용하기
 * + 중복된 값에 대한 정보를 조회하지 않는 가지치기 if(distance[curr] > curr.weigth) continue;
 */

/** Main_백준_1916_최소비용구하기_골드5_548ms*/
public class Main_백준_1916_최소비용구하기_골드5_548ms {
	// Node라는 데이터타입 정의
	static class Node implements Comparable<Node>{
		int ver;
		int wei;
		public Node(int ver, int wei) {
			super();
			this.ver = ver;
			this.wei = wei;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.wei-o.wei;
		}
	}

	private static int N;
	private static final int INF = 999_999_999;
	private static ArrayList<Node>[] list;
	private static int[] distance;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 도시의 개수 1<= N <= 1000
		int M = Integer.parseInt(br.readLine()); // 버스의 개수 1<= M <= 100_000
		// 인접 리스트 초기화
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Node>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int curr = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[curr].add(new Node(next, weight));
		}
		st = new StringTokenizer(br.readLine());
		// 시작 정점과 끝나는 정점
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		go(start);
		
		System.out.println(distance[end]);
	} // end of main
	
	
	private static void go(int start) {
		
		distance = new int[N+1];
		Arrays.fill(distance, INF);
		distance[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int currver = curr.ver;
			// 중복된 값에 대한 가지치기, 더 weight가 더 큰 값이면 조회할 필요가 없다
			if(distance[currver] < curr.wei) continue;
			// 현재 정점과 연결된 정점들 탐색
			for(Node next:list[currver]) {
				int nextver = next.ver;
				if(distance[nextver]==INF || distance[nextver] > distance[currver] + next.wei) {
					distance[nextver] = distance[currver] + next.wei;
					pq.offer(new Node(nextver, distance[nextver]));
				}
			}
		} // end of while 
		
	} // end of go
	
} // end of class 





