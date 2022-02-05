package src.boj.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/** Main_백준_9252_LCS2_골드4_196ms*/
public class Main_백준_9252_LCS2_골드4_196ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		int r = s2.length();
		int c = s1.length();
		int[][] LCS = new int[r+1][c+1];
		
		for(int row=1; row<=r; row++) {
			for(int col=1; col<=c; col++) {
				if(s2.charAt(row-1)==s1.charAt(col-1)) {
					LCS[row][col] = LCS[row-1][col-1] + 1;
				}
				else {
					LCS[row][col] = Math.max(LCS[row-1][col], LCS[row][col-1]);
				}
			}
		}
		// LCS의 최대 길이를 저장
		int len = LCS[r][c];
		sb.append(len).append("\n");
		if(len==0) {
			System.out.println(sb.toString());
			System.exit(0);
		}
		Stack<Character> stack = new Stack<>();
		// LCS 탐색하면서 출력할 데이터 넣기, 데이터 추가할 때도 좌, 위와 비교했으니 똑같이 진행해주자
		while(r>=1 && c>=1) {
			// 현재 값과 좌측 값이 일치하는 경우 좌측으로 이동
			if(LCS[r][c]==LCS[r][c-1]) {
				c--;
			}
			// 현재 값과 위 값와 같으면 위로 이동
			else if(LCS[r][c]==LCS[r-1][c]){
				r--;
			}
			// 좌, 위와 같지 않다면 대각으로 이동
			else {
				stack.push(s1.charAt(c-1));
				r--; c--;
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb.toString());
	}
}
