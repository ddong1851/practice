package src.boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2562 {
    public static void main(String[] args) throws IOException{
        soultion();
    }

    private static void soultion() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] data = new int[9];
        for(int i=0; i<9; i++){
            int n = Integer.parseInt(br.readLine());
            data[i]=n;
        }
        br.close();

        int count, max, index;
        count = max = index = 0;
        for(int temp : data){
            count ++;
            if(temp>=max){
                max = temp;
                index = count;
            }
        }
        System.out.println(max + "\n" + index);
    }
}