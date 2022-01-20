package src.boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Main_����_18310_���׳�_�ǹ�3_1304ms <br>
 * �� 1���� ���׳��� ���ϴ� ���������� ��� ��ġ�� ���׳��� ���� ȿ���� ����. 
 * �ٸ� �������� ��ű��� ��ġ�� ���� �ٸ��� ������ �����ؾ� �Ѵ�. 
 * @author HD
 *
 */
// ��� ��ġ�� ���� ����ϸ� ���� ������.
public class Main_����_18310_���׳�_�ǹ�3_1304ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int [] houses = new int[n];
		
		for (int i = 0; i < houses.length; i++) {
			houses[i] = sc.nextInt();
		}
		
		Arrays.sort(houses);
		
		int center = n%2==0?n/2-1:n/2;
		System.out.println(houses[center]);
	}
}
