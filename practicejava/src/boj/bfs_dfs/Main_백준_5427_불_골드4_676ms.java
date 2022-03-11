package src.boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** Main �� 5427*/
public class Main_����_5427_��_���4_676ms {
	private static class Node{
		int row, col;
		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	private static int sr, sc, W, H;
	private static Queue<Node> q, fire;
	private static char[][] map;
	private static int[][] vis;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	/** ���� ������ �޼���*/
	private static void spreadFire() {
		/** ť�� ����� �ҿ� ������ŭ �ݺ��ϸ鼭 ����*/
		for(int repeat=0, len=fire.size(); repeat<len; repeat++) {
			Node curr = fire.poll();
			for(int i=0; i<4; i++) {
				int nr = curr.row + dr[i];
				int nc = curr.col + dc[i];
				// ���� üũ
				if(nr<0 || nr>=H || nc<0 || nc>=W) continue;
				// ��ĭ�̸� ���� ������.
				if(map[nr][nc]=='.') {
					map[nr][nc]='*';
					// ���� ��ġ ���
					fire.offer(new Node(nr, nc));
				}
			} // end of for 4 dir 
		} // end of for 
	} // end of spreadfire
	
	/** BFS �˰���*/
	private static String go() {
		// ���� ��ǥ ��ĭ���� ǥ��
		map[sr][sc] = '.';
		vis = new int[H][W];
		vis[sr][sc] = 1;
		q = new LinkedList<Node>();
		q.offer(new Node(sr, sc));
		
		while(!q.isEmpty()) {
			// ���� ������
			for(int repeat=0, len=q.size(); repeat<len; repeat++) {
				Node curr = q.poll();
				int row = curr.row;
				int col = curr.col;
				// �ش� ��ǥ�� �ҿ� ź �����̶�� 
				if(map[row][col]=='*') continue;
				for(int i=0; i<4; i++) {
					int nr = row + dr[i];
					int nc = col + dc[i];
					// �迭 ������ �����ٸ�
					if(nr<0 || nr>=H || nc<0 || nc>=W) {
						return String.valueOf(vis[row][col]);
					}
					// �� �� �ִ� ��ǥ���
					else if(map[nr][nc]=='.' && vis[nr][nc]==0) {
						vis[nr][nc] = vis[row][col]+1;
						q.add(new Node(nr, nc));
					}
				} // end of 4�� Ž��
			} // end of for
			spreadFire();
		} // end of while
		// Ż������ ���� ��� 
		return "IMPOSSIBLE";
	} // end of go
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());
		
		/*
		 * ����� �̵� -> �� �̵� 
		 * ����� ��ǥ�� �ҿ� ź ��ǥ���� Ȯ�� �� �� ���� �ݺ�
		 * �迭�� ����� Ż�� ����, ����� ���ѵ�� Ż�� ����
		 */
		
		for(int tc = 1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			fire = new LinkedList<>();
			map = new char[H][W];
			for(int i=0; i<H; i++) {
				String temp = br.readLine();
				for(int j=0; j<temp.length(); j++) {
					map[i][j] = temp.charAt(j);
					// ������� ��ġ ����
					if(temp.charAt(j)=='@') {
						sr=i; sc=j;
					}
					// ���� ��ġ ����
					else if(temp.charAt(j)=='*') {
						fire.offer(new Node(i, j));
					}
				}
			}
			// BFS���鼭 ���� ����
			sb.append(go()).append("\n");
		} // end of for tc 
		System.out.println(sb.toString());
	} // end of main
} // end of class
