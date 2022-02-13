package src.boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

class Node3{
	int idx;
	int row;
	int col;
	public Node3(int idx, int row, int col) {
		super();
		this.idx = idx;
		this.row = row;
		this.col = col;
	}
	public int getIdx() {
		return idx;
	}
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
}

/** Main_백준_7569_토마토_골드5_748ms*/
public class Main_백준_7569_토마토_골드5_748ms {
	static int days = 0;
	static int zeros = 0;
	public static void main(String[] args) throws Exception{
		// 3차원 구조의 상자의 바이러스를 퍼트리기. 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		// 토마토의 데이터를 저장할 3차원 배열을 만들고 초기화한다. ㅍ
		int[][][] tomatoes = new int[H][row][col];
		boolean[][][] visited = new boolean[H][row][col];
		List<Node3> to = new ArrayList<Node3>();
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<row; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<col; k++) {
					int temp  = Integer.parseInt(st.nextToken());
					tomatoes[i][j][k] = temp;
					if(temp==0) {
						zeros++;
					}
					else if(temp==1) {
						to.add(new Node3(i, j, k));
					}
				}
			}
		}
		
		if(zeros==0) {
			System.out.println(0);
			System.exit(0);
		}
		else {
			BFS(to, tomatoes, visited, H, row, col);
			if(zeros==0) {
				System.out.println(days);
			}
			else {
				System.out.println(-1);
			}
		}
	}

	private static void BFS(List<Node3> to, int[][][] tomatoes, boolean[][][] visited, int h, int row, int col) {
		// TODO Auto-generated method stub
		Deque<Node3> deque = new ArrayDeque<Node3>();
		// 처음에 저장된 모든 토마토 좌표들에 대해 deque에 추가 + 방문 처리
		for(int i=0; i<to.size(); i++) {
			Node3 node = to.get(i);
			int idx = node.getIdx();
			int r = node.getRow();
			int c = node.getCol();
			visited[idx][r][c] = true;
			deque.offer(node);
		}
		
		while(!deque.isEmpty()) {
			// 6방 탐색을 위한 배열
			int[] di = {0, 0, 0, 0, -1, 1};
			int[] dr = {-1, 1, 0, 0, 0, 0};
			int[] dc = {0, 0, -1, 1, 0, 0};
			// 현재 큐의 사이즈만큼의 반복이 끝나면 days를 증가
			for(int len = deque.size(), repeat=0; repeat<len; repeat++) {
				Node3 node = deque.pollFirst();
				int i = node.getIdx();
				int r = node.getRow();
				int c = node.getCol();
				for(int dir=0; dir<6; dir++) {
					int ni = i + di[dir];
					int nr = r + dr[dir];
					int nc = c + dc[dir];
					// 밤위 체크
					if(ni<0 || ni>=h || nr<0 || nr>=row || nc<0 || nc>=col) {
						continue;
					}
					// 갈 수 없는 좌표라면
					if(tomatoes[ni][nr][nc]==-1) {
						continue;
					}
					if(tomatoes[ni][nr][nc]==0 && visited[ni][nr][nc]==false) {
						visited[ni][nr][nc]=true;
						deque.offerLast(new Node3(ni, nr, nc));
						zeros--;
					}
				} // end of for dir
			} // end of for repeat
			days++;
			if(zeros==0) {
				return;
			}
		} // end of while
	} // end of BFS
} // end of class
