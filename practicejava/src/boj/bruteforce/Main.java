package src.boj.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


/** Main_����_12100_2048easy_���2_*/
public class Main {
	
	private static int N;
	private static int[][] map;
	private static int total, addedTop;
	private static Stack<Integer> stack;
	
	private static void makeOper(int cnt, int[] oper) {
		if(cnt==5) {
			// �迭 ����
			int[][] cmap = new int[N][N];
			for(int i=0; i<N; i++) cmap[i] = map[i].clone();
			// 5���� �������̼� 
			for(int i=0; i<5; i++) {
//				moveBlock(oper[i], cmap);
				moveBlock(0, cmap);
			}
			// �ִ밪 ã��
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

	// �迭 �̵�
	private static void realMove(int row, int col, int[][] cmap) {
		if(cmap[row][col]==0) {
			return;
		}
		// 0�� �ƴ϶��
		else {
			// ������ ����ִٸ�
			if(stack.isEmpty()) stack.push(cmap[row][col]);
			else {
				// ���ÿ� �����ִ� ���̶� �ٸ� ���̸� �׳� �߰�
				if(cmap[row][col]!=stack.peek()) stack.push(cmap[row][col]);
				// ���� ���� ������ ��
				else {
					// ���ÿ� �ִ� ���� ������ ���� ���̶��
					if(addedTop==stack.peek()) {
						stack.push(cmap[row][col]);
						// �ʱ�ȭ
						addedTop = 0;
					}
					// ��ġ��
					else {
						int temp = stack.pop()*2;
						stack.push(temp);
						addedTop = temp;
					}
					
				} // end of else cmap == stack.peek
			} // end of else !stack.isEmpty
			// �ش� �ڸ� ����ֱ�
			cmap[row][col] = 0;
		} // end of else not zero
	}

	// �̵� ����
	private static void moveBlock(int oper, int[][] cmap) {
		// �����͸� ���� ����
		stack = new Stack<Integer>();
		addedTop = 0;
		switch(oper) {
		case 0: // ���� �ø���
			// �� �Ʒ� ���� ���ۺ��� 
			for(int col=0; col<N; col++) {
				for(int row=N-1; row>=0; row--) {
					realMove(row, col, cmap);
				} // end of for rows 
				// �� ������ �ö���� ��
				int r = 0;
				while(!stack.isEmpty()) {
					cmap[r++][col] = stack.pop();
				}
				addedTop=0;
			} // end of for cols
			break;
		case 1: // ���� ������
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
		case 2: // ���� ��������
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
		case 3: // ���� ����������
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
		 * ���̵��
		 * �̵� ������ 1, 2, 3, 4�� �ΰ�
		 * 1, 2, 3, 4�� 5���� ���� �� �ִ� ��� �������� ���� ���� ū ���� ����Ѵ�. -> 4^5 --> 1024�� ������
		 * 
		 * 1 <= N <= 20   ==> �ִ� 400���� ĭ�� ���� ���� 5 ���� �� 1024�� --> 400*5*1024 = 2048000���� ����? 
		 * �־����� ����Ű�� ���� ���� �ջ�����
		 * 
		 * 0	1	2	3
		 * ��	��	��	��
		 */
		
		// ������ ũ��
		N = Integer.parseInt(br.readLine());
		// ������ �ʱ�ȭ
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



