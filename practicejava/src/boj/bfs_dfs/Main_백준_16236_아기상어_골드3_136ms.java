package src.boj.bfs_dfs;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// ������ ������ ���� �� �о�� �ϴ� ����
// Main_����_16236_�Ʊ���_���3_136ms
public class Main_����_16236_�Ʊ���_���3_136ms {
	
	private static class Shark{
		int row, col;

		public Shark(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	private static int eatable;
	private static int N;
	private static int[] fishs = new int[7];;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dr = {-1, 0, 0, 1};
	private static int[] dc = {0, -1, 1, 0};

	private static void bfs(Shark shark) {
		// ���� ����� ť�� ��� ��ǥ�� �����ϴ� ť
		Queue<Shark> eatenfish = new LinkedList<>();
		Queue<Shark> q = new LinkedList<>();
		q.offer(shark);
		// �湮 ó��
		visited[shark.row][shark.col] = true;
		// ������ Ȯ�ο� ����
		boolean moved = false;
		// ������ ī��Ʈ 
		int cnt=0;
		int size = 2;
		// ���� ����� ��
		int ate = 0;
		// �ǹ��ִ� �����Ӹ� ī��Ʈ
		int total=0;
		// ���� �� �ִ� ������ ���� �� Ȥ�� ť�� ���� �ʾ��� ��
		while((eatable>0) && !q.isEmpty()) {
			moved = false;
			for (int repeat = q.size(), i = 0; i < repeat; i++) {
				Shark curr = q.poll();
				int row = curr.row;
				int col = curr.col;
				for (int dir = 0; dir < 4; dir++) {
					int nr = row + dr[dir];
					int nc = col + dc[dir];
					// ���� üũ
					if (nr < 0 || nr >= N || nc < 0 || nc >= N)
						continue;
					// �湮�Ǿ��ų� ������ ū ����Ⱑ �ִ� ��ǥ��� ������.
					if (visited[nr][nc] || map[nr][nc] > size)
						continue;
					// �� �� �ִ� ��ǥ��
					// �湮 ó��
					visited[nr][nc] = true;
					moved = true;
					// �̵��� ��ǥ�� �׳� ��ĭ�̰ų� ���� �� ���� �������
					if (map[nr][nc] == 0 || map[nr][nc] == size) {
						q.offer(new Shark(nr, nc));
					}
					// ���� �� �ִ� ����Ⱑ �ִ� ��ǥ��� ( map[nr][nc]<size )
					else {
						// ���� ����� ť�� �߰�
						eatenfish.offer(new Shark(nr, nc));
					}
				} // end of for 4 dir
			} // end of for
			// ������ Ƚ�� ����
			if(moved) cnt++;
			// ���� ����Ⱑ �ִٸ�
			if(!eatenfish.isEmpty()) {
				// ������ �� �־���.
				q.clear();
				visited = new boolean[N][N];
				int distance = 0;
				int min = 10000;
				int killrow = 0;
				int killcol = 0;
				// ���� ����� �� ���� ��, ���ʿ� �ִ� �༮ ����
				while(!eatenfish.isEmpty()) {
					Shark eFish = eatenfish.poll();
					distance = eFish.row-0;
					if(min>distance) {
						min = distance;
						killrow = eFish.row;
						killcol = eFish.col;
					}
					// row ���� ���� �Ÿ���� 
					if(distance==min) {
						if(killcol>eFish.col) {
							killcol = eFish.col;
						}
					}
				}
				// �����ŭ �Ծ��� �� ����
				if (++ate == size) {
					// ���� �� �ִ� ����� �� ���� + ������ ����
					if(size<=6) {
						eatable+=fishs[size++];
					}
					ate = 0;
				}
				// �ǹ��ִ� ������ ī��Ʈ
				total+=cnt;
				cnt=0;
				// ���� ó��
				map[killrow][killcol] = 0;
				// ���� �� �ִ� ����� �� ����
				eatable--;
				visited[killrow][killcol] = true;
				q.offer(new Shark(killrow, killcol));
			}
		} // end of while 
		// ���� ���
		System.out.println(total);
	} // end of method
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// �ʱ�ȭ ����
		Shark shark = null;
		map = new int[N][N];
		visited = new boolean[N][N];
		// �迭 �ʱ�ȭ
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				// ��� ��ġ ����
				if(num==9) {
					// ��ĭ���� �α� 
					map[i][j] = 0;
					shark = new Shark(i, j);
				}
				// �İ�� ũ�⺰ ���� üũ
				else if(num!=0){
					map[i][j] = num;
					fishs[num]++;
				}
			}
		}
		
		eatable+=fishs[1];
		bfs(shark);
	}
} // end of class 
