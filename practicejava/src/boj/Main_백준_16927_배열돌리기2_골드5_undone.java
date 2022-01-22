package src.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Main_����_16927_�迭������2_���5_undone(�ð��ʰ�)
 * �� ���̾���� ��ȯ�� dx dy�� �̿��� �̵��� ���� for ���� ������ �ٿ��� �� �� ����.
 * �̶� �迭�� ũ�⸦ �ϳ� �� ũ�� ����� ������ �������� Ȯ������ �ʰ� �غ���.
 */

/**NxM ¥�� �迭�� �ݽð� �������� ������. �ð��� 1��*/

public class Main_����_16927_�迭������2_���5_undone {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// n x m �迭, 2<= N, M <= 300
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		// �ݺ� Ƚ��	1<= R <=10^9 int�ȿ� ����.
		int repeat = Integer.parseInt(st.nextToken());
		
		// n x m �迭�� �����.
		int [][] matrix = new int[n][m];
		// �迭�� �� �ʱ�ȭ
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			} // end of for
		} // end of for
		
		// n��m �� �� �������� inner�� �����Ѵ�. inner�� �迭 ȸ���� ���̾�� ���� ����
		int inner = Math.min(n,m) / 2;
		
		// �ݺ� Ƚ����ŭ ������ �ݺ��ض�.
		for(int rp=0; rp<repeat; rp++) {
			
			/**���� ���̾� ����*/
			int start = 0;
			// ���̾��� ����ŭ �ݺ�
			while(start<inner) {
				
				/**�� ���� ��ǥ*/
				int r = n-1-start;
				/**�� ���� ��ǥ*/
				int c = 0+start;
				
				int temp = matrix[r][c]; // ù �������� ����
				
				for(;r>start;r--) { // 0, 0 ���ؿ��� �Ʒ������� �̵� 
					matrix[r][c] = matrix[r-1][c];
				} // 0, 0
				for(;c<m-1-start;c++) { // �� �������� �������� ��ܿ��� �̵�
					matrix[r][c] = matrix[r][c+1];
				} // 0, 3
				for(;r<n-1-start; r++) { // �ٴڿ��� �ø��°�
					matrix[r][c] = matrix[r+1][c];
				} // 4, 3
				for(;c>start;c--) { //  �� �������� �������� ��ܿ��� �̵�
					matrix[r][c] = matrix[r][c-1];
				} // ù ���������� ���ư� 4, 0
				
				// ������ �ߺ��� ù ����� ������ ä��
				matrix[r][c+1] = temp;
				start++;
			} // end of while 
			
		} // end of for
		
		// �ٲ� �迭�� ����Ѵ�.
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
