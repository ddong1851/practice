package src.programmers.kakao2021;
class Solution_2021īī��ä�뿬�������ͽ�_���ڹ��ڿ������ܾ� {
	
    public int solution(String s) {
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i=0; i<10; i++){
            if(s.contains(arr[i])){
                s = s.replaceAll(arr[i], String.valueOf(i));
            }
        }
        return Integer.parseInt(s);
    }
    
}
