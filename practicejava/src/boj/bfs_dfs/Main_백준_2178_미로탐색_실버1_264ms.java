package src.boj.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Main_백준_2178_미로탐색_실버1_264ms
 * @author HD
 *
 */
public class Main_백준_2178_미로탐색_실버1_264ms {
	public static void main(String[] args) {
		// 풀이 방법 BFS를 통해 4방 탐색을 해보자 + 좌표까지의 최단 거리를 구하기 위해서 다음 좌표 = 이전 좌표 + 1 로 한다.
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int [][] maze = new int[n][m];
		for(int i=0; i<n; i++) {
			String str = sc.next();
			char [] c = new char[m];
			c = str.toCharArray();
			for(int j=0; j<m; j++) {
				maze[i][j] = c[j]-'0';
			}
		}
		sc.close();
		
		boolean [][] visited = new boolean[n][m];
		// 맨 끝 좌표를 출력하면, 이전 값들이 다 더해진 값이라 정답이 출력된다.
		System.out.println(bfs(0, 0, maze, visited, n, m));
		
		
	} // end of main

	private static int bfs(int r, int c, int[][] maze, boolean[][] visited, int n, int m) {
		// TODO Auto-generated method stub
		
		// 큐에 x, y 좌표를 넣기 위해 node라는 데이터 타입을 정의한다.
		Queue<Node> q = new LinkedList<>();
		// 큐에 시작 정점을 추가한다.
		q.add(new Node(c, r));
		// 시작 정점을 방문 표시한다.
		visited[c][r] = true;
		// 상하 좌우 방향 지정	상		하		좌		우
		int [][] dxy = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			// 4방 탐색
			for(int i=0; i<4; i++) {
				// 다음 좌표 탐색
				int nc = node.getCol() + dxy[i][0];
				int nr = node.getRow() + dxy[i][1];
				// 범위를 벗어났다면 다음 방향 탐색
				if(nc<0 || nc>=n || nr<0 || nr>=m) {
					continue;
				}
				// 해당 좌표가 갈 수 없는 길이라면 다른 방향 탐색
				if(maze[nc][nr]==0) {
					continue;
				}
				// 해당 좌표가 이동 가능한 1이라면, 해당 좌표를 큐에 넣고, 그래프의 값을 하나 증가시킨다.
				if(maze[nc][nr]==1 && visited[nc][nr] == false) {
					maze[nc][nr] = maze[node.getCol()][node.getRow()] + 1;
					// 방문 처리
					visited[nc][nr] = true;
					// 해당 좌표를 큐에 넣는다
					q.add(new Node(nc, nr));
				}
			}
		}
		
		// 맨 끝 값을 반환
		return maze[n-1][m-1];
		
	} // end of bfs
} // end of class

//class Node{
//	int col;
//	int row;
//	
//	public Node(int col, int row) {
//		this.col = col;
//		this.row = row;
//	}
//
//	public int getRow() {
//		return row;
//	}
//	public int getCol() {
//		return col;
//	}
//	
//}
