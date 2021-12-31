package src.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] data;
    static int[] numList;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        data = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int i =0;
        while(st.hasMoreTokens())
            data[i] = Integer.parseInt(st.nextToken());
        
        
        i=0;
        int m = Integer.parseInt(br.readLine());
        numList = new int[m];
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens())
            numList[i] = Integer.parseInt(st.nextToken());
        
        for(int a :data){
            binarySearch2(a, 0, numList.length-1);
        }
    }
    static void binarySearch2(int key, int low, int high){
        int mid;
        while(low<=high){
            mid = (low + high)/2;
            if(key == numList[mid])
               System.out.print(1+' ');
            else if(key < numList[mid]) high = mid - 1;
            else low = mid + 1;
        }
        //탐색 실패
        System.out.print(0+' ');
    }
}
