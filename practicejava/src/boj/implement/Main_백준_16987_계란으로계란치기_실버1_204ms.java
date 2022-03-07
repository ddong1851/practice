package src.boj.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** Main_����_16987_������ΰ��ġ��_�ǹ�1_204ms*/
public class Main_����_16987_������ΰ��ġ��_�ǹ�1_204ms {
	
	private static int N, total;
	private static int[] durability;
	private static int[] weight;

	public static void main(String[] args) throws Exception{
		
		/*
		 * ����� �������� ���԰� �������ִ�.
		 * ������� ����� ġ�ԵǸ�, �� ����� �������� ��� ����� ���Ը�ŭ �پ���.
		 * �������� 0 ���ϰ� �Ǹ� ����� ������. 
		 * 
		 * �Ϸķ� �����ִ� ����� ���� ���ʺ��� �� �� ������ �ٸ� ����� �� �ִ��� ���� ����� ���� ����
		 * 1 ���� ���� ����� ���
		 * 2 �ٸ� ����� ģ��. ��. �տ� �� ����� �����ų�, ������ ���� �ٸ� ����� ������ ġ�� �ʰ� �Ѿ��. �̶� ����� ����ġ��Ų��,
		 * 3 �ֱٿ� ����� ��� ������ �ִ� ����� ��� ������ ���� ��� �� �ϳ��� ģ��. 
		 * �� ���� �ֱٿ� �� ����� ���� �����ʿ� ��ġ�� ����� ��� �����Ѵ�
		 * 
		 * ��Ʈ��ŷ ����,
		 * + ������ ������� ���� ���� ����� �����Ѵ�
		 * --> ��� �Ʊ� �ݳ� �ݺ�
		 * ���� �����ʿ� ��ġ�� ����� ��� �ȴٸ� return total(���� ��� ��)
		 * + �� �� �ִ� ����� ���� ��� return
		 */
		
		// �ʱ�ȭ ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 1 <= N <= 8 
		durability = new int[N];
		weight = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			durability[i] = Integer.parseInt(st.nextToken());
			weight[i] = Integer.parseInt(st.nextToken());
		}
		total = 0;
		// ���° ���, ���� ��� ��
		go(0, 0);
		
		System.out.println(total);
	} // end of main
	

	private static void go(int picked, int broken) {
		// ���� ������ �ִ� ����� ����� ��� + �� �� �ִ� ����� ���� ���
		if(picked==N || N-broken == 1) {
			total = Math.max(total, broken);
			return;
		}
		// �ݺ���
		for(int i=0; i<N; i++) {
			// ���� �տ� �� ����̶��
			if(picked==i) continue;
			// ��� �ִ� ����� ���� ����̸� + �Ʒ����� �̹� ���� ������� �ջ� ��
			if(durability[picked]<=0) {
				// ���� ���
				go(picked+1, broken);
				return;
			}
			// ��� ����� �̹� ���� ����̶��
			if(durability[i]<=0) continue;
			int breakEggs = 0;
			// ������� �������
			durability[picked]-=weight[i];
			durability[i]-=weight[picked];
			
			// ������� ����� �ļ� ���� ��� �� ī����
			if(durability[picked]<=0) breakEggs++;
			if(durability[i]<=0) breakEggs++;
			
			go(picked+1, broken+breakEggs);
			
			// �ٸ� ��� �������� Ž���� ���� ����
			durability[picked]+=weight[i];
			durability[i]+=weight[picked];
		}
	} // end of go()
} // end of class
