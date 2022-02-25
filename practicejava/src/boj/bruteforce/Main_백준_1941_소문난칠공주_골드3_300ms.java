package src.boj.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_����_1941_�ҹ���ĥ����_���3_300ms{
	
	private static class Node{
		int row, col;
		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	private static boolean[][] visited;
	private static char[][] map;
	private static int total;
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		
		/*
		 * BFS�� �����ؾ� �� 
		 * �켱 25C7 ( S >= 4 )�� �̰� --> �� ����� �ƴϸ� ��� üũ�� �ؾ���
		 * ������ ��ǥ���� ���������� üũ -> BFS��
		 * 
		 * + DFS�� �����غôµ�, ���� �ȵ˴ϴ�. 
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[5][5];
		for(int i=0; i<5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		total = 0;
		go(0, 0, 0, new boolean[25]); // ������, �̴ټ���, ������, �湮�迭
		
		System.out.println(total);
	} // end of main 

	private static void go(int start, int S, int picked, boolean[] vis) {
		// �ӵ����İ� 4�� �̻��̸� return
		if(picked-S>=4) return;
		// S�� 4�̻��̰�, 7���� �̾��� ��
		if(picked==7) {
			// ������ ��ĭ ���������Ƿ� �ڷ� ��ĭ
			BFS((start-1)/5, (start-1)%5, vis);
			return;
		}
		// ���� �˰���
		for(int i=start; i<25; i++) {
			vis[i] = true;
			if(map[i/5][i%5]=='S') go(i+1, S+1, picked+1, vis);
			else go(i+1, S, picked+1, vis);		
			vis[i] = false;
		}
		
	} // end of go 

	// row col���� �����Ͽ� ������ ��ǥ�� �� vis�� ���� ��ǥ�� �ִ��� Ȯ��
	private static void BFS(int sr, int sc, boolean[] vis) {
		visited = new boolean[5][5];
		visited[sr][sc] = true;
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(sr, sc));
		int cnt=1;
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int row = curr.row;
			int col = curr.col;
			for(int i=0; i<4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				// ������ ����ų�, �̹� �湮�� �����̶��
				if(nr<0 || nr>=5 || nc<0 || nc>=5 || visited[nr][nc]) continue;
				// ������ ������ �ƴ϶��
				if(!vis[nr*5+nc]) continue;
				// ������ �����̰�, �湮���� ���� ��ǥ���
				q.offer(new Node(nr, nc));
				visited[nr][nc] = true;
				cnt++;
			} // end of for dir 
		} // end of while 
		// ��� ��ΰ� ����Ǿ��� �� 
		if(cnt==7) total++;
	} // end of BFS 
} // end of class 






