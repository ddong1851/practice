package src.programmers.kakao2021blind;

import java.util.*;

public class Solution_순위검색 {
	
	public static HashMap<String, ArrayList<Integer>> allQuerys;
	
	public static int[] solution(String[] info, String[] query) {
		
		/*
		 * info를 읽을 때 모든 조건에 따라 나눠서 저장한다.
		 * 
		 * 점수는 1~100000인데.. 어캐 나누지
		 * 
		 * 1. 순차탐색하니까 효율성 0점이다
		 * 
		 * 2. list를 정렬하고 이분탐색하고.. 해당 index를 찾고 size랑 비교하자
		 */
		
		int queryLength=query.length;
		int[] answer = new int[queryLength];
		
		allQuerys = new HashMap<String, ArrayList<Integer>>();
		
		// info로 주어지는 조건에 따라 
		for(String infos: info) {
			makeQuerySelect(infos.split(" "), "", 0);
		}
		
		// 모든 query뮨에 대해 검색한다. 
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
				// 리스트를 오름차순으로 정렬한다. 
				scores.sort((o1, o2)->{
					return o1-o2;
				});
				// 이분탐색으로 해당 점수를 만족하는 최소 index를 찾는다. 
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
			// 현재 만든 쿼리문이 없을 때 리스트를 만들고, 거기에 추가한다. 
			if(!allQuerys.containsKey(query)) {
				allQuerys.put(query, new ArrayList<Integer>());
			}
			allQuerys.get(query).add(Integer.parseInt(infos[cnt]));
			return;
		} // end of 기저조건 
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
