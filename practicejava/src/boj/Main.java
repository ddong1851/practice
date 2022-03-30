package src.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/** Main_백준_14890_경사로_골드3_*/
public class Main {
	
	private static class Road{
		int hei, len;
		public Road(int hei, int len) {
			super();
			this.hei = hei;
			this.len = len;
		}
	}
	
	private static int N, L, nr, nc;
	private static int[][] map;
	private static int cnt;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		cnt = 0;
		
		int[] dir1 = {1, 0};
		// 아래로
		for(int i=0; i<N; i++) {
			go(0, i, dir1);
		}
		
		dir1 = new int[]{0, 1};
		// 가로 탐색
		for(int i=0; i<N; i++) {
			go(i, 0, dir1);
		}
		
		System.out.println(cnt);
		
	} // end of main 
	
	private static void go(int sr, int sc, int[] dir) {
		
		Stack<Road> stack = new Stack<>();
		int firstval = map[sr][sc];
		stack.add(new Road(firstval, 0));
		int diff = 0;
		for(int i=1; i<N; i++) {
			nr = sr + (dir[0]*i);
			nc = sc + (dir[1]*i);
			if(map[nr][nc]==firstval && map[nr][nc]==stack.peek().hei) {
				stack.push(new Road(map[nr][nc], 0));
				continue;
			}
			// 일정한 높이의 경사로인 경우
			if(map[nr][nc]==stack.peek().hei) {
				// 경사로가 진행중이면 -1, 경사로가 완공이라면 0 으로 넣기
				stack.push(new Road(map[nr][nc], stack.peek().len==0?0:stack.peek().len-1));
				continue;
			}
			int temp = stack.peek().hei - map[nr][nc];
			// 높이 차이가 2 이상이면 실패
			if(Math.abs(temp)>1) return;
			// 위로가는 길인지 아래로 가는 길인지 파악이 안된 경우에만 갱신
			if(diff==0) diff = temp;
			// 일정한 경사로이며 다음 값이 와도 괜찮은 경우
			if(temp==diff && stack.peek().len==0) {
				stack.push(new Road(map[nr][nc], L-1));
				continue;
			} 
			break;
		}
		if(stack.size()==N) cnt++;
	} // end of go
	
} // end of class 









