package src.boj.undone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;

/** Main_백준_1339_단어수학_undone*/
/** 진짜 쉬운 방법은! 각 단어? 에 자리별로 10^n을 곱해서 제일 큰거부터 9의 값을 부여해보는 것*/
public class Main_백준_1339_단어수학_undone {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 단어의 개수
		int n = sc.nextInt();
		// 단어의 배열
		List<String> strList = new ArrayList<String>();
		// 단어의 길이별 알파벳 개수, 이를 초기화한다
		Map<Integer, HashMap<Character, Integer>> Alpha = new HashMap<>(8);
		for(int i=1; i<=8; i++) {
			// 알파벳은 최대 10개
			HashMap<Character, Integer> temp = new HashMap<Character, Integer>(10);
			Alpha.put(i, (HashMap<Character, Integer>) temp);
		}
		// 반복문을 통해 ex) 7의 길이의 문자열들의 알파벳 개수 등을 저장할 수 있다.
		for(int i=0; i<n; i++) {
			// 단어
			String str = sc.next();
			// 단어의 배열에 단어 추가
			strList.add(str);
			// 단어의 크기 저장
			int s = str.length();
			// 단어의 길이별 
			for(int size = str.length(), j=0; j<size; j++) {
				char c = str.charAt(j); //(ex) 0번째가 길이 3인 문자열에서 3번째 단어이므로, 이를 문자열의 길이인 s키에 넣는다
				// 10개의 단어의 개수를 저장할 HashMap
				Map<Character, Integer> alpha = Alpha.get(s);
				// HashMap에 해당 알파벳이 존재하지 않는다면 추가하자
				if(!alpha.containsKey(c)) {
					alpha.put(c, 1);
				}
				// 포함하고 있다면 값을 꺼내온 다음 하나 더 큰 값을 다시 넣는다
				else {
					int count = alpha.get(c);
					alpha.put(c, count+1);
				}
				// 전체 HashMap에 다시 추가
				Alpha.put(s--, (HashMap<Character, Integer>) alpha);
			}
		} // end of Data Initalization 
		
		// 알파벳 길이의 우선순위별 알파벳을 저장할 큐
		Queue<Character> q = new LinkedList<>();
		
		// Alpha에서 길이별 HashMap을 빼고 조회, Alpha size는 8
		for(int size = Alpha.size(), i=size; i>=0; i--) {
			HashMap<Character, Integer> temp = Alpha.get(i);
			// 해당 HashMap이 비었다면 다음 
			if(temp==null) {
				continue;
			}
			// 알파벳 개수별 우선순위를 내림차순으로 정렬하고, 이를 큐에 넣는다
			List<Map.Entry<Character, Integer>> entryList = new LinkedList<>(temp.entrySet());
			entryList.sort((o1, o2)-> {
				return o2.getValue() - o1.getValue();
			});
			// 큐에 알파벳 개수별 알파벳 추가
			for(Entry<Character, Integer> ent:entryList) {
				q.add(ent.getKey());
			}
			// 동일할 때 어떻게 내려가서 연산할까? 
			while(!q.isEmpty()) {
				
			}
		} // end of for
		
		// 'A' = 65
//		System.out.println(list.get(klist.get(0)).get((char)65));
		
		
	} // end of main
} // end of class
