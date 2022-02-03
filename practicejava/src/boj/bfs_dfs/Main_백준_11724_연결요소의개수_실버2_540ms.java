package src.boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** Main_����_11724_�������ǰ���_�ǹ�2_540ms*/
public class Main_����_11724_�������ǰ���_�ǹ�2_540ms {
	static boolean[]visited;
	static int[][] graph;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// ��ǥ�� 6���� 1~6���� ����� �� �ֵ���
		graph = new int[n+1][n+1];
		// �׳� ��� row ��ǥ�鿡 ���� Ž�� 
		visited = new boolean[n+1];
		
		// ����� ���� �Է��� ���� �׷��� �ʱ�ȭ
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			graph[row][col]=1;
			graph[col][row]=1;
		}
		br.close();
		
		// 1�� �ִ� ��ǥ�鿡 ���Ͽ� DFS�� ���� Ž��
		int count = 0;
		// ��� ��ǥ�鿡 ���� Ž�� ����
		for(int i=1; i<=n; i++) {
			if(visited[i]==false) {
				count+=DFS(n, i);
			}
		}
		System.out.println(count);
	}

	
	private static int DFS(int n, int row) {
		// TODO Auto-generated method stub
		// �̹� �湮�ߴٸ�
		if(visited[row]) {
			return 0;
		}
		visited[row] = true;
		for(int i=1; i<=n; i++) {
			// ����� ��ǥ��� DFS �ǽ�
			if(graph[row][i]==1) {
				DFS(n, i);
			}
		}
		// ����� ��ҵ��� ������ ���ϰ� �Ѵ�
		return 1;
	}
}
