package src.boj.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_����_1244_����ġ�Ѱ����_�ǹ�3_128ms{
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine())+1;
		
		int[] switches = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<N; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		switches[0] = 100;
		int students = Integer.parseInt(br.readLine());
		
		for(int i=0; i<students; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int key = Integer.parseInt(st.nextToken());
			remote(gender, key, switches, N);
		}
		
		// ���� ���
		printAnswer(switches, N);
		
	} // end of main

	private static void printAnswer(int[] switches, int N) {
		StringBuilder sb = new StringBuilder();
		if(N<=20) {
			for(int i=1; i<N; i++) {
				sb.append(switches[i]).append(" ");
			}
		} 
		else {
			int repeat = (N-1)/20;
			for(int i=0; i<repeat; i++) {
				for(int start = i*20+1, end = start+20, j=start; j<end; j++) {
					sb.append(switches[j]).append(" ");
				}
				sb.append("\n");
			}
			for(int start = 20*repeat+1, i=start; i<N; i++) {
				sb.append(switches[i]).append(" ");
			}
		}
		System.out.println(sb.toString());
	}

	private static void remote(int gender, int key, int[] switches, int length) {
		// ������ ��
		if(gender==1) {
			int add = key;
			while(key<length) {
				// ��Ʈ ����
				switches[key] = Math.abs(switches[key]-1);
				key+=add;
			}
		}
		// ������ ��
		else {
			// ù��° �ڸ��� ������ �ٲٱ�
			switches[key] = Math.abs(switches[key]-1);;
			int left = key-1; int right = key+1;
			while(true) {
				// ������ ����� Ȥ�� ���� �������� ����ġ�ϸ� �����
				if((left<1 || right >= length) || switches[left]!=switches[right]) break;
				// �¿� �ٲٱ�
				int num = Math.abs(switches[left]-1);;
				switches[left--] = switches[right++] = num;
			}
		}
	}
} // end of class 


//42
//0 1 0 1 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//1
//1 6
