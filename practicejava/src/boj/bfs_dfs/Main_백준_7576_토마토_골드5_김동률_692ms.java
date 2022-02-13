package src.boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

/** Main_����_7576_�丶��_���5_�赿��_692ms*/
public class Main_����_7576_�丶��_���5_�赿��_692ms {
	
	private static int[][] tomato;
	private static int colsize;
	private static int rowsize;
	// ��ü�� Node�� ����� �ͺ��� ȿ������ �迭�� ����ߴ�.
	private static ArrayDeque<int[]> dq;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		colsize = Integer.parseInt(st.nextToken());
		rowsize = Integer.parseInt(st.nextToken());
		
		// 2���� ũ�� ���� ���� üũ ���ϱ�
		tomato = new int[rowsize+2][colsize+2];
		
		// -1�� �ʱ�ȭ(�ٱ� �µθ� ������ ����)
		Arrays.fill(tomato[0], -1);
		Arrays.fill(tomato[rowsize+1], -1);
		for(int r=1; r<=rowsize; r++) {
			tomato[r][0] = -1;
			tomato[r][colsize+1] = -1;
		}
		
		// �丶�� ��ġ ����
		dq = new ArrayDeque<int[]>();
		for(int r=1; r<=rowsize; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=1; c<=colsize; c++) {
				int num = Integer.parseInt(st.nextToken());
				tomato[r][c] = num;
				if(num==1) {
					// �丶�䰡 �ִ� ��ġ�� ��ǥ�� ����
					int[] temp = {r, c};
					dq.offer(temp);
				}
			}
		}
		
		// BFS�� ���� �ϼ� ���
		int result = BFS();
		
		// �丶�� ���ڸ� ��ȸ�ϸ� ���� �丶�䰡 �߰ߵǸ� -1 ���
		for(int i=1; i<=rowsize; i++) {
			for(int j=1; j<=colsize; j++) {
				if(tomato[i][j]==0) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}
		
		// �������� �丶�䰡 ���ٸ� ���� ���
		System.out.println(result);
		
	} // end of main

	
	// �ʺ� �켱 Ž�� �޼���
	private static int BFS() {
		// �湮 ���ε� 1��1 ��Ī
		boolean[][] v = new boolean[rowsize+2][colsize+2];
		// �����¿�
		int [] dr = {-1, 1, 0, 0};
		int [] dc = {0, 0, -1, 1};
		int days = 0;
		while(!dq.isEmpty()) {
			// ���߿� ��� 1�� ����Ǿ��µ� ť�� ���鼭 �ϼ��� ������ �� ������ ���� Ȯ�ο� ����
			boolean changed = false;
			// ��ũ�� �� �ִ� �丶��� ��ŭ�� ����(�ѹ� ���� �Ϸ� ����
			for(int range=dq.size(), i=0; i<range; i++) {
				int[] rc = dq.poll();
				// 4�� Ž��
				for(int dir=0; dir<4; dir++) {
					// Ž���� ��ǥ
					int nr = rc[0] + dr[dir];
					int nc = rc[1] + dc[dir];
					// ���̸� ��������
					if(tomato[nr][nc]==-1) {
						continue;
					}
					// ���� �丶���̸� �湮���� �ʾ��� ��
					if(tomato[nr][nc]==0 && v[nr][nc]==false) {
						int[] temp = {nr, nc};
						dq.offer(temp);
						tomato[nr][nc]=1;
						v[nr][nc]=true;
						// �ش� �Ͽ� �丶�䰡 �ٲ���� ���
						changed = true;
					}
				}
			}
			// �丶�䰡 ����Ǿ��ٸ� �ϼ� ����
			if(changed) days++;
		} // end of while isEmpty
		return days;
	} // end of BFS
	
} // end of class
