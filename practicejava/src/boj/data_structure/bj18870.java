package src.boj.data_structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj18870 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        Integer [] data = new Integer[N];

        //2 4 -10 4 -9
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) data[i] = Integer.parseInt(st.nextToken());

        Integer[] cloneData = data.clone();
        Arrays.sort(cloneData);
        
        //Set?? μ€λ³΅? ??λ₯? κ°μ? ???€. Integerλ‘? λ§λ  λ°°μ΄ λ¦¬μ€?Έλ₯? Set?Όλ‘? λ³?κ²½νλ©? μ€λ³΅? ???€?΄ ?¬?Όμ§λ€. 
        //HashMap? ?΄?©?κ³?, ?¬κΈ°μ containsKeyλ₯? ?΄?©?? κ²λ λ°©λ²
        HashMap<Integer, Integer> map = new HashMap<>();
        int count=0;
        for(int i: cloneData){
            if(!map.containsKey(i)){
                map.put(i, count);
                count++;
            }
        }
        for(int i:data){
            bw.write(map.get(i)+" ");
        }
        br.close();
        bw.close();
    }
}
