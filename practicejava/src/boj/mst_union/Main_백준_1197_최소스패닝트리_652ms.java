package src.boj.mst_union;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 크루스칼을 활용하여 MST를 구현하는 간단한 예제
/** Main_백준_1197_최소스패닝트리_652ms*/
public class Main_백준_1197_최소스패닝트리_652ms {
	
	private static class Node implements Comparable<Node>{
		int from, to, weight;
		public Node(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			// 현재꺼가 더 작다면 
			if(this.weight<o.weight) {
				return -1;
			}
			return 1;
		}
	}
	
	private static int N;
	private static Node[] list;
	private static int[] p;
	
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
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		list = new Node[M];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[i] = new Node(from, to, weight);
		}
		// makeSet 
		p = new int[N+1];
		for(int i=1; i<=N; i++) {
			p[i] = i;
		}
		// 오름 차순 정렬
		Arrays.sort(list);
		
		int total=0;
		int cnt = 0;
		for(int i=0; i<M; i++) {
			Node curr = list[i];
			if(union(curr.from, curr.to)) {
				total+=curr.weight;
				++cnt;
			}
			if(cnt==N-1) {
				break;
			}
		}
		
		System.out.println(total);
		
	} // end of main
	
} // end of class













