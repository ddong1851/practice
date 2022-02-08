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

/** Main_����_1167_Ʈ��������_���3_796ms*/
public class Main_����_1167_Ʈ��������_���3_796ms {
	
	static boolean[] visited;
	// Node���� ��� ������ ������ �� ����ϴ� ���
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
		 * �� �̻� ����� ������ ���� �� max�� counting �� ����
		 * ��� ����� ������ ���Ͽ� Ž��.
		 * DFS�� Ǯ��� �ϸ� 
		 * �� ������ ������ �׿� ����� ���� �� visited == false�� �� Ž��
		 * --> ���
		 */
		// �������� ���踦 �����ϴ� ����Ʈ
		for(int i=1; i<=V; i++) {
			// ���� �а�
			st = new StringTokenizer(br.readLine());
			// �׷��� ����
			int idx = Integer.parseInt(st.nextToken());
			while(true) {
				// ���õ� ����
				int temp = Integer.parseInt(st.nextToken());
				if(temp==-1) break;
				int distance = Integer.parseInt(st.nextToken());;
				graph[idx].add(new NodeV(temp, distance));
			}
		}
		
		// ������ ���� ���� ���� �� ������ ã�´�
//		DFS()
		visited = new boolean[V+1];
		DFS(1, 0);
		
//		���� �� ��忡���� �Ÿ� 
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
