package src.programmers.kakao2021;

import java.util.*;

public class Solution_2021카카오채용연계형인턴십_표편집 {
	
	private static class Node{
		Node left, right;
		int idx;
		boolean notUsing;
		public Node(int idx) {
			super();
			this.idx = idx;
		}
	}
	
	public static void main(String[] args) {
		int n = 8;
		int k = 2;
		String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
		
		System.out.println(solution(n, k, cmd));
	}
	
	public static String solution(int n, int k, String[] cmd) {
        StringBuilder answer = new StringBuilder();
        StringTokenizer st = null;
        Stack<Integer> dump = new Stack<>();
        Node[] list = new Node[n];
        
        list[0] = new Node(0);
        for (int i = 1; i < n; i++) {
			list[i] = new Node(i);
			list[i].left = list[i-1];
			list[i-1].right = list[i];
		}
        
        Node pointer = list[k];
        Node recover = null;
        Node left = null;
		Node right = null;
		
        String key = "";
        int val = 0;
        for(int i=0, size=cmd.length; i<size; i++) {
        	st = new StringTokenizer(cmd[i], " ");
        	key = st.nextToken();
        	// 삭제
        	if(key.equals("C")) {
        		pointer.notUsing = true;
        		dump.add(pointer.idx);
        		// 삭제된거 이전과 이후 연결 후 포인터 조정
        		left = pointer.left;
        		right = pointer.right;
        		pointer = remove(pointer, left, right);
        	} else if(key.equals("Z")) { // 원복 
        		recover = list[dump.pop()];
        		recover.notUsing = false;
        		// 원복 
        		left = recover.left;
        		right = recover.right;
        		restore(recover, left, right);
        	} else { // 포인터 이동, 범위를 벗어나지 않는다고 했음
        		val = Integer.parseInt(st.nextToken());
        		if(key.equals("U")) {
        			for(int j=0; j<val; j++) {
        				pointer = pointer.left;
        			}
        		} else {
        			for (int j=0; j<val; j++) {
						pointer = pointer.right;
					}
        		}
        	}
        } // end of for 
        
        for(int i=0; i<n; i++) {
        	if(list[i].notUsing) answer.append("X");
        	else answer.append("O");
        }
        
        return answer.toString();
    } // end of solution 

	private static void restore(Node recover, Node left, Node right) {
		if(left!=null) left.right = recover;
		if(right!=null) right.left = recover;
	} // end of restore

	private static Node remove(Node pointer, Node left, Node right) {
		if(left!=null) left.right = right;
		if(right!=null) {
			right.left = left;
			pointer = pointer.right;
		}
		else pointer = pointer.left;
		return pointer;
	} // end of remove
	
} // end of class 
