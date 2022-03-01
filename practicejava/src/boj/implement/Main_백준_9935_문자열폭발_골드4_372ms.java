package src.boj.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/** Main_백준_9935_문자열폭발_골드4_372ms*/
public class Main_백준_9935_문자열폭발_골드4_372ms {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine(); // 1_000_000
		String pattern = br.readLine();
		
		int plen = pattern.length();
		
		for(int i=0, len=str.length(); i<len; i++) {
			sb.append(str.charAt(i));
			if(str.charAt(i)==pattern.charAt(plen-1) && sb.length()>=plen) {
				// 뒤에서부터 비교
				boolean flag = true;
				int idx = plen-1;
				int sblen = sb.length()-1;
				while(idx>=0) {
					// 다른 값이 나왔다면
					if(sb.charAt(sblen--)!=pattern.charAt(idx)){
						flag = false;
						break;
					}
					idx--;
				}
				if(flag) sb.setLength(sb.length()-plen);;
				
			}
		}
		
		if(sb.length()==0) System.out.println("FRULA");
		else System.out.println(sb.toString());
	}
}


