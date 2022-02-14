package src.boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** Main_����_17141_������2_���4_1448ms*/
public class Main_����_17141_������2_���4_1448ms {
	
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
		 * ���̷����� �����¿쿡 ������ ��� ��į�� ���ÿ� �����Ǹ�, 1���� �ð��� �ɸ���.
		 * 
		 * �������� ũ�� N 
		 * 5 <= N <= 50
		 * ���� �� �ִ� ���̷����� ���� M
		 * 1 <= M <= 10
		 * 
		 * ���
		 * ��� ��ĭ�� ���̷����� �ְ� �Ǵ� �ּ� �ð��� ����Ѵ�
		 * 
		 * --> M���� ���̷����� ������ ����Ͽ� ������ ��ġ�ϰ�,
		 * �ش� ��ġ�� ���̷������� ������ ��, ��� ��ĭ�� �����Ǵµ� �ɸ��� �ּ� �ð� �Խ� 
		 * --> ��Ž�ε�, min �ð��� �ִ�� �ΰ�, BFS�� ���� �� ��� ��ǥ�� ��ȸ�ϸ�
		 * ��ĭ�� �ִ��� Ȯ���ϰ�, ��ĭ�� ���ٸ� min ����
		 * ������ min�� ����Ѵ�.
		 * 
		 * ++ ���� ������ �ϴ� 0�� ������ counting�ϰ� BFS���� 0�� ������ ����
		 * ++ �ϼ� ī������ 0�� ������ 0�� �Ǹ� ���� --> �� ����� �ξ� ������ (50x50) �迭�� �ִ� 10PM�� �� ��ȸ�ϱ� ������
		 * --> 2500 * 10!/M! �� ��
		 */
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = 100000;	// ������ ū ���� �ʱ�ȭ
		// 1��1 ��Ī
		lab = new int[N+2][N+2];
		Arrays.fill(lab[0], 1);
		Arrays.fill(lab[N+1], 1);
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int num = Integer.parseInt(st.nextToken());
				lab[i][j] = num;
				if(num==2) {
					// ���̷����� �� �� �ִ� ���� ��ĭ���� �ΰ�, ���� ��ǥ�� �����Ѵ�.
					lab[i][j] = 0;
					virus.add(new int[]{i, j}); 
				}
				lab[i][0] = lab[i][N+1] = 1;
			}
		} // ������ �迭 �ʱ�ȭ
		
		visited = new boolean[virus.size()];
		
		// ���̷����� �����ǿ� ��ġ
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
		
		// BFS�� ť
		Queue<int[]> q = new LinkedList<int[]>();
		
		// ���̷����� ������ ��ǥ�� ���̷��� ��ġ + ť�� �߰� + �ϴ� ������ ǥ�� ( �ٸ� ���̷����� 0�϶� ħ���ع��� �� ���� ) 
		for(int len=virus.size(), i=0; i<len; i++) {
			if(visited[i]) {
				q.offer(new int[] {virus.get(i)[0], virus.get(i)[1]});
				BFSLab[virus.get(i)[0]][virus.get(i)[1]]=1;
			}
		}
		
		// �����¿� Ž��
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		while(!q.isEmpty()) {
			int[] vir = q.poll();
			int r = vir[0];
			int c = vir[1];
			for(int i=0; i<4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				// ���� ��ǥ�� ��ĭ�̸� ����
				if(BFSLab[nr][nc]==0) {
					// ���� ��ǥ + 1��
					BFSLab[nr][nc] = BFSLab[r][c] + 1;
					q.offer(new int[] {nr, nc});
				}
			} // end of for
		} // end of while q isEmpty
		
		// �迭�� ��ȸ�ϸ� �ִ� ���� �����ϰ�, ���ÿ� 0�� �ִ��� �ľ�
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
		
		// �ش� Case���� ��� �����Ǵµ� �ɸ� �ϼ��� ���� �ּ� �ϼ� �� �� ����
		min = Math.min(maxCase, min);
	}
	
} // end of class 
