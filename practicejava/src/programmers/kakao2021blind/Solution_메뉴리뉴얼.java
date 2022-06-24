package src.programmers.kakao2021blind;

import java.util.*;

public class Solution_�޴������� {
	
	private static HashMap<Integer, HashMap<String, Integer>> collectionCount;
	private static HashMap<Integer, Integer> maxCounts;
	
	public String[] solution(String[] orders, int[] course) {
		
		/*
		 * orders�� ���� �ܾ� ���յ�� ���� �� �ִ� ��� �������� ���ڿ� ������ ������, 
		 * ������ ������ ī����
		 * 
		 * ��� ������ ����� ī�����ϰ� ����
		 * �ִ�� ���� ������ �������� �迭�� ���� ��ȯ����
		 */
		
		collectionCount = new HashMap<Integer, HashMap<String, Integer>>();
		maxCounts = new HashMap<Integer, Integer>();
		
		// �� ������ ���ڿ��� �ִ� �ֹ� ������ �����ϴ� map �ʱ�ȭ
		for(int courseIdx=0, courseLength=course.length; courseIdx<courseLength; courseIdx++) {
			maxCounts.put(course[courseIdx], 0);
			collectionCount.put(course[courseIdx], new HashMap<String, Integer>());
		}
		
		// ������ �ܾ� ���տ� ���� ���� �� �ִ� ��� course ũ���� ������ ������. 
		for(int orderIdx=0, ordersLength=orders.length; orderIdx<ordersLength; orderIdx++) {
			// ������ ��� course ũ���� ������ ������. 
			for(int courseIdx=0, courseLength=course.length; courseIdx<courseLength; courseIdx++) {
				if(course[courseIdx]<=orders[orderIdx].length()) makeCourseSizeCollection(0, 0, course[courseIdx], new StringBuilder(), orderAscString(orders[orderIdx]));
			}
		}
		
		// �� course �� �ִ� �ֹ� ������ ���� ����Ʈ
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
			
			// ������ ���ڿ��� �߰�
			if(!collectionCount.get(maxSize).containsKey(sb.toString())) collectionCount.get(maxSize).put(sb.toString(), 1);
			// �̹� ���ڿ��� �ִٸ�
			else collectionCount.get(maxSize).put(sb.toString(), collectionCount.get(maxSize).get(sb.toString())+1);
			
			// �ִ� �ֹ� �� ����
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
