package src.boj.bruteforce;

import java.io.*;
import java.util.*;

public class Main_����_1799_���_���1_160ms {
	
	private static class Point{
		int row, col;
		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	private static int N, B, W;
	private static int max = 0;
	private static boolean[] RtoL, LtoR;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		/*
		 * �ٴ��� ���� ���� �и��ؼ� �����ؾ� �Ѵ�. --> �ð� ���⵵ �������� �پ��...
		 * ������ ����� ���� 1�� �������� �ʱ� ������. �̷��� Ư���� �츮�� ����� �� ����.
		 * 
		 * �����ʿ��� ���� �Ʒ��� �������� �밢���� ���
		 * row+col = i�� ��ġ
		 * ���ʿ��� ������ �Ʒ��� ���� �밢����
		 * ���� �ٴ��� 0���̶� �������� �� 
		 * col - row + (N-1) �� ���� ���´�.
		 * 
		 * �� Ư���� �̿��ϴ� boolean �迭�� ���� ����
		 */
		
		N = Integer.parseInt(br.readLine());
		
		ArrayList<Point> black = new ArrayList<>();
		ArrayList<Point> white = new ArrayList<>();
		
		RtoL = new boolean[2*N-1]; LtoR = new boolean[2*N-1];
		
		String temp = "";
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				temp = st.nextToken();
				if(temp=="1") {
					if((i+j)%2==0) black.add(new Point(i, j));
					else white.add(new Point(i, j));
				}
			}
		} // end of initialize
		
		go(0, black.size(), 0, black);
		B = max;
		max = 0;
		go(0, white.size(), 0, white);
		W = max;
		
		System.out.println(B+W);
		
	} // end of main 
	
	private static void go(int start, int size, int picked, ArrayList<Point> bishop) {
		if(start==size) {
			if(max<picked) max = picked;
			return;
		} // end of �������� 
		
		for(int i=start; i<size; i++) {
			if(BishopAble(bishop.get(i))) {
				setBishop(bishop.get(i), true);
				go(i+1, size, picked+1, bishop);
				setBishop(bishop.get(i), false);
			} // end if if 
		} // end of for
		
	} // end of go 

	private static boolean BishopAble(Point point) {
		if(RtoL[point.row+point.col] || LtoR[(point.col-point.row)+(N-1)]) return false;
		return true;
	} // end of BishopAble
	
	private static void setBishop(Point point, boolean flag) {
		RtoL[point.row+point.col] = LtoR[(point.col-point.row)+(N-1)] = flag;
	} // end of setBishop

} // end of class 












