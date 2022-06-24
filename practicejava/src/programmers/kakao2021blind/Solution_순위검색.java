package src.programmers.kakao2021blind;

import java.util.*;

public class Solution_�����˻� {
	
	public static HashMap<String, ArrayList<Integer>> allQuerys;
	
	public static int[] solution(String[] info, String[] query) {
		
		/*
		 * info�� ���� �� ��� ���ǿ� ���� ������ �����Ѵ�.
		 * 
		 * ������ 1~100000�ε�.. ��ĳ ������
		 * 
		 * 1. ����Ž���ϴϱ� ȿ���� 0���̴�
		 * 
		 * 2. list�� �����ϰ� �̺�Ž���ϰ�.. �ش� index�� ã�� size�� ������
		 */
		
		int queryLength=query.length;
		int[] answer = new int[queryLength];
		
		allQuerys = new HashMap<String, ArrayList<Integer>>();
		
		// info�� �־����� ���ǿ� ���� 
		for(String infos: info) {
			makeQuerySelect(infos.split(" "), "", 0);
		}
		
		// ��� query�ÿ� ���� �˻��Ѵ�. 
		int queryScore = 0;
		int findIndex = 0;
		String checkQuery = "";
		for(int queryIdx=0; queryIdx<queryLength; queryIdx++) {
			
			String[] queryString = query[queryIdx].split(" ");
			checkQuery = makeQueryString(queryString);
			
			List<Integer> scores = allQuerys.get(checkQuery);
			findIndex = 0;
			
			if(!queryString[7].equals("-")) {
				queryScore = Integer.parseInt(queryString[7]);
				// ����Ʈ�� ������������ �����Ѵ�. 
				scores.sort((o1, o2)->{
					return o1-o2;
				});
				// �̺�Ž������ �ش� ������ �����ϴ� �ּ� index�� ã�´�. 
				findIndex = binarySearch(scores, queryScore, 0, scores.size()-1);
			}
			answer[queryIdx] = scores.size()-findIndex;
		}
        return answer;
    } // end of solution 

	private static int binarySearch(List<Integer> scores, int queryScore, int low, int high) {
		while(low<=high) {
			int mid = (low+high)/2;
			int score = scores.get(mid);
			if(queryScore<=score) high = mid-1;
			else low = mid+1;
		}
		return low;
	}

	private static String makeQueryString(String[] queryString) {
		StringBuilder sb = new StringBuilder();
		sb.append(queryString[0]).append(queryString[2]).append(queryString[4]).append(queryString[6]);
		return sb.toString();
	} // end of makeQueryString;

	/** Makes All available Querys */
	public static void makeQuerySelect(String[] infos, String query, int cnt) {
		if(cnt==4) {
			// ���� ���� �������� ���� �� ����Ʈ�� �����, �ű⿡ �߰��Ѵ�. 
			if(!allQuerys.containsKey(query)) {
				allQuerys.put(query, new ArrayList<Integer>());
			}
			allQuerys.get(query).add(Integer.parseInt(infos[cnt]));
			return;
		} // end of �������� 
		makeQuerySelect(infos, query+infos[cnt], cnt+1);
		makeQuerySelect(infos, query+"-", cnt+1);
	} // end of makeQuerySelect 
	
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150",
				"cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200",
				"cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		
		System.out.println(Arrays.toString(solution(info, query)));
	}
	
} // end of class 
