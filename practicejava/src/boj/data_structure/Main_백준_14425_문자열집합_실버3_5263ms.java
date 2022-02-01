package src.boj.data_structure;

import java.util.ArrayList;
import java.util.Scanner;

/** Main_ï¿½ï¿½ï¿½ï¿½_14425_ï¿½ï¿½ï¿½Ú¿ï¿½ï¿½ï¿½ï¿½ï¿½_ï¿½Ç¹ï¿½3_5263ms*/
public class Main_¹éÁØ_14425_¹®ÀÚ¿­ÁýÇÕ_½Ç¹ö3_5263ms {	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int num= 0;
		
		ArrayList<String> srr = new ArrayList<String>(a);
		
		for(int i = 0 ; i < a ; i++ ) {
			srr.add(sc.next());
		}
		
		for(int i = 0 ; i < b ; i++ ) {
			String str = sc.next();
			if(srr.contains(str)==true) num++;
		}
		
		System.out.println(num);
	}
	
}