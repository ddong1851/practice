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
		// 단어의 개수
		int n = sc.nextInt();
		
		// 단어별 단어의 개수를 저장할 Map
		// str 문자열엔 a 알파벳이 int개 있다.
		Map<String, HashMap<Character, Integer>> list = new HashMap<>(10);
		// 단어의 길이별 리스트를 저장하는 리스트 0~7
		List<ArrayList<String>> Slist = new ArrayList<ArrayList<String>>(8);
		
		for(int i=0; i<n; i++) {
			// 단어
			String str = sc.next();
			Slist.get(str.length()-1).add(str);
			// 10개의 단어의 개수를 저장할 HashMap
			Map<Character, Integer> alpha = new HashMap<>(10);
			for(int j=0; j<str.length(); j++) {
				char c = str.charAt(j);
				// HashMap에 해당 알파벳이 존재하지 않는다면 추가하자
				if(!alpha.containsKey(c)) {
					alpha.put(c, 1);
				}
				// 포함하고 있다면 값을 꺼내온 다음 하나 더 큰 값을 다시 넣는다
				else {
					int count = alpha.get(c);
					alpha.put(c, count+1);
				}
				list.put(str, (HashMap<Character, Integer>) alpha);
			}
		}
		// 키 세트를 빼고
		Set<String> keys = list.keySet();
		// 새로운 리스트에 키 리스트를 저장하고, 이를 길이순으로 정렬한다
		List<String> klist = new ArrayList<>(keys);
		Collections.sort(klist, (o1, o2)->{
			return o2.length() - o1.length();
		});
		
		// 역순으로 비교(긴놈들이 뒤에 있으니까)
		for(int size = Slist.size(),i=size-1; i>=0; i--) {
			// 해당 길이의 문자열이 없다면 
			if(Slist.get(i).size()==0) {
				continue;
			}
			// 해당 길이의 문자열이 존재, 각 문자열들을 탐색
			// 가장 긴 문자열의 길이를 알게 되었다면, 이를 기준으로 돌리자
			for(int j=0; j<i; j++) {					// 이거는 단어의 끝
				// 길이에 포함되는 모든 단어에 대해 subString(j, str.lenght())
			}
			
			
			
		}
		// 'A' = 65
//		System.out.println(list.get(klist.get(0)).get((char)65));
	}
}
