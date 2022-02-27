package src.boj.djikstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/** Main_����_2665_�̷θ����_���4_136ms*/
public class Main_����_2665_�̷θ����_���4_136ms {
	
	private static class Node implements Comparable<Node>{
		int row, col, weight;

		public Node(int row, int col, int weight) {
			super();
			this.row = row;
			this.col = col;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
	}
	
	private static int n;
	
	private static int go(char[][] map) {
		// TODO Auto-generated method stub
		// �Ÿ� ���� �迭
		int [][]distance = new int[n][n];
		for(int i=0; i<n; i++) {
			Arrays.fill(distance[i], 10000);
		}
		// 1�� ��ĭ�̴�..... 
		// ù ��ǥ������ �� ������ map[0][0]���� �ʱ�ȭ ( Math.abs���� -'1' * -1�� �� �������� ���� ) 
		// ���� �غ��� �ð��� ������ ������..
		distance[0][0] = (map[0][0]-'1')*-1;
		// �����¿�
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(0, 0, distance[0][0]));
		
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int row = curr.row;
			int col = curr.col;
			for(int i=0; i<4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				// ������ ����ٸ�
				if(nr<0 || nr>=n || nc<0 || nc>=n) continue;
				// ��ĭ�̸� 0 ���� ������ 1 
				int wall = (map[nr][nc]-'1')*-1;
				// �ʱ�ȭ���� ���ų�, �� ȿ������ ��ΰ� �ִٸ� ����
				if(distance[nr][nc]>distance[row][col] + wall) {
					distance[nr][nc] = distance[row][col] + wall;
					pq.offer(new Node(nr, nc, distance[nr][nc]));
				}
			}
		}
		
		return distance[n-1][n-1];
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 1 <= n <= 50 �迭�� ũ��
		
		/*
		 * ���̵�� ���� �ִ� ��ġ�� ����ġ�� 1�� �ΰ�, ���� ���� ������ 0���� �Ѵ�.
		 * (0, 0) -> (n-1, n-1)���� �� �� ����ġ�� ���� ���� ���� ���� ���
		 * --> ���ͽ�Ʈ�� �����̴�
		 * 
		 * ����ġ�� ������ distance �迭 
		 * map �迭 
		 * + toCharArray�� ����ϱ� ���� �׵θ��� ��ġ���� �ʾҽ��ϴ�. 
		 */
		
		char[][] map = new char[n][];
		for(int i=0; i<n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		System.out.println(go(map));
	}
}
