package src.boj.greedy;

import java.io.*;
import java.util.*;

public class Main_백준_1202_보석도둑_골드2_1208ms {
	
	private static class Jewelry implements Comparable<Jewelry>{
		int M, V;
		public Jewelry(int m, int v) {
			super();
			M = m;
			V = v;
		}
		// 무게순으로 오름차순 
		@Override
		public int compareTo(Jewelry o) {
			// TODO Auto-generated method stub
			if(this.M==o.M) {
				return o.V-this.V;
			}
			return this.M-o.M;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 무게순으로 보석을 입력받고 넣음
		PriorityQueue<Jewelry> pq = new PriorityQueue<>();
		int M, V;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			pq.offer(new Jewelry(M, V));
		}
		
		// 가방을 입력받고 무게순으로 오름차순
		int[] bags = new int[K];
		for(int i=0; i<K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bags);
		
		// 더할 수 있는 보석들 중 가치가 가장 높은 것들 위주로 추가
		long total = 0;
		PriorityQueue<Integer> addVal = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i=0; i<K; i++) {
			while(!pq.isEmpty()) {
				if(pq.peek().M<=bags[i]) {
					addVal.offer(pq.poll().V);
				} else break;
			}
			// 한 가방에 하나씩만 들어가니까 하나만 넣어주기
			if(!addVal.isEmpty()) total+=addVal.poll();
			// 어차피 다음에 탐색할 가방은 더 무거운 가방이니까 굳이 비울 필요가 없다.
		}
		
		System.out.println(total);
		
	} // end of main
	
} // end of class 





