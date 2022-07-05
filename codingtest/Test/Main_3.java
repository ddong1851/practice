package Test;

import java.io.*;
import java.util.*;

public class Main_3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // 앞뒤 공백 제거
        input = input.trim();

        // 콤마가 있을 수 있으니 첫번째 콤바 기준으로 나눈다.
        int idx = 0;
        while(input.charAt(idx)!=',') idx++;

        String repeatedString = input.substring(0, idx);
        String checkString = input.substring(idx+1, input.length());

        System.out.println(isRepeatedString(repeatedString, checkString));

    } // end of main

    private static boolean isRepeatedString(String repeatedString, String checkString) {
        // 순환하는 문자열에는 다른 콤마는 없어야 한다.
        if(checkString.contains(",")) return false;

        // 순환하는지 확인

        // 순환 문자의 개수가 맞지 않는 경우
        if(checkString.length()%repeatedString.length()!=0) return false;



        return true;
    } // end of isRepeatedString

} // end of class
