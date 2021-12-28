package src.book;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class maze {
    //자바에서 큐를 사용할 때는 Queue와 LinkedList를 import하고
    //큐를 선언하고  이를 LinkedList로 구현한다.
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //숫자 2개를 입력하고, 이들을 n m에 저장
        StringTokenizer st; int n, m;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        ArrayList<Integer[]> graph = new ArrayList<>();
        //graph.sort(Comparator.naturalOrder()); 이렇게 쓰면 오름차순으로 정렬이 가능하다

        //m번만큼 반복하면서 graph에 배열 값들을 입력해준다. 
        for(int i=0;i<m; i++){
            st = new StringTokenizer(br.readLine());
        }
    }
}
