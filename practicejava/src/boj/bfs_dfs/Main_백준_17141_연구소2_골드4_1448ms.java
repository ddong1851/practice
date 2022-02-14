package src.boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** Main_백준_17141_연구소2_골드4_1448ms*/
public class Main_백준_17141_연구소2_골드4_1448ms {
	
	private static int N;
	private static int M;
	private static int[][] lab;
	private static ArrayList<int[]> virus = new ArrayList<>();
	private static boolean [] visited;
	private static int min;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		/*
		 * 바이러스는 상하좌우에 인접한 모든 빈캄에 동시에 복제되며, 1초의 시간이 걸린다.
		 * 
		 * 연구소의 크기 N 
		 * 5 <= N <= 50
		 * 놓을 수 있는 바이러스의 개수 M
		 * 1 <= M <= 10
		 * 
		 * 출력
		 * 모든 빈칸에 바이러스가 있게 되는 최소 시간을 출력한다
		 * 
		 * --> M개의 바이러스를 조합을 사용하여 지도에 배치하고,
		 * 해당 위치에 바이러스들이 존재할 때, 모든 빈칸이 전염되는데 걸리는 최소 시간 게싼 
		 * --> 완탐인데, min 시간을 최대로 두고, BFS가 끝난 후 모든 좌표를 순회하며
		 * 빈칸이 있는지 확인하고, 빈칸이 없다면 min 갱신
		 * 정답은 min을 출력한다.
		 * 
		 * ++ 내가 기존에 하던 0의 개수를 counting하고 BFS이후 0의 개수를 보자
		 * ++ 일수 카운팅은 0의 개수가 0이 되면 갱신 --> 이 방법이 훨씬 빠르다 (50x50) 배열을 최대 10PM번 더 조회하기 때문에
		 * --> 2500 * 10!/M! 번 더
		 */
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = 100000;	// 임의의 큰 수로 초기화
		// 1대1 매칭
		lab = new int[N+2][N+2];
		Arrays.fill(lab[0], 1);
		Arrays.fill(lab[N+1], 1);
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int num = Integer.parseInt(st.nextToken());
				lab[i][j] = num;
				if(num==2) {
					// 바이러스가 올 수 있는 곳도 빈칸으로 두고, 따로 좌표를 저장한다.
					lab[i][j] = 0;
					virus.add(new int[]{i, j}); 
				}
				lab[i][0] = lab[i][N+1] = 1;
			}
		} // 연구소 배열 초기화
		
		visited = new boolean[virus.size()];
		
		// 바이러스를 연구실에 배치
		placeVirus(0, 0);
		
		if(min==100000)System.out.println(-1);
		else System.out.println(min);
		
	} // end of main
	

	private static void placeVirus(int cnt, int placed) {
		
		if(placed==M) {
			BFS();
			return;
		}
		
		for(int len=virus.size(), i=cnt; i<len; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			placeVirus(cnt+1, placed+1);
			visited[i] = false;
		}
	}
	
	private static void BFS() {
		
		int[][] BFSLab = new int[N+2][N+2];
		for(int i=0; i<=N+1; i++) {
			BFSLab[i] = lab[i].clone();
		}
		
		// BFS용 큐
		Queue<int[]> q = new LinkedList<int[]>();
		
		// 바이러스로 지정할 좌표들 바이러스 배치 + 큐에 추가 + 일단 벽으로 표시 ( 다른 바이러스가 0일때 침투해버릴 수 있음 ) 
		for(int len=virus.size(), i=0; i<len; i++) {
			if(visited[i]) {
				q.offer(new int[] {virus.get(i)[0], virus.get(i)[1]});
				BFSLab[virus.get(i)[0]][virus.get(i)[1]]=1;
			}
		}
		
		// 상하좌우 탐방
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		while(!q.isEmpty()) {
			int[] vir = q.poll();
			int r = vir[0];
			int c = vir[1];
			for(int i=0; i<4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				// 다음 좌표가 빈칸이면 가라
				if(BFSLab[nr][nc]==0) {
					// 이전 좌표 + 1일
					BFSLab[nr][nc] = BFSLab[r][c] + 1;
					q.offer(new int[] {nr, nc});
				}
			} // end of for
		} // end of while q isEmpty
		
		// 배열을 순회하며 최대 값을 갱신하고, 동시에 0이 있는지 파악
		int maxCase = 0;
		for(int i=1; i<=N+1; i++) {
			for(int j=1; j<=N+1; j++) {
				if(BFSLab[i][j]==0) {
					return;
				}
				if(maxCase<BFSLab[i][j]-1) {
					maxCase = BFSLab[i][j]-1;
				}
			}
		}
		
		// 해당 Case에서 모두 전염되는데 걸린 일수와 현재 최소 일수 비교 후 갱신
		min = Math.min(maxCase, min);
	}
	
} // end of class 
