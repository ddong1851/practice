package src.boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** Main_����_14502_������_���5_400ms*/
public class Main_����_14502_������_���5_400ms {
	
	private static int N;
	private static int M;
	private static int[][] lab;
	private static ArrayList<int[]> virus = new ArrayList<>();
	private static ArrayList<int[]> zeros = new ArrayList<>();
	private static int max;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		/*
		 * IDEA
		 * ���� 3�� ���� �� �ִ� 
		 * --> ���� Ž��
		 * 
		 * + �޼��带 ������ �� �ȿ���
		 * �迭�� ����� �湮 �۾��� �ʱ�ȭ�Ѵ�.
		 * + ���� ������ ũ��� �ٽ� �迭�� ���鼭 ī���� �Ѵ�.
		 * + ������ 0�� ��ǥ�� Ž���ϸ� �����ϱ⿡ visited�� �ʿ� ����
		 */
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		max = 0;
		
		// �׵θ� ���� �� ������ �ʱ�ȭ
		lab = new int[N+2][M+2];
		Arrays.fill(lab[0], 1);
		Arrays.fill(lab[N+1], 1);
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				int num = Integer.parseInt(st.nextToken());
				lab[i][j] = num;
				// ���̷����� ��ġ ����
				if(num==2) {
					int[] temp = {i, j};
					virus.add(temp);
				}
				else if(num==0) {
					int[] temp = {i, j};
					zeros.add(temp);
				}
			}
			lab[i][0] = lab[i][M+1] = 1;
		}
		
		// ���� Ž�� ( ��� 0�� ��ǥ�� ���� �������� ) // �̰� ��� ���Ϸ��� ������ ����ϸ� �ȴ�.
		int size = zeros.size();
		for(int ilen=size-2, i=0; i<ilen; i++) {
			for(int jlen=size-1, j=i+1; j<jlen; j++) {
				for(int k=j+1; k<size; k++) {
					BFS(i,j,k);
				}
			}
		}
		// ���� ���
		System.out.println(max);
	}
	
//	/* ���������, ������ ����Ͽ� ���� ��ġ�ϴ� ���*/
//	private static void permWalls(int cnt) {
//		if(cnt==3) {
//			// ���� BFS()
//		}
//		
//		for(int i=1; i<=N+1; i++) {
//			for(int j=1; j<=M+1; j++) {
//				if(lab[i][j]==0) {
//					// �� �����
//					lab[i][j] = 1;
//					permWalls(cnt+1);
//					// �� ���ְ� �ݺ�
//					lab[i][j] = 0;
//				}
//			}
//		}
//	} // end of permWalls 

	private static void BFS(int wall1, int wall2, int wall3) {
		
		// ����
		int[][] BFSLab = new int[N+2][M+2];
		for(int i=0; i<=N+1; i++) {
			BFSLab[i] = lab[i].clone();
		}
		// ���޹��� 3���� ��ǥ�� 1�� �ʱ�ȭ�Ѵ�.
		BFSLab[zeros.get(wall1)[0]][zeros.get(wall1)[1]] = 1;
		BFSLab[zeros.get(wall2)[0]][zeros.get(wall2)[1]] = 1;
		BFSLab[zeros.get(wall3)[0]][zeros.get(wall3)[1]] = 1;
		
		// �����¿� Ž��
		int [] dr = { -1, 1, 0, 0};
		int [] dc = {  0, 0, -1,1};
		
		int save = 0;
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		// ��� ���̷����鿡 ���� Ž��
		for(int i=0; i<virus.size(); i++) {
			// ���̷��� ��ǥ �ϳ��� �ش�
			q.offer(virus.get(i));
			while(!q.isEmpty()) {
				int[] vir = q.poll();
				int r = vir[0];
				int c = vir[1];
				for(int dir=0; dir<4; dir++) {
					int nr = r + dr[dir];
					int nc = c + dc[dir];
					// �̰ŵ� �ʿ� ���� ���� 
					if(BFSLab[nr][nc]==1) {
						continue;
					}
					if(BFSLab[nr][nc]==0) {
						BFSLab[nr][nc] = 2;
						q.offer(new int[]{nr, nc});
					}
				}
			} // end of while 
			
		} // end of for virus
		
		for(int r=1; r<=N+1; r++) {
			for (int c=1; c<=M+1; c++) {
				if(BFSLab[r][c]==0) {
					save++;
				}
			}
		}
		
		// ���� ���� �ִ� ����
		max = Math.max(max, save);
		
	} // end of BFS
	
} // end of class
