package src.boj.mst_union;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** Main_����_1922_��Ʈ��ũ����_���4_620ms*/
public class Main_����_1922_��Ʈ��ũ����_���4_620ms {
	
	private static class Node implements Comparable<Node>{
		int from, to, E;
		public Node(int from, int to, int e) {
			super();
			this.from = from;
			this.to = to;
			E = e;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.E - o.E;
		}
	}
	
	private static Node[] lines;
	private static int N, total;
	private static int[] p;
	
	// ��Ʈ ��带 �����ϸ� ã��
	private static int findSet(int i) {
		if(p[i] == i) return i;
		else return p[i] = findSet(p[i]);
	}
	
	// ���Ͽ� 
	private static boolean union(Node node) {
		// TODO Auto-generated method stub
		int root1 = findSet(node.from);
		int root2 = findSet(node.to);
		// �̹� ���� ��Ʈ��ũ�� ���ߴ����
		if(root1==root2) return false;
		// ��ġ��
		total += node.E;
		p[root2] = root1;
		return true;
	}

	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		/*
		 * ��ǻ�Ϳ� ��ǻ�͸� �����ϴ� ��Ʈ��ũ�� �����϶�.
		 * ��� ��ǻ�Ͱ� ����Ǿ� �ϰ�, �ּ� ������� ��ǻ�͸� �����϶�.
		 * 
		 * --> MST�� �����϶�� ����
		 * 1 <= N <= 1000     	��ǻ���� ��
		 * 1 <= M <= 100000		������ ��
		 * 1 <= C <= 10000		��� 
		 * 
		 * --> ����ġ�� ���� �ִ밪�� 1000000 IntŸ�� 
		 * 
		 * ���� ��� ����ġ�� �����ϴ� ������Ÿ���� �����ϰ�, ���߿� �̸� ������������ ���� -> MST ����
		 */
		
		total = 0;
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		// makeSet
		p = new int[N+1];
		for(int i=1; i<=N; i++) {
			p[i] = i;
		}
		
		lines = new Node[M];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			lines[i] = new Node(from, to, e);
		}
		// �������� ����
		Arrays.sort(lines);
		
		// ���ε� �����Ͽ� 1���� ����
		int cnt = 1;
		for(Node node:lines) {
			if(union(node)) cnt++;
			// N�� ¥�� ��Ʈ��ũ�� �����ߴٸ�
			if(cnt==N) break;
		}
		
		System.out.println(total);
		
	} // end of main
} // end of class





