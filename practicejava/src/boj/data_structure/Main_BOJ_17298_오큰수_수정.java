package src.boj.data_structure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
 * �ð��� �ణ �پ��ϴ�.. 1028ms
 */
public class Main_BOJ_17298_��ū��_���� {
    
    public static void main(String[] args) throws IOException {
    	// Ű���� ��Ʈ���� �Է¹޴� ���۽�Ʈ��
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // ���ڿ� �����
        StringBuilder sb = new StringBuilder();
        
        Queue<Pair> queue = new LinkedList<>();
        // ���� ������ �� + ������ �� ���� ���� ����
        Stack<Pair> stack = new Stack<>();

        // ������ ũ�� �Է�
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        // �迭 �ʱ�ȭ ( ��ū���� ������ �迭 )
        int[] arr = new int[n+1];
        stack.push(new Pair(Integer.MAX_VALUE, n));
        // ť�� �Է� �����͵��� ���� ����( ��, �ε��� �������� )
        for (int i = 0; i < n; i++) {
            queue.offer(new Pair(Integer.parseInt(st.nextToken()), i));
        } // end of for

        // ť�� ������� ���� �� �ݺ�
        while (!queue.isEmpty()) {
            // ���� �� ���� ũ�� ��ū��
            if(stack.peek().val < queue.peek().val) {
            	while (stack.peek().val < queue.peek().val) {
            		arr[stack.pop().idx] = queue.peek().val;
            	}
            }
            // ���� �� ���� ������ ���� �־������ ���� ��ū�� ã����...
            stack.push(queue.poll());
        } // end of while
        // ���� ����
        while (!stack.isEmpty()) {
            arr[stack.pop().idx] = -1;
        }
        // ���� ���
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(' ');
        }
        System.out.println(sb);
    } // end of main
} // end of class

// ����� ������ Ÿ���� ����µ�, ��ġ�� index�� ���� �����Ѵ�.
//class Pair {
//    int val;
//    int idx;
//
//    public Pair(int val, int idx) {
//        this.val = val;
//        this.idx = idx;
//    }
//}