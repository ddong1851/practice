package src.boj.undone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** Main_����_2206_���μ����̵��ϱ�_���4_�ð��ʰ�*/
public class Main_����_2206_���μ����̵��ϱ�_���4_�ð��ʰ� {

	private static int N;
	private static int M;
	private static int min;
	private static int[][] map;
	// �ð���� �� �� �� ��
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	private static ArrayList<int[]> walls;
	
	private static void go(int[] broke) {
		
		int[][] newMap = new int[N+2][M+2];
		for(int i=0; i<=N+1; i++) {
			newMap[i] = map[i].clone();
		}
		
		newMap[broke[0]][broke[1]] = 0;
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {1, 1});
		newMap[1][1] = 1;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int row = curr[0];
			int col = curr[1];
			for(int i=0; i<4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				// �湮���� �ʾҰų�, �̹� �湮�Ǿ��� ������ �� ª�� ��ΰ� ���� ��
				if(newMap[nr][nc]==0 || newMap[nr][nc]>newMap[row][col]+1) {
					newMap[nr][nc] = newMap[row][col]+1;
					q.offer(new int[] {nr,nc});
				}
			}
		}
		
		if(newMap[N][M]!=0)	min = Math.min(min, newMap[N][M]);
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+2][M+2];
		Arrays.fill(map[0], -1);
		Arrays.fill(map[N+1], -1);
		walls = new ArrayList<int[]>();
		for(int i=1; i<=N; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=1; j<=M; j++) {
				map[i][j] = temp[j-1] - '0';
				if(temp[j-1]=='1') {
					walls.add(new int[] {i, j});
				}
				map[i][0] = map[i][M+1] = -1;
			}
		}
		min = 999_999_999;
		
		// ���� ���� ���� ������ �ѹ� ����
		go(new int[] {1, 1});
		// �� ����鼭 ����
		for(int[] wall:walls) {
			go(wall);
		}
		if(min==999999999) {
			System.out.println(-1);
		}
		else {
			System.out.println(min);
		}
		
	} // end of main
	
} // end of class
