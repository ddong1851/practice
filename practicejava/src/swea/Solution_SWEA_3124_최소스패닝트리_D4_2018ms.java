package src.swea;

import java.io.*;
import java.util.*;

public class Solution_SWEA_3124_최소스패닝트리_D4_2018ms {
	
	private static class Node implements Comparable<Node>{
		int from, to, Weight;
		public Node(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			Weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			// 현재꺼가 더 작다면 
			if(this.Weight<o.Weight) {
				return -1;
			}
			return 1;
		}
	}
	
	private static int V;
	private static int E;
	private static int from;
	private static int to;
	private static int Weight;
	private static int[] p;
	private static long total;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			Node[] nodes = new Node[E];
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				Weight = Integer.parseInt(st.nextToken());
				nodes[i] = new Node(from, to, Weight);
			}
			
			// 간선의 가중치로 오름차순 정렬
			Arrays.sort(nodes);
			
			// MakeSet
			p = new int[V+1];
			for(int i=1; i<=V; i++) p[i] = i;
			
			total = 0;
			int cnt = 0;
			for(int i=0; i<E; i++) {
				from = nodes[i].from;
				to = nodes[i].to;
				if(union(from, to)) {
					total+=nodes[i].Weight;
					if(++cnt==V-1) break;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(total).append("\n");
		}
		
		System.out.println(sb.toString());
		
		
	} // end of main
	
	private static int findSet(int a) {
		if(a==p[a]) return a;
		else return p[a] = findSet(p[a]);
	}
	
	private static boolean union(int a, int b) {
		int aroot = findSet(a);
		int broot = findSet(b);
		if(aroot == broot) return false;
		p[broot] = aroot;
		return true;
	}
	
} // end of class 












