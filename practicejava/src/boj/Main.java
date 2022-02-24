package src.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

/** 1941 �ҹ��� ĥ���� */
public class Main {
	
	private static class Node{
		int row, col;
		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
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
		 */
		
		map = new char[5][];
		for(int i=0; i<5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		// ��� ����� ����Ʈ
		list = new ArrayList<HashSet<Node>>();
		total = 0;
		go(0, 0, 0, 1, new boolean[5][5]);

		System.out.println(total);
		
	} // end of main

	// go ( row, col, Scount, picked, visited ) 
	private static void go(int row, int col, int S, int picked, boolean[][] vis) {
		
		// �湮 ó��
		vis[row][col] = true;
		
		// 7���� �̾��� ��
		if(picked==7) {
			// �̴ټ����� �� Ȯ��, �׸��� �̹� �ش� ��ΰ� �ִ��� Ȯ��
			if(S>=4 && !sameRoute(vis)) {
				total++;
			}
			return;
		}
		// �߰��� �ݳ��� �ȵ� ��ǥ���� �ִ�.. �ذ�����
		
		// �ش� ��ǥ�� �̴ټ��Ķ��
		if(map[row][col]=='S') S++;
		// �ð���� Ž��
		int nr = row-1; int nc = col;
		if(!(nr<0 || nr>=5 || nc<0 || nc>=5) && !vis[nr][nc]) go(nr, nc, S, picked+1, vis);
		nr = row; nc = col+1;
		if(!(nr<0 || nr>=5 || nc<0 || nc>=5) && !vis[nr][nc]) go(nr, nc, S, picked+1, vis);
		nr = row+1; nc = col;
		if(!(nr<0 || nr>=5 || nc<0 || nc>=5) && !vis[nr][nc]) go(nr, nc, S, picked+1, vis);
		nr = row; nc = col-1;
		if(!(nr<0 || nr>=5 || nc<0 || nc>=5) && !vis[nr][nc]) go(nr, nc, S, picked+1, vis);
		// �ݳ�
		vis[row][col] = false;
	}

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
			if(set.containsAll(temp)) return true;
		}
		// ���ο� ��ζ�� ��� �߰� �� true
		list.add(temp);
		return false;
	}
	
} // end of class 
