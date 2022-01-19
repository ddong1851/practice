 package src.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.Arrays;


/**
 * Main_백준_17298_오큰수_골드4_
 * @author HD
 *
 */
//시간 제한 1초, 512MB, 

//stack에 인덱스를 저장하고 해봐라.
public class Main_백준_17298_오큰수_골드4_undone {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// 스택
		Stack<Integer> stack = new Stack<>();
		// NGE 값들이 저장될 배열
		int [] NGE = new int[n];
		// int형 데이터를 저장할 data
		int [] data = new int[n];
		String [] str = br.readLine().split(" ");
		
		//먼저 배열에 다 넣는다.
		for(int i=0; i<n; i++) {
			data[i] = Integer.parseInt(str[i]);
		}
		
		// NGE배열을 -1로 초기화
		Arrays.fill(NGE,-1);
		
		
		// 0번째 인덱스를 스택에 넣는다.
		stack.push(0);
		int idx = 0;
		// 스택이 비어있지 않을 때 계속 반복
		while(!stack.isEmpty()) {
			// 값을 비교해줄 temp 변수, 데이터의 첫번째 데이터로 초기화한다. 
			int temp = data[idx++];
			// 현재 비교대상인 값이랑, 스택의 맨 위 idx 값이랑 비교
			for(int j=idx; j<idx; j++) {
				stack.push(idx);
				if(temp<data[stack.peek()]) {
					
				}
				
			}
			stack.pop();
		} // end of while
		
		for(int i:NGE) {
			System.out.print(i+" ");
		}
		/*
TC
4
9 5 4 8
		 */
		br.close();
	} // end of main
} // end of class
