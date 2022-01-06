package src.boj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class bj9095 {
    public static Scanner sc = new Scanner(System.in);
    public static int[] d = new int[11]; //최대 11
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int count = 0;
    public static void main(String[] args) throws IOException{
        int T = sc.nextInt();

        for(int i=0; i<T; i++){
            int n = sc.nextInt();
            bw.write(DP(n)+"\n");
            count = 0;
        }
        sc.close();
        bw.close();
    }

    static int DP(int x){
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for(int i=4; i<=x; i++){
            d[i] = d[i-3] + d[i-2] + d[i-1];
        }
        return d[x];
    }
}
