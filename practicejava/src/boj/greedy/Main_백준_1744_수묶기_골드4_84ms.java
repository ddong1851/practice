package src.boj.greedy;

import java.io.*;
import java.util.*;

public class Main_����_1744_������_���4_84ms {
	
	public static void main(String[] args) throws Exception{
		
		/*
		 * ����� �� ū ������ ����
		 * ������ �� ���� ���� ������ ���´�.
		 * 
		 * ���ť
		 * Zero boolean (������ ������ ���� �༮�ε�, �ϳ� ����� �� �������Ŵϱ� boolean���� ����.
		 * ����ť�� ����
		 * 
		 * ����� ū������ ��� ���ϰ�
		 * ������ ���������� ��� ���Ѵ�.
		 * 
		 * ������ ���Ҵ����, zero�� �־����� ���ؼ� 0���� ó���ظ����
		 * zero�� ������ ���ع�����.
		 * 
		 * ����� ¦�� ���°� ���ع�����.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> plusQ = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minusQ = new PriorityQueue<>();
		boolean zero = false;
		int temp = 0;
		for(int i=0; i<N; i++) {
			temp = Integer.parseInt(br.readLine());
			if(temp>0) plusQ.offer(temp);
			else if(temp<0) minusQ.offer(temp);
			else zero = true;
		}
		
		int ans = 0;
		int add, mult = 0;
		
		int curr, next;
		// 1. ���ť ¦�� ���缭 ���Ѵ�.
		while(!plusQ.isEmpty()) {
			// �ϳ��� ���� ����.
			curr = plusQ.poll();
			// ���� ���� ���� �� 
			if(plusQ.peek()!=null) {
				next = plusQ.poll();
				add = curr+next;
				mult = curr*next;
				// �� ���� ���� �Ͱ� ���� ���� ���ؼ� �� ū ���� �ִ´� ( 1 1 1 1 1�� ��� ���Ѱ� �� ũ�ϱ� �����ش� )
				if(mult>add) ans+=mult;
				else ans+=add;
			}
			// ¦�� ���� ���
			else {
				ans += curr;
			}
		} // end of while plus 
		
		// 2. ����ť ¦�� ���缭 ���Ѵ�.
		while(!minusQ.isEmpty()) {
			curr = minusQ.poll();
			if(minusQ.peek()!=null) {
				next = minusQ.poll();
				mult = curr*next;
				ans+=mult;
			}
			// ¦�� ���� ������ �� zero�� �ִٸ� �ȴ��ϰ�, ���ٸ� ���Ѵ�.
			else {
				if(!zero) ans+=curr;
			}
		}
		
		System.out.println(ans);
		
	} // end of main
	
} // end of class 







