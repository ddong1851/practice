package src.boj.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class bj2217 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int N = sc.nextInt();
        Integer[] data = new Integer[N];

        // 배열?�� 로프?�� 값들?�� ?��?��받고, ?��림차?��?���? ?��?��?��?��. 
        for(int i=0; i<N; i++) data[i] = sc.nextInt();
        sc.close();
        Arrays.sort(data, Collections.reverseOrder());

        int result=data[0];     //배열?�� 첫번�? 값을 ???��. 로프�? ?��개만 ?��?���? 처음 값을 ?��?���? �??�� ?��?��
        for(int i=1; i<N; i++){
            if(result<(i+1)*data[i]) result=(i+1)*data[i];
        }
        
        System.out.println(result);
    }
}
