package src.boj.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** Main_����_15684_��ٸ�����_���4_1536ms*/
public class Main_����_15684_��ٸ�����_���4_1536ms {
	
	private static int N, M, H, row, col, ori, size;
	private static int[][] map;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		/*
		 * �߰��ؾ� �ϴ� ���μ� ������ �ּڰ��� ���...
		 * 
		 * �̹� �����ϴ� ���μ��� ������ ������ ���μ��� 0~3���� �����Ͽ� 
		 * i -> i�� �� �� �ֵ��� �����
		 * 
		 * ����� ���� ���? 
		 * 2700C3 -> 30��?
		 * 2700C2 -> 360��
		 * 2700C1 -> 2700
		 * �뷫 30�ﰳ? �ð� ���� �����Ѱ�..
		 * 
		 * ���� 0�� ����
		 * ���� 1���� ����
		 * ���� 2���� ����
		 * ���������� 3���� ����
		 * 
		 * ������ �� ������ ��ǥ�� ����, j+1�� �� ��� 0�̾�� �����ϴ�
		 * 
		 * 1 -> ���� �̵�
		 * 2 -> ���� �̵�
		 * 
		 * 1���� �迭�� �ٲ㺸��
		 * 0��°, ù��, M��° ��Ҹ� ���� ������ ����
		 */
		
		N = Integer.parseInt(st.nextToken())+1; // �������� �� col 
		H = Integer.parseInt(st.nextToken()); // ���μ��� ���� 
		M = Integer.parseInt(st.nextToken())+1; // �������� �� row
		ori = N-1;
		size = (M)*(N);
		
		map = new int[M][N];
		int n1, n2;
		// ���μ��� ����
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			map[n1][n2] = 1;
			map[n1][n2+1] = 2;
		}
		
		// 0�� ��ġ���� �� �����ϸ� 0 ��� �� ����
		if(checkLadder()) {
			System.out.println(0);
			System.exit(0);;
		}
		
		// 1~3�� ����
		for(int i=1; i<=3; i++) {
			go(i, 0, N); // ������ ����, ���õ� ����
		}
		
		// �Ұ�
		System.out.println(-1);
		
	} // end of main 
	
	private static void go(int cnt, int picked, int start) {
		if(cnt==picked) {
			// Ž��
			if(checkLadder()) {
				// �����ߴٸ�, �߰��� ��ٸ��� ������ ����ϰ� ���� ����
				System.out.println(cnt);
				System.exit(0);
			}
			// �����ϸ� �׳� return 
			return;
		} // ��������
		for(int i=start; i<size; i++) {
			if(i%N==0 || i%N==ori) continue;
			row = i/M; col = i%N;
			if(map[row][col]==0 && map[row][col+1]==0) {
				map[row][col]=1;
				map[row][col+1]=2;
				go(cnt, picked+1, i+1);
				map[row][col] = map[row][col+1] = 0;
			}
		}
		
	} // end of go
	
	private static boolean checkLadder() {
		// i��°�� i��°���� �����ϴ��� Ȯ��
		for(int i=1; i<N; i++) {
			row = 1; col = i;
			while(row<M) {
				if(map[row][col]==1) col+=1;
				else if(map[row][col]==2) col-=1;
				row++;
			}
			// i -> i�� �ƴ϶��
			if(col!=i) return false;
		}
		return true;
	} // end of checkLadder
	
} // end of class 










