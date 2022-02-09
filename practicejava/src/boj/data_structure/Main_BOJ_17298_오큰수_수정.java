package src.boj.data_structure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
 * 시간도 약간 줄어듭니다.. 1028ms
 */
public class Main_BOJ_17298_오큰수_수정 {
    
    public static void main(String[] args) throws IOException {
    	// 키보드 스트림을 입력받는 버퍼스트림
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문자열 만들기
        StringBuilder sb = new StringBuilder();
        
        Queue<Pair> queue = new LinkedList<>();
        // 현재 지정된 수 + 지정된 수 보다 작은 수들
        Stack<Pair> stack = new Stack<>();

        // 수열의 크기 입력
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열 초기화 ( 오큰수를 저장할 배열 )
        int[] arr = new int[n+1];
        stack.push(new Pair(Integer.MAX_VALUE, n));
        // 큐에 입력 데이터들을 직접 저장( 값, 인덱스 형식으로 )
        for (int i = 0; i < n; i++) {
            queue.offer(new Pair(Integer.parseInt(st.nextToken()), i));
        } // end of for

        // 큐가 비어있지 않을 때 반복
        while (!queue.isEmpty()) {
            // 현재 수 보다 크면 오큰수
            if(stack.peek().val < queue.peek().val) {
            	while (stack.peek().val < queue.peek().val) {
            		arr[stack.pop().idx] = queue.peek().val;
            	}
            }
            // 현재 수 보다 작으면 집어 넣어버려서 다음 오큰수 찾으러...
            stack.push(queue.poll());
        } // end of while
        // 스택 비우기
        while (!stack.isEmpty()) {
            arr[stack.pop().idx] = -1;
        }
        // 정답 출력
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(' ');
        }
        System.out.println(sb);
    } // end of main
} // end of class

// 페어라는 데이터 타입을 만드는데, 위치인 index와 값을 저장한다.
//class Pair {
//    int val;
//    int idx;
//
//    public Pair(int val, int idx) {
//        this.val = val;
//        this.idx = idx;
//    }
//}