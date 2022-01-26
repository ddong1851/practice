package src.boj.implement;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**Main_����_17413_�ܾ������2_�ǹ�3_192ms*/
public class Main_����_17413_�ܾ������2_�ǹ�3_192ms {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
	
		//���ڿ��� ���̸�ŭ ������, <>�� ������ �ٸ� ������� ������ �ذ��Ѵ�.
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
			// ���⸦ �� �д���
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