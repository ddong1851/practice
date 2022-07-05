package Test;

import java.io.*;
import java.util.*;

public class Main_2 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input, "$");
        String originString = st.nextToken();
        String removeString = st.nextToken();

        int removeStringLength = removeString.length();

        int removeCount = 0;

        // 삭제해야할 문자열이 남아있을 때 계속 반복
        while(originString.contains(removeString)){
            removeCount++;
            int idx = originString.lastIndexOf(removeString);

            StringBuilder sb = new StringBuilder();
            sb.append(originString.substring(0, idx));
            sb.append(originString.substring(idx+removeStringLength, originString.length()));
            originString = sb.toString();
        }

        System.out.println(removeCount+" "+originString);

    }
}

