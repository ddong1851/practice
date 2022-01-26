package src.boj.implement;

import java.util.Scanner;


public class Main_백준_10162_전자레인지_브론즈4_164ms {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = 0;
        int b = 0;
        int c = 0;
        
        int t = sc.nextInt();
        sc.close();
        while(t >= 10) {
            if(t >= 300) {
                t -= 300;
                a++;
            } else if(t >= 60) {
                t -= 60;
                b++;
            } else if(t >= 10) {
                t -= 10;
                c++;
            }
        }
        System.out.println(t == 0 ? a + " " + b + " " + c : -1);
    }
}