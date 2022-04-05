package src.jungol.figure;

import java.io.*;
import java.util.*;

public class Main_����_2577_ȸ���ʹ�_AC_550ms {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		/*
		 * IDEA
		 * 
		 * �ߺ��Ǵ� ĭ���� �Ź� ���� �����ϰ� ���� �ͺ���
		 * �� �� ��ĭ�� ���� �� �ڿ� ���� ���� ���ø� ���°� ����
		 * 
		 * �ʹ��� ���� ��(?) ���� �ʹ��� �����ϴ��� ���ϴ����� Ȯ���ϰ�
		 * �������� �ʴ´ٸ� ���� �ʹ� �߰� ( +1 ) 
		 * 
		 * �����̵� ������� Ǯ�� �Ǵ� ����
		 */
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());
		
		go(arr, N, d, k, c);
		
	} // end of main 

	private static void go(int[] arr, int N, int d, int k, int c) {
		int max = 0;
		int count = 0;
		int[] using = new int[d+1];
		
		Queue<Integer> q = new LinkedList<>();
		// �ʱ� ���� üũ
		int start = 0;
		for(int i=0; i<k; i++) {
			if(using[arr[start]]++==0) 
				count++;
			q.offer(arr[start++]);
		}
		
		max = count;
		if(using[c]==0) max++;
		if(max==k+1) {
			System.out.println(k+1);
			return;
		}
		
		// i���� �����ϴ� ��� ������ Ȯ��
		for(int i=1; i<N; i++) {
			// 1. ù��°�� ����
			if(--using[q.poll()]==0) --count;
			// 2. �� ���� ���ο� �ʹ� �߰�
			if((using[arr[(i+k-1)%N]]++)==0) count++;
			q.offer(arr[(i+k-1)%N]);
			// 3. ���� �ʹ� �߰� ���� Ȯ��
			if(using[c]==0) count++; // ���� �߰� 
			// 4. �ִ� �ʹ� ���� �� ���� 
			if(max<count) max = count; 
			// 5. ������ �־��ٸ� ����
			if(using[c]==0) count--;
			// 6. ���� �ʹ� ���� ���� k+1�̸� ������ �ִ�ϱ� ����
			if(max == k+1) break;
		}
		System.out.println(max);
	}
	
} // end of class