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

// 메모리 초과
/** Main_백준_1629_곱셈_실버1_undone*/
public class Main_백준_1629_곱셈_실버1_undone {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		/*
		 * 1번 시도
		 * BigInteger을 활용하여 
		 * 2의 지수배만큼씩 증가하게 하여 연산 횟수를 
		 * O(log(N))으로 줄였지만 
		 * 실질적으로 매우 큰 값을 컴퓨터가 연산하게 하여
		 * 메모리가 터지게 되었다.
		 * 
		 * 2번 시도는 정수의 특징을 사용해보겠다.
		 * 나머지를 식으로 표현해보자
		 * 분할 정복 문제로 바꿀 수 있다
		 * --> A^B / C = A^(B-1)/C + A^(B-1)/C --> 분할 정복 -------> A^1/C ----> 이들을 다시 더한다.
		 * --> 재귀를 통한 분할정복 문제 A^1 % C 2개의 합에 %C 의 합에 %C..........
		 * --> result = (result*A)%C 방식을 사용하면 한계값 연산에서 벽을 만나게 된다
		 * 다른 조건(?)으로 접근해야 할거 같다.
		 * 
		 * 3번 접근
		 * 나머지 정리.. 뭐 없나 
		 * --> 정답을 검색해보니 정수론 + 모둘려 법칙을 사용하더라
		 */
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		
		// 2147483646 2147483646 2147483647 여기서 연산의 한계 봉착 --> 계속 한계치 곱셈을 진행하니까
		// result를 BigInteger로 하자
		long result = A%C;
		for(int i=1; i<B; i++) {
			result = (result*A)%C;
		}
		System.out.println(result);
		
		
		// BigInteger를 사용해도 한계값 연산에서 오류가 발생한다.
//		BigInteger ans = new BigInteger(String.valueOf(A%C));
//		for(int i=1; i<B; i++) {
//			ans = ans.multiply(new BigInteger(String.valueOf(A)));
//			ans = ans.remainder(new BigInteger(String.valueOf(C)));
//		}
//		System.out.println(ans);
	}
	
}