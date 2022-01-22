package src.jungol.figure;

import java.util.Arrays;
import java.util.Scanner;

/** Main_����_1338_���ڻﰢ��1_539ms*/
public class Main_����_1338_���ڻﰢ��1_539ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		char [][] figure = new char[n][n];
		
		// ��ĭ���� ä��
		for(char[] c:figure) {
			Arrays.fill(c, ' ');
		}
		
		
		
		// ��� ���ڸ��� �ʱ�ȭ�ǰ� �ִ�.
		char p = 'A';
		int k=0;
		for(int i=1; i<=n; i++) {
			for(int j=i; j<=n; j++) {
				figure[j-1]
						[n-j+k] =p++;
				if(p>'Z') p='A';
			}
			k++;
		}
		
		
		
		for(char[] c:figure) {
			for(char a:c) {
				System.out.print(a+" ");
			}
			System.out.println();
		}
		
		
		/*
		 * ex. n=5
		 * 				����	���
		 * 			*	4	1					0 n-1
		 * 		  * *	3	2    			1 n-2 1 n-1
		 * 		* * *	2	3	  		2 n-3 2 n-2
		 * 	  * * * *	1	4		3 n-4
		 *  * * * * *	0	5	4 n-5
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
	}
}	
