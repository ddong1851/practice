package src.boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// �ܾ��� ����
		int n = sc.nextInt();
		
		// �ܾ �ܾ��� ������ ������ Map
		// str ���ڿ��� a ���ĺ��� int�� �ִ�.
		Map<String, HashMap<Character, Integer>> list = new HashMap<>(10);
		// �ܾ��� ���̺� ����Ʈ�� �����ϴ� ����Ʈ 0~7
		List<ArrayList<String>> Slist = new ArrayList<ArrayList<String>>(8);
		
		for(int i=0; i<n; i++) {
			// �ܾ�
			String str = sc.next();
			Slist.get(str.length()-1).add(str);
			// 10���� �ܾ��� ������ ������ HashMap
			Map<Character, Integer> alpha = new HashMap<>(10);
			for(int j=0; j<str.length(); j++) {
				char c = str.charAt(j);
				// HashMap�� �ش� ���ĺ��� �������� �ʴ´ٸ� �߰�����
				if(!alpha.containsKey(c)) {
					alpha.put(c, 1);
				}
				// �����ϰ� �ִٸ� ���� ������ ���� �ϳ� �� ū ���� �ٽ� �ִ´�
				else {
					int count = alpha.get(c);
					alpha.put(c, count+1);
				}
				list.put(str, (HashMap<Character, Integer>) alpha);
			}
		}
		// Ű ��Ʈ�� ����
		Set<String> keys = list.keySet();
		// ���ο� ����Ʈ�� Ű ����Ʈ�� �����ϰ�, �̸� ���̼����� �����Ѵ�
		List<String> klist = new ArrayList<>(keys);
		Collections.sort(klist, (o1, o2)->{
			return o2.length() - o1.length();
		});
		
		// �������� ��(������ �ڿ� �����ϱ�)
		for(int size = Slist.size(),i=size-1; i>=0; i--) {
			// �ش� ������ ���ڿ��� ���ٸ� 
			if(Slist.get(i).size()==0) {
				continue;
			}
			// �ش� ������ ���ڿ��� ����, �� ���ڿ����� Ž��
			// ���� �� ���ڿ��� ���̸� �˰� �Ǿ��ٸ�, �̸� �������� ������
			for(int j=0; j<i; j++) {					// �̰Ŵ� �ܾ��� ��
				// ���̿� ���ԵǴ� ��� �ܾ ���� subString(j, str.lenght())
			}
			
			
			
		}
		// 'A' = 65
//		System.out.println(list.get(klist.get(0)).get((char)65));
	}
}
