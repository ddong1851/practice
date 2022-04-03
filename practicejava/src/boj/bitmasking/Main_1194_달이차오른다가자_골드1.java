package src.boj.bitmasking;
import java.io.*;
import java.util.*;

public class Main_1194_�����������ٰ���_���1 {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int N;
	static int M;

	static char[][] map;

	public static class Node {
		int row;
		int col;
		int keys;

		public Node(int row, int col, int keys) {
			super();
			this.row = row;
			this.col = col;
			this.keys = keys; // 7�ڸ� bit�� 0ABCDEF ���� ǥ��
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		Node start = null;

		for (int row = 0; row < N; row++) {
			String line = br.readLine();

			for (int col = 0; col < M; col++) {
				map[row][col] = line.charAt(col);

				// ���ڰ� �������� �˻��Ͽ�, �� �����صα�
				// ��ĭ, ��, �ⱸ �ʿ� ����

				// �������� ���� ��ġ ����
				if (map[row][col] == '0') {
					start = new Node(row, col, 1);
				}
			}
		} // �Է�

		System.out.print(bfs(start));

	} // main()

	public static int bfs(Node start) {
		Queue<Node> queue = new LinkedList<Node>();
		boolean[][][] visited = new boolean[N][M][130]; // �������,A,B,C,D,E,F �湮���� üũ�� �迭
		visited[start.row][start.col][1] = true; // ���谡 ���� �� �湮�ߴٸ� 1�� üũ
		queue.offer(start);

		int move = 0; // �̵� Ƚ��

		while (!queue.isEmpty()) {

			int size = queue.size(); // depth

			while (--size >= 0) {

				Node cur = queue.poll();

				// Ż�⿡ �����ߴٸ�
				if (map[cur.row][cur.col] == '1') return move;

				// 4���� ���⿡ ���ؼ�
				for (int i = 0; i < 4; i++) {
					int newR = cur.row + dr[i];
					int newC = cur.col + dc[i];

					// ���� 1: ���� ����ų�, ���� ���
					if (newR < 0 || newC < 0 || newR >= N || newC >= M || map[newR][newC] == '#') continue;

					// ���� 2: �̹� �湮��
					if (visited[newR][newC][cur.keys]) continue;

					// �湮�� �����ϴ�
					visited[newR][newC][cur.keys] = true;
					Node next = new Node(newR, newC, cur.keys); // ���� ���踦 �����޴´�

					// ��� 1 : ���ο� ����ĭ�� ������ ���(�ҹ��� 97~102)
					if (map[newR][newC] >= 97 && map[newR][newC] <= 102) {
						// ����� a,b,c,d,e,f �̹Ƿ� 1,2,3,4,5,6 �� ����. 96�� ���ָ� �ȴ�
						next.keys |= 1 << (map[newR][newC] - 'a' + 1); // �ش� key�� �����Ѱ����� üũ
						visited[newR][newC][next.keys] |= true; // �ش� key�� �����ϰ� �湮�Ѱ����� üũ
					}

					// ��� 2 : �빮ĭ�� ������ ���(�빮�� 65~70)
					else if (map[newR][newC] >= 65 && map[newR][newC] <= 70) {
						// ���� ���踦 �����ִ��� üũ ( -64 ���ָ� �ȴ�), �Ȱ��������� Ž���� �Ұ����� ���̴�
						if ((next.keys & 1 << (map[newR][newC] - 'A' + 1)) == 0) continue;
					}
					// ��� 3 : �׳� ��ĭ�̰ų�. ���� Ž���� �����ϴ�

					queue.offer(next);
				}
			}

			move++;
		}

		return -1; // Ż�� ����

	} // bfs()

}