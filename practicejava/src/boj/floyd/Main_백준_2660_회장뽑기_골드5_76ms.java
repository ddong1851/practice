package src.boj.floyd;

import java.io.*;
import java.util.*;

public class Main_����_2660_ȸ��̱�_���5_76ms {
	
	public static void main(String[] args) throws Exception{
		
		/*
		 * �÷��̵� �ͼ� �⺻ ���� ����
		 * �÷��̵� �ͼ��� ģ�� ���踦 ���� ����? ���Ѵ�.
		 * map�� �����鼭 ģ�� ���� �� �ִ밪�� �������� Ȯ���Ѵ�.
		 * 
		 * ���� ģ�� ������ ����, ȸ�� �ĺ��� list�� ���
		 * list�� ����ϸ� ��
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N+1][N+1];
		// ģ���� �� 50���� �� �� ������, ģ�� ������ �ִ밪�� 50���� �����ߴ�.
		for(int i=1; i<=N; i++) Arrays.fill(map[i], 50);
		StringTokenizer st = null;
		int a, b;
		while(true) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if(a==-1 && b==-1) break;
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		// �÷��̵� �ͼ�
		int temp = 0;
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(i==k || i==j) continue;
					temp = map[i][k] + map[k][j];
					if(map[i][j] > temp) map[i][j] = temp;
				}
			}
		}
		
		// ȸ�� �ĺ��� ��� ���� ����Ʈ
		ArrayList<Integer> list = new ArrayList<>();
		int min = 50; // �ִ� ���� 50������
		for(int i=1; i<=N; i++) {
			temp = 0;
			for(int j=1; j<=N; j++) {
				if(i==j) continue;
				// �ش� �ĺ��� ģ�� ���� �� �ִ밪�� ����
				temp = Math.max(temp, map[i][j]);
			}
			// ���� ������� ����
			if(temp<min) {
				min = temp;
				list.clear();
				list.add(i);
			}
			// ������ ������ ����Ʈ�� �߰�
			else if(temp==min) list.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(min).append(" ").append(list.size()).append("\n");
		for(Integer i:list) sb.append(i).append(" ");
		
		System.out.println(sb.toString());
		
		
	} // end of main 
	
	
} // end of class 


















