package src.boj.bfs_dfs;

import java.io.*;
import java.util.*;

/** Main_����_9466_��������Ʈ_���3_1304ms*/
public class Main_����_9466_��������Ʈ_���3_1304ms {
	
	private static class cycle{
		int start, len;
		public cycle(int start, int len) {
			super();
			this.start = start;
			this.len = len;
		}
	}

	private static cycle[] teams;
	private static int[] pair;
	private static int left;
	
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		for (int tc = 0; tc < TC; tc++) {
			int n = Integer.parseInt(br.readLine());
			pair = new int[n+1]; // 1~n
			teams = new cycle[n+1]; // 1~n
			left = 0; // ������ ģ���� ī��Ʈ
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=n; i++) {
				pair[i] = Integer.parseInt(st.nextToken());
			}
			
			// ������ ������ ���� cycle�� �����ϰ� �ȴٸ� ������ ������
			// cycle�� �����Ǳ� �ߴµ�, ©���� ����� ��� ����ұ�
			// �߰��� �߸��� ��� ex 1-2-3-4-5-2 --> 2-3-4-5 ����, �̰� 1�� ������ --> ģ�� ���� �����ϴ� �迭�� �������� ( dis[2]-1 ��ŭ�� ģ���� ������ )
			// �ʿ��Ѱ� ���� ���� pair, ģ�� �� ī���� �迭 teams, 
			// + � ģ���� �̹� ����� cycle�� ��� �Ǹ� �� ģ���� ���յ� ������
			
			for(int i=1; i<=n; i++) {
				// �湮���� ���� ��ǥ���
				if(teams[i]==null) {
					go(i, i, 1);
				}
			}
			sb.append(left).append("\n");
		}
		
		System.out.println(sb.toString());
		
	} // end of main

	private static void go(int start, int num, int cnt) {
		// �湮 ó��
		teams[num] = new cycle(start, cnt);
		// ���� ��ǥ
		int next = pair[num];
		// �湮���� ���ٸ�
		if(teams[next]==null) {
			go(start, next, cnt+1);
		} else { // �湮���� �ִٸ�
			// ���� ����Ŭ�� ���� ������ �����ߴٸ�
			if(teams[next].start == start) {
				left += teams[next].len-1;
			}
			// �ٸ� ����Ŭ�� ���� ������ ��Ҵٸ�
			else {
				left += teams[num].len;
			}
		} // end of else
	} // end of go
	
} // end of class 
