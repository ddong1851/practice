package src.boj.undone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.math.BigInteger;
import java.util.StringTokenizer;


/* TestCase
2147483646 2147483646 2147483647
1
2147483645 3 2147483647
2147483639
2147483645 4 2147483647
16
2 222 41 
4
3 200 241
225
 */

// �޸� �ʰ�
/** Main_����_1629_����_�ǹ�1_undone*/
public class Main_����_1629_����_�ǹ�1_undone {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		/*
		 * 1�� �õ�
		 * BigInteger�� Ȱ���Ͽ� 
		 * 2�� �����踸ŭ�� �����ϰ� �Ͽ� ���� Ƚ���� 
		 * O(log(N))���� �ٿ����� 
		 * ���������� �ſ� ū ���� ��ǻ�Ͱ� �����ϰ� �Ͽ�
		 * �޸𸮰� ������ �Ǿ���.
		 * 
		 * 2�� �õ��� ������ Ư¡�� ����غ��ڴ�.
		 * �������� ������ ǥ���غ���
		 * ���� ���� ������ �ٲ� �� �ִ�
		 * --> A^B / C = A^(B-1)/C + A^(B-1)/C --> ���� ���� -------> A^1/C ----> �̵��� �ٽ� ���Ѵ�.
		 * --> ��͸� ���� �������� ���� A^1 % C 2���� �տ� %C �� �տ� %C..........
		 * --> result = (result*A)%C ����� ����ϸ� �Ѱ谪 ���꿡�� ���� ������ �ȴ�
		 * �ٸ� ����(?)���� �����ؾ� �Ұ� ����.
		 * 
		 * 3�� ����
		 * ������ ����.. �� ���� 
		 * --> ������ �˻��غ��� ������ + ��ѷ� ��Ģ�� ����ϴ���
		 */
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		
		// 2147483646 2147483646 2147483647 ���⼭ ������ �Ѱ� ���� --> ��� �Ѱ�ġ ������ �����ϴϱ�
		// result�� BigInteger�� ����
		long result = A%C;
		for(int i=1; i<B; i++) {
			result = (result*A)%C;
		}
		System.out.println(result);
		
		
		// BigInteger�� ����ص� �Ѱ谪 ���꿡�� ������ �߻��Ѵ�.
//		BigInteger ans = new BigInteger(String.valueOf(A%C));
//		for(int i=1; i<B; i++) {
//			ans = ans.multiply(new BigInteger(String.valueOf(A)));
//			ans = ans.remainder(new BigInteger(String.valueOf(C)));
//		}
//		System.out.println(ans);
	}
	
}