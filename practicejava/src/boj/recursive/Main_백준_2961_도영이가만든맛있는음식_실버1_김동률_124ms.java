package src.boj.recursive;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/** Main_백준_2961_도영이가만든맛있는음식_실버1_김동률_124ms*/
public class Main_백준_2961_도영이가만든맛있는음식_실버1_김동률_124ms {
	private static int N;
	private static int[] S;
	private static int[] B;
	private static BigInteger minSB;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		/*
		 * 신맛과 쓴맛이 주어졌을 때 이들의 차이가 가장 작은 요리를 만드는 문제
		 * 재료는 적어도 하나를 사용한다
		 * 총 10개의 재료가 주어진다 
		 * 
		 * 입력
		 * 재료의 수
		 * 1 <= 신맛 쓴맛 <= 1_000_000_000 --> 최대 10억이 올 수 있다 --> 맛은 int으로 표현할 수 있지만
		 * 합은 long, 곱은 BigInteger 사용하자
		 * -- 부분집합 문제
		 */
		
		N = Integer.parseInt(br.readLine());// 재료의 수
		S = new int[N];						// 신맛
		B = new int[N];						// 쓴맛
		minSB = new BigInteger("99999999999999999");
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			S[i]= Integer.parseInt(st.nextToken());
			B[i]= Integer.parseInt(st.nextToken());
		}
		
		subset(0, new BigInteger("1"), 0, 0);
		
		System.out.println(minSB);
	}

	/** 부분집합 만들가*/
	private static void subset(int cnt, BigInteger totalS, long totalB, int added) {
		// 모든 재료를 탐색했을 때
		if(cnt==N) {
			if(added>0) {
				BigInteger diff = totalS.subtract(new BigInteger(String.valueOf(totalB))).abs();
				if(diff.compareTo(minSB)<0) {
					minSB = diff;
				}
			}
			return;
		}
		// 넣지 않는다.
		subset(cnt+1, totalS, totalB, added);
		// 넣는다
		totalS = totalS.multiply(new BigInteger(String.valueOf(S[cnt])));
		subset(cnt+1, totalS, totalB+B[cnt], added+1);
	}
}
