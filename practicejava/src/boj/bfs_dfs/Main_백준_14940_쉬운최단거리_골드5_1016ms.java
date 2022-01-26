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


/** Main_백준_14940_쉬운최단거리_골드5_1016ms*/
// 특이사항 - Scanner 로는 시간 초과였는데, BufferedReader Writer로 바꾸니까 시간 안에 들어왔다.
public class Main_백준_14940_쉬운최단거리_골드5_1016ms {
	
	/**그래프*/
	static Integer[][] graph;
	/**방문 여부*/
	static boolean[][] visited;
	
	private static void BFS(Node start, int n, int m) {
		// TODO Auto-generated method stub
		// BFS를 위한 데크 생성
		Deque<Node> deque = new ArrayDeque<>();
		// 데크에 첫 시작점 추가
		deque.add(start);
		// 첫 시작점 방문 처리
		visited[start.getRow()][start.getCol()]=true;
		
		// 반복 
		while(!deque.isEmpty()) {
			Node node = deque.poll();
			// 현재 노드의 좌표
			int r = node.getRow();
			int c = node.getCol();
			// 상하좌우 이동
			int [][] dxy = {{-1, 0},{1, 0},{0, -1},{0, 1}};
			// 4방 탐색
			for(int i=0; i<4; i++) {
				// 다음 좌표 지정
				int nr = r + dxy[i][0];
				int nc = c + dxy[i][1];
				// 범위를 벗어나면
				if(nr<0 || nr>=n || nc<0 || nc>=m) {
					continue;
				}
				// 갈 수 없는 영역이라면
				if(graph[nr][nc]==0) {
					continue;
				}
				// 갈 수 있는 좌표이며 아직 방문하지 않은 곳이라면
				if(graph[nr][nc]==-1 && visited[nr][nc]==false) {
					// 이전 좌표에 비해 하나 더 큰 값 저장
					graph[nr][nc] = graph[r][c] + 1;
					visited[nr][nc] = true;
					deque.add(new Node(nr,nc));
				}
			} // end of 4방 탐색
		} // end of while 
		
		
	} // end of BFS
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		// n은 세로 크기, m은 가로 크기
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
					// 시작점 0으로 바꾸기
					graph[i][idx++]=0;
				}
				else {
					graph[i][idx++] = num;
				}
			} // end of while
			
		} // end of for
		
		// BFS를 통해 각 좌표까지의 거리를 저장
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
