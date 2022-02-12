package src.boj.implement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_16926_배열돌리기1_실버2_704ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		/* 아이디어
		 * %연산 사용하면 580 으로 줄어듬
		 * 한바퀴를 1차원 배열로 바꾸고 시프트 연산을 하면 400ms까지 줄일 수 있다.
		 */
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		// 배열 초기화
		int [][] arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int len = st.countTokens();
			for(int j=0; j<len; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// TotalLayer 계산
		int TotalLayer = Math.min(N,  M)/2;
		
		int currlayer = 0;
		while(currlayer!=TotalLayer) {
			// R번 회전
			for(int i=0; i<R; i++) {
				// 시작 지점을 (0, 0) / (1, 1) 등으로 지정
				int row = currlayer;
				int col = currlayer;
				// 시작점 값 임시 저장
				int temp = arr[row][col];
				// 순회 범위 지정
				int rowRange = N-currlayer-1;
				int colRange = M-currlayer-1;
				// 우측
				for(;col<colRange;col++) {
					arr[row][col] = arr[row][col+1];
				}
				// 하단 이동
				for(;row<rowRange;row++) {
					arr[row][col] = arr[row+1][col];
				}
				// 좌측
				for(;col>currlayer;col--) {
					arr[row][col] = arr[row][col-1];
				}
				// 상단
				for(;row>currlayer;row--) {
					arr[row][col] = arr[row-1][col];
				}
				arr[currlayer+1][currlayer] = temp;
			}
			currlayer++;
		}
		
		// 출력 입력
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
