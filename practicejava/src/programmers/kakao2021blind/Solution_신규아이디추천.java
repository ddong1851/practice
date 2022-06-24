package src.programmers.kakao2021blind;

public class Solution_신규아이디추천 {
	
	public static String solution(String new_id) {
        
        // 1단계
		String role1 = new_id.toLowerCase();
        
        // 2단계
        StringBuilder role2 = new StringBuilder();
        char check = '\u0000';
        for(int i=0, len=role1.length(); i<len; i++) {
        	check = role1.charAt(i);
        	if(isCharacterVaild(check)) role2.append(check);
        }
        
        // 3단계
        StringBuilder answer = new StringBuilder();
        boolean isDotAppeared = false;
        for(int i=0, len=role2.length(); i<len; i++) {
        	check = role2.charAt(i);
        	if(check=='.') isDotAppeared = true;
        	else {
        		if(isDotAppeared) {
        			answer.append(".");
        			isDotAppeared = false;
        		}
        		answer.append(check);
        	}
        }
        
        // 4단계
        if(answer.length()!=0 && answer.charAt(0)=='.') answer.deleteCharAt(0);
        if(answer.length()!=0 && answer.charAt(answer.length()-1)=='.') answer.deleteCharAt(answer.length()-1);
        
        // 5단계
        if(answer.length()==0) answer.append("a");
        
        // 6단계
        if(answer.length()>=16) {
        	answer.setLength(15);
        	if(answer.charAt(answer.length()-1)=='.') answer.deleteCharAt(answer.length()-1);
        }
        
        // 7단계
        if(answer.length()<=2) {
        	while(answer.length()!=3) answer.append(answer.charAt(answer.length()-1));
        }
        
        return answer.toString();
    }
	
	private static boolean isCharacterVaild(char check) {
		if(isLowercaseAlphabet(check) || isNumber(check) || isValidSign(check)) return true;
		return false;
	}

	private static boolean isValidSign(char check) {
		if(check==45 || check==46 || check==95) return true;
		return false;
	}

	private static boolean isNumber(char check) {
		if(check>=48 && check<=57) return true;
		return false;
	}

	private static boolean isLowercaseAlphabet(char check) {
		if(check>=97 && check<=122) return true;
		return false;
	}

	public static void main(String[] args) {
//		String new_id = "...!@BaT#*..y.abcdefghijklm...asd asd asdasdas0123,,AS";
//		String new_id = "=.=";
		String new_id = "abcdefghijklmn.p";
		System.out.println(solution(new_id));
	}
}
