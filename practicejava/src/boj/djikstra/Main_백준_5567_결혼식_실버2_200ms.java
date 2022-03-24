package src.boj.djikstra;

import java.io.*;
import java.util.*;

/** Main_����_5567_��ȥ��_�ǹ�2_200ms*/
public class Main_����_5567_��ȥ��_�ǹ�2_200ms {
	
	private static class Friend{
		int idx, depths;
		public Friend(int idx, int depths) {
			super();
			this.idx = idx;
			this.depths = depths;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		int n1, n2;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			list[n1].add(n2);
			list[n2].add(n1);
		}
		
		int cnt = 0;
		boolean[] friend = new boolean[N+1];
		Queue<Friend> q = new LinkedList<>();
		friend[1] = true;
		q.offer(new Friend(1, 0));
		// ���ͽ�Ʈ��
		while(!q.isEmpty()) {
			Friend curr = q.poll();
			for(int n : list[curr.idx]) {
				if(friend[n]) continue;
				friend[n] = true;
				cnt++;
				// ������� ģ�������� ����
				if(curr.depths==0) {
					q.offer(new Friend(n, curr.depths+1));
				}
			}
		}
		System.out.println(cnt);
	} // end of main
	
	
} // end of class 








