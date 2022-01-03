package src.book;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//순차 탐색 알고리즘
/**
 * 순차 탐색 알고리즘은 말 그래도
 * 데이터의 첫번째 부터 차례대로 확인하는 방법이다.
 */
public class sequential_sort {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sequentialSort(n, t, arr);
    }

    static void sequentialSort(int range, int target, int[] array){
        for(int i=0; i<range; i++){
            if(array[i]==target){
                System.out.println((i+1)+"번째 위치에 target인 "+ target+"이 존재합니다.");
                break;
            }
        }
    }
}
