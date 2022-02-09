package src.boj.djikstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 다익스트라 문제, DFS와 비슷하지만 방문 처리와 거리 합산을 함수 내에서 한다.
/** Main_백준_1504_특정한최단경로_골드4_868ms*/
public class Main_백준_1504_특정한최단경로_골드4_868ms {
	
	private static int N;
	private static int E;
	
	// 경로가 없다면 -1
	private static int max = 200000000;
	static ArrayList<VE>[] list;
	static boolean visited[];
	static int[] distance;
	

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		/*
		 * 첫 줄에 정점의 개수 N과 간선의 개수 E가 주어진다.
		 * 2개의 정점을 지나는 최단 경로의 길이를 출력한다.
		 * 
		 * 방문한 정점의 개수가 2개가 되었을 때 길이를 반환해야 하는데
		 * 이때 길이가 최대 길이보다 큰지, 작은지를 구분해야 한다.
		 * + 메모이제이션을 통해 어떤 정점에서 다른 정점까지의 거리를 미리 저장해두는게 좋다
		 * 이 문제는 DFS로 접근하여 푸는게 좋을 거 같다.
		 * visited 처리 없이 DFS에 값을 추가, 미추가로 해보자
		 */
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		// 1대1 매칭
		list = new ArrayList[N+1];
		distance = new int[N+1];
		// 초기화
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		// 간선의 개수만큼 추가
		for(int i=1; i<=E; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int ver = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());
			// 양방향으로 연결
			list[v].add(new VE(ver, edge));
			list[ver].add(new VE(v, edge));
		}
		
		st = new StringTokenizer(br.readLine());
		// 반드시 탐색해야 하는 2개의 정정
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		// 이런 경우에는 1-> v1, v1->v2, v2->N 의 최단거리를 각각 구하여 더해야 한다.
		int len1 = go(1, v1) + go(v1, v2) + go(v2, N);
		int len2 = go(1, v2) + go(v2, v1) + go(v1, N);
		// 하나라도 불가능한 경로가 있다면 -1 출력
		int result = (len1 >= max && len2 >= max)?-1:Math.min(len1, len2);
		System.out.println(result);
	}

	// 문제1 visited가 공유가 되고 있다. --> 1-2-3-4에서 min이 7로 바뀌었는데 1-4가 들어왔을 때 visited가 초기화가 안되어 min이 4로 바뀐다.
	// 1번 노드부터 가라
	private static int go(int start, int end) {
		// 구현파트3 
		// 거리를 저장하는 배열을 알고리즘 내에 선언
		distance = new int[N+1];
		Arrays.fill(distance, max);
		Arrays.fill(visited, false);
		distance[start] = 0;
		PriorityQueue<VE> queue = new PriorityQueue<VE>();
		// 시작 정점 추가
		queue.offer(new VE(start, 0));
		
		while(!queue.isEmpty()) {
			VE node = queue.poll();
			int ver = node.V;
			int edge = node.E;
			// 지금 가중치가 더 크면 갱신하지 마라(최소 거리만 저장할거니까)
			if(!visited[ver]) {
				visited[ver] = true;
			}
			for(int i=0; i<list[ver].size(); i++) {
				int nextver = list[ver].get(i).V;
				int nextedge = list[ver].get(i).E;
				// 지금 거리가 최단 경로라면 갱신한다. ( 방문 안했다면 ) 
				if(!visited[nextver] && distance[nextver] > distance[ver] + nextedge) {
					distance[nextver] = nextedge + distance[ver];
					queue.add(new VE(nextver, distance[nextver]));
				}
			} // end of for
		} // end of while
		// 최단 경로를 반환한다.( 목표하는 장소까지의 최단경로가 없다면 MAX를 반환한다) 
		return distance[end];
	}
}

class VE implements Comparable<VE>{
	public int V;
	public int E;
	public VE(int V, int E) {
		super();
		this.V = V;
		this.E = E;
	}
	@Override
	public int compareTo(VE o) {
		// TODO Auto-generated method stub
		return E - o.E;
	}
}

