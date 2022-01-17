package src.boj;

import java.util.Scanner;

public class bj1057 {
	static double kim;
	static double lim;
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	@SuppressWarnings("unused")
		int n = sc.nextInt(); kim = sc.nextInt(); lim = sc.nextInt();
    	sc.close();
    	
    	int result=0;
    	while(kim!=lim) {
    		isMet();
    		result++;
    	}
    	
    	System.out.println(result);
    	
    }
    
    static void isMet() {
    	kim = Math.ceil(kim/2);
    	lim = Math.ceil(lim/2);
    }
    
}