package src.programmers.kakao2022blind;

import java.util.*;

public class Solution_������ݰ�� {
	public static int[] solution(int[] fees, String[] records) {
        /*
        fees[0] = �⺻ �ð�(��) (�⺻ �ð� ��ŭ�� ���ش�)
        fees[1] = �⺻ ���(��) 
        fees[2] = ���� �ð�(��) (���� ���� �ð� ��������)
        fees[3] = ���� ���(��) (���� �ð� ��ŭ ����)
        
              �Ѵ밡 ������ �Դ� ���� �� ���� �ִ�?
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
        	// ����
        	if(in_out.equals("IN")) {
        		if(!car_num.contains(car_id)) car_num.add(car_id);
        		cars.put(car_id, time);
        	}
        	// ����
        	else {
        		time -= cars.get(car_id);
        		// �ð� �����ϱ�
        		if(car_added.get(car_id) != null) {
        			time += car_added.get(car_id);
        		}
        		// ���� ���� �ð� ����
        		car_added.put(car_id, time);
        		// ���������� ���� ��Ͽ��� ����
        		cars.remove(car_id);
        	}
        }
        
        // ���� ���� ����  ���� ���
        List<String> list = new ArrayList<>(cars.keySet());
        for(int i=0, size = list.size(); i<size; i++) {
        	car_id = list.get(i);
        	time = timeToInt("23:59") - cars.get(car_id);
    		// ������ ���� ������ ����� �ִٸ� �ð� �ջ�
    		if(car_added.get(car_id) != null) {
    			time += car_added.get(car_id);
    		}
    		// ���� ���� �ð� ����
    		car_added.put(car_id, time);
    		// ���������� ���� ��Ͽ��� ����
    		cars.remove(car_id);
        }
        
        // ����ȣ �������� ����
        Collections.sort(car_num);
        int[] answer = new int[car_num.size()];
        // ���� ���� �ݾ� ����
        for(int i=0, size=car_num.size(); i<size; i++) {
        	answer[i] = getPaid(car_added.get(car_num.get(i)), fees);
        }
        
        return answer;
    } // end of solution
	
	private static int getPaid(int time_added, int[] fees) {
		int time = time_added - fees[0];
		// �⺻ �ð� ���� �����ߴٸ� �⺻ ��ݸ�
		if(time<=0) return fees[1];
		// �⺻ �ð��� ����ٸ�
		else {
			// �⺻ ��� + �߰� ���
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
