package src.boj.implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class bj15552 {
    public static void main(String[] args) throws IOException{
        //?��기서 throws IOException?�� ?��?�� ?��?�� 출력?�� ?�� ?�� ?��?��.
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            //?��?�� \n?�� ?��줘야 출력?�� ?�� ?��?��?�� 출력?��?��.
            bw.write((Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()))+"\n");
        }
        br.close();
        bw.flush();
        bw.close();            
        //bw?�� 버퍼?�� ?��?��?��?�� ???��?���? ?��?���? flush?�� close�? ?��?��?��?��?�� ?�� 
        //값들?�� 출력?��?��. 
    }
}
