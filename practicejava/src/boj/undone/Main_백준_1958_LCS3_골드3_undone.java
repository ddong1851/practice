package src.boj.undone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/** Main_����_1958_LCS3_���3_undone*/
public class Main_����_1958_LCS3_���3_undone {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = new String[3];
		str[0] = br.readLine();
		str[1] = br.readLine();
		str[2] = br.readLine();
		Arrays.sort(str);
		// int [][][] LCS = new int[��][��][��] 
		int idx = str[0].length();
		int row = str[1].length();
		int col = str[2].length(); 
		int[][][] LCS = new int[idx+1][row+1][col+1];
		// � �������� LCS�� ������ �ұ�
		
		
	}
}
