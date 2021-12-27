package src.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class bj15552 {
    public static void main(String[] args) throws IOException{
        //여기서 throws IOException을 해서 예외 출력을 할 수 있다.
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            //끝에 \n을 해줘야 출력될 때 띄어써 출력된다.
            bw.write((Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()))+"\n");
        }
        br.close();
        bw.flush();
        bw.close();            
        //bw는 버퍼에 입력들을 저장하고 있다가 flush나 close가 입력되었을 때 
        //값들을 출력한다. 
    }
}
