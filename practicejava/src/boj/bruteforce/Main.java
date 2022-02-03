package src.boj.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

/** Main_����_14502_������_���5_*/
public class Main {
	static int n;
	static int m;
	static Deque<Node> q = new ArrayDeque<Node>();
	// �ٲ� ������ ����, Math.min���� ��� �ٲ�����, �ʱ�ȭ�� �Ұ����� ������ �Ѵ�
	static int min = 10000;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int [][] graph = new int[n][m];
		boolean [][] visited = new boolean[n][m];
		
		// ���̷����� ��ġ�� �����ؼ� �ϴ°� ������ ����
		List<Node> zeros = new ArrayList<Node>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				int num = Integer.parseInt(st.nextToken());
				graph[i][j] = num;
				if(num==0) {
					zeros.add(new Node(i, j));
				}
				if(num==2) {
					q.offer(new Node(i, j));
				}
			}
		}
		// ���� �� ������ ���� ex 35
		int countZeros = zeros.size();
		// ����� �׷����� ��� �־��
		int[][] graph2 = graph.clone();
		
		// ��� 0 ��Ʈ 3���� ������ �����ϰ� �������� ī����(���Ʈ ����)
		for(int i=0; i<zeros.size()-2; i++) {
			for(int j=i+1; j<zeros.size()-1; j++) {
				for(int k=j+1; k<zeros.size(); k++) {
					BFS(zeros.get(i), zeros.get(j), zeros.get(k), graph2, visited);
					visited = new boolean[n][m];
					graph2 = graph.clone();
				}
			}
		}
		
		System.out.println(countZeros - min);
	}

	private static void BFS(Node i, Node j, Node k, int[][] graph, boolean[][] visited) {
		// ������ ������ ��ǥ�� ������ ����
		graph[i.getRow()][i.getCol()] = 1;
		graph[j.getRow()][j.getCol()] = 1;
		graph[k.getRow()][k.getCol()] = 1;
		
		// ť�� ���� �貸�ͼ� �غ���
		Deque<Node> deque = new ArrayDeque<Node>(q);
		
		int count = 0;
		// ��� 2�鿡 ���� ����
		while(!deque.isEmpty()) {
			// 4�� Ž���� ���ǿ� ���� ��� ��ǥ�� �ٲ�ٸ�, count�� ���� 
			Node node = deque.poll();
			int r = node.getRow();
			int c = node.getCol();
			int[][] dxy = {{-1, 0},{1, 0},{0, -1},{0, 1}};
			for(int dir=0; dir<4; dir++) {
				int nr = r + dxy[dir][0];
				int nc = c + dxy[dir][1];
				if(nr<0 || nr>=n || nc<0 || nc>=m) {
					continue;
				}
				if(graph[nr][nc]==1) {
					continue;
				}
				if(graph[nr][nc]==0 && visited[nr][nc]==false) {
					deque.offer(new Node(nr, nc));
					visited[nr][nc]=true;
					count++;
				}
			}
		}
		// ����� ȸ���� ���Ͽ� min�� ����
		min = Math.min(min, count);
	}
}

class Node{
	int row;
	int col;
	public Node(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
}