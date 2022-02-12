package src.boj.implement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_����_16926_�迭������1_�ǹ�2_704ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		/* ���̵��
		 * %���� ����ϸ� 580 ���� �پ��
		 * �ѹ����� 1���� �迭�� �ٲٰ� ����Ʈ ������ �ϸ� 400ms���� ���� �� �ִ�.
		 */
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		// �迭 �ʱ�ȭ
		int [][] arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int len = st.countTokens();
			for(int j=0; j<len; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// TotalLayer ���
		int TotalLayer = Math.min(N,  M)/2;
		
		int currlayer = 0;
		while(currlayer!=TotalLayer) {
			// R�� ȸ��
			for(int i=0; i<R; i++) {
				// ���� ������ (0, 0) / (1, 1) ������ ����
				int row = currlayer;
				int col = currlayer;
				// ������ �� �ӽ� ����
				int temp = arr[row][col];
				// ��ȸ ���� ����
				int rowRange = N-currlayer-1;
				int colRange = M-currlayer-1;
				// ����
				for(;col<colRange;col++) {
					arr[row][col] = arr[row][col+1];
				}
				// �ϴ� �̵�
				for(;row<rowRange;row++) {
					arr[row][col] = arr[row+1][col];
				}
				// ����
				for(;col>currlayer;col--) {
					arr[row][col] = arr[row][col-1];
				}
				// ���
				for(;row>currlayer;row--) {
					arr[row][col] = arr[row-1][col];
				}
				arr[currlayer+1][currlayer] = temp;
			}
			currlayer++;
		}
		
		// ��� �Է�
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
