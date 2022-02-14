package src.boj.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/** Main_����_5430_AC_���5_916ms*/
public class Main_����_5430_AC_���5_916ms {
	
	// �迭�� ������ �ִ� ���� �ִ밪���� ����
	static int[] AC;
	static int head, tail;
	static boolean flag, reversed;
	private static StringBuilder sb;
	
	/** AC�迭�� � ���� ������ �� �޼���*/
	private static void addAC(int num) {
		AC[tail++] = num;
	}
	
	private static void D() {
		// ��Ƽ�Ͱ� ���� ��
		if(tail<0 || (AC[head]==0 && AC[tail]==0)) {
			flag = false;
		} // check end of array
		else if(reversed) {
			if(AC[tail-1]==0){
				flag = false;
			}
			else {
				AC[--tail]=0;
			}
		} // end of if reversed 
		
		else {
			if(AC[head]==0){
				flag = false;
			}
			else {
				AC[head++]=0;
			}
		} // end of not reversed 
	}
	
	private static void R() {
		// head ���� ���� & ���
		if(reversed) {
			reversed = false;
		}
		// tail���� ���� & ���
		else {
			reversed = true;
		}
	}
	
	private static void ACString() {
		if(flag) {
			sb.append("[");
			if(head!=tail) {
				if(!reversed) {
					while(head<tail) {
						sb.append(AC[head++]).append(",");
					}
				}
				else {
					if(tail>0) {
						while(--tail>=head) {
							sb.append(AC[tail]).append(",");
						}
					}
				}
				// [] �̷� ��µ� �����ϱ�
				if(sb.length()>=2) {
					sb.setLength(sb.length()-1);
				}
			}
			sb.append("]").append("\n");
		}
		else {
			sb.append("error").append("\n");
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		// TC�� ����ŭ �ݺ�
		for(int testcase=0; testcase<TC; testcase++) {
			// ���� �۾��� Ŀ��Ʈ�� �ִ´�.
			char[] command = br.readLine().toCharArray();
			// �迭�� ����
			int N = Integer.parseInt(br.readLine());
			// �Ѱ�ġ �迭�� �����. �迭�� ����µ� D�� 100000�� �� �� �ִ�.
			AC = new int[4000001];
			// ���, ���� 0�� �ʱ�ȭ
			head = 0;
			tail = 0;
			flag = true;
			reversed = false;
			// �迭 �� StringTokenizer�� delim�� [,]�� �ξ� �ش� ��ȣ�� �������� ����
			StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
			for(int i=0; i<N; i++) {
				addAC(Integer.parseInt(st.nextToken()));
			}
			// AC �ൿ ����
			for(int i=0, len = command.length; i<len; i++) {
				if(command[i]=='R') {
					R();
				}
				else {
					D();
				}
			}
			// ���� ����ϱ�
			ACString();
		}
		// ���� ���
		System.out.println(sb.toString());
	} // end of main
	
} // end of Main

