package src.boj.dp;
import java.util.Scanner;

public class Main_����_11726_2xnŸ�ϸ�_�ǹ�3_116ms {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.close();
		// 1�� �ԷµǸ� 2x1 Ÿ�� �Ѱ��ϱ� ��� �� ����
		if(n==1) System.out.println(1);
		else {
			// 2 �̻��� �� �Ǻ���ġ
			long[] D = new long[n+1];
			D[1] = 1;
			D[2] = 2;
			for(int i=3; i<=n; i++) {
				D[i] = (D[i-1] + D[i-2])%10007 ;
			}
			
			System.out.println(D[n]);
		}
	}
}