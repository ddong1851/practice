package src.boj.undone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/** Main_백준_1958_LCS3_골드3_undone*/
public class Main_백준_1958_LCS3_골드3_undone {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = new String[3];
		str[0] = br.readLine();
		str[1] = br.readLine();
		str[2] = br.readLine();
		Arrays.sort(str);
		// int [][][] LCS = new int[면][행][열] 
		int idx = str[0].length();
		int row = str[1].length();
		int col = str[2].length(); 
		int[][][] LCS = new int[idx+1][row+1][col+1];
		// 어떤 기준으로 LCS를 돌려야 할까
		
		
	}
}
