package Test;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main_1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Set<Long> addedNumber = new HashSet<>();

        StringTokenizer st = new StringTokenizer(input, ",");

        long result = 0L;
        long countOdd = 0;
        long checkNum = 0;
        boolean isNum = false;
        String checkString;
        int checkCharArrange;
        // 콤마를 기준으로 나눈 모든 문자열을 탐색한다.
        while(st.hasMoreTokens()) {
            isNum = false;
            checkString = st.nextToken();
            for(int i=0, len=checkString.length(); i<len; i++) {
                checkCharArrange = checkString.charAt(i)-'0';
                if(checkCharArrange<0 || checkCharArrange>9) {
                    isNum = true;
                    break;
                }
            } // 콤마로 나눈 문자열의 모든 자리를 확인. 숫자가 아닐 경우 break

            // 만약 숫자일 때
            if(!isNum){
                checkNum = Long.parseLong(checkString);
                // 만약 홀수일 때
                if(!addedNumber.contains(checkNum) && checkNum%2==1) {
                    addedNumber.add(checkNum);
                    countOdd++;
                    result += checkNum;
                }
            } // end of if isNum

        } // end of while

        System.out.println(countOdd+" "+result);

    }


}