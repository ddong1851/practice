package src.boj.dp;

import java.io.*;
import java.util.*;

public class Main_����_12015_����������ϴºκм���2_���2_460ms {
	
	private static int[] LIS;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		/*
		 * ����Ž���� �̿��� LIS�� �ϸ�
		 * LIS[]�� ����� ���� �� 
		 * LIS[] < arr[i] <= LIS[k] �� �κ��� ã�Ƽ�
		 * LIS[k] = arr[i] �� �����Ѵ�.
		 * �̴�, k�� ������ LIS�� �̷�� �ּҰ��� �����ϴ� �ൿ�̴�.
		 * 
		 */
		
		int[] arr = new int[N];
		LIS = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int len = 0;
		int idx = 0;
		for (int i = 0; i < N; i++) {
			// Ž���� ���ڰ� ���� ������ ũ�� ����
			if(arr[i] > LIS[len]) {
				// ����+1 �� �ش� �� ����
				LIS[++len] = arr[i];
			}
			// ���ο� ���� num ������ �ּڰ��� �ִ밪 ���̿� �ִ� ���̶�� ����Ž���� ���� ���� �� ����
			else {
				idx = binarySearch(0, len, arr[i]);
				LIS[idx] = arr[i];
			}
		}
		// ��� Ž���� ������ LEN�� ���̰� ��ü LIS�� �ִ밪�� �ȴ�.
		System.out.println(len);
		
	} // end of main 

	private static int binarySearch(int low, int high, int key) {
		int mid = 0;
		while(low<high) {
			mid = (low+high)/2;
			if(LIS[mid] < key) low = mid+1;
			else high = mid;
		}
		return high;
	}
	
} // end of class 








