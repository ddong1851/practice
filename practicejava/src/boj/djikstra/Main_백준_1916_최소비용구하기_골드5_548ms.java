package src.boj.djikstra;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * �湮ó���� ���ŵ� distance������ Ȱ���ϱ�
 * + �ߺ��� ���� ���� ������ ��ȸ���� �ʴ� ����ġ�� if(distance[curr] > curr.weigth) continue;
 */

/** Main_����_1916_�ּҺ�뱸�ϱ�_���5_548ms*/
public class Main_����_1916_�ּҺ�뱸�ϱ�_���5_548ms {
	// Node��� ������Ÿ�� ����
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
		
		N = Integer.parseInt(br.readLine()); // ������ ���� 1<= N <= 1000
		int M = Integer.parseInt(br.readLine()); // ������ ���� 1<= M <= 100_000
		// ���� ����Ʈ �ʱ�ȭ
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
		// ���� ������ ������ ����
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
			// �ߺ��� ���� ���� ����ġ��, �� weight�� �� ū ���̸� ��ȸ�� �ʿ䰡 ����
			if(distance[currver] < curr.wei) continue;
			// ���� ������ ����� ������ Ž��
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





