package src.programmers.kakao2021blind;

import java.util.*;

public class Solution_합승택시요금 {
	
	/* int형 최대값을 21억으로 잡고, 200개의 정점이 있으니까, 대략 1천만으로 잡았다. */
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
         * 아이디어 
         * 
         * S에서 출발하여 
         * A, B를 모두 방문하는 경로 중 최저 비용이 얼마인지
         * 다익스트라 or 플로이드 다 가능할듯
         * 꼭 하나의 택시를 탈 필요가 없고, 어느 지점까지만 합승하고, 아닐 땐 아니여도 됨
         * 다익으로 해보자
         * 
         * 시작 지점에서 특점지점까지의 요금 + 해당 지점에서 A까지 요금 + 해당 지점에서 B까지 요금 
         */
		
		// 미리 1을 더해서 항상 n+1을 하지 않도록 한다.
		n++;
		
		// 각각의 지점을 위한 ArrayList 초기화 
		nodes = new ArrayList[n];
		for(int i=1; i<n; i++) {
			nodes[i] = new ArrayList<Node>();
		}
		
		// 양방향 연결
		for(int i=0, len=fares.length; i<len; i++) {
			nodes[fares[i][0]].add(new Node(fares[i][1], fares[i][2]));
			nodes[fares[i][1]].add(new Node(fares[i][0], fares[i][2]));
		}
		
		int[] startFromS = makeCostArray(n, s);
		int[] startFromA = makeCostArray(n, a);
		int[] startFromB = makeCostArray(n, b);
		
		// 초기 정답은 S에서 각각 택시를 타고 a, b로 이동한 방법
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
			
			// 중복 제거
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







