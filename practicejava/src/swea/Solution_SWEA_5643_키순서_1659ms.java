package src.swea;

import java.io.*;
import java.util.*;

public class Solution_SWEA_5643_Å°¼ø¼­_1659ms {
	private static class Node implements Comparable<Node>{
		int to, dis;
		public Node(int to, int dis) {
			super();
			this.to = to;
			this.dis = dis;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.dis - o.dis;
		}
	}

	private static int N, M, a, b, cnt;
	private static final int INF = 999_999_999;
	private static List<Node>[] list;
	private static int[] dist, vis;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		for (int test = 1; test <= TC; test++) {

			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			vis = new int[N+1];
			list = new ArrayList[N+1];
			for(int i=1; i<=N; i++) {
				list[i] = new ArrayList<Node>();
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				list[a].add(new Node(b, 1));
			}
			
			for(int i=1; i<=N; i++) {
				go(i);
			}
			
			cnt = 0;
			for(int i=1; i<=N; i++) {
				if(vis[i]==N-1) cnt++;
			}
			sb.append("#").append(test).append(" ").append(cnt).append("\n");
		} // end of for TC
		System.out.println(sb.toString());
	} // end of main 
	
	private static void go(int start) {
		boolean[] visited = new boolean[N+1];
		
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			if(visited[curr.to]) continue;
			visited[curr.to] = true;
			for(Node next:list[curr.to]) {
				if(!visited[next.to] && dist[next.to] > dist[curr.to] + curr.dis) {
					dist[next.to] = dist[curr.to] + curr.dis;
					vis[next.to]++;
					vis[start]++;
					pq.offer(new Node(next.to, dist[next.to]));
				}
			}
		} // end of while 
		
	} // end of go
} // end of class 


//1
//6
//6
//1 5
//3 4
//5 4
//4 2
//4 6
//5 2

//1
//6
//7
//1 3
//1 5
//3 4
//5 4
//4 2
//4 6
//5 2

//1
//6
//3
//1 2
//2 3
//4 5
