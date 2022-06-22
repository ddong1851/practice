package src.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_오래된스마트폰 {

	private static int N, O, M, target, temp;
	private static int[] nums = new int[10];
	private static char[] oper = new char[5];
	private static int johap[] = new int[1000];
	private static int joCnt;
	private static int johapNumCnt[] = new int[1000];
	private static int johapUsed[] = new int[1000];
	private static int best[] = new int[1000];
	private static int used[] = new int[1000];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		/*
		 * 숫자들로 만들 수 있는 모든 조합을 먼저 만들고
		 * 다음 숫자들을 합치며 연산을 해본다.
		 * 
		 * 연산 후 값이 0~999인지 확인도 하고
		 * 등등의 가지치기를 진행한다.
		 * 
		 * 
		 * 
		 */

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			O = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < O; i++) {
				temp = Integer.parseInt(st.nextToken());
				if (temp == 1)
					oper[i] = '+';
				else if (temp == 2)
					oper[i] = '-';
				else if (temp == 3)
					oper[i] = '*';
				else if (temp == 4)
					oper[i] = '/';
			}

			target = Integer.parseInt(br.readLine());

			go();
			init();
			int ret = 0;
			if (best[target] != 99)
				ret = best[target];
			else {
				for (int i = 0; i < joCnt; i++) {
					getMinTouchCnt(johapNumCnt[i], johap[i]);
				}
				ret = best[target] + 1;
			}

			if (best[target] == 99)
				ret = -1;

			sb.append("#").append(tc).append(" ").append(ret).append("\n");
		} // end of for

		System.out.println(sb.toString());

	} // end of main

	private static void init() {
		for (int i = 0; i < 1000; i++) {
			best[i] = 99;
			used[i] = 0;
		}
		for (int i = 0; i < joCnt; i++) {
			int num = johap[i];
			best[num] = johapNumCnt[i];
		}
	}

	private static void go() {
		for (int i = 0; i < 1000; i++) {
			johap[i] = 0;
			johapUsed[i] = 0;
			johapNumCnt[i] = 0;
		}
		joCnt = 0;
		getJoHapDFS(0, 0);
		for (int i = 0; i < 1000; i++) {
			if (johapUsed[i] == 0)
				continue;
			johap[joCnt] = i;
			if (i < 10)
				johapNumCnt[joCnt] = 1;
			else if (i < 100)
				johapNumCnt[joCnt] = 2;
			else if (i < 1000)
				johapNumCnt[joCnt] = 3;
			joCnt++;
		}
	} // end of go

	private static void getJoHapDFS(int lev, int sum) {
		for (int i = 0; i < N; i++) {
			int next = sum * 10 + nums[i];
			if (next > 999)
				continue;
			if (johapUsed[next] == 1)
				continue;
			johapUsed[next] = 1;
			getJoHapDFS(lev + 1, next);
		}
	} // end of getJohapDFS

	private static void getMinTouchCnt(int touchCnt, int now) {
		for (int x = 0; x < O; x++) {
			for (int i = 0; i < joCnt; i++) {
				int num = johap[i];
				int nextCnt = touchCnt + johapNumCnt[i] + 1;
				if (nextCnt > M - 1)
					break;
				if (oper[x] == '/' && num == 0)
					continue;
				int next = getCalResult(now, oper[x], num);

				if (oper[x] == '+' && next > 999)
					break;
				if (oper[x] == '-' && next < 0)
					break;
				if (oper[x] == '*' && next > 999)
					break;
				if (used[next] == 1)
					continue;
				if (best[next] <= nextCnt)
					continue;

				best[next] = nextCnt;
				used[next] = 1;
				getMinTouchCnt(nextCnt, next);
				used[next] = 0;
			}
		}
	} // end of getMinTouchCnt

	private static int getCalResult(int a, char oper, int b) {
		if (oper == '*')
			return a * b;
		if (oper == '-')
			return a - b;
		if (oper == '/')
			return a / b;
		return a + b;
	} // end of getCalResult

} // end of class
