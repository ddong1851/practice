package src.boj.data_structure;

import java.util.ArrayList;
import java.util.Scanner;

/** Main_����_14425_���ڿ�����_�ǹ�3_5263ms*/
public class Main_백준_14425_문자열집합_실버3_5263ms {	
	
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