package src.boj.greedy;

import java.io.*;
import java.util.*;

import com.sun.org.apache.xml.internal.utils.StringBufferPool;

public class Main_백준_12904_A와B_골드5_100ms {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String start = br.readLine();
		String target = br.readLine();
		
		/*
		 * start -> target 유형에서는 
		 * target -> start 로 접근해야 그리디하게 문제를 풀 수 있다.
		 * 왜냐하면, start -> target은 무조건적으로 A나 B를 붙이며 나가지만
		 * target->start는 특정 조건을 만족해야 start로 다가갈 수 있기 때문이다.
		 */
		
		Queue<String> q = new LinkedList<>();
		q.offer(target);
		
		String curr = "";
		StringBuilder sb = null;
		int len = 0;
		boolean found = false;
		int size = start.length();
		while(!q.isEmpty()) {
			curr = q.poll();
			if(curr.equals(start)) {
				found = true;
				break;
			}
			len = curr.length();
			if(len>size) {
				sb = new StringBuilder();
				sb.append(curr);
				// 맨 뒤가 A라면 A를 뺀다
				if(curr.charAt(len-1)=='A') {
					q.offer(curr.substring(0, len-1));
				}
				// 맨 뒤가 B라면 B를 빼고 뒤집는다.
				if(sb.toString().charAt(len-1)=='B') {
					sb.setLength(len-1);
					q.offer(sb.reverse().toString());
				}
			}
		} // end of while 
		
		System.out.println(found?1:0);
		
	} // end of main 
} // end of class 























