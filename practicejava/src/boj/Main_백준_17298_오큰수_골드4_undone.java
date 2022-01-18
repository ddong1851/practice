package src.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


/**
 * Main_백준_17298_오큰수_골드4_
 * @author HD
 *
 */
//시간 제한 1초, 512MB, 
public class Main_백준_17298_오큰수_골드4_undone {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		int [] NGE = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		int i=0;
		
		//먼저 배열에 다 넣는다.
		while(st.hasMoreTokens()) {
			NGE[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		br.close();
		
		i=0;
		while(true) {
			// 값들을 비교해줄 변수, 내가 지금 가리키는 변수
			int num = -1;
			int temp = NGE[i];			
			// 현재 조회중인 변수부터 비교, 
			for(int j=i+1; j<n; j++) {
				// 현재 가리키고 있는 변수보다 
				if(temp<NGE[j]) {
					num = NGE[j];
					break; // for문 탈출
				} 
			}
			stack.push(num);
			if(i==n-1) {
				break;
			}
			i++;		// 다음 칸 조회
		} // end of while
		String str = stack.toString();
		System.out.println(str.substring(1, str.length()-1));
	} // end of main
} // end of class
