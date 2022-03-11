package src.prac;

import java.util.*;

public class prac {
	
	public static void main(String[] args) {
		
		Deque<Integer> dq2 = new ArrayDeque<Integer>();
		Deque<Integer> dq3 = new ArrayDeque<Integer>();
		for(int i=0; i<5; i++) {
			dq2.offerLast(i);
			dq3.offerFirst(i);
		}
		
		System.out.println(dq2.pollLast());
		System.out.println(dq3.pollFirst());
		
	}
}
