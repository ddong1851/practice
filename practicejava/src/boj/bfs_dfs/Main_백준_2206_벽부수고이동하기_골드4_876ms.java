package src.boj.bfs_dfs;

import java.io.*;
import java.util.*;


/*
 * ��� ���� �ѹ��� �μź��鼭 ���Ʈ�����ϱ⿣ N, M�� ũ�Ⱑ �ʹ� ū ���
 * 3���� �迭�� ����Ͽ� ���� �μ� ���� �μ��� ���� ��츦 ���� �����غ��ƶ�.
 * Ȥ�� ��� ���� ����? 3���� �迭�� �����ؼ� ����غ���
 * �ѹ��� Ž������ ��Ʈ��ŷ�� ���� ȿ���� ���� �� �ִ� ������ �ִ�.
 */

/** Main_����_2206_���μ����̵��ϱ�_���4_876ms*/
public class Main_����_2206_���μ����̵��ϱ�_���4_876ms {
	
	private static class Node{
		int row, col, depth, destroyed;
		public Node(int row, int col, int depth, int destroyed){
			this.row = row;
			this.col = col;
			this.depth = depth;
			this.destroyed = destroyed;
		}
	}
	
	private static int N;
	private static int M;
	private static char[][] map;
	private static boolean[][][] visited;
	// �� �� �� �� �������� �����̸� �밢�� �Ʒ� ���� �켱�̴ϱ�
	private static int[] dr = {0, 1, 0, -1};
	private static int[] dc = {1, 0, -1, 0};
	
	private static void go() {
		// �湮ó��
		visited[0][0][0] = visited[0][0][1] = true;
		Queue<Node> q = new LinkedList<Node>();
		// ù ������ 1ĭ���� ��������
		q.offer(new Node(0, 0, 1, 0));
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int row = curr.row;
			int col = curr.col;
			// ��ǥ������ �����ߴ����
			if(row==N-1 && col==M-1) {
				System.out.println(curr.depth);
				return;
			}
			// 4�� Ž��
			for(int i=0; i<4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				int destroyed = curr.destroyed;
				// ������ ����ٸ�
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				// ��ĭ�̶��
				if(map[nr][nc]=='0') {
					// ���� ���� �Ȳ���, �湮������ �ִ� ��ǥ���� Ȯ��
					if(!visited[nr][nc][destroyed]) {
						visited[nr][nc][destroyed] = true;
						q.offer(new Node(nr, nc, curr.depth+1, destroyed));
					}
				}
				// ���̶��
				else if(map[nr][nc]=='1') {
					// �̹� �ٸ� ���� �μ����� �ִٸ� ���� Ž��
					if(destroyed!=0) {
						continue;
					}
					// ���� ���� ������ ���� ���
					else {
						// �ش� ���� ���� ���� �ִٰ� ǥ��
						visited[nr][nc][destroyed+1] = true;
						q.offer(new Node(nr, nc, curr.depth+1, 1));
					}
				}
			} // end of for move
		} // end of while 
		
		System.out.println(-1);
		
	} // end of go()
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M][2];
		for(int i=0; i<N; i++) {
			String temp = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		// BFS
		go();
		
	} // end of main
	
} // end of class
