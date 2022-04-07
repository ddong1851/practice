package src.boj.dp;

import java.io.*;
import java.util.*;

public class Main_백준_14003_가장긴증가하는부분수열5_플레5_848ms {
	
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
		// 결국 20억짜리를 탐색을 해야한다. LIS 배열을 사용하지 못하는 이유는 꼬이니까
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











