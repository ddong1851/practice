package src.boj.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/** Main_����_1543_�����˻�_�ǹ�4_�赿��_136ms*/
public class Main_����_1543_�����˻�_�ǹ�4_�赿��_136ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		int row = str2.length;
		int col = str1.length;
		/*
		 *  ababababab
		 * b0101010101 
		 * a102 
		 * 
		 * 
		 * 
		 * 
		 */
		// ���� ���� �κй��ڿ� ������ �ذ��غ���
		int[][] LCS = new int [row+1][col+1];
		int count = 0;
		for(int r=1; r<=row; r++) {
			for(int c=1; c<=col; c++) {
				// str1�� ��ǥ�� str2�� ��ǥ�� ��ġ�Ѵٸ�
				if(str2[r-1]==str1[c-1]) {
					LCS[r][c] = LCS[r-1][c-1] + 1;
					// str2 ���ڿ��� ���̿� LCS���� ��ġ�Ѵٸ� �ߺ� Ȯ��
					if(LCS[r][c]==row) {
						// �ش� ��ǥ ���� row�� ũ�⸸ŭ Ž���ϸ�, ���� row���� �߰ߵǸ� ���� ����
						// �߰ߵǸ� 0���� �ʱ�ȭ
						boolean flag = false;
						for(int i=1; i<row; i++) {
							if(LCS[r][c-i]==row) {
								flag = true;
								LCS[r][c] = 0;
							}
						}
						// �ߺ����� �ʴ´ٸ� ����
						if(flag==false) {
							count++;
						}
					}
				}
				// ��ġ�ϴ� ���� ������ 0 
				else {
					LCS[r][c] = 0;
				}
			}
		}
		System.out.println(count);
	}
}
