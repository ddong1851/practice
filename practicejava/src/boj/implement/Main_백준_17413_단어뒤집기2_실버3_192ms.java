package src.boj.implement;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**Main_백준_17413_단어뒤집기2_실버3_192ms*/
public class Main_백준_17413_단어뒤집기2_실버3_192ms {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
	
		//문자열의 길이만큼 읽으며, <>가 나오면 다른 방식으로 문제를 해결한다.
		int index = 0;
		for(int i=0; i<str.length();) {
			char c = str.charAt(i);
			if(c=='<') {
				index = i;
				while(str.charAt(index)!='>') {
					index++;
				}
				bw.write(str.substring(i, index+1));
				i=index+1;
			}
			// 띄어쓰기를 못 읽는중
			else if(c!=' '){
				index = i;
				while(index<str.length()) {
					if(str.charAt(index)==' ') {
						break;
					}
					if(str.charAt(index)=='<') {
						break;
					}
					else {
						index++;
					}
				}
				for(int j=index-1; j>=i; j--) {
					bw.write(str.charAt(j));
				}
				i = index;
			}
			else if(c==' ') {
				bw.write(' ');
				i++;
			}
		}
		
		br.close();
		bw.close();
		
	}
}