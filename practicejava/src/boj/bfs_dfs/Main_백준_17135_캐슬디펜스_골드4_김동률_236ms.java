package src.boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** Main_����_17135_ĳ�����潺_���4_�赿��_236ms*/
public class Main_����_17135_ĳ�����潺_���4_�赿��_236ms {
	
	/** ���� ũ��*/
	private static int N;
	/** ���� ũ��*/
	private static int M;
	/** �ü��� ��Ÿ�*/
	private static int D;
	/** ������*/
	private static int[][] board;
	/**óġ�� ���� �ִ� ��*/
	private static int max = 0;
	/** �湮 Ȯ�ο� �迭*/
	private static boolean[][] visited;
	/** BFS�� ť*/
	private static Queue<Node> q;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		/* ����
		 * ����
		 * �Է�
		 * ���� �� N, ���� �� M, �ü��� ���� ��Ÿ� D 
		 * 3 <= N, M <= 15
		 * 1 <= D <= 10
		 * --> ��Ž�̶� �����Ͱ� ���� �� ����.
		 * 
		 * IDEA
		 * �ü��� ��ġ�� ���� Ž������ �Ѵ�. 
		 * �ü����� ������ ���� ������ �� �����Ƿ� 
		 * ���ݴ��� ������ ��ġ�� ���� �����ϰ�, ������ �����ϱ� ������ ���ӿ��� ���ܽ�Ų��.
		 * �Ÿ� ����� �������� ���� �޼���� ���� + ��ǥ �̵��� 
		 * ���� ã��� �ü��� ��ǥ �������� BFS��(����� �� �켱�̴ϱ�)
		 * 
		 * + ���ܵ� �༮���� 0���� ���� + ���ŵ� ��ǥ�� �� -> óġ�� ��
		 * + 1�� ������ ���� ���� -> ������ ����
		 */
		
		// �ʱ� ������ ����
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		
		// �� �Ʒ� �࿡ �ü����� ��ġ���� �������� ������ ����
		board = new int[N+2][M+2];
		// ���� �� �Ʒ� ������ ä���
		Arrays.fill(board[0], -1);
		Arrays.fill(board[N+1], -1);
		// ���� ���� �ʱ�ȭ
		for(int r=1; r<=N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=1; c<=M; c++) {
				int num = Integer.parseInt(st.nextToken());
				board[r][c] = num;
				// �¿쿡 �� �����
				board[r][0] = -1;
				board[r][M+1] = -1;
			}
		}
		
		
		// �ü��� ��ǥ�� ���� ���� Ž�� ( ��ġ�� 0,1,2 -> 0,1,3 �̷������� �ݺ��Ͽ� ó���� ���� �ֵ� ���� ����Ѵ�. )
		for(int i=1; i<=M-2; i++) {
			for(int j=i+1; j<=M-1; j++) {
				for(int k=j+1; k<=M; k++) {
					int[] archer = {i, j, k};
					BFS(archer);
				}
			}
		}
		
		// óġ�� ���� �ִ� ���� ����Ѵ�.
		System.out.println(max);
		
		
	} // end of main

	/** BFS*/
	private static void BFS(int[] archers) {
		
		
		// ������ �迭, �� �迭�� �����ϸ� �ȵǴϱ�
		int [][]game = new int[N+2][M+2];
		for(int r=0; r<=N+1; r++) {
			game[r] = board[r].clone();
		}
		
		// �� �� �� Ž��
		int [] dr = {0, -1, 0};
		int [] dc = {-1, 0, 1};
		
		int killed = 0;
		
		// N�� ��ŭ �ݺ�
		int repeat=0;
		while(repeat<N) {
			// ���� ������ ��ǥ ����
			Queue<Node> dead = new LinkedList<>();
			// Ž�� ����
			for(int i=0; i<3; i++) {
				// ť �ʱ�ȭ
				q = new LinkedList<Node>();
				// �� �ü� ������� Ž��
				q.offer(new Node(N+1, archers[i]));
				// �湮 Ȯ�� �迭 �ʱ�ȭ
				visited = new boolean[N+2][M+2];
				W:while(!q.isEmpty()) {
					Node node = q.poll();
					int r = node.row;
					int c = node.col;
					// 3�� Ž��
					for(int dir=0; dir<3; dir++) {
						// Ž���� ��ǥ
						int nr = r + dr[dir];
						int nc = c + dc[dir];
						// ���� ��ǥ�� ���̰ų� ���̰ų�, �����Ÿ��� ����ų�, �湮�ߴٸ�
						if(game[nr][nc]==-1 || distance(archers[i], nr, nc)>D || visited[nr][nc]) {
							continue;
						}
						// �湮 ǥ��
						visited[nr][nc] = true;
						// �ش� ��ǥ�� ���̶�� ������ ��ǥ�� �����ϰ� �ݺ����� ������.
						if(game[nr][nc]==1) {
							dead.offer(new Node(nr, nc));
							break W;
						}
						// ���̾ƴ϶��
						else {
							q.offer(new Node(nr, nc));
						}
					} // end of for 3�� Ž��
					
				} // end of while isEmpty
				
			} // end of for archers
			// ���� ���� ����
			while(!dead.isEmpty()) {
				killed +=killEnemy(game, dead.poll());
			}
			// ���� ����
			enemyMove(game);
			// �ݺ�Ƚ�� ����
			repeat++;
		} // end of while game 
		
		// ���� ������ �ִ�ġ�� ����
		max = Math.max(max, killed);
		
	} // end of BFS 

	/** Move arrays game*/
	private static void enemyMove(int[][] game) {
		// �� �پ� �����.
		for(int r=N; r>=1; r--) {
			game[r] = game[r-1];
		}
	}

	/** erase Enemy*/
	private static int killEnemy(int[][] game, Node enemy) {
		// ���� �ִ� ��ǥ��� 0���� �ٲٰ� 1�� ��ȯ
		if(game[enemy.row][enemy.col]==1) {
			game[enemy.row][enemy.col]=0;
			return 1;
		}
		// ���� ���� ��ǥ�� 0 ��ȯ ( �ߺ� �� ��� ) 
		return 0;
	}

	/** �Ÿ���� �޼���*/
	private static int distance(int archer, int row, int col) {
		return Math.abs(archer-col) + Math.abs(N+1-row);
	}
	
} // end of Main

//class Node{
//	public int row;
//	public int col;
//	public Node(int row, int col) {
//		super();
//		this.row = row;
//		this.col = col;
//	}
//}
