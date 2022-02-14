package src.boj.recursive;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/** Main_����_2961_�����̰�������ִ�����_�ǹ�1_�赿��_124ms*/
public class Main_����_2961_�����̰�������ִ�����_�ǹ�1_�赿��_124ms {
	private static int N;
	private static int[] S;
	private static int[] B;
	private static BigInteger minSB;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		/*
		 * �Ÿ��� ������ �־����� �� �̵��� ���̰� ���� ���� �丮�� ����� ����
		 * ���� ��� �ϳ��� ����Ѵ�
		 * �� 10���� ��ᰡ �־����� 
		 * 
		 * �Է�
		 * ����� ��
		 * 1 <= �Ÿ� ���� <= 1_000_000_000 --> �ִ� 10���� �� �� �ִ� --> ���� int���� ǥ���� �� ������
		 * ���� long, ���� BigInteger �������
		 * -- �κ����� ����
		 */
		
		N = Integer.parseInt(br.readLine());// ����� ��
		S = new int[N];						// �Ÿ�
		B = new int[N];						// ����
		minSB = new BigInteger("99999999999999999");
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			S[i]= Integer.parseInt(st.nextToken());
			B[i]= Integer.parseInt(st.nextToken());
		}
		
		subset(0, new BigInteger("1"), 0, 0);
		
		System.out.println(minSB);
	}

	/** �κ����� ���鰡*/
	private static void subset(int cnt, BigInteger totalS, long totalB, int added) {
		// ��� ��Ḧ Ž������ ��
		if(cnt==N) {
			if(added>0) {
				BigInteger diff = totalS.subtract(new BigInteger(String.valueOf(totalB))).abs();
				if(diff.compareTo(minSB)<0) {
					minSB = diff;
				}
			}
			return;
		}
		// ���� �ʴ´�.
		subset(cnt+1, totalS, totalB, added);
		// �ִ´�
		totalS = totalS.multiply(new BigInteger(String.valueOf(S[cnt])));
		subset(cnt+1, totalS, totalB+B[cnt], added+1);
	}
}
