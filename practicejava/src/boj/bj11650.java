package src.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class bj11650 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[][] array = new int[n][2];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }

        //Arrays.sort()를 new Comparator<T>(){} 의 compare(T o1, T o2)를 재정의하여 사용한다
        //참고로 Comparable은 compareTo(T o1) 메소드를, comparator는 compare(T o1, T o2)를 제공한다.
        //2단 배열을 정렬할 때는 이를 이용한다.
        //Comparable은 자신과 객체를, Comparator는 두 객체를 비교할 때 사용
        Arrays.sort(array, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0]){
                    // 양수면 o1을, 같으면 0, 음수이면 o2를 반환한다.
                    return o1[1] - o2[1];
                }
                else{
                    return o1[0] - o2[0]; 
                }
            }
        });

        /**
         * 위 식을 람다식으로 구현
         * Arrays.sort(array, (x, y) ->{
            if(x[0] == y[0]){
                return x[1] - y[1];
            }
            else{
                return x[0] - y[0];
            }
        });
         */
        for(int i=0; i<n; i++){
            String str = array[i][0] + " " + array[i][1];
            bw.write(str+"\n");
        }

        br.close();
        bw.close();
    }
}
