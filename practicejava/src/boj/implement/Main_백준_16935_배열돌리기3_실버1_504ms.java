package src.boj.implement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_����_16935_�迭������3_�ǹ�1_504ms {
	
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
		
		// �迭 �ʱ�ȭ
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// �־��� ������ ����
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreElements()) {
			int oper = Integer.parseInt(st.nextToken());
			remote(oper);
		}
		
		// �迭 ������ �����ؼ� ���
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

	/** 1�� ����, ���� ����*/
	private static void operation1() {
			// 1�� ����
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
	
	/** 2�� ���� �¿� ����*/
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
	
	/** ���� 3 ���������� 90�� ȸ��*/
	private static void operation3() {
		// ȸ���� �迭�� ������ �迭
		int[][] arr1 = new int[M][N];
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				arr1[r][c] = arr[N - c - 1][r];
			}
		}
		// N, M �ݴ�� ����
		int temp = N;
		N = M;
		M = temp;
		// �� �迭 �ʱ�ȭ
		arr = arr1;
	}
	
	/** ���� �������� 90�� ȸ�� ( ���������� 3���� ���� )*/
	private static void operation4() {
		operation3();
		operation3();
		operation3();
	}
	
	
	private static void operation5() {
		// �ݺ� Ƚ����ŭ �����ش�.
		// 4���� �迭�� ������ش�.
		int rowsize = N / 2;
		int colsize = M / 2;
		// 4���� ������ �۾� ����
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
			// 1, 2, 3, 4 �� �� �ݺ� Ƚ���� ���� �迭�� �����´�
			int[][] arr1 = arrays.get(idx[i]);
			// arr1�� ��ǥ���� arr�� ���� ���ϴ� ���� �־��ش�.
			int startR = startrow[i];
			int startC = startcol[i];
			for (int r = 0; r < rowsize; r++) {
				for (int c = 0; c < colsize; c++) {
					arr[startR + r][startC + c] = arr1[r][c];
				}
			}
		}
	}
	
	/**4���� ���� �迭�� �������� 90�� ������*/
	private static void operation6() {
		operation5();
		operation5();
		operation5();
	}
}
