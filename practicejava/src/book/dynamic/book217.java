package src.book.dynamic;

import java.util.Scanner;

public class book217 {
    //DP는 도식화를 할 줄 알아야한다. 

    //정수의 최대 개수만큼 배열을 선언해줘야 한다.
    //해당 배열에 연산한 결과들을 넣어줘야 한다.
    public static int[] d = new int[30001];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        sc.close();

        //바텀 업 방식
        //모든 경우에 대하여 -1, /5, /3, /2를 진행하는데
        //이들 중 가장 작은 값을 선택하여 배열에 최종적으로 저장한다.
        /**
         * 아래식을 자세히 다뤄보면
         * f(x) 값마다 가장 작은 값들을 갱신하는 형태
         */
        for(int i=2; i<=X; i++){
            //현재의 수에서 1을 빼는 경우
            d[i] = d[i-1] + 1;

            //현재의 수에서 5를 나누는 경우
            if(i%5==0){
                d[i] = Math.min(d[i], d[i/5]+1);
            }

            if(i%3==0){
                d[i] = Math.min(d[i], d[i/3]+1);
            }

            if(i%2==0){
                d[i] = Math.min(d[i], d[i/2]+1);
            }
        }
        System.out.println(d[X]);        
    }
}
