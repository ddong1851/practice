package src.boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/** Main_����_1679_���ٲ���_�ǹ�1_212ms*/
public class Main_����_1679_���ٲ���_�ǹ�1_212ms {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// �������� ��ġ
		int n = Integer.parseInt(st.nextToken());
		// ������ ��ġ
		int k = Integer.parseInt(st.nextToken());
		// ������ ��� ��ǥ, 0~100000
		int [] position = new int[100001];
		
		// �̵� ���� ����, ���� ���� 1, -1, *2 
		// ���� ��ǥ�� �����ϴ� �迭�� �����, �ش� �迭�� �����ϴµ� �ɸ��� �ð��� �� ��ǥ�� min�� ����Ͽ� ��������
		if(n==k) {
			System.out.println(0);
			System.exit(0);
		}
		else {
			solution(n, k, position);
		}
	} // end of main

	private static void solution(int n, int k, int[] position) {
		// TODO Auto-generated method stub
		// ����, ù ��ǥ������ ��, ��, x2�� �̵��� ���� �Ұǵ�, ���ķ� ��� ��ǥ�� ���� -1, 1, x2�� �����ϰ�, �ҿ� �ð��� �������
		Deque<Integer> deque = new ArrayDeque<Integer>();
		boolean [] visited = new boolean[100001];
		deque.add(n);
		position[n]=0;
		visited[n] = true;
		// � ���ǿ� ���� ť�� �������ΰ�?, �ϴ� ����� ������ ��������!(ó�� ��� ���̶�� ���� ���� �� �� �ִ°� �ƴѰ�
		while(!deque.isEmpty()) {
			// 3�� Ž��, 
			int x = deque.poll();
			for(int i=0; i<3; i++) {
				int nx = x;
				// ��ǥ �̵� �� k�� �ƴ϶�� ť�� �߰�
				if(i==0) {
					nx++;
				}
				else if(i==1) {
					nx--;
				}
				else {
					nx*=2;
				}
				// ������ ����ٸ�
				if(nx<0 || nx>=100001) {
					continue;
				}
				// �湮�� ��ǥ���
				if(visited[nx]==true) {
					continue;
				}
				// �̹湮�Ǿ��ٸ�
				if(position[nx]==0 && visited[nx]==false) {
					position[nx] = position[x]+1;
					deque.add(nx);
					visited[nx] = true;
					if(nx==k) {
						System.out.println(position[nx]);
						System.exit(0);
					}
				}
			}
		} // end of while 
	} // end of solution
} // end of class


