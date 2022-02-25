package src.boj.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


/** Main_백준_12100_2048easy_골드2_*/
public class Main {
	
	private static int N;
	private static int[][] map;
	private static int total, addedTop;
	private static Stack<Integer> stack;
	
	private static void makeOper(int cnt, int[] oper) {
		if(cnt==5) {
			// 배열 복사
			int[][] cmap = new int[N][N];
			for(int i=0; i<N; i++) cmap[i] = map[i].clone();
			// 5번의 오버레이션 
			for(int i=0; i<5; i++) {
//				moveBlock(oper[i], cmap);
				moveBlock(0, cmap);
			}
			// 최대값 찾기
			findmax(cmap);
			return;
		}
		
		for(int i=0; i<4; i++) {
			oper[cnt] = i;
			makeOper(cnt+1, oper);
		}
	}
	
	private static void findmax(int[][] cmap) {
		int max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				max = Math.max(max, cmap[i][j]);
			}
		}
		total = Math.max(total, max);
	}

	// 배열 이동
	private static void realMove(int row, int col, int[][] cmap) {
		if(cmap[row][col]==0) {
			return;
		}
		// 0이 아니라면
		else {
			// 스택이 비어있다면
			if(stack.isEmpty()) stack.push(cmap[row][col]);
			else {
				// 스택에 들어와있는 값이랑 다른 값이면 그냥 추가
				if(cmap[row][col]!=stack.peek()) stack.push(cmap[row][col]);
				// 같은 값이 들어왔을 때
				else {
					// 스택에 있는 값이 이전에 더한 값이라면
					if(addedTop==stack.peek()) {
						stack.push(cmap[row][col]);
						// 초기화
						addedTop = 0;
					}
					// 합치기
					else {
						int temp = stack.pop()*2;
						stack.push(temp);
						addedTop = temp;
					}
					
				} // end of else cmap == stack.peek
			} // end of else !stack.isEmpty
			// 해당 자리 비워주기
			cmap[row][col] = 0;
		} // end of else not zero
	}

	// 이동 지시
	private static void moveBlock(int oper, int[][] cmap) {
		// 데이터를 쌓을 스택
		stack = new Stack<Integer>();
		addedTop = 0;
		switch(oper) {
		case 0: // 전부 올리기
			// 맨 아래 열의 시작부터 
			for(int col=0; col<N; col++) {
				for(int row=N-1; row>=0; row--) {
					realMove(row, col, cmap);
				} // end of for rows 
				// 맨 위까지 올라왔을 때
				int r = 0;
				while(!stack.isEmpty()) {
					cmap[r++][col] = stack.pop();
				}
				addedTop=0;
			} // end of for cols
			break;
		case 1: // 전부 내리기
			for(int col=0; col<N; col++) {
				for(int row=0; row<N; row++) {
					realMove(row, col, cmap);
				} // end of for rows 
				int r = N-1;
				while(!stack.isEmpty()) {
					cmap[r--][col] = stack.pop();
				}
				addedTop=0;
			}
			break;
		case 2: // 전부 왼쪽으로
			for(int row=0; row<N; row++) {
				for(int col=N-1; col>=0; col--) {
					realMove(row, col, cmap);
				} // end of for rows 
				int c = 0;
				while(!stack.isEmpty()) {
					cmap[row][c++] = stack.pop();
				}
				addedTop=0;
			} // end of for cols
			break;
		case 3: // 전부 오른쪽으로
			for(int row=0; row<N; row++) {
				for(int col=0; col<N; col++) {
					realMove(row, col, cmap);
				} // end of for rows 
				int c = N-1;
				while(!stack.isEmpty()) {
					cmap[row][c--] = stack.pop();
				}
				addedTop=0;
			} // end of for cols
			break;
		default: break;
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		/*
		 * 아이디어
		 * 이동 방향을 1, 2, 3, 4로 두고
		 * 1, 2, 3, 4를 5개로 만들 수 있는 모든 가지수에 대해 가장 큰 값을 기억한다. -> 4^5 --> 1024개 가지수
		 * 
		 * 1 <= N <= 20   ==> 최대 400개의 칸에 대해 연산 5 번을 총 1024번 --> 400*5*1024 = 2048000번의 연산? 
		 * 주어지는 방향키에 따라 값을 합산하자
		 * 
		 * 0	1	2	3
		 * 상	하	좌	우
		 */
		
		// 보드의 크기
		N = Integer.parseInt(br.readLine());
		// 게임판 초기화
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		total = 0;
		
		makeOper(0, new int[5]);
		
		System.out.println(total);
		
	} // end of main 

} // end of class 

// --> 2048
//3
//0 8 1024
//4 0 4
//0 1024 32

//5
//2 0 0 0 0
//2 0 0 0 0
//4 0 0 0 0
//2 0 0 0 0
//2 0 0 0 0



