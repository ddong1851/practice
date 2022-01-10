package src.book.dynamic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class book226 {

    static int[] d = new int[101];
    static int[] mType;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());

        mType = new int[n];

        for(int i=0; i<n; i++) {
            mType[i] = Integer.parseInt(br.readLine());
            d[i] = mType[i];
        }

        br.close();

        bw.write(DP(m));
        bw.close();
    }

    static int DP(int money){
        return money;
    }
}
