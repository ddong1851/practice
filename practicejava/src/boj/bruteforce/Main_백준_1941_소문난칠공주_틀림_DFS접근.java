package src.boj.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/** 1941 �ҹ��� ĥ����  */
public class Main_����_1941_�ҹ���ĥ����_Ʋ��_DFS���� {
	
	private static class Node{
		int row, col;
		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
		public boolean equal(Node other) {
			if(this.row==other.row && this.col==other.col) return true;
			return false;
		}
	}
	
	private static char[][] map;
	private static int total;
	private static ArrayList<HashSet<Node>> list;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		 * 5x5 �����Ͱ� ���´�.
		 * �ҹ��� ĥ���ָ� �����϶�
		 * ����
		 * 1) 7���� ���л����� �����϶�
		 * 2) 7���� ���� ���γ� ���η� ������ �־�� �Ѵ�.
		 * 3) �̴ټ��İ� 4�� �̻��� �׷츸 ������ �� �ִ�.
		 * 
		 * -> �̴ټ��İ� 4�� �̻��ΰ��� Ȯ���ؾ� �ϰ�,
		 * -> ���� ��θ� Ÿ�� �ȵǰ�,
		 * -> 7���� �����ؾ� �Ѵ� 
		 * => ��Ʈ��ŷ ���� 
		 * 
		 * 1. �̵��� ��ǥ�� Y���� S���� Ȯ���Ͽ� �̴ټ����� ���� counting 
		 * 2. 7���� �����ϸ� return 
		 * 2.1 �̶� �̴ټ��İ� 4�� �̻��̶��, ���ĿԴ� ��ǥ���� list�� �߰�
		 * 2.2 ���� ���� ��η� �Դٸ� �߰� x 
		 * map�� ��� ���� �Ű������� ��� �ٴ���
		 * 
		 * + DFS�� T�� ������ �ȵȴ�.
		 * ���. 
		 * �Ŵ뺯���� ��� �ٳ���ؼ� DFS�� �����ߴµ�, Ž�� ������ �ᱹ BFS�� �����ؾ� �Ұ� ����.
		 * BFS�� ����ؾ� �Ұ� ����.
		 */
		
		map = new char[5][];
		for(int i=0; i<5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		// ��� ����� ����Ʈ
		list = new ArrayList<HashSet<Node>>();
		total = 0;
		// ���� Ž��
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				int S = 0;
				boolean [][] vis = new boolean[5][5];
				vis[i][j] = true;
				if(map[i][j]=='S') S=1;
				go(i, j, S, 1, vis);
			}
		}

		System.out.println(total);
		
	} // end of main

	// go ( row, col, Scount, picked, visited ) 
	private static void go(int row, int col, int S, int picked, boolean[][] vis) {
		// �ӵ����İ� �̹� 4�� �̻��̶�� (3������� �����ϴ�)
		if(picked-S>=4) return;
		// 7���� �̾��� ��
		if(picked==7) {
			// �̴ټ����� �� Ȯ��, �׸��� �̹� �ش� ��ΰ� �ִ��� Ȯ��
			if(S>=4 && !sameRoute(vis)) {
				total++;
			}
			return;
		}
		// �ð���� Ž��
		int nr = row-1; int nc = col;
		if(!(nr<0 || nr>=5 || nc<0 || nc>=5) && !vis[nr][nc]) { 
			vis[nr][nc] = true;
			if(map[nr][nc]=='S') go(nr, nc, S+1, picked+1, vis);
			else go(nr, nc, S, picked+1, vis);
			vis[nr][nc] = false;
		}
		nr = row; nc = col+1;
		if(!(nr<0 || nr>=5 || nc<0 || nc>=5) && !vis[nr][nc]) {
			vis[nr][nc] = true;
			if(map[nr][nc]=='S') go(nr, nc, S+1, picked+1, vis);
			else go(nr, nc, S, picked+1, vis);
			vis[nr][nc] = false;
		}
		nr = row+1; nc = col;
		if(!(nr<0 || nr>=5 || nc<0 || nc>=5) && !vis[nr][nc]) {
			vis[nr][nc] = true;
			if(map[nr][nc]=='S') go(nr, nc, S+1, picked+1, vis);
			else go(nr, nc, S, picked+1, vis);
			vis[nr][nc] = false;
		}
		nr = row; nc = col-1;
		if(!(nr<0 || nr>=5 || nc<0 || nc>=5) && !vis[nr][nc]) {
			vis[nr][nc] = true;
			if(map[nr][nc]=='S') go(nr, nc, S+1, picked+1, vis);
			else go(nr, nc, S, picked+1, vis);
			vis[nr][nc] = false;
		}
	}
	
	// ���� ���Ű� �� �ȵǰ� �ִ�.
	private static boolean sameRoute(boolean[][] vis) {
		// �湮 ��Ʈ �����
		HashSet<Node> temp = new HashSet<>();
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(vis[i][j]) temp.add(new Node(i, j));
			}
		}
		// ��� ����Ʈ�� ���Ͽ� �˻�
		for(HashSet<Node> set:list) {
		// �Ʒ� ���ÿ��� set�� Node��� ������Ÿ���� ���� �ִµ�, ���⼭�� �Ʒ� �޼���� ���� �� ����
			// if(set.containsAll(temp) return true;
			if(sameSet(set, temp)) return true; 
		}
		// ���ο� ��ζ�� ��� �߰� �� false
		list.add(temp);
		return false;
	}
	
	private static boolean sameSet(HashSet<Node> set1, HashSet<Node> set2) {
		boolean flag = false;
		for(Node node1:set1) {
			flag = false;
			for(Node node2:set2) {
				// �ѹ��̶� ������ ���´ٸ� true 
				if(node1.equal(node2)) flag = true;
			}
			if(!flag) return false;
		}
		return true;
	}
} // end of class 

/*
SSSSS
SSSSS
SSSSS
SSSSS
SSSSS
-> 3546
*/
