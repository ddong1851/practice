package src.boj.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj8958 {
    public static void main(String[] args) throws IOException{
        soultion();
    }

    private static void soultion() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //??€?Έ μΌ??΄?€ κ°μλ₯? ?? ₯λ°λ?€.
        int n = Integer.parseInt(br.readLine());
        //nκ°μ λ¬Έμ?΄ ?°?΄?°λ₯? ???₯?  λ°°μ΄ ??±
        String[] data = new String[n];
        for(int i=0; i<n; i++){
            data[i] = br.readLine();
        }
        br.close();

        //λ¬Έμ?΄? ? nλ²? λ§νΌ κ³μ°κΈ? λ©μ?λ₯? ?? €?Ό
        for(int i=0; i<n; i++)
            calc(data[i]);
        
    }

    private static void calc(String string) {
        int score, count;
        score = count = 0;

        //λ¬Έμ?΄? κΈΈμ΄λ§νΌ λ°λ³΅ 
        for(int i=0; i<string.length(); i++){
            // O ?Ό? count μ¦κ???€κ³?, ? ?? ???€.
            if(string.charAt(i)=='O'){
                count++;
                score+=count;
            }
            else
                count = 0;
        }
        System.out.println(score);
    }
}
