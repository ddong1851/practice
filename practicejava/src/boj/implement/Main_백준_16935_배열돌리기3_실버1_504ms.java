package src.boj.implement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_16935_배열돌리기3_실버1_504ms {
	
	private static int[][] arr;
	private static int N;
	private static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		// 배열 초기화
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 주어진 연산을 수행
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreElements()) {
			int oper = Integer.parseInt(st.nextToken());
			remote(oper);
		}
		
		// 배열 값들을 저장해서 출력
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void remote(int oper) {
		switch(oper) {
		case 1:
			operation1();
			break;
		case 2:
			operation2();
			break;
		case 3:
			operation3();
			break;
		case 4:
			operation4();
			break;
		case 5:
			operation5();
			break;
		case 6:
			operation6();
			break;
		}
	}

	/** 1번 연산, 상하 반전*/
	private static void operation1() {
			// 1번 수행
		int rangeRow = N/2;
		// N - 1 - r
		for(int r=0; r<rangeRow; r++) {
			int diff = N-1-r;
			for(int c=0; c<M; c++) {
				int temp = arr[r][c];
				arr[r][c] = arr[diff][c];
				arr[diff][c] = temp;
			}
		}
	}
	
	/** 2번 연산 좌우 반전*/
	private static void operation2() {
		int rangeCol = M/2;
		for(int c=0; c<rangeCol; c++) {
			int diff = M-1-c;
			for(int r=0; r<N; r++) {
				int temp = arr[r][c];
				arr[r][c] = arr[r][diff];
				arr[r][diff] = temp;
			}
		}
	}
	
	/** 연산 3 오른쪽으로 90도 회전*/
	private static void operation3() {
		// 회전한 배열을 저장할 배열
		int[][] arr1 = new int[M][N];
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				arr1[r][c] = arr[N - c - 1][r];
			}
		}
		// N, M 반대로 수정
		int temp = N;
		N = M;
		M = temp;
		// 원 배열 초기화
		arr = arr1;
	}
	
	/** 연산 왼쪽으로 90도 회전 ( 오른쪽으로 3번과 동일 )*/
	private static void operation4() {
		operation3();
		operation3();
		operation3();
	}
	
	
	private static void operation5() {
		// 반복 횟수만큼 돌려준다.
		// 4개의 배열을 만들어준다.
		int rowsize = N / 2;
		int colsize = M / 2;
		// 4개로 나누는 작업 수행
		ArrayList<int[][]> arrays = new ArrayList<>();
		int[] startrow = { 0, 0, rowsize, rowsize };
		int[] startcol = { 0, colsize, colsize, 0 };
		for (int i = 0; i < 4; i++) {
			int startR = startrow[i];
			int startC = startcol[i];
			int[][] arr1 = new int[rowsize][colsize];
			for (int r = 0; r < rowsize; r++, startR++) {
				for (int c = 0; c < colsize; c++, startC++) {
					arr1[r][c] = arr[startR][startC];
				}
				startC = startcol[i];
			}
			arrays.add(arr1);
		}
		
		int[] idx = { 3, 0, 1, 2 };
		for (int i = 0; i < 4; i++) {
			// 1, 2, 3, 4 번 중 반복 횟수에 맞춘 배열을 꺼내온다
			int[][] arr1 = arrays.get(idx[i]);
			// arr1의 좌표들을 arr의 내가 원하는 곳에 넣어준다.
			int startR = startrow[i];
			int startC = startcol[i];
			for (int r = 0; r < rowsize; r++) {
				for (int c = 0; c < colsize; c++) {
					arr[startR + r][startC + c] = arr1[r][c];
				}
			}
		}
	}
	
	/**4개의 서브 배열을 왼쪽으로 90도 돌리기*/
	private static void operation6() {
		operation5();
		operation5();
		operation5();
	}
}
