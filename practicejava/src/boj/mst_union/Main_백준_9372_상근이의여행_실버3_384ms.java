package src.boj.mst_union;

import java.io.*;
import java.util.StringTokenizer;

/** Main_����_9372_������ǿ���_�ǹ�3_384ms*/
public class Main_����_9372_������ǿ���_�ǹ�3_384ms {
	
	private static int N;

	public static void main(String[] args) throws Exception	{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		/*
		 * ����̰� ���� ���� ������ ����⸦Ÿ�� ��� �������� �湮�� �� �ֵ���
		 * --> MST�� �����϶�
 		 */
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase=0; testcase<T; testcase++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
			}
			
			// MST�� ������ N-1�� ������ �ִ�
			sb.append(N-1).append("\n");
		}
		
		System.out.println(sb.toString());
		
		
	} // end of main
} // end of class
