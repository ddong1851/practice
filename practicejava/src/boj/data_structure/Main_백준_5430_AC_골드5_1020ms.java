package src.boj.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/** Main_백준_5430_AC_골드5_1020ms*/
public class Main_백준_5430_AC_골드5_1020ms {
	
	public static StringBuilder sb, result;
	public static Deque<Integer> dq;
	/** 좌우 반전 여부, 1이면 아님, -1이면 반전*/
	public static int FB;
	public static boolean error;
	public static String ERR = "error";
	
	public static void main(String[] args) throws Exception{
		
		/*
		 * 1 <= TC <= 100
		 * 1 <= 함수P <= 100_000
		 * 0 <= N <= 100_000 	배열의 크기
		 * 데크를 직접 구현하면 된다.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		result = new StringBuilder();
		
		for(int testcase=1; testcase<=TC; testcase++) {
			// 초기화
			dq = new ArrayDeque<Integer>();
			sb = new StringBuilder();
			FB = 1;
			error = false;
			// 실행할 함수
			char[] oper = br.readLine().toCharArray();
			int N = Integer.parseInt(br.readLine());
			
			// 배열 값 추가
			StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
			for(int i=0; i<N; i++) {
				dq.offer(Integer.parseInt(st.nextToken()));
			}
			
			// 모든 메서드 실행
			for(int len=oper.length, i=0; i<len; i++) {
				switch(oper[i]) {
				case 'R':
					FB *= -1;
					break;
				case 'D':
					Delete();
					break;
				}
			}
			
			if(error) {
				sb.append(ERR).append("\n");
			}
			else {
				// 앞에서부터 뺄 때
				sb.append("[");
				if(dq.size()>0) {
					if(FB==1) {
						while(!dq.isEmpty()) {
							sb.append(dq.pollFirst()).append(",");
						}
					}
					else {
						while(!dq.isEmpty()) {
							sb.append(dq.pollLast()).append(",");
						}
					}
					sb.setLength(sb.length()-1); // , 삭제
				}
				sb.append("]").append("\n");
			}
			
			result.append(sb.toString());
		} // end of for testcase
		
		
		// 정답 출력
		System.out.println(result.toString());
		
	} // end of main
	
	private static void Delete() {
		if(FB==1) {
			// dq.isEmpty일 때 poll Request를 하면 null을 반환
			if(dq.pollFirst()==null) {
				error = true;
			}
		}
		else {
			if(dq.pollLast()==null) {
				error = true;
			}
		}
	} // end of Delete Method
	
} // end of Main

