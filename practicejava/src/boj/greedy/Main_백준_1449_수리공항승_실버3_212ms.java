package src.boj.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Main_����_1149_�������׽�_�ǹ�3_212ms
 * @author HD
 *
 */
public class Main_����_1449_�������׽�_�ǹ�3_212ms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//		���� ���� �� n, �������� ���� L
		int n = sc.nextInt(); int l = sc.nextInt();
//		���� ���� ���� ��ġ�� ���� �迭
		int [] data = new int[n];
		for (int i = 0; i < n; i++) {
			data[i] = sc.nextInt();
		} // end of for 
		sc.close();
		
//		�迭 �������� ����
		Arrays.sort(data);
//		�迭 ���ݰ� ���̸� �ջ��Ͽ� ������ �迭 
		int [] difference = new int[n-1];
		for(int i=0; i<n-1; i++) {
			difference[i] = data[i+1] - data[i];
		} // end of for
//		�������� ���̿� �迭�� �ְ� ������ ����ϴ� �޼���
		solution(l, difference);
	} // end of main
	
	static void solution(int tape, int[] arr) {
//		�� ���� ������ �շ��� �������� �ʿ��ϴ� count=1; 
		int count=1; int tlen = 0;
//		���� �迭�� ������ŭ �ݺ����� ������. 
		for(int i=0; i<arr.length; i++) {
			tlen += arr[i];
			if(tlen>=tape) {
				count++;
				tlen=0;
				continue;
			}
		}
		System.out.println(count);
	} // end of solution

} // end of class
