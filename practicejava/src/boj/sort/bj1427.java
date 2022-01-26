package src.boj.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class bj1427 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        String str = br.readLine();
        br.close();
        Integer[] data = new Integer[str.length()];
        for(int i=0; i<str.length(); i++){
            data[i] = Integer.valueOf(str.charAt(i));
        }
        Arrays.sort(data, Collections.reverseOrder());
        for(int i:data) bw.write(i);
        bw.close();
    }
}
