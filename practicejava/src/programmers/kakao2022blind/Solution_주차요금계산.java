package src.programmers.kakao2022blind;

import java.util.*;

public class Solution_주차요금계산 {
	public static int[] solution(int[] fees, String[] records) {
        /*
        fees[0] = 기본 시간(분) (기본 시간 만큼은 빼준다)
        fees[1] = 기본 요금(원) 
        fees[2] = 단위 시간(분) (이후 단위 시간 기준으로)
        fees[3] = 단위 요금(원) (단위 시간 만큼 지불)
        
              한대가 여러번 왔다 갔다 할 수도 있다?
         */
        
        int rep = records.length;
        
        Map<String, Integer> cars = new HashMap<>();
        Map<String, Integer> car_added = new HashMap<>();
        List<String> car_num = new ArrayList<>();
        
        int time = 0;
        String car_id = "";
        String in_out = "";
        StringTokenizer st = null;
        for(int i=0; i<rep; i++) {
        	st = new StringTokenizer(records[i]);
        	time = timeToInt(st.nextToken());
        	car_id = st.nextToken();
        	in_out = st.nextToken();
        	// 입차
        	if(in_out.equals("IN")) {
        		if(!car_num.contains(car_id)) car_num.add(car_id);
        		cars.put(car_id, time);
        	}
        	// 출차
        	else {
        		time -= cars.get(car_id);
        		// 시간 누적하기
        		if(car_added.get(car_id) != null) {
        			time += car_added.get(car_id);
        		}
        		// 차량 누적 시간 저장
        		car_added.put(car_id, time);
        		// 출차했으니 차량 목록에서 제거
        		cars.remove(car_id);
        	}
        }
        
        // 아직 출차 안한  차량 목록
        List<String> list = new ArrayList<>(cars.keySet());
        for(int i=0, size = list.size(); i<size; i++) {
        	car_id = list.get(i);
        	time = timeToInt("23:59") - cars.get(car_id);
    		// 이전에 차가 출차한 기록이 있다면 시간 합산
    		if(car_added.get(car_id) != null) {
    			time += car_added.get(car_id);
    		}
    		// 차량 누적 시간 저장
    		car_added.put(car_id, time);
    		// 출차했으니 차량 목록에서 제거
    		cars.remove(car_id);
        }
        
        // 차번호 오름차순 정렬
        Collections.sort(car_num);
        int[] answer = new int[car_num.size()];
        // 차량 지불 금액 저장
        for(int i=0, size=car_num.size(); i<size; i++) {
        	answer[i] = getPaid(car_added.get(car_num.get(i)), fees);
        }
        
        return answer;
    } // end of solution
	
	private static int getPaid(int time_added, int[] fees) {
		int time = time_added - fees[0];
		// 기본 시간 내에 출차했다면 기본 요금만
		if(time<=0) return fees[1];
		// 기본 시간을 벗어났다면
		else {
			// 기본 요금 + 추가 요금
			int mult = time/fees[2];
			if(time%fees[2]!=0) mult++;
			return fees[1]+fees[3]*mult;
		}
	}

	private static int timeToInt(String time) {
		StringTokenizer st = new StringTokenizer(time, ":");
		return 60*(Integer.parseInt(st.nextToken()))+Integer.parseInt(st.nextToken());
	} // end of timeToInt
	
	
	public static void main(String[] args) {
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", 
				"18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		int[] arr = solution(fees, records);
		System.out.println(Arrays.toString(arr));
	} // end of main 
}
