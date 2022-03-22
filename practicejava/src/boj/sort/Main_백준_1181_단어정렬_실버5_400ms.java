package src.boj.sort;

import java.io.*;
import java.util.*;

class Main_백준_1181_단어정렬_실버5_400ms{
    
    private static class Str implements Comparable<Str> {
        int len;
        String str;
        public Str(String str){
            super();
            len = str.length();
            this.str = str;
        }
        public int compareTo(Str o){
            if(this.len!=o.len){
                return this.len - o.len;
            }
            return this.str.compareTo(o.str);
        }
    }
    
    public static void main(String[] args) throws Exception{
        
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<String>();
        
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Str> pq = new PriorityQueue<>();
        
        
        
        for(int i=0; i<N; i++) {
        	String temp = br.readLine();
        	if(!set.contains(temp)) {
        		set.add(temp);
        		pq.offer(new Str(temp));
        	}
        }
        
        while(!pq.isEmpty()) {
        	sb.append(pq.poll().str).append("\n");
        }
        
        System.out.println(sb.toString());
        
    }
    
}




