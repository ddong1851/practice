package src.boj.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/** Main_백준_11286_절댓값힙_실버1_372ms*/
public class Main_백준_11286_절댓값힙_실버1_372ms {
	public static void main(String[] args) throws IOException{
		PriorityQueue<Integer> plus_pq = new PriorityQueue<Integer>();
		PriorityQueue<Integer> minus_pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			switch (num) {
			case 0:
				if(plus_pq.size()==0 && minus_pq.size()==0) {
					sb.append(0+"\n");
				}
				else if(plus_pq.size()==0 && minus_pq.size()!=0) {
					sb.append(minus_pq.poll()+"\n");
				}
				else if(plus_pq.size()!=0 && minus_pq.size()==0) {
					sb.append(plus_pq.poll()+"\n");
				}
				else {
					int plus = Math.abs(plus_pq.peek());
					int minus = Math.abs(minus_pq.peek());
					if(plus==minus) {
						sb.append(minus_pq.poll()+"\n");
					}
					else if(plus>minus) {
						sb.append(minus_pq.poll()+"\n");
					}
					else {
						sb.append(plus_pq.poll()+"\n");
					}
				}
				break;
			default:
				if(num>0)plus_pq.offer(num);
				else minus_pq.offer(num);
				break;
			}
		}
		br.close();
		System.out.println(sb.toString());
	}
}
