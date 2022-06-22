package src.programmers.kakao2022;

import java.util.*;

public class Solution_�Ű����ޱ� {
	public static int[] solution(String[] id_list, String[] report, int k) {
		int size = id_list.length;
		int[] answer = new int[size];
		Map<String, Integer> reported = new HashMap<String, Integer>();
		Map<String, HashSet<String>> user_report = new HashMap<>();

		// HashMap �ʱ�ȭ
		for (int i = 0; i < size; i++) {
			reported.put(id_list[i], 0);
			user_report.put(id_list[i], new HashSet<String>());
		}
		
		StringTokenizer st = null;
		String name = "";
		String rep_name = "";
        // �Ű���Ʈ ���� �κ�
		for(int i=0, len=report.length; i<len; i++) {
			st = new StringTokenizer(report[i]);
			name = st.nextToken();
			rep_name = st.nextToken();
            // �Ű��ڰ� �Ű� ����� �Ű������� ���ٸ� ����Ʈ ����
			if(!user_report.get(name).contains(rep_name)) {
				user_report.get(name).add(rep_name);
				reported.put(rep_name, reported.get(rep_name)+1);
			}
		}
		
		for(int i=0; i<size; i++) {
            // ����ڰ� k�� �̻� �Ű� ���g�� ��� 
			if(reported.get(id_list[i])>=k) {
                // ���� �Ű����� �Ű��ڸ�ܿ� ��� ����ڰ� �ִٸ� +1
				for(int j=0; j<size; j++) {
					if(user_report.get(id_list[j]).contains(id_list[i])) {
						answer[j]++;
					}
				}
			}
		}
        
        return answer;

	}

	public static void main(String[] args) {
		String[] id_list = { "muzi", "frodo", "apeach", "neo" };
		String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
		int k = 2;
		
		int[] ans = solution(id_list, report, k);
		for(int a:ans) System.out.print(a);
	}
}
