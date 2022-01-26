package src.boj.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj5585{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cost = Integer.parseInt(br.readLine());
        soultion(cost);
        br.close();
    }

    private static void soultion(int money){
        int [] money_type = {500, 100, 50, 10, 5, 1};
        int count, i;
        int rest = 1000 - money;
        count = i = 0;
        while(true){
            if(rest==0) {
                System.out.println(count);
                break;
            }
            if(rest-money_type[i]>=0){
                count++;
                rest -= money_type[i];
            }
            else i++;
        }
    }
}
