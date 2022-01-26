package src.boj.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj12738 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 증�??��?��?�� ???��?�� 리스?��
        List<Integer> list = new ArrayList<>();
        // ?��?��?�� 값을 ???��?�� 배열
        int arr[] = new int[n + 1];

        for(int i = 1 ; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        list.add(Integer.MIN_VALUE);

        for(int i = 1 ; i <= n; i++){
            int num = arr[i];
            int left = 1;
            int right = list.size() - 1;

            // ?��?��?��?�� ?��?���? 증�??��?��?�� 마�?�? ?��보다 ?�� 경우
            // ?��?��?�� 추�??���??��.
            if(num > list.get(list.size() - 1)) list.add(num);
            // ?��?��?��?�� ?��?���? 증�??��?��?�� 마�?�? ?��보다 ?��?? 경우
            else{
                // ?��?��?�� ?��?��?�� ?��치�?? 찾아
                // 증�??��?��?�� 값을 �?경해�??��.
                while(left < right){
                    int mid = (left + right) >> 1;

                    if(list.get(mid) >= num) right = mid;
                    else left = mid + 1;
                }
                list.set(right, num);
            }
        }
        // 최장 길이 출력
        sb.append(list.size() - 1 + "\n");

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}