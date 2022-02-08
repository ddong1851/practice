package src.boj.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/* 반례
6 5
1 6
2 4 5
2 1 2
2 2 3
2 3 4
2 5 6
-> 0
 */

/** Main_백준_1043_거짓말_골드4_152ms*/
public class Main_백준_1043_거짓말_골드4_152ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N은 사람의 수 M은 파티의 수
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int lierCnt = Integer.parseInt(st.nextToken());
		// 거짓말은 아는 사람이 없다면 총 파티의 수를 출력하고 끝내라
		// 진실을 아는 사람의 세트
		Set<Integer> set = new HashSet<Integer>();
		while(st.hasMoreTokens()) set.add(Integer.parseInt(st.nextToken()));
		// 진실을 아는 사람, 갱신 여부를 여기에 저장할까 , 1대1 매칭
		boolean[] truth = new boolean[M];
		
		int result = M;
		Map<Integer, Set<Integer>> partyInfo = new HashMap<>();
		// 파티의 수만큼 파티 정보를 입력 받음 + 비밀을 아는 사람 세트 갱신
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			// 파티에 오는 사람 수 1~50
			int size = Integer.parseInt(st.nextToken());
			// 사람들 세트 초기화
			Set<Integer> people = new HashSet<Integer>(size);;
			for(int p=0; p<size; p++) {
				people.add(Integer.parseInt(st.nextToken()));
			}
			// 파티 정보에 추가
			partyInfo.put(i, people);
			// 진실을 아는 사람이 파티에 참석하는가?
			boolean flag = false;
			for(Integer se:set) {
				if(people.contains(se)) {
					// i번째 파티는 이미 수정 되었다.
					truth[i] = true;
					result--;
					flag = true;
					break;
				}
			}
			// 참석하면 모두가 진실을 알게 되므로 진실 세트에 추가
			if(flag==true) {
				set.addAll(people);
			}
		} // end of init partyInfo for
		
		while(true) {
			boolean repeat = false;
			// temp의 데이터들을 set이 갖고 있는지 보고, 갖고있지 않고 있는 Set을 따로 만들어서 추가
			for(int i=0; i<M; i++) {
				boolean flag = false;
				Set<Integer> temp = partyInfo.get(i);
				Set<Integer> conX = new HashSet<>();
				
				for(Integer person:temp) {
					if(set.contains(person)) {
						flag = true;
					}
					else {
						// set이 없는 인자를 저장
						conX.add(person);
					}
				}
				
				if(flag) {
					// flag가 true면 기존에 없는 인자들 set에 추가
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
