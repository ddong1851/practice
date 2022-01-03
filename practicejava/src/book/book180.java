package src.book;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class book180 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static HashMap<Integer, String> data;
    // HashMap<key, value> 순서니까 꼭 인지하고 사용하자.
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        //해시맵의 최대 용량을 n개로 선언
        data = new HashMap<>(n);

        Integer [] integers = new Integer[n];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int val = Integer.valueOf(st.nextToken());
            integers[i] = val;
            data.put(val, str);
        }

        Arrays.sort(integers);
        for(int i:integers) bw.write(data.get(i)+" ");
        bw.close();
    }
}
