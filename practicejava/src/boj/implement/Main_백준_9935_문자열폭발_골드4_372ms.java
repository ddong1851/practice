package src.boj.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/** Main_����_9935_���ڿ�����_���4_372ms*/
public class Main_����_9935_���ڿ�����_���4_372ms {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine(); // 1_000_000
		String pattern = br.readLine();
		
		int plen = pattern.length();
		
		for(int i=0, len=str.length(); i<len; i++) {
			sb.append(str.charAt(i));
			if(str.charAt(i)==pattern.charAt(plen-1) && sb.length()>=plen) {
				// �ڿ������� ��
				boolean flag = true;
				int idx = plen-1;
				int sblen = sb.length()-1;
				while(idx>=0) {
					// �ٸ� ���� ���Դٸ�
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


