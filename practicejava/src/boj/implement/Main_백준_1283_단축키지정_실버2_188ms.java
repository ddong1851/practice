package src.boj.implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/** Main_백준_1283_단축키지정_실버2_188ms*/
public class Main_백준_1283_단축키지정_실버2_188ms {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    
    /**문제의 규칙 <br>
     * *** 
     * 왼쪽에서부터 오른쪽 순서로 단어의 첫 글자라 이미 단축키로 지정되었는지 살펴본다<br>
     * 만약 지정이 안되어있다면 그 알파벳을 단축키로 지정한다<br>
     * 
     * ***<br>
     * 만약 모든 단어의 첫 글자가 이미 지정되어있다면 왼쪽에서부터 차례대로 알파벳을 보면서 단축키로 지정 안된 것이 있다면 지정<br>
     * 
     * ***<br>
     * 어떠한 것도 단축키로 지정할 수 없다면 그냥 놔두고 대소문자를 구분하지 않는다.<br>
     * 
     * ***<br>
     * 위의 규칙을 첫 번째 옵션부터 N번째 옵션까지 차례대로 적용<br>
     * @throws IOException 
     * @throws NumberFormatException 
     * */
    
    public static void main(String[] args) throws NumberFormatException, IOException {
    	// 
		int n = Integer.parseInt(br.readLine());
		String[] str = new String[n];
		for(int i=0; i<n; i++) {
			str[i] = br.readLine();
		}
		// 큐로 대신해도 괜찮을거 같은데
		Map<Character, Integer> map = new HashMap<>();
		
		F:for(int i=0; i<n; i++) {
			String temp = str[i].toUpperCase();
			// 조건 1 첫번째 단어가 없다면 + 다 대문자로 넣어서 대소문자 구분하지 않게 한다
			if(!map.containsKey(temp.charAt(0)) && !map.containsKey(temp.charAt(0))) {
				map.put(temp.charAt(0), i);
				String con = "["+str[i].charAt(0)+"]";
				str[i] = con+str[i].substring(1);
				bw.write(str[i]+"\n");
				continue;
			}
			// 조건 1 중 띄어쓰기를 포함하는 단어면, 다음 단어의 첫번째 단어 확인
			if(temp.contains(" ")) {
				for(int len=temp.length(), j=0; j<len; j++) {
					if(temp.charAt(j)==' ') {
						int idx = j+1;
						if(!map.containsKey(temp.charAt(idx)) && !map.containsKey(temp.charAt(idx))) {
							map.put(temp.charAt(idx), i);
							String con = "["+str[i].charAt(idx)+"]";
							String s = str[i];
							str[i] = s.substring(0, idx) + con + s.substring(idx+1);
							bw.write(str[i]+"\n");
							continue F;
						}
					}
				}
			}
			// 조건 2 왼쪽부터 차례대로 확인
			for(int len = temp.length(), j=1; j<len; j++) {
				char c = temp.charAt(j);
				if(c==' ') continue; 
				if (!map.containsKey(temp.charAt(j)) && !map.containsKey(temp.charAt(j))) {
					map.put(c, i);
					String con = "[" + str[i].charAt(j) + "]";
					String s = str[i];
					str[i] = s.substring(0, j) + con + s.substring(j+1);
					bw.write(str[i]+"\n");
					continue F;
				}
			}
			bw.write(str[i]+"\n");
			// 조건 3 그냥 내비둔다
		}
		
		br.close();
		bw.close();
	}
}
