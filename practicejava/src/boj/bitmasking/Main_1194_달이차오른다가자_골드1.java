package src.boj.bitmasking;
import java.io.*;
import java.util.*;

public class Main_1194_달이차오른다가자_골드1 {

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
			this.keys = keys; // 7자리 bit로 0ABCDEF 열쇠 표현
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

				// 문자가 무엇인지 검사하여, 값 저장해두기
				// 빈칸, 벽, 출구 필요 없음

				// 민혁이의 시작 위치 저장
				if (map[row][col] == '0') {
					start = new Node(row, col, 1);
				}
			}
		} // 입력

		System.out.print(bfs(start));

	} // main()

	public static int bfs(Node start) {
		Queue<Node> queue = new LinkedList<Node>();
		boolean[][][] visited = new boolean[N][M][130]; // 열쇠없음,A,B,C,D,E,F 방문상태 체크용 배열
		visited[start.row][start.col][1] = true; // 열쇠가 없을 때 방문했다면 1로 체크
		queue.offer(start);

		int move = 0; // 이동 횟수

		while (!queue.isEmpty()) {

			int size = queue.size(); // depth

			while (--size >= 0) {

				Node cur = queue.poll();

				// 탈출에 성공했다면
				if (map[cur.row][cur.col] == '1') return move;

				// 4개의 방향에 대해서
				for (int i = 0; i < 4; i++) {
					int newR = cur.row + dr[i];
					int newC = cur.col + dc[i];

					// 예외 1: 범위 벗어나거나, 벽인 경우
					if (newR < 0 || newC < 0 || newR >= N || newC >= M || map[newR][newC] == '#') continue;

					// 예외 2: 이미 방문함
					if (visited[newR][newC][cur.keys]) continue;

					// 방문이 가능하다
					visited[newR][newC][cur.keys] = true;
					Node next = new Node(newR, newC, cur.keys); // 기존 열쇠를 물려받는다

					// 경우 1 : 새로운 열쇠칸에 진입한 경우(소문자 97~102)
					if (map[newR][newC] >= 97 && map[newR][newC] <= 102) {
						// 열쇠는 a,b,c,d,e,f 이므로 1,2,3,4,5,6 에 대응. 96을 빼주면 된다
						next.keys |= 1 << (map[newR][newC] - 'a' + 1); // 해당 key를 보유한것으로 체크
						visited[newR][newC][next.keys] |= true; // 해당 key를 보유하고 방문한것으로 체크
					}

					// 경우 2 : 대문칸에 진입한 경우(대문자 65~70)
					else if (map[newR][newC] >= 65 && map[newR][newC] <= 70) {
						// 내가 열쇠를 갖고있는지 체크 ( -64 해주면 된다), 안갖고있으면 탐색이 불가능한 것이다
						if ((next.keys & 1 << (map[newR][newC] - 'A' + 1)) == 0) continue;
					}
					// 경우 3 : 그냥 빈칸이거나. 이제 탐색이 가능하다

					queue.offer(next);
				}
			}

			move++;
		}

		return -1; // 탈출 실패

	} // bfs()

}