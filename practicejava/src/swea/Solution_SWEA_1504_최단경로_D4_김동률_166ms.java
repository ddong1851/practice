package src.swea;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1504_�ִܰ��_D4_�赿��_166ms {
	
	private static int[][] ladder;
	private static boolean[][] v;
	private static int result;
	static Node X;

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int testCase=1; testCase<=10; testCase++) {
			int tc = Integer.parseInt(br.readLine());
			result = 0;
			// �� ���� 0 ��ǥ �߰� + �Ʒ��� �� �߰�
			ladder = new int[100+1][100+2];
			// ��ٸ� �迭 ������ �ʱ�ȭ
			for(int i=0; i<100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=100; j++) {
					int num = Integer.parseInt(st.nextToken());
					ladder[i][j] = num;
					if(num==2) {
						X = new Node(i-1, j);
					}
				}
			}
			// 0~99�� Ž��
			for(int i=1; i<=100; i++) {
				// ��ٸ��� ��쿡�� Ž��
				if(ladder[0][i]==1) {
					v = new boolean[100+1][100+2];
					go(0, i, i-1);
				}
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	} // end of main
	
	
	private static int[] dr = {0, 0, 1};
	private static int[] dc = {-1, 1, 0};
	private static void go(int r, int c, int idx) {
		Queue<Node> q = new LinkedList<>();
		v[r][c] = true;
		q.offer(new Node(r, c));
		int row=0; int col=0;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			//�� �� �� Ž��
			for(int i=0; i<3; i++) {
				int nr = node.row + dr[i];
				int nc = node.col + dc[i];
				if(ladder[nr][nc]==0) {
					continue;
				}
				if(ladder[nr][nc]==1 && !v[nr][nc]) {
					row = nr;
					col = nc;
					q.offer(new Node(nr, nc));
					v[nr][nc] = true;
					break;
				}
			}
		}
		
		if(row==X.row && col==X.col) {
			result = idx;
		}
	}
	
} // end of class

class Node{
	public int row;
	public int col;
	public Node(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
}
