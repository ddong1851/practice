package src.boj.bfs_dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

/**
 * Main_백준_7576_토마토_골드5_1756ms
 * @author HD
 *
 */

// 좌표를 큐에 저장하기 위한 데이터 타입 정의
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
//}


// -1 토마토가 없는 칸, 0 익지 않은 토마토, 1 익은 토마토
public class Main_백준_7576_토마토_골드5_1756ms {
	public static int [][] box;
	public static boolean[][] visited;
	public static ArrayList<Node> tomato = new ArrayList<>();
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// m = 가로 칸의 수 n = 세로 칸의 수
		int m = sc.nextInt();
		int n = sc.nextInt();
		// 토마토를 담을 상자의 크기를 지정해준다. 
		box = new int[n][m];
		// 방문 여부를 체크할 배열
		visited = new boolean[n][m];
		int zeros = 0;
		
		// 가로 줄의 수만큼 반복을 돌며 박스를 초기화한다.
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				int num = sc.nextInt();
				box[i][j] = num;
				if(num==1) {
					// 토마토가 있는 좌표를 미리 저장한다.
					tomato.add(new Node(i, j));
				}
				if(num==0) {
					zeros++;
				}
			}
		}
		
//		토마토 좌표들을 스태틱으로 만들고 bfs 내부적으로 모든 좌표들을 넣는다, 그리고 0의 개수가 0인가를 확인하고 종료
		bfs(zeros, n, m);
		
	}

//	BFS 구현
	private static void bfs(int zeros, int n , int m) {
		// TODO Auto-generated method stub
//		좌표를 담을 큐를 생성한다.
		Deque<Node> deque = new ArrayDeque<>();
//		모든 토마토 좌표를 데크에 넣고 방문 처리 한다
		tomato.forEach(to->{
			deque.add(to);
			visited[to.getRow()][to.getCol()] = true;
		});
		
		int zero = zeros;
		// 마지막엔 큐를 비우는거만 하니까 -1? 
		int days = -1;
		
//		상 하 좌 우 탐색
		int [][] dxy = {{-1, 0},{1, 0},{0, -1},{0, 1}};
		
//		여기서 while문으로 돌리면 첫번째 토마토에서 다 전파시키는거 아닌가
		W:while(!deque.isEmpty()) {
			// 여기서 큐의 개수만큼 빼면서 돌리면 되나
			int range = deque.size();
			// 큐에 담긴 좌표들을 빼면서 돌린다
			for(int repeat=0; repeat<range; repeat++) {
				// 앞쪽에 있는거 빼고
				Node node = deque.pollFirst();
				int r = node.getRow();
				int c = node.getCol();
				// 4방 탐색
				for(int i=0; i<4; i++) {
					int nr = r + dxy[i][0];
					int nc = c + dxy[i][1];
					// 범위 확인
					if(nr<0 || nr>=n || nc<0 || nc>=m) {
						continue;
					}
					// -1 이면 못가니까
					if(box[nr][nc] == -1) {
						continue;
					}
					// 방문 처리 및 전파 + 끝에다가 넣는다
					if(box[nr][nc] == 0 && visited[nr][nc]==false) {
						// 0의 개수 -1, 방문 처리, 해당 좌표 전파, 데크의 끝에 넣는다(앞쪽은 빼서 쓸거니까)
						zero--;
						// 0이 이제 없다면,
						if(zero==0) {
							days++;
							break W;
						}
						visited[nr][nc] = true;
						box[nr][nc] = 1;
						deque.addLast(new Node(nr,nc));
					}
				}
			}
			// 하루가 지나간다
			days++;
		}
		
		
		if(zero==0) {
			System.out.println(days);
		} else {
			System.out.println(-1);
		}
	}
}
