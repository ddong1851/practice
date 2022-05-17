package src.boj.bfs_dfs;

import java.io.*;
import java.util.*;

public class Main_백준_12851_숨바꼭질2_골드5_204ms {
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(N!=K) {
			Queue<Integer> q = new LinkedList<Integer>();
			boolean[] vis = new boolean[100_001];
			
			q.offer(N);
			boolean found = false;
			int turn = 0;
			int cnt = 0;
			int curr = 0;
			int next = 0;
			final int max = 100000;
			
			while(true) {
				for(int i=0, size=q.size(); i<size; i++) {
					curr = q.poll();
					vis[curr] = true;
					if(curr==K) {
						found = true;
						cnt++;
					} // end of if found 
					// 순간이동
					next = curr*2;
					if(next<=max && curr<K && !vis[next]) q.offer(next);
					// +1
					next = curr+1;
					if(next<=max && curr<K && !vis[next]) q.offer(next);
					// -1
					next = curr-1;
					if(next>=0 && !vis[next]) q.offer(next);
				} // end of for each turns
				if(found) break;
				turn++;
			} // end of while found 
			System.out.println(turn);
			System.out.println(cnt);
		} else {
			System.out.println(0);
			System.out.println(1);
		}
	} // end of main 
} // end of class 















