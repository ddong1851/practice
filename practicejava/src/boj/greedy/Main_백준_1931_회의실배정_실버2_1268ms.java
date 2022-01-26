package src.boj.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/** Main_����_1931_ȸ�ǽǹ���_�ǹ�2_1268ms*/
public class Main_����_1931_ȸ�ǽǹ���_�ǹ�2_1268ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		// ȸ�� �ð��� ������ �迭
		int [][] time = new int[n][2];
		
		
		// ȸ�� �ð� ����
		for(int i=0; i<n; i++) {
			time[i][0] = sc.nextInt();
			time[i][1] = sc.nextInt();
		}
		sc.close();
		
		// �� �ð� ���� ����
		Arrays.sort(time, new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[1]==o2[1]) {
					return o1[0]-o2[0];
				}
				else {
					return o1[1]-o2[1];
				}
			}			
		});
		
		
		// ���� �̸� �������� �����Ͽ�, ���� ȸ�� �ð��� �����ϴ� �ð��� ���� ȸ�ǰ� ������ �ð��� ���ų� �� ũ��, 
		// ������ �ð��� �������ϰ�, count�� ������Ų��.
		int count = 1;
		int end = time[0][1];
		for(int i=1; i<n; i++) {
			int start = time[i][0];
			if(end<=start) {
				end = time[i][1];
				count++;
			}
		}
		System.out.println(count);
	}
}	
