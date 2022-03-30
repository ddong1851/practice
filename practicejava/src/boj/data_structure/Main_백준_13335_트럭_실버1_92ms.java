package src.boj.data_structure;

import java.io.*;
import java.util.*;

/** Main_����_13335_Ʈ��_�ǹ�1_148ms*/
public class Main_����_13335_Ʈ��_�ǹ�1_92ms {
	
	private static class Truck{
		int weight, time;
		public Truck(int weight, int time) {
			super();
			this.weight = weight;
			this.time = time;
		}
	}
	

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		/*
		 * Ʈ���� ��		1 <= n <= 1000
		 * �ٸ��� ����		1 <= w <= 100
		 * �ٸ��� �ִ� ����	10<= L <= 1000
		 * �� Ʈ���� ����	1 <= ai<= 10
		 * 
		 * �ð� 1�� 1ĭ�� ������ �� �ִ�.
		 * ��� Ʈ���� �ٸ��� �ǳʴ� �ִ� �ð��� ����϶�.
		 * 
		 * �� �� Ʈ������ �̵�
		 * �ٸ����� Ż���԰� ���ÿ� �ٸ� Ʈ���� �ٸ� ���� �ö�� �� �ִ�.
		 * �ٸ��� ���̸�ŭ�� ���� ������ �ٸ� ���� �ִ� Ʈ�� �� ���� �� Ʈ���� ����.
		 * ���ο� Ʈ���� �ٸ� ���� �ö�� �� �ִٸ� �ø���, �Ұ��ϸ� �ø��� �ʴ´�.
		 * 
		 * �ٸ� ť�� �����, Ʈ���� �ٸ��� �ö� ������ �ð��� ���. ���� �ð� - ��� = �ٸ��� ���̰� �Ǹ� Ż��
		 * �ٸ� �� ���� ����
		 * ���� �ð� ����
		 * Ʈ�� ť
		 */
		
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int maxWeight = Integer.parseInt(st.nextToken());
		
		Queue<Integer> trucks = new LinkedList<Integer>();
		Queue<Truck> Bridge = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) trucks.add(Integer.parseInt(st.nextToken()));
		
		int time = 0;
		int currWeight = 0;
		int passed = 0;
		// Ʈ���� ������ŭ ������� ���ߴٸ� �ݺ�
		while(passed<n) {
			//1. Ʈ�� �̵�, �ٸ� ���� Ʈ���� ���� ��
			if(Bridge.peek()!=null) {
				if(time - Bridge.peek().time == w) {
					// �ٸ� �� �տ� �ִ� Ʈ���� �����鼭 ���� ���� ����
					currWeight-=Bridge.poll().weight;
					passed++;
				}
			}
			
			//2. �ٸ� ���� Ʈ���� �ö� �� �ִ��� Ȯ��
			if(!trucks.isEmpty()) {
				// ���� ���� + ���� Ʈ���� ���� <= �ִ� ������ ��� �߰�
				if(currWeight+trucks.peek()<=maxWeight) {
					currWeight+=trucks.peek();
					Bridge.offer(new Truck(trucks.poll(), time));
				}
			}
			time++;
		}
		System.out.println(time);
		
		
	} // end of main
	
	
} // end of class 






