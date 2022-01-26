package src.boj.implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class bj15552 {
    public static void main(String[] args) throws IOException{
        //?ó¨Í∏∞ÏÑú throws IOException?ùÑ ?ï¥?Ñú ?òà?ô∏ Ï∂úÎ†•?ùÑ ?ï† ?àò ?ûà?ã§.
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            //?Åù?óê \n?ùÑ ?ï¥Ï§òÏïº Ï∂úÎ†•?ê† ?ïå ?ùÑ?ñ¥?ç® Ï∂úÎ†•?êú?ã§.
            bw.write((Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()))+"\n");
        }
        br.close();
        bw.flush();
        bw.close();            
        //bw?äî Î≤ÑÌçº?óê ?ûÖ?†•?ì§?ùÑ ???û•?ïòÍ≥? ?ûà?ã§Í∞? flush?Çò closeÍ∞? ?ûÖ?†•?êò?óà?ùÑ ?ïå 
        //Í∞íÎì§?ùÑ Ï∂úÎ†•?ïú?ã§. 
    }
}
