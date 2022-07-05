package Test;

import java.io.*;
import java.util.*;

public class Main_4 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String result = isMultiStringArray(input);
        System.out.println(result);

    } // end of main

    private static String isMultiStringArray(String input) {
        input = input.substring(1, input.length()-1);

        // 일차원 배열인 경우
        if(input.charAt(0)!='[') {
            return "Error";
        }
        // 다중 배열인 경우
        else {
            // 배열의 수를 카운팅

            int countArray = 0;
            int addNumArray = 0;
            int maxAddedArray = 0;
            String checkArray = null;
            String maxArray = null;
            boolean isNum = false;
            // 배열 조합 중복 제거
            Set<String> set = new HashSet<>();

            for(int i=0; i<input.length(); i++){
                if(input.charAt(i)=='['){
                    int p=i;
                    while(input.charAt(p)!=']') p++;
//                    System.out.println(input.substring(i+1, p));
                    checkArray = input.substring(i+1, p);
                    // 해당 문자열이 숫자로만 이루어졌으며 중복되지 않은 문자열일 때
                    if(isNumArray(checkArray) && !set.contains(checkArray)){
                        set.add(checkArray);
                        addNumArray = 0;

                        StringTokenizer st = new StringTokenizer(checkArray, ",");
                        while(st.hasMoreTokens()){
                            addNumArray+=Integer.parseInt(st.nextToken());
                        }

                        // 최대값과 최대크기 배열 갱신
                        if(maxAddedArray<addNumArray) maxArray = checkArray;
                    } // end of is isNumArray and set.contains
                    // i를 포인터 기준으로 당겨오기
                    i=p+1;
                } // end of if '['
            } // end of for

            // 3개 이하 다중배열
            if(set.size()<3){
                return "Error";
            }

            StringBuilder sb = new StringBuilder();
            sb.append(set.size()).append(" ").append("/").append(" ").append("[").append(maxArray).append("]");
            return sb.toString();
        }

    } // end of isMultStringArray

    /** 문자열에 숫자와 콤마가 아닌 그 외의 것이 았다면 false 반환*/
    private static boolean isNumArray(String checkArray) {
        StringTokenizer st = new StringTokenizer(checkArray, ",");
        while(st.hasMoreTokens()){
            String check = st.nextToken();
            for(int i=0, len=check.length(); i<len; i++){
                int temp = check.charAt(i)-'0';
                if(temp<0 || temp>9) return false;
            }
        }
        return true;
    } // end of isNumArray

} // end of class
