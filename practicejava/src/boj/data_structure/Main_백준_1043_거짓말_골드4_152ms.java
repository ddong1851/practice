package src.boj.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/* �ݷ�
6 5
1 6
2 4 5
2 1 2
2 2 3
2 3 4
2 5 6
-> 0
 */

/** Main_����_1043_������_���4_152ms*/
public class Main_����_1043_������_���4_152ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N�� ����� �� M�� ��Ƽ�� ��
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int lierCnt = Integer.parseInt(st.nextToken());
		// �������� �ƴ� ����� ���ٸ� �� ��Ƽ�� ���� ����ϰ� ������
		// ������ �ƴ� ����� ��Ʈ
		Set<Integer> set = new HashSet<Integer>();
		while(st.hasMoreTokens()) set.add(Integer.parseInt(st.nextToken()));
		// ������ �ƴ� ���, ���� ���θ� ���⿡ �����ұ� , 1��1 ��Ī
		boolean[] truth = new boolean[M];
		
		int result = M;
		Map<Integer, Set<Integer>> partyInfo = new HashMap<>();
		// ��Ƽ�� ����ŭ ��Ƽ ������ �Է� ���� + ����� �ƴ� ��� ��Ʈ ����
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			// ��Ƽ�� ���� ��� �� 1~50
			int size = Integer.parseInt(st.nextToken());
			// ����� ��Ʈ �ʱ�ȭ
			Set<Integer> people = new HashSet<Integer>(size);;
			for(int p=0; p<size; p++) {
				people.add(Integer.parseInt(st.nextToken()));
			}
			// ��Ƽ ������ �߰�
			partyInfo.put(i, people);
			// ������ �ƴ� ����� ��Ƽ�� �����ϴ°�?
			boolean flag = false;
			for(Integer se:set) {
				if(people.contains(se)) {
					// i��° ��Ƽ�� �̹� ���� �Ǿ���.
					truth[i] = true;
					result--;
					flag = true;
					break;
				}
			}
			// �����ϸ� ��ΰ� ������ �˰� �ǹǷ� ���� ��Ʈ�� �߰�
			if(flag==true) {
				set.addAll(people);
			}
		} // end of init partyInfo for
		
		while(true) {
			boolean repeat = false;
			// temp�� �����͵��� set�� ���� �ִ��� ����, �������� �ʰ� �ִ� Set�� ���� ���� �߰�
			for(int i=0; i<M; i++) {
				boolean flag = false;
				Set<Integer> temp = partyInfo.get(i);
				Set<Integer> conX = new HashSet<>();
				
				for(Integer person:temp) {
					if(set.contains(person)) {
						flag = true;
					}
					else {
						// set�� ���� ���ڸ� ����
						conX.add(person);
					}
				}
				
				if(flag) {
					// flag�� true�� ������ ���� ���ڵ� set�� �߰�
					if(conX.size()!=0) {
						truth[i] = true;
						result--;
						set.addAll(conX);
						repeat = true;
					}
					if(truth[i]==false) {
						truth[i] = true;
						result--;
					}
				}
			} // end of for(counting party)
			
			if(repeat == false) {
				break;
			}
			
		}
		
		System.out.println(result);
	}
}
