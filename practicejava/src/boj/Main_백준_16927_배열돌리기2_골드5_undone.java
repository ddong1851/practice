package src.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Main_백준_16927_배열돌리기2_골드5_undone(시간초과)
 * 각 레이어에서의 순환을 dx dy를 이용한 이동을 통해 for 문의 개수를 줄여야 할 거 같다.
 * 이때 배열의 크기를 하나 더 크게 만들고 범위를 나갔는지 확인하지 않게 해보자.
 */

/**NxM 짜리 배열을 반시계 방향으로 돌린다. 시간은 1초*/

public class Main_백준_16927_배열돌리기2_골드5_undone {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// n x m 배열, 2<= N, M <= 300
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		// 반복 횟수	1<= R <=10^9 int안에 들어간다.
		int repeat = Integer.parseInt(st.nextToken());
		
		// n x m 배열을 만든다.
		int [][] matrix = new int[n][m];
		// 배열의 값 초기화
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			} // end of for
		} // end of for
		
		// n과m 중 더 작은값을 inner로 설정한다. inner는 배열 회전의 레이어로 사용될 예정
		int inner = Math.min(n,m) / 2;
		
		// 반복 횟수만큼 변경을 반복해라.
		for(int rp=0; rp<repeat; rp++) {
			
			/**시작 레이어 설정*/
			int start = 0;
			// 레이어의 수만큼 반복
			while(start<inner) {
				
				/**행 시작 좌표*/
				int r = n-1-start;
				/**열 시작 좌표*/
				int c = 0+start;
				
				int temp = matrix[r][c]; // 첫 기준점을 저장
				
				for(;r>start;r--) { // 0, 0 기준에서 아래쪽으로 이동 
					matrix[r][c] = matrix[r-1][c];
				} // 0, 0
				for(;c<m-1-start;c++) { // ← 우측에서 좌측으로 당겨오는 이동
					matrix[r][c] = matrix[r][c+1];
				} // 0, 3
				for(;r<n-1-start; r++) { // 바닥에서 올리는거
					matrix[r][c] = matrix[r+1][c];
				} // 4, 3
				for(;c>start;c--) { //  → 좌측에서 우측으로 당겨오는 이동
					matrix[r][c] = matrix[r][c-1];
				} // 첫 기준점으로 돌아감 4, 0
				
				// 마지막 중복을 첫 사라진 값으로 채움
				matrix[r][c+1] = temp;
				start++;
			} // end of while 
			
		} // end of for
		
		// 바뀐 배열을 출력한다.
		for(int []i:matrix) {
			for(int mat:i) {
				bw.write(mat+" ");
			}
			bw.write("\n");
		}
		
		br.close();
		bw.close();
	} // end of main
	
} // end of class 
