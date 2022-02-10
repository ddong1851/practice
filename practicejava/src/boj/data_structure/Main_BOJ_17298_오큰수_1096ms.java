package src.boj.data_structure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * ť�� �� �ε������� ���� ������ Pair��� ������Ÿ�Կ� �ְ� ����
 * ���ÿ��� ��ū���� ã�ƾ��ϴ� �ε������� Pair Ÿ������ �ױ�
 * arr �迭�� ������ �����ϴ� �迭
 * 
 * ��ū�� ����
 * ž ������ ����( ��ǻ� �갡 ��ū�� )
 * ������ �ڽź��� ū ���� ���� ��ū���� ã�����Ƿ� ���ÿ��� ������
 * �ڽź��� ���� ���� ������ ��ū���� ã�� ���� ���ÿ� �״´�. 
 * ��ū���� ���ٸ� �ش� ���� -1�� �����ض�
 * 
 * 
 * �ƽ����� ��
 * �迭 �ε����� �ϳ� �÷��� �� ���� ���� ū �����͸� ���� ������ ������ �ű⼭ ���� �� ��ū���� ã�� �� �ۿ� ����.
 * ������ ������ �ᱹ ���� ������ ���״� ť�� �������� ���� ���� ����.
 * +int[] arr = new int[n+1];
 * stack.push(new Pair(Integer.MAX_VALUE, n));
 * --> isEmpty ���� ������ �� �ִ�.
 * 
 * + ������ ������ while�� ó���� �� �̻ܰ� ����(�⵶��?)
 */


public class Main_BOJ_17298_��ū��_1096ms {
    
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
        int[] arr = new int[n];

        // ť�� �Է� �����͵��� ���� ����( ��, �ε��� �������� )
        for (int i = 0; i < n; i++) {
            queue.offer(new Pair(Integer.parseInt(st.nextToken()), i));
        } // end of for

        // ť�� ������� ���� �� �ݺ�
        while (!queue.isEmpty()) {
            // ���ÿ� �ϰ͵� ������
            if (stack.isEmpty()) {
            	// ���ÿ� ť�� ���� �ϳ� �״´�.
                stack.push(queue.poll());
            }
            // ���� �� ���� ������ ���� �־������ ���� ��ū�� ã����...
            while (!stack.isEmpty() && !queue.isEmpty() && stack.peek().val >= queue.peek().val) {
            	// �ܼ��� �� ���� ���̸� ( stack.top 2(5) > q.poll = 3(2) �̴ϱ� stack�� �ױ� (�ش� index���� ��ū���� ã�� ����) )
                stack.push(queue.poll());
            }
            // ���� �� ���� ũ�� ��ū��
            while (!stack.isEmpty() && !queue.isEmpty() && stack.peek().val < queue.peek().val) {
            	// ��ū�� �迭�� ���� ���� �� ���� �ִ� ���� ������ �ش� idx�� ���� �迭�� ���� �񱳴���� ���� �ִ´�. 
            	// ( ���ÿ� 0(3)�� �ִµ� 2(5)�� ������ arr[0] = 5  
                arr[stack.pop().idx] = queue.peek().val;
            }
        } // end of while
        
        // ���ÿ� ���� �ִ� �ε������� ��ū���� ���� �����̸��� ���鼭 -1�� �ο��Ѵ�.
        // ���� ���Ҵµ��� ������ // 7,6,5,4,3,2,1
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
class Pair {
    int val;
    int idx;

    public Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}