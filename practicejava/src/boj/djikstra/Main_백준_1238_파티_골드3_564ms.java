package src.boj.djikstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/** Main_����_1238_��Ƽ_���3_564ms*/
public class Main_����_1238_��Ƽ_���3_564ms {
	
	private static class Node implements Comparable<Node>{
		int Ver;
		int len;
		public Node(int Ver, int len) {
			super();
			this.Ver = Ver;
			this.len = len;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.len - o.len;
		}
	}
	
	private static final int inf = 999_999_999;
	private static int N;
	private static int M;
	private static ArrayList<Node>[] list;
	private static int[] distance;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		// �ʱ�ȭ
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Node>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int curr = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			list[curr].add(new Node(next, len));
		}
		
		// ��� �������� X�� ���°� �ɸ��� �Ÿ�
		int[] lengo = new int[N+1];
		// ��� ������ X�� ���µ� �ɸ��� �Ÿ� ����
		for(int i=1; i<=N; i++) {
			go(i);
			lengo[i] = distance[X];
		}
		// X���� ��� ��ǥ�� ����
		go(X);
		// �ִ� �Ÿ� ����, ������ go(X)���� distance�� X���� ����ϴ� ��� ��ǥ �Ÿ��� �ٲ�� ������ 
		int max = 0;
		for(int i=1; i<=N; i++) {
			int total = lengo[i]+distance[i];
			if(max<total) {
				max = total;
			}
		}
		
		System.out.println(max);
		
	} // end of main

	private static void go(int start) {
		
		distance = new int[N+1];
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		// ������ ��带 �����, ���� ��尡 Start�̰�, weight=0;
		pq.offer(new Node(start, 0));
		// INF ���Ƿ� �ο�
		Arrays.fill(distance, inf);
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int currVer = curr.Ver;
			// �湮 ó��. ��������� �Դٰ��� �� �� �ֱ� ������
			if(!visited[currVer]) {
				visited[currVer] = true;
			}
			for(int len=list[currVer].size(), i=0; i<len; i++) {
				Node next = list[currVer].get(i);
				int nextVer = next.Ver;
				int nextE = next.len;
				// �ʱ�ȭ���� �ʾҰų� �� ���� ���� ���´ٸ�
				if(distance[nextVer]==inf || distance[nextVer] > distance[currVer] + nextE) {
					distance[nextVer] = distance[currVer] + nextE;
					pq.offer(new Node(nextVer, distance[nextVer]));
				}
			}
		}
	} // end of go dijkstra

	
} // end of class 
