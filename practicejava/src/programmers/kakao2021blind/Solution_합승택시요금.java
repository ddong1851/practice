package src.programmers.kakao2021blind;

import java.util.*;

public class Solution_�ս��ýÿ�� {
	
	/* int�� �ִ밪�� 21������ ���, 200���� ������ �����ϱ�, �뷫 1õ������ ��Ҵ�. */
	public int INF = 10_000_001;
	public ArrayList<Node>[] nodes;
	public PriorityQueue<Node> pq = new PriorityQueue<>();
	
	public class Node implements Comparable<Node>{
		int edge;
		int cost;
		public Node(int edge, int cost) {
			super();
			this.edge = edge;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}
	
	@SuppressWarnings("unchecked")
	public int solution(int n, int s, int a, int b, int[][] fares) {
        
        /*
         * ���̵�� 
         * 
         * S���� ����Ͽ� 
         * A, B�� ��� �湮�ϴ� ��� �� ���� ����� ������
         * ���ͽ�Ʈ�� or �÷��̵� �� �����ҵ�
         * �� �ϳ��� �ýø� Ż �ʿ䰡 ����, ��� ���������� �ս��ϰ�, �ƴ� �� �ƴϿ��� ��
         * �������� �غ���
         * 
         * ���� �������� Ư������������ ��� + �ش� �������� A���� ��� + �ش� �������� B���� ��� 
         */
		
		// �̸� 1�� ���ؼ� �׻� n+1�� ���� �ʵ��� �Ѵ�.
		n++;
		
		// ������ ������ ���� ArrayList �ʱ�ȭ 
		nodes = new ArrayList[n];
		for(int i=1; i<n; i++) {
			nodes[i] = new ArrayList<Node>();
		}
		
		// ����� ����
		for(int i=0, len=fares.length; i<len; i++) {
			nodes[fares[i][0]].add(new Node(fares[i][1], fares[i][2]));
			nodes[fares[i][1]].add(new Node(fares[i][0], fares[i][2]));
		}
		
		int[] startFromS = makeCostArray(n, s);
		int[] startFromA = makeCostArray(n, a);
		int[] startFromB = makeCostArray(n, b);
		
		// �ʱ� ������ S���� ���� �ýø� Ÿ�� a, b�� �̵��� ���
		int answer = startFromS[a] + startFromS[b];
		int cost = 0;
		for(int i=1; i<n; i++) {
			cost = startFromS[i] + startFromA[i] + startFromB[i];
			if(answer>cost) answer = cost;
		}
		
        return answer;
    } // end of solution 

	private int[] makeCostArray(int n, int start) {
		int[] costs = new int[n];
		Arrays.fill(costs, INF);
		
		pq.offer(new Node(start, 0));
		costs[start] = 0;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int edge = curr.edge;
			
			// �ߺ� ����
			if(costs[edge] < curr.cost) continue;
			
			for(Node next:nodes[edge]) {
				int nextedge = next.edge;
				if(costs[nextedge] > costs[edge] + next.cost) {
					costs[nextedge] = costs[edge] + next.cost;
					pq.offer(new Node(nextedge, costs[nextedge]));
				}
			}
		}
		
		return costs;
	} // end of makeCostArray
	
	
	
} // end of class 







