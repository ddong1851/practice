package src.boj.dp;

import java.util.Scanner;

public class bj1463 {
    public static int[] d = new int[10000001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        for(int i=2; i<=n; i++){
        	// �ϳ� �����ѰŶ�
            d[i] = d[i-1] + 1;
            // 3���� �����ſ� ��
            if(i%3==0){
                d[i] = Math.min(d[i], d[i/3]+1);
            }
            // 2�� �����ſ� ��
            if(i%2==0){
                d[i] = Math.min(d[i], d[i/2]+1);
            }
        }
        System.out.println(d[n]);
    }
}
