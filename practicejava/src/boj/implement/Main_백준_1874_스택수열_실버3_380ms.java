package src.boj.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 
 * API를 사용하지 않고
 * 메서드를 만들어서 사용하게 된다면 
 * 시간적 이득을 볼 수 있다.
 */

/** Main_백준_1874_스택수열_실버3_380*/
public class Main_백준_1874_스택수열_실버3_380ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		// 1부터 추가될 변수
		
		// in을 1로 두면 1만 입력했을 때 EmptyStackException 발생
		int in = 0;
		for(int i=0; i<n; i++) {
			// 타겟인 숫자 지정
			int target = Integer.parseInt(br.readLine());
			// 값을 추가해야 하는 경우
			if(target > in) {
				for(int j=in+1; j<=target; j++) {
					sb.append("+").append("\n");
					stack.push(j);
					in++;
				}
				// in = target 로 하면 연산 횟수를 줄일 수 있다
			}
			
			// stack의 맨위값이 target과 일치하지 않는 경우
			else if(stack.peek()!=target) {
				System.out.println("NO");
				// NO 출력하고 바로 탈출
				System.exit(0);
			}
			
			// 무조건 하나 빼기, 4를 넣고 바로 뺼 수 있게 <--- 조건으로 빼려다가 한 30분 버렸어요
			stack.pop();
			sb.append("-").append("\n");
			
		}
		System.out.println(sb.toString());
	}
}
