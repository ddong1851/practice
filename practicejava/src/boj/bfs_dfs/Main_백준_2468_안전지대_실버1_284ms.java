package src.boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** Main_����_2468_��������_�ǹ�1_284ms*/

// ����� ���������� ������ ����ض�! �ϴ� ������ BFS�� ������ �����ϴ� return 1�� �Ѱ����� ����
public class Main_����_2468_��������_�ǹ�1_284ms {
	
	static int n;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0,- 1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		graph = new int[n][n];
		
		int maxHeight=0;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j] > maxHeight) {
					maxHeight =graph[i][j];
				}
			}
		}
		
		// �ִ� ����+1 ������ Ž���Ͽ� ���ʿ��� ���� ���̱�
		int max =0;
		for(int height=0; height<maxHeight+1; height++) {
			// ���� ���̸� ���Ҷ����� count�� �湮 ���θ� �ʱ�ȭ�Ѵ�
			visited = new boolean[n][n];
			int cnt=0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					// �湮���� �ʰ� �ǹ� �ִ� ���̶��
					if(!visited[i][j] && graph[i][j] > height){
						cnt+=dfs(i,j,height); // �ش� �������� Ž�� ����
					}
				}
			}
			// �ִ� ���� ���� ����
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}
	// ���� ���� DFSŽ��
	static int dfs(int x, int y, int height) {
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x +dx[i];
			int ny = y +dy[i];
			
			if(nx<0 || ny<0 || nx>=n || ny >=n) continue;
			if(visited[nx][ny]) continue;
			if(graph[nx][ny]> height) {
				dfs(nx,ny, height);
			}
		}
		// ������ 1�� ��ȯ�ؼ� �������밡 1���� ����
		return 1;
	}
}
