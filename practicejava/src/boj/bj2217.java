package src.boj;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class bj2217 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int N = sc.nextInt();
        Integer[] data = new Integer[N];

        // 배열에 로프의 값들을 입력받고, 내림차순으로 정렬한다. 
        for(int i=0; i<N; i++) data[i] = sc.nextInt();
        sc.close();
        Arrays.sort(data, Collections.reverseOrder());

        int result=data[0];     //배열의 첫번째 값을 저장. 로프를 한개만 쓴다면 처음 값을 쓰는게 가장 이득
        for(int i=1; i<N; i++){
            if(result<(i+1)*data[i]) result=(i+1)*data[i];
        }
        
        System.out.println(result);
    }
}
