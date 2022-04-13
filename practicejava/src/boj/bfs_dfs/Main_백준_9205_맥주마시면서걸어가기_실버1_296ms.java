package src.boj.bfs_dfs;

import java.io.*;
import java.util.*;

/** Main_����_9205_���ָ��ø鼭�ɾ��_�ǹ�1_296ms*/
public class Main_����_9205_���ָ��ø鼭�ɾ��_�ǹ�1_296ms {
	
	private static int N, dis;
	private static ArrayList<int[]> points = new ArrayList<>();
	private static boolean[][] floyd;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		/*
		 * �÷��̵�� �غ���.
		 * ���� �� ������ �ٸ� ������ �� �� �ִ� ��츦 �Ÿ��� ���� �����ϰ�,
		 * ���� ����� �������� �� �� �ִ� �κ��� �÷��̵�� ����.
		 */
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc=0; tc<TC; tc++) {
			
			N = Integer.parseInt(br.readLine());
			// �� �������� �佺Ƽ�� ��ġ �Է¹ޱ�
			for(int i=0; i<N+2; i++) {
				st = new StringTokenizer(br.readLine());
				points.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
			
			floyd = new boolean[N+2][N+2];
			
			// 1. �� �� ����
			for(int i=0; i<N+2; i++) {
				for(int j=0; j<N+2; j++) {
					if(i==j) continue;
					dis = distance(points.get(i), points.get(j));
					if(dis<=1000) floyd[i][j] = true;
				}
			}
			
			// 2. �÷��̵�
			for(int k=0; k<N+2; k++) {
				for(int i=0; i<N+2; i++) {
					for(int j=0; j<N+2; j++) {
						if(i==k) continue;
						if(floyd[i][k] && floyd[k][j]) floyd[i][j] = true;
					}
				}
			}
			
			// ������ �佺Ƽ�������� �� �� �ִ°�?
			sb.append(floyd[0][N+1]?"happy":"sad").append("\n");
			// ������ ���� ����ֱ�
			points.clear();
		} // end of for 
		
		System.out.println(sb.toString());
		
	} // end of main 
	
	private static int distance(int[] p1, int[] p2) {
		return Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]);
	} // end of distance
	
} // end of class 






