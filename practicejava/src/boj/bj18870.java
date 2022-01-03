package src.boj;

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
        
        //Set은 중복된 원소를 갖지 않는다. Integer로 만든 배열 리스트를 Set으로 변경하면 중복된 원소들이 사라진다. 
        //HashMap을 이용하고, 여기서 containsKey를 이용하는 것도 방법
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
