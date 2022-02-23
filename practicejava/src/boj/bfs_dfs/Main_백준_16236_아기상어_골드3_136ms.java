package src.boj.bfs_dfs;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 문제의 조건을 아주 잘 읽어야 하는 문제
// Main_백준_16236_아기상어_골드3_136ms
public class Main_백준_16236_아기상어_골드3_136ms {
	
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
		// 먹은 물고기 큐와 상어 좌표를 저장하는 큐
		Queue<Shark> eatenfish = new LinkedList<>();
		Queue<Shark> q = new LinkedList<>();
		q.offer(shark);
		// 방문 처리
		visited[shark.row][shark.col] = true;
		// 움직임 확인용 변수
		boolean moved = false;
		// 움직임 카운트 
		int cnt=0;
		int size = 2;
		// 먹은 물고기 수
		int ate = 0;
		// 의미있는 움직임만 카운트
		int total=0;
		// 먹을 수 있는 생선이 있을 때 혹은 큐가 비지 않았을 떄
		while((eatable>0) && !q.isEmpty()) {
			moved = false;
			for (int repeat = q.size(), i = 0; i < repeat; i++) {
				Shark curr = q.poll();
				int row = curr.row;
				int col = curr.col;
				for (int dir = 0; dir < 4; dir++) {
					int nr = row + dr[dir];
					int nc = col + dc[dir];
					// 범위 체크
					if (nr < 0 || nr >= N || nc < 0 || nc >= N)
						continue;
					// 방문되었거나 나보다 큰 물고기가 있는 좌표라면 못간다.
					if (visited[nr][nc] || map[nr][nc] > size)
						continue;
					// 갈 수 있는 좌표들
					// 방문 처리
					visited[nr][nc] = true;
					moved = true;
					// 이동한 좌표가 그냥 빈칸이거나 먹을 수 없는 물고기라면
					if (map[nr][nc] == 0 || map[nr][nc] == size) {
						q.offer(new Shark(nr, nc));
					}
					// 먹을 수 있는 물고기가 있는 좌표라면 ( map[nr][nc]<size )
					else {
						// 먹은 물고기 큐에 추가
						eatenfish.offer(new Shark(nr, nc));
					}
				} // end of for 4 dir
			} // end of for
			// 움직인 횟수 증가
			if(moved) cnt++;
			// 먹은 물고기가 있다면
			if(!eatenfish.isEmpty()) {
				// 생존할 수 있었다.
				q.clear();
				visited = new boolean[N][N];
				int distance = 0;
				int min = 10000;
				int killrow = 0;
				int killcol = 0;
				// 먹은 물고기 중 가장 위, 왼쪽에 있는 녀석 선택
				while(!eatenfish.isEmpty()) {
					Shark eFish = eatenfish.poll();
					distance = eFish.row-0;
					if(min>distance) {
						min = distance;
						killrow = eFish.row;
						killcol = eFish.col;
					}
					// row 기준 같은 거리라면 
					if(distance==min) {
						if(killcol>eFish.col) {
							killcol = eFish.col;
						}
					}
				}
				// 사이즈만큼 먹었을 때 갱신
				if (++ate == size) {
					// 먹을 수 있는 물고기 수 증가 + 사이즈 갱신
					if(size<=6) {
						eatable+=fishs[size++];
					}
					ate = 0;
				}
				// 의미있는 움직임 카운트
				total+=cnt;
				cnt=0;
				// 죽임 처리
				map[killrow][killcol] = 0;
				// 먹을 수 있는 물고기 수 감소
				eatable--;
				visited[killrow][killcol] = true;
				q.offer(new Shark(killrow, killcol));
			}
		} // end of while 
		// 정답 출력
		System.out.println(total);
	} // end of method
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// 초기화 세션
		Shark shark = null;
		map = new int[N][N];
		visited = new boolean[N][N];
		// 배열 초기화
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				// 상어 위치 저장
				if(num==9) {
					// 빈칸으로 두기 
					map[i][j] = 0;
					shark = new Shark(i, j);
				}
				// 뮬고기 크기별 개수 체크
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
