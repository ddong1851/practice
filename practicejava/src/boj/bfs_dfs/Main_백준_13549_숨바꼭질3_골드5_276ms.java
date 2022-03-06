package src.boj.bfs_dfs;

import java.util.*;

/** Main_����_13549_���ٲ���3_���5_276ms*/
public class Main_����_13549_���ٲ���3_���5_276ms {
	
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
		// �����̿� ������ ������ ��ǥ 0~100000
		boolean [] vis = new boolean[100001];
		Queue<Node> pq = new LinkedList<Node>();
		pq.offer(new Node(subin, 0));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int me = curr.place;
			int time = curr.time;
			// �湮 ó���� ���⼭�ϸ� �Ʒ����� �ߺ��ǰ� �湮ó���� �� �ʿ䰡 ����
			vis[me] = true;
			// ���� �ʿ� ���� �����̶��
			if(time>=min) continue;
			// �������� �����ߴٸ� �ּҽð� ���� �� Ÿ�� ť Ž��
			if(me==sister) {
				min = Math.min(min, time);
				continue;
			}
			// ������ ����� �ʴ� ������ *2 +1 -1�� �Ѵ�.
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
