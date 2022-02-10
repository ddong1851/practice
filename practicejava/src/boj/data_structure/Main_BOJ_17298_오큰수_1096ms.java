package src.boj.data_structure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 큐에 각 인덱스마다 갖는 값들을 Pair라는 데이터타입에 넣고 저장
 * 스택에는 오큰수를 찾아야하는 인덱스들을 Pair 타입으로 쌓기
 * arr 배열은 정답을 저장하는 배열
 * 
 * 오큰수 문제
 * 탑 문제와 유사( 사실상 얘가 좌큰수 )
 * 우측에 자신보다 큰 값이 오면 오큰수를 찾았으므로 스택에서 빠진다
 * 자신보다 작은 값이 들어오면 오큰수를 찾기 위해 스택에 쌓는다. 
 * 오큰수가 없다면 해당 값을 -1로 지정해라
 * 
 * 
 * 아쉬웠던 점
 * 배열 인덱스를 하나 늘려서 맨 끝에 가장 큰 데이터를 집어 넣으면 무조건 거기서 만날 수 오큰수를 찾을 수 밖에 없다.
 * 스택의 끝에서 결국 벽을 만나게 될테니 큐가 빌때까지 빠질 일이 없다.
 * +int[] arr = new int[n+1];
 * stack.push(new Pair(Integer.MAX_VALUE, n));
 * --> isEmpty 없이 구현할 수 있다.
 * 
 * + 조건을 넣으면 while문 처리가 더 이쁠거 같다(기독성?)
 */


public class Main_BOJ_17298_오큰수_1096ms {
    
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
        int[] arr = new int[n];

        // 큐에 입력 데이터들을 직접 저장( 값, 인덱스 형식으로 )
        for (int i = 0; i < n; i++) {
            queue.offer(new Pair(Integer.parseInt(st.nextToken()), i));
        } // end of for

        // 큐가 비어있지 않을 때 반복
        while (!queue.isEmpty()) {
            // 스택에 암것도 없으면
            if (stack.isEmpty()) {
            	// 스택에 큐의 값을 하나 쌓는다.
                stack.push(queue.poll());
            }
            // 현재 수 보다 작으면 집어 넣어버려서 다음 오큰수 찾으러...
            while (!stack.isEmpty() && !queue.isEmpty() && stack.peek().val >= queue.peek().val) {
            	// 단순히 더 작은 값이면 ( stack.top 2(5) > q.poll = 3(2) 이니까 stack에 쌓기 (해당 index들의 오큰수를 찾기 위해) )
                stack.push(queue.poll());
            }
            // 현재 수 보다 크면 오큰수
            while (!stack.isEmpty() && !queue.isEmpty() && stack.peek().val < queue.peek().val) {
            	// 오큰수 배열에 현재 스택 맨 위에 있는 값을 뺴내어 해당 idx를 갖는 배열에 현재 비교대상인 값을 넣는다. 
            	// ( 스택에 0(3)이 있는데 2(5)가 들어오면 arr[0] = 5  
                arr[stack.pop().idx] = queue.peek().val;
            }
        } // end of while
        
        // 스택에 남아 있는 인덱스들은 오큰수가 없는 값들이르모 비우면서 -1을 부여한다.
        // 스택 남았는데도 없으면 // 7,6,5,4,3,2,1
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
class Pair {
    int val;
    int idx;

    public Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}