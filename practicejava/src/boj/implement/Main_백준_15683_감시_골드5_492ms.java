package src.boj.implement;

import java.io.*;
import java.util.*;

/** Main_����_15683_����_���5_492ms*/
class Main_����_15683_����_���5_492ms{
	
	private static class CCTV{
		int row, col;
		public CCTV(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	private static int safe, min, N, M;
	private static CCTV[] cctv = new CCTV[8];
	// �ð����
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		/*
		 * ���� ������ �ش� ���� Ž���� ����
		 * �簢������ �ּ� ���� ã�ƶ�
		 * �׵θ��� ��ġ�Ͽ�, ������ ���� ������ �����ϰ� �����
		 * ������ 2048���� �μ����� �����Ͻ� ��ó��
		 * ī�ǹ迭�� �������� ������ �޸������̼��� ����غ���
		 * + �迭�� ũ�� <= 8 , CCTV <= 8 ��Ž
		 */
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		safe = 0;
		// �׵θ��� �� ��ġ
		int[][] map = new int[N+2][M+2];
		Arrays.fill(map[0], 6);
		Arrays.fill(map[N+1], 6);
		
		int idx = 0;
		for(int i=1; i<=N; i++) {
			map[i][0] = map[i][M+1] = 6;
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				// �ո� �����̶��
				if(n==0) safe++;
				// ���� ī�޶���
				else if(n!=6) {
					cctv[idx++] = new CCTV(i, j);
					
				}
			}
		}
		min = 100;
 		go(0, 0, idx, map);
		System.out.println(min);
		
	} // end of main

	private static void go(int picked, int changed, int idx, int[][] cmap) {
		// TODO Auto-generated method stub
		if(picked==idx) {
			min = Math.min(min, safe - changed);
			return;
		} // ���� ����
		// ��� cctv�� ���� ������ �������� Ž��
		CCTV curr = cctv[picked];
		int row = curr.row;
		int col = curr.col;
		int change = 0;
		int[][] copymap = new int[N+2][M+2];
		switch(cmap[row][col]) {
		case 1:
			// 4���� ��� Ʈ����
			for(int i=0; i<4; i++) {
				change = 0;
				copymap = copy(cmap);
				change=dfs(i, copymap, row, col);
				go(picked+1, changed+change, idx, copymap);
			}
			break;
			// ���� or �¿�
		case 2:
			for(int i=0; i<2; i++) {
				change = 0;
				copymap = copy(cmap);
				change+=dfs(i, copymap, row, col);
				change+=dfs(i+2, copymap, row, col);
				go(picked+1, changed+change, idx, copymap);
			}
			break;
		case 3:
			// ������ �� ���⾿
			for(int i=0; i<4; i++) {
				change = 0;
				copymap = copy(cmap);
				change+=dfs(i, copymap, row, col);
				change+=dfs((i+1)%4, copymap, row, col);
				go(picked+1, changed+change, idx, copymap);
			}
			break;
		case 4:
			// 3���� 4��
			for(int i=0; i<4; i++) {
				change = 0;
				copymap = copy(cmap);
				change+=dfs(i, copymap, row, col);
				change+=dfs((i+1)%4, copymap, row, col);
				change+=dfs((i+2)%4, copymap, row, col);
				go(picked+1, changed+change, idx, copymap);
			}
			break;
		case 5:
			// 4���� ��� Ȯ�� �� ����
			copymap = copy(cmap);
			for(int i=0; i<4; i++) {
				change+=dfs(i, copymap, row, col);
			}
			go(picked+1, changed+change, idx, copymap);
			break;
		default:
			break;
		}
	}
	
	private static int[][] copy(int[][] mat){
		int[][] temp = new int[N+2][M+2];
        for (int i=0; i<=N+1; i++) {
            System.arraycopy(mat[i], 0, temp[i], 0, M+2);
        }
        return temp;
	} // end of copy
	
	private static int dfs(int i, int[][] map, int sr, int sc) {
		// TODO Auto-generated method stub
		Queue<CCTV> q = new LinkedList<CCTV>();
		q.offer(new CCTV(sr, sc));
		int cnt = 0;
		while(!q.isEmpty()) {
			CCTV curr = q.poll();
			int nr = curr.row + dr[i];
			int nc = curr.col + dc[i];
			if(map[nr][nc]==6) break;
			// ���� ������ ���� �簢������ ���� �� ī��Ʈ ����
			if(map[nr][nc]==0) {
				map[nr][nc]=-1;
				cnt++;
			}
			q.offer(new CCTV(nr, nc));
		}
		return cnt;
	} // end of dfs
} // end of class











