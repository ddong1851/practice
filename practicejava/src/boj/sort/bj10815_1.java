package src.boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj10815_1 {
    

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> myCard = new ArrayList<>();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens())
            myCard.add(Integer.parseInt(st.nextToken()));
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        br.close();
        ArrayList<Integer> numList = new ArrayList<>();
        while(st.hasMoreTokens())
            numList.add(Integer.parseInt(st.nextToken()));

        System.out.println(n+m);
        for(int i : numList){
            if(myCard.contains(i)==true){
                System.out.print(1+" ");
            }
            else
                System.out.print(0+" ");
        }
    }
}
