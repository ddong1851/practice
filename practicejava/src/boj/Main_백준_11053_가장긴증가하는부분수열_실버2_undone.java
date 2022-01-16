package src.boj;

import java.util.Arrays;
import java.util.Scanner;
/**
 * Main_����_11053_����������ϴºκм���_�ǹ�2_undone
 * @author HD
 *
 */
public class Main_����_11053_����������ϴºκм���_�ǹ�2_undone {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		int [] dp = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		} // end of for_init array
		
		for (int i = 0; i < dp.length; i++) {
			dp[i]=1;
			
			for(int j=0; j<i; j++) {
				if(arr[j] > arr[i]) {
					dp[i] = dp[j]+1;
				}
			}
		}
		
		Arrays.sort(dp);
		System.out.println(dp[n-1]);
	} // end of main

} // end of class
