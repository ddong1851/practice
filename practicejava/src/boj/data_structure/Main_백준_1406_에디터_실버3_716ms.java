package src.boj.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

// �ð� �ʰ�
/** Main_����_1406_������_�ǹ�3_716ms*/
public class Main_����_1406_������_�ǹ�3_716ms {
	
	static int n;
	static List<Character> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		// ���� �߰�, ������ ���� LinkedList
		list = new LinkedList<Character>();
		//���ڿ� list�� �߰�
		char[] temp = br.readLine().toCharArray();
		for(int i=0; i<temp.length; i++) {
			list.add(temp[i]);
		}
		// List.add remove�� O(n)�̰�, listIterator�� ����ϸ� �ε����� ���� �����Ͽ� O(1)�̶�� �ϳ׿�.
		ListIterator<Character> iter = list.listIterator();
		while(iter.hasNext()) {
			iter.next();
		}
		// �Է��� ��
		n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			// �Է��� �޴´�
			st = new StringTokenizer(br.readLine());
			// �Է¿� ���� �ൿ ����
			switch(st.nextToken()) {
			case "L":
				if(iter.previousIndex()!=-1) {
					iter.previous();
				}
				break;
			case "D":
				if(iter.hasNext()) {
					iter.next();
				}
				break;
			case "B":
				// ������ ����� �ʰ�
				if(iter.previousIndex()!=-1) {
					// ���� �� ���� �� ����
					iter.previous();
					iter.remove();
				}
				break;
			case "P":
				iter.add(st.nextToken().charAt(0));;
				break;
			default:
				break;
			} // end of switch
		} // end of for 
		// iterator �� ������ �̵�
		while(iter.previousIndex()!=-1) {
			iter.previous();
		}
		// �տ������� �ܾ� ���
		while(iter.hasNext()) {
			sb.append(iter.next());
		}
		System.out.println(sb.toString());
	} // end of main
} // end of class
