package src.boj.djikstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/** Main_����_1238_��Ƽ_���3_*/
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
		 * N���� �л��� N�� ��Ƽ�� �𿩼� ��Ƽ�� ���̱�� �Ѵ�. 
		 * ���� ���̿��� M���� �ܹ���(�ѹ���) ���ε��� �ֿ� i��° �ð��� �����µ� Ti�� �Һ�ȴ�.
		 * ��Ƽ�� �����ϰ�, �ٽ� ������ ���ƿ;� �Ѵ� -> ����Ŭ 
		 * N���� �л��� �� ���� ���°� ���� ���� �ð��� �Һ��ϴ� �л��� �������� ���϶�
		 * 
		 * 1 <= N <= 1000
		 * 1 <= M <= 10000
		 * 
		 * ���ͽ�Ʈ�� ����
		 * �� ��庰�� �켱 �����ϰ�, �л��� �Դٰ��� �ִ�Ÿ��� max�� �����Ѵ�.
		 * �л��� ��� ������ ����, �ٽ� ���ƿ��� �� max���� ������
		 * ( �л����� �ִܰŸ��θ� �Դٰ��� �Ѵ� ) 
		 * 
		 */
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		max = INF;
		int X = Integer.parseInt(st.nextToken());
		
		// 1��1 ��Ī  
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Node>();
		}
		// �׷��� �ʱ�ȭ
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			list[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		
		for(int i=1; i<=N; i++) {
			temp = INF;
			boolean[] visited = new boolean[N+1];
			int goparty = go(i, X, 0, visited); // �������, ��������, �� �Ÿ�, �湮 ����
			visited = new boolean[N+1];
			int returnparty = go(X, i, 0, visited);
			max = Math.max(max, goparty+returnparty);
		}
		
		
		// ���� ���
		System.out.println(max);
		
		
	} // end of main
	
	private static int go(int start, int dest, int total, boolean[] visited) {
		
		if(start==dest) {
			return Math.min(temp, total);
		}
		// �̹� �湮�� �����
		if(visited[start]) return 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		while(!pq.isEmpty()) {
			
		}
		
		return total;
	}
	
	
	
	
	
	
	
	
	
	
	
	
} // end of class 
