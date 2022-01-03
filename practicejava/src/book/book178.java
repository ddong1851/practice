package src.book;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

//나동빈 정렬 파트, 위에서 아래로
public class book178 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Integer [] data;
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        data = new Integer[n];

        for(int i=0; i<n; i++) data[i] = Integer.parseInt(br.readLine());
        Arrays.sort(data, Collections.reverseOrder());
        //자바에서 내림차순을 사용할 때는 기본 타입인 int, char, long 등이 아닌 Wrapper 클래스를 사용해야 한다.

        for(Integer i:data) bw.write(i+" ");
        br.close();
        bw.close();
    }
}
