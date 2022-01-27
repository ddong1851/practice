package src.boj.undone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;

/** Main_����_1339_�ܾ����_undone*/
/** ��¥ ���� �����! �� �ܾ�? �� �ڸ����� 10^n�� ���ؼ� ���� ū�ź��� 9�� ���� �ο��غ��� ��*/
public class Main_����_1339_�ܾ����_undone {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// �ܾ��� ����
		int n = sc.nextInt();
		// �ܾ��� �迭
		List<String> strList = new ArrayList<String>();
		// �ܾ��� ���̺� ���ĺ� ����, �̸� �ʱ�ȭ�Ѵ�
		Map<Integer, HashMap<Character, Integer>> Alpha = new HashMap<>(8);
		for(int i=1; i<=8; i++) {
			// ���ĺ��� �ִ� 10��
			HashMap<Character, Integer> temp = new HashMap<Character, Integer>(10);
			Alpha.put(i, (HashMap<Character, Integer>) temp);
		}
		// �ݺ����� ���� ex) 7�� ������ ���ڿ����� ���ĺ� ���� ���� ������ �� �ִ�.
		for(int i=0; i<n; i++) {
			// �ܾ�
			String str = sc.next();
			// �ܾ��� �迭�� �ܾ� �߰�
			strList.add(str);
			// �ܾ��� ũ�� ����
			int s = str.length();
			// �ܾ��� ���̺� 
			for(int size = str.length(), j=0; j<size; j++) {
				char c = str.charAt(j); //(ex) 0��°�� ���� 3�� ���ڿ����� 3��° �ܾ��̹Ƿ�, �̸� ���ڿ��� ������ sŰ�� �ִ´�
				// 10���� �ܾ��� ������ ������ HashMap
				Map<Character, Integer> alpha = Alpha.get(s);
				// HashMap�� �ش� ���ĺ��� �������� �ʴ´ٸ� �߰�����
				if(!alpha.containsKey(c)) {
					alpha.put(c, 1);
				}
				// �����ϰ� �ִٸ� ���� ������ ���� �ϳ� �� ū ���� �ٽ� �ִ´�
				else {
					int count = alpha.get(c);
					alpha.put(c, count+1);
				}
				// ��ü HashMap�� �ٽ� �߰�
				Alpha.put(s--, (HashMap<Character, Integer>) alpha);
			}
		} // end of Data Initalization 
		
		// ���ĺ� ������ �켱������ ���ĺ��� ������ ť
		Queue<Character> q = new LinkedList<>();
		
		// Alpha���� ���̺� HashMap�� ���� ��ȸ, Alpha size�� 8
		for(int size = Alpha.size(), i=size; i>=0; i--) {
			HashMap<Character, Integer> temp = Alpha.get(i);
			// �ش� HashMap�� ����ٸ� ���� 
			if(temp==null) {
				continue;
			}
			// ���ĺ� ������ �켱������ ������������ �����ϰ�, �̸� ť�� �ִ´�
			List<Map.Entry<Character, Integer>> entryList = new LinkedList<>(temp.entrySet());
			entryList.sort((o1, o2)-> {
				return o2.getValue() - o1.getValue();
			});
			// ť�� ���ĺ� ������ ���ĺ� �߰�
			for(Entry<Character, Integer> ent:entryList) {
				q.add(ent.getKey());
			}
			// ������ �� ��� �������� �����ұ�? 
			while(!q.isEmpty()) {
				
			}
		} // end of for
		
		// 'A' = 65
//		System.out.println(list.get(klist.get(0)).get((char)65));
		
		
	} // end of main
} // end of class
