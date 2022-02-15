package src.boj.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_����_1439_������_�ǹ�5_136ms {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		 * 0���� 1���� ��� ��, ���� ���� ����ϰ� �ִ´�
		 * ��Ʈ ����ŷ���� Ǯ� �ǰ�, �ϳ��� �������� ���Ͽ�
		 * ��� ���ӵ� ���ڿ��� �ִ��� ����. �� ���� ���� �ٲ��ָ� ��
		 */
		
		char[] ch = br.readLine().toCharArray();
		int[] count = new int[2];
		char last = ch[0];
		for(int i=1; i<ch.length; i++) {
			if(last != ch[i]) {
				count[last-'0']++;
				last = ch[i];
			}
		}
		count[last - '0']++;
		System.out.println(Math.min(count[0], count[1]));
		
	} // end of main
} // end of Main
