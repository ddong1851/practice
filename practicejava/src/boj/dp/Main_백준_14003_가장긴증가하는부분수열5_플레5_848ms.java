package src.boj.dp;

import java.io.*;
import java.util.*;

public class Main_����_14003_����������ϴºκм���5_�÷�5_848ms {
	
	private static int[] LIS;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int[] path = new int[N];
		Arrays.fill(path, -1);
		path[0] = 0;
		
		LIS = new int[N+1];
		LIS[0] = -1_000_000_001;
		
		int len = 0;
		int idx = 0;
		for(int i=0; i<N; i++) {
			if(LIS[len]<arr[i]) {
				LIS[++len] = arr[i];
				path[i] = len;
			}
			else {
				idx = binarySearch(0, len, arr[i]);
				LIS[idx] = arr[i];
				path[i] = idx;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(len).append("\n");
		Stack<Integer> stack = new Stack<>();
		// �ᱹ 20��¥���� Ž���� �ؾ��Ѵ�. LIS �迭�� ������� ���ϴ� ������ ���̴ϱ�
		for(int i=N-1; i>=0; i--) {
			if(len==path[i]) {
				len--;
				stack.push(arr[i]);
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb.toString());
	} // end of main
	
	private static int binarySearch(int low, int high, int key) {
		int mid = 0;
		while(low<high) {
			mid = (low+high)/2;
			if(LIS[mid]<key) low = mid+1;
			else high = mid;
		}
		return high;
	} // end of BS
	
} // end of class 











