package src.boj.dp;

import java.io.*;
import java.util.*;

/** Main_����_11660_�����ձ��ϱ�5_�ǹ�1_900ms*/
public class Main_����_11660_�����ձ��ϱ�5_�ǹ�1_900ms {
	private static int[][] map;
	
	private static int go(int sr, int sc, int dr, int dc) {
		/*
		 * -----
		 * | A	|
		 * |____|
		 * | B|C|
		 * -----
		 * C�� ���ϱ� ���� ū ��ü �տ��� -(A+B-�ߺ�)
		 */
		return map[dr][dc] - map[dr][sc-1] - map[sr-1][dc] + map[sr-1][sc-1];
	}

	public static void main(String[] args) throws Exception{
		
		/*
		 * �迭�� �Է� ���� �� 
		 * �ึ���� ���������� �̸� ���� (�� +�� + ����)
		 * �ʿ��� �� ���� ���� ����.
		 * 
		 * �ߺ��� ���� �� ���� ���� ���� �ѹ� ���ش�. 
		 * 
		 * ������ ����� ���
		 * �� + �� - �ߺ� �밢�� + ����
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        map = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                // �� ���� �ش� �� - �밢���� ��� ���� �������� �ش� ��ǥ�� ����
            	map[i][j] = map[i-1][j] + map[i][j-1] - map[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            sb.append(go(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 
            		Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
        }
        
        System.out.println(sb.toString());
		
	}
}