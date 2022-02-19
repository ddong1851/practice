package src.boj.djikstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/** Main_백준_1238_파티_골드3_*/
public class Main {
	
	private static class Node implements Comparable<Node>{
		public int V;
		public int E;
		public Node(int v, int e) {
			super();
			V = v;
			E = e;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return o.E - this.E;
		}
	}
	
	private static int N;
	private static int M;
	private static final int INF = 999_999_999;
	private static ArrayList<Node>[] list;
	private static int max;
	private static int temp;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		/*
		 * N명의 학생이 N번 파티에 모여서 파티를 벌이기로 한다. 
		 * 마을 사이에는 M개의 단방향(한방향) 도로들이 있오 i번째 시간을 지나는데 Ti가 소비된다.
		 * 파티에 참석하고, 다시 마을로 돌아와야 한다 -> 사이클 
		 * N명의 학생들 중 오고 가는게 가장 많은 시간을 소비하는 학생은 누구일지 구하라
		 * 
		 * 1 <= N <= 1000
		 * 1 <= M <= 10000
		 * 
		 * 다익스트라 예제
		 * 각 노드별로 우선 연결하고, 학생별 왔다갔다 최대거리를 max로 지정한다.
		 * 학생이 어느 마을로 가고, 다시 돌아왔을 떄 max값을 비교하자
		 * ( 학생들은 최단거리로만 왔다갔다 한다 ) 
		 * 
		 */
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		max = INF;
		int X = Integer.parseInt(st.nextToken());
		
		// 1대1 매칭  
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Node>();
		}
		// 그래프 초기화
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			list[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		
		for(int i=1; i<=N; i++) {
			temp = INF;
			boolean[] visited = new boolean[N+1];
			int goparty = go(i, X, 0, visited); // 출발지점, 도착지점, 총 거리, 방문 여부
			visited = new boolean[N+1];
			int returnparty = go(X, i, 0, visited);
			max = Math.max(max, goparty+returnparty);
		}
		
		
		// 정답 출력
		System.out.println(max);
		
		
	} // end of main
	
	private static int go(int start, int dest, int total, boolean[] visited) {
		
		if(start==dest) {
			return Math.min(temp, total);
		}
		// 이미 방문한 노드라면
		if(visited[start]) return 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		while(!pq.isEmpty()) {
			
		}
		
		return total;
	}
	
	
	
	
	
	
	
	
	
	
	
	
} // end of class 
