package src.boj.greedy;

import java.io.*;
import java.util.*;

public class Main_����_1202_��������_���2_1208ms {
	
	private static class Jewelry implements Comparable<Jewelry>{
		int M, V;
		public Jewelry(int m, int v) {
			super();
			M = m;
			V = v;
		}
		// ���Լ����� �������� 
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
		
		// ���Լ����� ������ �Է¹ް� ����
		PriorityQueue<Jewelry> pq = new PriorityQueue<>();
		int M, V;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			pq.offer(new Jewelry(M, V));
		}
		
		// ������ �Է¹ް� ���Լ����� ��������
		int[] bags = new int[K];
		for(int i=0; i<K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bags);
		
		// ���� �� �ִ� ������ �� ��ġ�� ���� ���� �͵� ���ַ� �߰�
		long total = 0;
		PriorityQueue<Integer> addVal = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i=0; i<K; i++) {
			while(!pq.isEmpty()) {
				if(pq.peek().M<=bags[i]) {
					addVal.offer(pq.poll().V);
				} else break;
			}
			// �� ���濡 �ϳ����� ���ϱ� �ϳ��� �־��ֱ�
			if(!addVal.isEmpty()) total+=addVal.poll();
			// ������ ������ Ž���� ������ �� ���ſ� �����̴ϱ� ���� ��� �ʿ䰡 ����.
		}
		
		System.out.println(total);
		
	} // end of main
	
} // end of class 





