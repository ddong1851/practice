package src.boj.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class bj2217 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int N = sc.nextInt();
        Integer[] data = new Integer[N];

        // λ°°μ΄? λ‘ν? κ°λ€? ?? ₯λ°κ³ , ?΄λ¦Όμ°¨??Όλ‘? ? ? ¬??€. 
        for(int i=0; i<N; i++) data[i] = sc.nextInt();
        sc.close();
        Arrays.sort(data, Collections.reverseOrder());

        int result=data[0];     //λ°°μ΄? μ²«λ²μ§? κ°μ ???₯. λ‘νλ₯? ?κ°λ§ ?΄?€λ©? μ²μ κ°μ ?°?κ²? κ°??₯ ?΄?
        for(int i=1; i<N; i++){
            if(result<(i+1)*data[i]) result=(i+1)*data[i];
        }
        
        System.out.println(result);
    }
}
