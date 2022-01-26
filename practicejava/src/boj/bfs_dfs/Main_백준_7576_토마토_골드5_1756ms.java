package src.boj.bfs_dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

/**
 * Main_����_7576_�丶��_���5_1756ms
 * @author HD
 *
 */

// ��ǥ�� ť�� �����ϱ� ���� ������ Ÿ�� ����
//class Node{
//	int row;
//	int col;
//	public Node(int row, int col) {
//		super();
//		this.row = row;
//		this.col = col;
//	}
//	public int getRow() {
//		return row;
//	}
//	public int getCol() {
//		return col;
//	}
//}


// -1 �丶�䰡 ���� ĭ, 0 ���� ���� �丶��, 1 ���� �丶��
public class Main_����_7576_�丶��_���5_1756ms {
	public static int [][] box;
	public static boolean[][] visited;
	public static ArrayList<Node> tomato = new ArrayList<>();
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// m = ���� ĭ�� �� n = ���� ĭ�� ��
		int m = sc.nextInt();
		int n = sc.nextInt();
		// �丶�並 ���� ������ ũ�⸦ �������ش�. 
		box = new int[n][m];
		// �湮 ���θ� üũ�� �迭
		visited = new boolean[n][m];
		int zeros = 0;
		
		// ���� ���� ����ŭ �ݺ��� ���� �ڽ��� �ʱ�ȭ�Ѵ�.
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				int num = sc.nextInt();
				box[i][j] = num;
				if(num==1) {
					// �丶�䰡 �ִ� ��ǥ�� �̸� �����Ѵ�.
					tomato.add(new Node(i, j));
				}
				if(num==0) {
					zeros++;
				}
			}
		}
		
//		�丶�� ��ǥ���� ����ƽ���� ����� bfs ���������� ��� ��ǥ���� �ִ´�, �׸��� 0�� ������ 0�ΰ��� Ȯ���ϰ� ����
		bfs(zeros, n, m);
		
	}

//	BFS ����
	private static void bfs(int zeros, int n , int m) {
		// TODO Auto-generated method stub
//		��ǥ�� ���� ť�� �����Ѵ�.
		Deque<Node> deque = new ArrayDeque<>();
//		��� �丶�� ��ǥ�� ��ũ�� �ְ� �湮 ó�� �Ѵ�
		tomato.forEach(to->{
			deque.add(to);
			visited[to.getRow()][to.getCol()] = true;
		});
		
		int zero = zeros;
		// �������� ť�� ���°Ÿ� �ϴϱ� -1? 
		int days = -1;
		
//		�� �� �� �� Ž��
		int [][] dxy = {{-1, 0},{1, 0},{0, -1},{0, 1}};
		
//		���⼭ while������ ������ ù��° �丶�信�� �� ���Ľ�Ű�°� �ƴѰ�
		W:while(!deque.isEmpty()) {
			// ���⼭ ť�� ������ŭ ���鼭 ������ �ǳ�
			int range = deque.size();
			// ť�� ��� ��ǥ���� ���鼭 ������
			for(int repeat=0; repeat<range; repeat++) {
				// ���ʿ� �ִ°� ����
				Node node = deque.pollFirst();
				int r = node.getRow();
				int c = node.getCol();
				// 4�� Ž��
				for(int i=0; i<4; i++) {
					int nr = r + dxy[i][0];
					int nc = c + dxy[i][1];
					// ���� Ȯ��
					if(nr<0 || nr>=n || nc<0 || nc>=m) {
						continue;
					}
					// -1 �̸� �����ϱ�
					if(box[nr][nc] == -1) {
						continue;
					}
					// �湮 ó�� �� ���� + �����ٰ� �ִ´�
					if(box[nr][nc] == 0 && visited[nr][nc]==false) {
						// 0�� ���� -1, �湮 ó��, �ش� ��ǥ ����, ��ũ�� ���� �ִ´�(������ ���� ���Ŵϱ�)
						zero--;
						// 0�� ���� ���ٸ�,
						if(zero==0) {
							days++;
							break W;
						}
						visited[nr][nc] = true;
						box[nr][nc] = 1;
						deque.addLast(new Node(nr,nc));
					}
				}
			}
			// �Ϸ簡 ��������
			days++;
		}
		
		
		if(zero==0) {
			System.out.println(days);
		} else {
			System.out.println(-1);
		}
	}
}
