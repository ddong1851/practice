package src.boj.undone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

/** Main_백준_14502_연구소_골드5_undone*/
public class Main_백준_14502_연구소_골드5_undone {
	static int n;
	static int m;
	// 바뀐 값들의 개수, Math.min으로 계속 바꿔주자, 초기화를 불가능한 값으로 한다
	static int min = 10000;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int [][] graph = new int[n][m];
		// 복사할 배열
		int [][] graph2 = new int[n][m];
		boolean [][] visited = new boolean[n][m];
		
		int ones = 0;
		
		// 바이러스의 위치도 지정해서 하는게 나을거 같다
		List<Node> zeros = new ArrayList<Node>();
		List<Node> twos = new ArrayList<Node>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				int num = Integer.parseInt(st.nextToken());
				graph[i][j] = num;
				graph2[i][j] = num;
				if(num==0) {
					zeros.add(new Node(i, j));
				}
				if(num==1) {
					ones++;
				}
				if(num==2) {
					twos.add(new Node(i, j));
				}
			}
		}
		// 이 방법이 맞는지 확인
		int countZeros = zeros.size();
		
		// 모든 0 세트 3개씩 벽으로 변경하고 안전구역 카운팅(브루트 포스)
		for(int i=0; i<zeros.size()-2; i++) {
			for(int j=i+1; j<zeros.size()-1; j++) {
				for(int k=j+1; k<zeros.size(); k++) {
					int changed = 0;
					for(Node T:twos) {
						changed+=BFS(zeros.get(i), zeros.get(j), zeros.get(k), graph2, visited, T);
					}
					visited = new boolean[n][m];
					// 복사된 그래프를 계속 넣어라
					for(int r=0; r<n; r++) {
						for(int c=0; c<m; c++) {
							graph2[r][c] = graph[r][c];
						}
					}
					// 						변하지 않은 공간 + 벽 + 3개 더해진 벽
					min = Math.min(min, countZeros-changed+ones+3);
				}
			}
		}
		
		System.out.println(min);
	}

	private static int BFS(Node i, Node j, Node k, int[][] graph, boolean[][] visited, Node two) {
		// 방문되었다면 돌아가라
		if(visited[two.getRow()][two.getCol()]) {
			return 0;
		}
		
		graph[i.getRow()][i.getCol()] = 1;
		graph[j.getRow()][j.getCol()] = 1;
		graph[k.getRow()][k.getCol()] = 1;
		
		Deque<Node> deque = new ArrayDeque<Node>();
		deque.offer(two);
		visited[two.getRow()][two.getCol()]=true;
		
		int count = 0;
		while(!deque.isEmpty()) {
			// 4방 탐색의 조건에 의해 어떠한 좌표가 바뀐다면, count를 증가 
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
					graph[nr][nc] = 2;
					visited[nr][nc]=true;
					count++;
				}
			}
		}
		// 변경해야함
		// 변경된 회수를 비교하여 min값 갱신
		return count;
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