package src.boj.bfs_dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/** Main_����_13913_���ٲ���4_���4_388ms*/
public class Main_����_13913_���ٲ���4_���4_388ms {
	
	public static int next;
	private static int K;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		K = sc.nextInt();
		if(N==K) {
			System.out.println(0);
			System.out.println(N);
			return;
		}
		else {
			// BFS Ž��
			go(N);
		}
		
	} // end of main

	private static void go(int n) {
		int[] vis = new int[100001];
		Arrays.fill(vis, -1);
		vis[n] = n;
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		int time = 0;
		while(!q.isEmpty()) {
			for(int i=0, len=q.size(); i<len; i++) {
				int curr = q.poll();
				// ���� ����
				if(curr==K) {
					StringBuilder sb = new StringBuilder();
					sb.append(time).append("\n");

					Stack<Integer> stack = new Stack<>();
					stack.push(curr);
					int parent = vis[curr];
					// �θ� ��� ���󰡱�
					while(true) {
						stack.push(parent);
						if(parent==n) {
							while(!stack.isEmpty()) sb.append(stack.pop()).append(" ");
							break;
						}
						parent = vis[parent];
					} // end of while 
					System.out.println(sb.toString());
					return;
				} // end of ��������
				// ���ϱ� 2 
				next = 2*curr;
				if(next<=100000 && curr<K && vis[next]==-1) {
					vis[next] = curr; // �θ� ����
					q.offer(next);
				}
				// ���ϱ� 1
				next = curr+1;
				if(curr<K && vis[next]==-1) {
					vis[next] = curr; // �θ� ����
					q.offer(next);
				}
				// ���� 1 
				next = curr-1;
				if(next>=0 && vis[next]==-1) {
					vis[next] = curr; // �θ� ����
					q.offer(next);
				}
			} // end of for size
			time++;
		} // end of while 
	} // end of go 
} // end of class 
