package src.boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//class Node{
//	int row;
//	int col;
//	public Node(int row, int col) {
//		super();
//		this.row = row;
//		this.col = col;
//	}
//	public int getRow() {
//		return row;
//	}
//	public int getCol() {
//		return col;
//	}
//} // end of Node


/** Main_����_14940_�����ִܰŸ�_���5_1016ms*/
// Ư�̻��� - Scanner �δ� �ð� �ʰ����µ�, BufferedReader Writer�� �ٲٴϱ� �ð� �ȿ� ���Դ�.
public class Main_����_14940_�����ִܰŸ�_���5_1016ms {
	
	/**�׷���*/
	static Integer[][] graph;
	/**�湮 ����*/
	static boolean[][] visited;
	
	private static void BFS(Node start, int n, int m) {
		// TODO Auto-generated method stub
		// BFS�� ���� ��ũ ����
		Deque<Node> deque = new ArrayDeque<>();
		// ��ũ�� ù ������ �߰�
		deque.add(start);
		// ù ������ �湮 ó��
		visited[start.getRow()][start.getCol()]=true;
		
		// �ݺ� 
		while(!deque.isEmpty()) {
			Node node = deque.poll();
			// ���� ����� ��ǥ
			int r = node.getRow();
			int c = node.getCol();
			// �����¿� �̵�
			int [][] dxy = {{-1, 0},{1, 0},{0, -1},{0, 1}};
			// 4�� Ž��
			for(int i=0; i<4; i++) {
				// ���� ��ǥ ����
				int nr = r + dxy[i][0];
				int nc = c + dxy[i][1];
				// ������ �����
				if(nr<0 || nr>=n || nc<0 || nc>=m) {
					continue;
				}
				// �� �� ���� �����̶��
				if(graph[nr][nc]==0) {
					continue;
				}
				// �� �� �ִ� ��ǥ�̸� ���� �湮���� ���� ���̶��
				if(graph[nr][nc]==-1 && visited[nr][nc]==false) {
					// ���� ��ǥ�� ���� �ϳ� �� ū �� ����
					graph[nr][nc] = graph[r][c] + 1;
					visited[nr][nc] = true;
					deque.add(new Node(nr,nc));
				}
			} // end of 4�� Ž��
		} // end of while 
		
		
	} // end of BFS
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		// n�� ���� ũ��, m�� ���� ũ��
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		graph = new Integer[n][m];
		visited = new boolean[n][m];
		Node start = null;
		
		for(int i=0; i<n; i++) {
			int idx = 0;
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				if(num==1) {
					graph[i][idx++]=-1;
				}
				else if(num==2) {
					start = new Node(i, idx);
					// ������ 0���� �ٲٱ�
					graph[i][idx++]=0;
				}
				else {
					graph[i][idx++] = num;
				}
			} // end of while
			
		} // end of for
		
		// BFS�� ���� �� ��ǥ������ �Ÿ��� ����
		BFS(start, n, m);
		
		for(Integer[] g:graph) {
			for(Integer result:g) {
				bw.write(result+" ");
			}
			bw.write("\n");
		}
		
		bw.close();
		br.close();
		
		
	} // end of main
} // end of class
