package src.jungol.figure;

import java.util.Scanner;

/**Main_����_1307_���ڻ簢��1_563ms*/
public class Main_����_1307_���ڻ簢��1_563ms {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		char [][] square = new char[n][n];
		// char [y][x] �������!
		
		char a = 'A';
		for(int i=n-1; i>=0; i--) {
			for(int j=n-1; j>=0; j--) {
				square[j][i] = a++;
				if(a>'Z') { a = 'A';}
			}
		}
		
		for(char[] c:square) {
			for(char s:c) {
				System.out.print(s+" ");
			}
			System.out.println();
		}
		
		
		/*
		 * 
		 *   p l h d
		 *   o k g c
		 * 	 m j f b
		 *   m i e a
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
	}
}
