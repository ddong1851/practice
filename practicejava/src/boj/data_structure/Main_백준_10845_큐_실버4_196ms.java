package src.boj.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/** Main_백준_10845_큐_실버4_196ms*/
public class Main_백준_10845_큐_실버4_196ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> queue = new ArrayDeque<Integer>();
		for(int i=0; i<N; i++) {		
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push":
				queue.add(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(!queue.isEmpty())
					sb.append(queue.poll());
				else sb.append(-1);
				sb.append("\n");
				break;
			case "size":
				sb.append(queue.size());
				sb.append("\n");
				break;
			case "empty":
				if(queue.isEmpty()) {
					sb.append(1);
				}
				else sb.append(0);
				sb.append("\n");
				break;
			case "front":
				if(!queue.isEmpty()) {
					sb.append(queue.getFirst());
				}
				else sb.append(-1);
				sb.append("\n");
				break;
			case "back":
				if(!queue.isEmpty()) {
					sb.append(queue.getLast());
				}
				else sb.append(-1);
				sb.append("\n");
				break;
			} // end of switch
		} // end of for 
		br.close();
		System.out.println(sb.toString());
		
	} // end of main
} // end of class
