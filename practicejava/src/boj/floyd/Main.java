package src.boj.floyd;

import java.io.*;
import java.util.*;

/** Main_����_9205_���ָ��ø鼭�ɾ��_�ǹ�1_*/
public class Main {
	
	private static int N;
	private static final int INF = 999_999_999;
	private static int[][] map;
	private static ArrayList<int[]> list;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc<TC; tc++) {
			
			N = Integer.parseInt(br.readLine());
			// �湮 ���� ���� map 
			map = new int[N+2][N+2];
			list = new ArrayList<>();
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				// x, y ��ǥ �Է�
				list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
			
			// ù��° map �ʱ�ȭ
			initMap();
			
			
		}
		
		System.out.println(sb.toString());
		
	} // end of main 

	private static void initMap() {
		for(int i=0; i<N; i++) {
			Arrays.fill(map[i], INF);
		}
		
		
		
	} // end of initMap
	
	
	
} // end of class 















