package src.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/** Main_����_9251_LCS_���5_156ms*/
public class Main_����_9251_LCS_���5_156ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// �ΰ��� ���ڿ� ��, ���ڿ��� �ִ� 1000�� 
		String arr1 = br.readLine();
		String arr2 = br.readLine();
		
		int n = arr1.length();
		int m = arr2.length();
		
		int [][] LCS = new int[m+1][n+1];
		// �ݺ����� ���鼭 �տ������� ��ġ�ϴ� ��ǥ�� �߰��Ѵٸ� �ش� ��ǥ���� �� ���� ������ �ش� ���� �밢�� ���� �� + 1�� �ʱ�ȭ�Ѵ�
		for(int r=1; r<=m; r++) {
			for(int c=1; c<=n; c++) {
				// arr2�� �ش� ��ǥ�� arr1�� ��ǥ�� �տ������� Ž���ϴµ�, ��ġ�ϴ� ���� �߰ߵǸ�
				if(arr2.charAt(r-1)==arr1.charAt(c-1)) {
					LCS[r][c] = LCS[r-1][c-1]+1;
				}
				// ��ġ���� �ʴ´ٸ� ��, ���� ��ǥ ���Ͽ� �� ū ������ �ʱ�ȭ
				else {
					LCS[r][c] = Math.max(LCS[r-1][c], LCS[r][c-1]);
				}
			}
		}
		// �� ������ ������ �ִ�ϱ�, ���
		System.out.println(LCS[m][n]);
	} // end of main
} // end of class
