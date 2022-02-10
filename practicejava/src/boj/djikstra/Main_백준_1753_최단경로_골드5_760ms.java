package src.boj.djikstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/** Main_백준_1753_최단경로_골드5_760ms*/ 
public class Main_백준_1753_최단경로_골드5_760ms {
	
	// 노드 저장
	static ArrayList<Node>[] list;
	// 거리 저장
	static int[] distance;
	private static int V;
	private static int E;
	// 최대 값 V 간선 개수 300000 길이 최대 10 -> 3000000
	static final int INF = 3_000_000;
	
	private static void go(int start) {
		// 시작 정점에서 시작
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.offer(new Node(start, 0));
		// 다익스트라 구현
		while(!queue.isEmpty()) {
			// 현재 탐색 노드
			Node node = queue.poll();
			int currVer = node.V;
			int currW = node.weight;
			// 이미 갱신이 되었다면 --> 이미 방문한거니까 + 지금께 더 좋은 값이 아니라면
			if(distance[currVer] < currW) {
				continue;
			}
			// 현재 정점과 연결된 정점들
			for(int i=0; i<list[currVer].size(); i++) {
				int nextVer = list[currVer].get(i).V;
				// 먼저 넣어버리면 관리가 용이하다
				int nextW = list[currVer].get(i).weight + currW;
				// 다음 노드를 방문하지 않았고, 다음 노드까지의 거리가 현재 노드의 거리 + 다음 노드까지의 거리보다 큰 경우 갱신
				// 만약 이를 들리지 않게 된다면 INF 이상의 distance가 저장될 것
				if((distance[nextVer]> nextW)) {
					distance[nextVer] = nextW;
					queue.offer(new Node(nextVer, nextW));
				}
			}
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		// 시작 정점
		int start = Integer.parseInt(br.readLine());
		
		// 배열 초기화
		list = new ArrayList[V+1];
		for(int i=1; i<=V; i++) {
			list[i] = new ArrayList<Node>();
		}
		
		// 노드 추가
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int vertax = Integer.parseInt(st.nextToken());
			int nextV = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			// 방향 그래프다
			list[vertax].add(new Node(nextV, weight));
		}
		
		// 거리 배열 초기화
		distance = new int[V+1];
		Arrays.fill(distance, INF);
		// 시작 정점 -> 시작 정점 = 0 + 방문 처리
		distance[start] = 0;
		
		// 시작 정점과 연결된 모든 최단 경로 계산
		go(start);
		// 최단 경로에 따른 출력 처리
		for(int i=1; i<=V; i++) {
			if(distance[i] >= INF) {
				sb.append("INF").append("\n");
			}
			else {
				sb.append(distance[i]).append("\n");
			}
		}
		// 정답 출력
		System.out.println(sb.toString());
		
	}
}

class Node implements Comparable<Node>{
	public int V;
	public int weight;
	public Node(int v, int distance) {
		super();
		V = v;
		this.weight = distance;
	}
	// 오름차순으로 우선순위
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return weight - o.weight;
	}
}
