package src.boj.implement;

import java.io.*;
import java.util.*;

public class Main_����_3190_��_���5_88ms {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		/*
		 * Head�� Tail�� ����ؾ� �ϴϱ� Dequeue�� ������� �������� �����ϸ� �ɰ� ����. ���� ��ȯ�� ���� ���� HashMap�� �������.
		 * �������� ������� ��������
		 */

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N + 2][N + 2];
		// ���� ����� ����, ���� ����� �����ϰ� =2�� ó��. 
		Arrays.fill(map[0], 2);
		Arrays.fill(map[N + 1], 2);
		for (int i = 1; i <= N; i++)
			map[i][0] = map[i][N + 1] = 2;
		
		// ����� ��ġ�� �Է� �޴´�.
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}

		// ������ ��ȭ�� HashMap�� �����Ѵ�.
		int L = Integer.parseInt(br.readLine());
		HashMap<Integer, Character> changeDirection = new HashMap<Integer, Character>();
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			changeDirection.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
		}

		System.out.println(go(map, changeDirection));

	} // end of main

	private static int go(int[][] map, HashMap<Integer, Character> changeDirection) {
		int time = 0;
		// �� �� �� ��
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		Deque<int[]> dq = new ArrayDeque<int[]>();
		dq.offer(new int[] { 1, 1 }); // row, col
		map[1][1] = 2;

		int[] curr = new int[2];
		int nr, nc, dir;
		dir = 0;
		while (true) {
			// ���� �Ӹ��� Ȯ��
			curr = dq.peekLast();
			time++;
			// 1. �Ӹ��� ��ĭ ������
			nr = curr[0] + dr[dir];
			nc = curr[1] + dc[dir];
			// 2. ���̰ų� ���� ���� ������ ����
			if (map[nr][nc] == 2) 
				break;
			// 3. ������ �� �ִٸ� ������ ó��
			dq.offer(new int[] { nr, nc });
			// 4.1 ����� �ִٸ� �԰�
			if (map[nr][nc] != 1) {
				// ���� ���� ����.
				curr = dq.poll();
				map[curr[0]][curr[1]] = 0;
			}
			// ������ ó��(������ map[nr][nc]=2�� �ٲٰ� �˻��ϸ� �̻�����
			map[nr][nc] = 2;
			// 5. ���� ������ �䱸�Ǹ� ����
			if (changeDirection.containsKey(time)) {
				// �������� 90��
				if (changeDirection.get(time).equals('D'))
					dir = (dir + 1) % 4;
				else // �������� 90��
					dir = (dir + 3) % 4;
			}
		} // end of while
		return time;
	} // end of go

} // end of class
