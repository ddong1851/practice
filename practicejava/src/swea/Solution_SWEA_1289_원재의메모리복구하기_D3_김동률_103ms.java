package src.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** Solution_SWEA_1289_�����Ǹ޸𸮺����ϱ�_D3_�赿��_103ms*/
public class Solution_SWEA_1289_�����Ǹ޸𸮺����ϱ�_D3_�赿��_103ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for(int i=1; i<=TC; i++) {
			// ������ �а�, ���ӵ� 1, ���ӵ� 0�� ������ŭ �ݺ�����( �� �� �����ʹ� �� 00000 �̴�)
			// ����ó���� �����ϴ� �޼���
			String temp = br.readLine();
			sb.append(String.format("#%d %d\n", i, calc(temp)));
		}
		br.close();
		System.out.println(sb.toString());
	}

	private static int calc(String temp) {
		// TODO Auto-generated method stub
		int len = temp.length();
		// charAt���� ��ó ����
		char[] bit = temp.toCharArray();
		int count = 0;
		// bit[i] bit[i-1] �񱳷� ��ó ����, ������ ������ �������� ���� ȿ���� ������ �� �ִ�
		char flag = '0';
		// ù��° ���ں��� 1�̸� ��ü�� 1�� ��ȯ�ؾ� ��
		if(bit[0]=='1') {
			count++;
			flag = '1';
		}
		// ��ü ���̸�ŭ �ݺ�
		for(int i=1; i<len; i++) {
			// ������ ���ӵ� ���������� Ȯ��
			if(bit[i]==flag) {
				continue;
			}
			// ���ӵ��� ���� �����͸� ����
			else {
				flag = bit[i];
				count++;
			}
		}
		return count;
	}
}
