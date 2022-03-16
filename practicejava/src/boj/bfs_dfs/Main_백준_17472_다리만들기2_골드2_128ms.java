package src.boj.bfs_dfs;

import java.util.*;
import java.io.*;

// Main_����_17472_�ٸ������2_���2_128ms
public class Main_����_17472_�ٸ������2_���2_128ms {
	
	// ��ǥ�� ������ Ŭ����
	private static class land implements Comparable<land>{
		int row, col, island;
		public land(int row, int col, int island) {
			super();
			this.row = row;
			this.col = col;
			this.island = island;
		}
		@Override
		public int compareTo(land o) {
			// TODO Auto-generated method stub
			return this.island - o.island;
		}
	}
	
	// MST�� ���� class 
	private static class Edge implements Comparable<Edge>{
		int from, dest, length;

		public Edge(int from, int dest, int length) {
			super();
			this.from = from;
			this.dest = dest;
			this.length = length;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.length-o.length;
		}
	}
	
	private static int N;
	private static int M;
	private static int island = 1;
	private static int[][] map;
	// �����¿�
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static PriorityQueue<land> bridge;
	private static PriorityQueue<Edge> edge;

	public static void main(String[] args) throws Exception{
		
		/*
		 * ���� ���� ������ ������
		 * �� ���������� ����-���� �������� �ٸ� ���� ���� �õ�
		 * �̶� �ٸ��� ���� ���� ���ڷθ� ��ġ�� �� �ְ�,
		 * �Ÿ��� 2 �̻��̾�� �Ѵ�. 
		 * 
		 * ��� ���� ����Ǵ� 2 �̻��� �ٸ��� ���� ������ �����ϰ�,
		 * �̸� ���� MST�� �����Ѵ�.
		 * ( ���� �� §��? )
		 * 
		 * �������� �ñ��� ��
		 * ���� �� �� ���̰� 12�� �κγ׼�, 3-5�� ���̰� 2�� 2-5���� ª���� �� ä���� �ȵȰǰ�
		 * �ڼ��� ������ ����, ���̰� 12��� ���÷� ���°���, ������ 12�� �ƴϾ���.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// ������ ������ ������ �켱���� ť
		edge = new PriorityQueue<Edge>();
		// ��� ���� ���� 
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==1) {
					go(i, j);
				}
			}
		}
		
		// MST ���� 
		// ���� ������ŭ ����
		int[] p = new int[island+1];
		for(int i=0; i<=island; i++) {
			p[i] = i;
		}
		
		int distance = 0;
		int cnt = 0;
		int limit = island-2; // 2���� �����ؼ�
		// ���� �켱����ť�� �� ������ �ݺ�
		while(!edge.isEmpty()) {
			Edge curr = edge.poll();
			if(union(curr.from, curr.dest, p)) {
				distance += curr.length;
				// ��� ���� �����ߴٸ� �Ÿ� ��� �� ����
				if(++cnt==limit) {
					System.out.println(distance);
					return;
				}
			}
		}
		// ��� �� ���� ����
		System.out.println(-1);
		
	} // end of main
	
	private static int findSet(int a, int[] p) {
		if(a==p[a]) return a;
		return p[a] = findSet(p[a], p);
	}
	
	private static boolean union(int a, int b, int[] p) {
		int ar = findSet(a, p);
		int br = findSet(b, p);
		if(ar==br) return false;
		p[br] = ar;
		return true;
	}

	// BFS�ε�, �ٸ�ó�� �� ��������?
	private static void go(int sr, int sc) {
		
		bridge = new PriorityQueue<land>();
		// 1 ���� ������
		sameLand(sr, sc, ++island);
		
		while(!bridge.isEmpty()) {
			land curr = bridge.poll();
			int currIsland = curr.island;
			int row = curr.row;
			int col = curr.col;
			for(int i=0; i<4; i++) {
				int cnt = 1;
				while(true) {
					int nr = row+dr[i]*cnt;
					int nc = col+dc[i]*cnt;
					// ������ ����ų�, ���� ���̶��
					if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc]==currIsland) break;
					// �̹߰ߵ� �ٸ� ���� �����ߴٸ�? or �̹� �߰ߵ��� �ִ� ���̶��
					if(map[nr][nc]==1 || map[nr][nc]!=0) {
						// �ٸ��� ���̰� 2 �̻��̶��
						if(cnt>2) {
							// �̹߰ߵ� ���̶��
							if(map[nr][nc]==1) {
								// ���� ǥ��
								sameLand(nr, nc, ++island);
							}
							// ���ۼ� -> ������, �Ÿ�
							edge.offer(new Edge(currIsland, map[nr][nc], cnt-1));
						}
						// �ƹ�ư �ٸ� ���� ������ ����
						break;
					}
					cnt++;
				} // end of while
			} // end of for 4 dir
		} // end of while
	} // end of go
	
	// ���� �������� Ȯ���ϸ鼭 BFS�� �� ��ǥ�� �߰��Ѵ�.
	private static void sameLand(int sr, int sc, int island) {
		// 1 ���� ������
		Queue<land> q = new LinkedList<land>();
		// ���� �� ���� ǥ��
		map[sr][sc] = island;
		bridge.offer(new land(sr, sc, island));
		q.offer(new land(sr, sc, island));
		while(!q.isEmpty()) {
			land curr = q.poll();
			int row = curr.row;
			int col = curr.col;
			for(int i=0; i<4; i++) {
				int cnt = 1;
				while(true) {
					int nr = row+dr[i]*cnt;
					int nc = col+dc[i]*cnt;
					// ������ ����ų� ���� ������ ���� �ƴ� ���
					if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc]==0 || map[nr][nc]==island) break;
					map[nr][nc]=island;
					q.offer(new land(nr, nc, island));
					// Ž���� ��ǥ �߰�
					bridge.offer(new land(nr, nc, island));
					cnt++;
				}
			} // end of for
		} // end of while same land
	} // 
	
	
} // end of class













