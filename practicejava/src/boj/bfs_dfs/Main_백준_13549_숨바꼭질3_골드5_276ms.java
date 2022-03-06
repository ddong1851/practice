package src.boj.bfs_dfs;

import java.util.*;

/** Main_백준_13549_숨바꼭질3_골드5_276ms*/
public class Main_백준_13549_숨바꼭질3_골드5_276ms {
	
	private static class Node{
		int place, time;
		public Node(int place, int time) {
			super();
			this.place = place;
			this.time = time;
		}
	} // end of class Node
	
	
	private static int min = Integer.MAX_VALUE;
	private static int sister;
	
	private static void go(int subin) {
		// 수빈이와 동생의 가능한 좌표 0~100000
		boolean [] vis = new boolean[100001];
		Queue<Node> pq = new LinkedList<Node>();
		pq.offer(new Node(subin, 0));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int me = curr.place;
			int time = curr.time;
			// 방문 처리를 여기서하면 아래에서 중복되게 방문처리를 할 필요가 없다
			vis[me] = true;
			// 비교할 필요 없는 지점이라면
			if(time>=min) continue;
			// 도착지에 도달했다면 최소시간 갱신 후 타음 큐 탐색
			if(me==sister) {
				min = Math.min(min, time);
				continue;
			}
			// 범위를 벗어나지 않는 선에서 *2 +1 -1을 한다.
			int next = me*2;
			if(next<=100000 && me<sister && !vis[next]) pq.offer(new Node(next, time));
			next = me + 1;
			if(next<=100000 && me<sister && !vis[next]) pq.offer(new Node(next, time+1));
			next = me - 1;
			if(next>=0 && !vis[next]) pq.offer(new Node(next, time+1));
		} // end of for
	} // end of go()
	
	 public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
		 
		 int subin = sc.nextInt();
		 sister = sc.nextInt();
		 
		 go(subin);
		 
		 System.out.println(min);
		 
	} // end of main
} // end of class
