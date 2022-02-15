package src.boj.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/** Main_����_5430_AC_���5_1020ms*/
public class Main_����_5430_AC_���5_1020ms {
	
	public static StringBuilder sb, result;
	public static Deque<Integer> dq;
	/** �¿� ���� ����, 1�̸� �ƴ�, -1�̸� ����*/
	public static int FB;
	public static boolean error;
	public static String ERR = "error";
	
	public static void main(String[] args) throws Exception{
		
		/*
		 * 1 <= TC <= 100
		 * 1 <= �Լ�P <= 100_000
		 * 0 <= N <= 100_000 	�迭�� ũ��
		 * ��ũ�� ���� �����ϸ� �ȴ�.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		result = new StringBuilder();
		
		for(int testcase=1; testcase<=TC; testcase++) {
			// �ʱ�ȭ
			dq = new ArrayDeque<Integer>();
			sb = new StringBuilder();
			FB = 1;
			error = false;
			// ������ �Լ�
			char[] oper = br.readLine().toCharArray();
			int N = Integer.parseInt(br.readLine());
			
			// �迭 �� �߰�
			StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
			for(int i=0; i<N; i++) {
				dq.offer(Integer.parseInt(st.nextToken()));
			}
			
			// ��� �޼��� ����
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
				// �տ������� �� ��
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
					sb.setLength(sb.length()-1); // , ����
				}
				sb.append("]").append("\n");
			}
			
			result.append(sb.toString());
		} // end of for testcase
		
		
		// ���� ���
		System.out.println(result.toString());
		
	} // end of main
	
	private static void Delete() {
		if(FB==1) {
			// dq.isEmpty�� �� poll Request�� �ϸ� null�� ��ȯ
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

