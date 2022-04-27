package src.boj.greedy;

import java.io.*;
import java.util.*;

public class Main_����_24374_����_���3_84ms {
	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] weights = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			weights[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(weights);
		int check = 0;
		for(int w:weights) {
			if(check+1 < w) break;
			check+=w;
		}
		// ������ ����� ����� ����
		// 11234��� ���� �־����ٰ� ��������
		// �켱 Ȯ���ؾ� �� ����, ���� ã�����ϴ� ����, �� ������ + 1�� ��.
		// �ֳ��ϸ� ���� �� ���� ���� �� �ּڰ���
		// ���� �� �ִ� ��+1 �� ���� �� ���� ���� ���̱� �����̴�.
		System.out.println(check+1);
	} // end of main
	
} // end of class 








