package src.boj;

import java.math.BigInteger;
import java.util.Scanner;

//DP로 풀어야함
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // 100
        int m = sc.nextInt(); // 6 
        
        BigInteger up = BigInteger.ONE;
        BigInteger down = BigInteger.ONE;
        for(int i=0; i<m; i++){
            up = up.multiply(new BigInteger(String.valueOf(n-i)));
            down = down.divide(new BigInteger(String.valueOf(i+1)));
        }
        
        System.out.println(up.divide(down));
               
    } // end of main
} // end of Main