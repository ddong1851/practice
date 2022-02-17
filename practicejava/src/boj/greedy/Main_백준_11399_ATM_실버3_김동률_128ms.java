package src.boj.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_����_11399_ATM_�ǹ�3_�赿��_128ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		/*
		 * ���� ���� ���� �� 
		 * ������ ���� ���տ� ���Ѵ� -> �ݺ�
		 */
		
		int[] atm = new int[n];
		for(int i=0; i<n; i++) {
			atm[i] = Integer.parseInt(st.nextToken());
		}
		// �������� ����
		Arrays.sort(atm);
		int total = 0;
		int added = 0;
		for(int time:atm) {
			added+=time;
			total+=added;
		}
		System.out.println(total);
	}
}
