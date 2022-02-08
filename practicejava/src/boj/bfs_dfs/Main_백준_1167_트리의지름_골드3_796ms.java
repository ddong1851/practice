package src.boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class NodeV{
	int ver;
	int edge;
	public NodeV(int ver, int edge) {
		super();
		this.ver = ver;
		this.edge = edge;
	}
	public int getVer() {
		return ver;
	}
	public int getEdge() {
		return edge;
	}
}

/** Main_백준_1167_트리의지름_골드3_796ms*/
public class Main_백준_1167_트리의지름_골드3_796ms {
	
	static boolean[] visited;
	// Node들을 어떠한 정점에 연결할 때 사용하는 방법
	static ArrayList<NodeV>[] graph;
	static int max = 0;
	static int node;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int V = Integer.parseInt(br.readLine());
		graph = new ArrayList[V+1];
		for(int i=1; i<=V; i++) {
			graph[i] = new ArrayList<>();
		}
		/*
		 * 더 이상 연결된 정점이 없을 때 max를 counting 후 갱신
		 * 모든 연결된 정점에 대하여 탐색.
		 * DFS로 풀어야 하며 
		 * 한 정점에 닿으면 그에 연결된 정점 중 visited == false인 곳 탐방
		 * --> 재귀
		 */
		// 정점간의 관계를 저장하는 리스트
		for(int i=1; i<=V; i++) {
			// 한줄 읽고
			st = new StringTokenizer(br.readLine());
			// 그래프 갱신
			int idx = Integer.parseInt(st.nextToken());
			while(true) {
				// 선택된 정점
				int temp = Integer.parseInt(st.nextToken());
				if(temp==-1) break;
				int distance = Integer.parseInt(st.nextToken());;
				graph[idx].add(new NodeV(temp, distance));
			}
		}
		
		// 정점과 정점 기준 가장 먼 정점을 찾는다
//		DFS()
		visited = new boolean[V+1];
		DFS(1, 0);
		
//		가장 먼 노드에서의 거리 
		visited = new boolean[V+1];
		DFS(node, 0);
		
		System.out.println(max);
	}
	
	private static void DFS(int x, int distance) {
		 if(distance > max) {
			 max = distance;
			 node = x;
		 }
		 visited[x] = true;
		 
		 for(int i=0; i<graph[x].size(); i++) {
			 NodeV nd = graph[x].get(i);
			 if(visited[nd.getVer()]==false) {
				 DFS(nd.getVer(), nd.getEdge()+distance);
			 }
		 }
	}
	
}
