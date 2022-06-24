package src.programmers.kakao2021blind;

import java.util.*;

public class Solution_메뉴리뉴얼 {
	
	private static HashMap<Integer, HashMap<String, Integer>> collectionCount;
	private static HashMap<Integer, Integer> maxCounts;
	
	public String[] solution(String[] orders, int[] course) {
		
		/*
		 * orders로 들어온 단어 조합들로 만들 수 있는 모든 사이즈의 문자열 조합을 만들어보고, 
		 * 각각의 조합을 카운팅
		 * 
		 * 모든 조합을 만들며 카운팅하고 나서
		 * 최대로 나온 조합을 기준으로 배열을 만들어서 반환하자
		 */
		
		collectionCount = new HashMap<Integer, HashMap<String, Integer>>();
		maxCounts = new HashMap<Integer, Integer>();
		
		// 각 길이의 문자열의 최대 주문 개수를 저장하는 map 초기화
		for(int courseIdx=0, courseLength=course.length; courseIdx<courseLength; courseIdx++) {
			maxCounts.put(course[courseIdx], 0);
			collectionCount.put(course[courseIdx], new HashMap<String, Integer>());
		}
		
		// 각각의 단어 조합에 대해 만들 수 있는 모든 course 크기의 조합을 만들어본다. 
		for(int orderIdx=0, ordersLength=orders.length; orderIdx<ordersLength; orderIdx++) {
			// 가능한 모든 course 크기의 조합을 만들어본다. 
			for(int courseIdx=0, courseLength=course.length; courseIdx<courseLength; courseIdx++) {
				if(course[courseIdx]<=orders[orderIdx].length()) makeCourseSizeCollection(0, 0, course[courseIdx], new StringBuilder(), orderAscString(orders[orderIdx]));
			}
		}
		
		// 각 course 별 최대 주문 조합을 넣을 리스트
		ArrayList<String> list = makeListOfMaxCount(course);
		
		String[] answer = list.toArray(new String[list.size()]);
		
        return answer;
    } // end of solution 

	/**Returns String ordered by Alphabet Asc */
	private String orderAscString(String order) {
		char[] arr = order.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	} // end of orderAscString 

	/** Makes List Of Max Counts */
	private ArrayList<String> makeListOfMaxCount(int[] course) {
		ArrayList<String> list = new ArrayList<>();
		for(int courseIdx=0, courseLength=course.length; courseIdx<courseLength; courseIdx++) {
			int max = maxCounts.get(course[courseIdx]);
			if(max<2) continue;
			HashMap<String, Integer> map = collectionCount.get(course[courseIdx]);
			for(String stringCollection:map.keySet()) {
				if(map.get(stringCollection)==max) list.add(stringCollection);
			}
		}
		
		list.sort((o1, o2)-> {
			return o1.compareTo(o2);
		});
		
		return list;
	} // end of makeListOfMaxCount

	/** Makes String Collection of maxSize size and saves it in map */
	private void makeCourseSizeCollection(int start, int count, int maxSize, StringBuilder sb, String order) {
		if(count==maxSize) {
			
			// 조합한 문자열을 추가
			if(!collectionCount.get(maxSize).containsKey(sb.toString())) collectionCount.get(maxSize).put(sb.toString(), 1);
			// 이미 문자열이 있다면
			else collectionCount.get(maxSize).put(sb.toString(), collectionCount.get(maxSize).get(sb.toString())+1);
			
			// 최대 주문 수 갱신
			int max = collectionCount.get(maxSize).get(sb.toString());
			if(maxCounts.get(maxSize)<max) maxCounts.put(maxSize, max);
			
			return;
		} // end of if 
		
		for(int startIdx=start, orderLength=order.length(); startIdx<orderLength; startIdx++) {
			sb.append(order.charAt(startIdx));
			makeCourseSizeCollection(startIdx+1, count+1, maxSize, sb, order);
			sb.setLength(sb.length()-1);
		} // end of for 
		
	} // end of makeCourseSizeCollection 
	
}
