package src.boj.implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj10828 {
	static Stack stack = new Stack();
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        
        
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			switchStr(st.nextToken());
		}
        
        br.close();
        bw.close();
    }
    
    static void switchStr(String str) throws IOException{
    	switch (str) {
		case "push":
			stack.push(Integer.parseInt(st.nextToken()));
			break;
		case "pop":
			bw.write(stack.pop()+"\n");
			break;
		case "size":
			bw.write(stack.size()+"\n");
			break;
		case "empty":
			bw.write(stack.empty()+"\n");
			break;
		case "top":
			bw.write(stack.top()+"\n");
			break;
		default:
			break;
		}
    }
}

class Stack{
	private int top;
	final private int MAX = 100001;
	public int[] stack = new int[10000];
	
	public Stack() {
		init();
	}
	
//	stack의 초기값을 한계보다 하나 큰 100001로. 
	public void init() {
		top = -1;
		Arrays.fill(stack, MAX);
	}
	
	public void push(int x) {
		top++;
		stack[top] = x;
	}
	
	public int pop() {
		if(empty()!=1) {
			int temp = stack[top];
			stack[top] = 0;
			top--;
			return temp;
		}
		return -1;
	}
	
	public int empty() {
		if(top>=0) {
			return 0;
		}
		return 1;
	}
	
	public int size() {
		return top+1;
	}
	
	public int top() {
		if(top>=0) {
			return stack[top];
		}
		return -1;
	}
}