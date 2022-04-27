package src.boj.bruteforce;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String start = br.readLine();
		String target = br.readLine();
		
		Queue<String> q = new LinkedList<>();
		q.offer(start);
		
		String curr = "";
		boolean found = false;
		int size = target.length();
		while(!q.isEmpty()) {
			curr = q.poll();
			if(curr.equals(target)) {
				found = true;
				break;
			}
			if(curr.length()<size) {
				StringBuilder sb = new StringBuilder();
				sb.append(curr);
				// 문자열 뒤에 A 추가
				q.offer(sb.append("A").toString());
				// 문자열 뒤집고 B 추가
				sb.setLength(sb.length()-1);
				q.offer(sb.reverse().append("B").toString());;
			}
		} // end of while 
		 
		System.out.println(found?1:0);
		
	} // end of main 
} // end of class 























