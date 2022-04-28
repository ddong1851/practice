package src.boj.greedy;

import java.io.*;
import java.util.*;

import com.sun.org.apache.xml.internal.utils.StringBufferPool;

public class Main_����_12904_A��B_���5_100ms {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String start = br.readLine();
		String target = br.readLine();
		
		/*
		 * start -> target ���������� 
		 * target -> start �� �����ؾ� �׸����ϰ� ������ Ǯ �� �ִ�.
		 * �ֳ��ϸ�, start -> target�� ������������ A�� B�� ���̸� ��������
		 * target->start�� Ư�� ������ �����ؾ� start�� �ٰ��� �� �ֱ� �����̴�.
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
				// �� �ڰ� A��� A�� ����
				if(curr.charAt(len-1)=='A') {
					q.offer(curr.substring(0, len-1));
				}
				// �� �ڰ� B��� B�� ���� �����´�.
				if(sb.toString().charAt(len-1)=='B') {
					sb.setLength(len-1);
					q.offer(sb.reverse().toString());
				}
			}
		} // end of while 
		
		System.out.println(found?1:0);
		
	} // end of main 
} // end of class 























