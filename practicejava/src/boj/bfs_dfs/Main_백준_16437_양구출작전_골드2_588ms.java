package src.boj.bfs_dfs;

import java.io.*;
import java.util.*;

public class Main_����_16437_�籸������_���2_588ms {
	
	private static class Node{
		char type;
		int NoInd, index;
		public Node(char type, int noInd, int index) {
			super();
			this.type = type;
			NoInd = noInd;
			this.index = index;
		}
	}
	
	private static int N;
	private static ArrayList<Node>[] list;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		/*
		 * DFS�� �����ϸ鼭 
		 * �ٴ��� ���� �������� ���� ��� �ø��鼭 �ش� ���̿����� ���� ��ȯ����
		 * 
		 * �ٴ��� ��� �ö���� ����� ����ؾ� ���� �˾Ҵµ�.. ���� �Դ� �ð��� �ɱ�? �ϸ鼭 ���� �˻� ���ٰ� �ʹ� �� Ǯ�� ������ �־
		 * �����߽��ϴ�..��
		 */
		
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) list[i] = new ArrayList<Node>();
		
		char type = '\u0000';
		int NoInd = 0;
		int to = 0;
		for(int i=2; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			type = st.nextToken().charAt(0);
			NoInd = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			list[to].add(new Node(type, NoInd, i));
		}
		
		System.out.println(go(new Node('S', 0, 1)));
		
	} // end of main

	private static long go(Node curr) {
		long total = 0;
		// ����� ���鿡 ���� ������ �ް�
		for(Node island : list[curr.index]) {
			total += go(island);
		} // end of for 
		if(curr.type=='S') return total+curr.NoInd;
		else return total-curr.NoInd>0?total-curr.NoInd:0;
	} // end of go 
	
} // end of class 















