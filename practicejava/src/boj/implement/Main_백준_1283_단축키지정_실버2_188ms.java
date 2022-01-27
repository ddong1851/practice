package src.boj.implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/** Main_����_1283_����Ű����_�ǹ�2_188ms*/
public class Main_����_1283_����Ű����_�ǹ�2_188ms {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    
    /**������ ��Ģ <br>
     * *** 
     * ���ʿ������� ������ ������ �ܾ��� ù ���ڶ� �̹� ����Ű�� �����Ǿ����� ���캻��<br>
     * ���� ������ �ȵǾ��ִٸ� �� ���ĺ��� ����Ű�� �����Ѵ�<br>
     * 
     * ***<br>
     * ���� ��� �ܾ��� ù ���ڰ� �̹� �����Ǿ��ִٸ� ���ʿ������� ���ʴ�� ���ĺ��� ���鼭 ����Ű�� ���� �ȵ� ���� �ִٸ� ����<br>
     * 
     * ***<br>
     * ��� �͵� ����Ű�� ������ �� ���ٸ� �׳� ���ΰ� ��ҹ��ڸ� �������� �ʴ´�.<br>
     * 
     * ***<br>
     * ���� ��Ģ�� ù ��° �ɼǺ��� N��° �ɼǱ��� ���ʴ�� ����<br>
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
		// ť�� ����ص� �������� ������
		Map<Character, Integer> map = new HashMap<>();
		
		F:for(int i=0; i<n; i++) {
			String temp = str[i].toUpperCase();
			// ���� 1 ù��° �ܾ ���ٸ� + �� �빮�ڷ� �־ ��ҹ��� �������� �ʰ� �Ѵ�
			if(!map.containsKey(temp.charAt(0)) && !map.containsKey(temp.charAt(0))) {
				map.put(temp.charAt(0), i);
				String con = "["+str[i].charAt(0)+"]";
				str[i] = con+str[i].substring(1);
				bw.write(str[i]+"\n");
				continue;
			}
			// ���� 1 �� ���⸦ �����ϴ� �ܾ��, ���� �ܾ��� ù��° �ܾ� Ȯ��
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
			// ���� 2 ���ʺ��� ���ʴ�� Ȯ��
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
			// ���� 3 �׳� ����д�
		}
		
		br.close();
		bw.close();
	}
}
