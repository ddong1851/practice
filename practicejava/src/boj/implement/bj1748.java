package src.boj.implement;

import java.util.Scanner;

public class bj1748 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        sc.close();

        int count = 0;
        int temp = 10;
        int add = 1;
        for(int i=1; i<=n; i++){
            if(i>=temp){
                add++;
                temp *= 10;
            }
            count += add;
        }
        System.out.println(count);
    }
}
