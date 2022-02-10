package src.boj.data_structure;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main_����_1158_�似Ǫ������_�ǹ�5_572ms {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		Deque<Integer> deque = new ArrayDeque<>();
		for(int i=1; i<=N; i++) {
			deque.offer(i);
		}
		
		sb.append("<");
		
		for(int i=0; i<N; i++) {
			int idx = 0;
			// �似Ǫ�� ������ ã�� �ݺ���
			while(true) {
				idx++;
				int curr = deque.pop();
				if(idx!=K) {
					deque.offerLast(curr);
				}
				else {
					sb.append(curr).append(",").append(" ");
					break;
				}
			} // end of �似Ǫ�� ���� 
		} // end of for main
		
		sb.setLength(sb.length()-2);
		sb.append(">");
		
		System.out.println(sb.toString());
		
	} // end of main
} // end of class
