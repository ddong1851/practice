package src.boj.bfs_dfs;

import java.util.*;

public class Main_백준_16953_AB_실버1_156ms {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long start = sc.nextLong();
		long end = sc.nextLong();
		sc.close();

		Queue<Long> q = new LinkedList<>();
		q.offer(start);

		int time = 0;
		while (!q.isEmpty()) {
			time++;
			for (int i = 0, size = q.size(); i < size; i++) {
				start = q.poll();
				if(start>end) continue;
				if (start == end) {
					System.out.println(time);
					System.exit(0);
				}
				q.offer(2*start);
				q.offer(start * 10 + 1);
			} // end of for
		} // end of while

		System.out.println(-1);

	} // end of main

} // end of class
