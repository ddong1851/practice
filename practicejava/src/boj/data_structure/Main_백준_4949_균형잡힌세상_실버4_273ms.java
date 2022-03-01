package src.boj.data_structure;
import java.io.*;
import java.util.*;

class Main_백준_4949_균형잡힌세상_실버4_273ms {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack;
        String in;
        while(!(in=br.readLine()).equals(".")) {
			stack = new Stack<Character>();
			char[] line = in.toCharArray();
			boolean ck = true;
			for (int len = line.length, i = 0; i < len; i++) {
				char c = line[i];
				if(c=='(' || c=='[') stack.push(c);				
				else if(c==')') {
					if(!stack.isEmpty()) {
						char temp = stack.pop();
						if(temp!='(') {
							ck = false;
							break;
						}
					}
					else {
						ck=false;
						break;
					}
				}
				else if(c==']') {
					if(!stack.isEmpty()) {
						char temp = stack.pop();
						if(temp!='[') {
							ck = false;
							break;
						}
					}
					else {
						ck=false;
						break;
					}
				}
			} // end of for
			if (ck && stack.isEmpty())
				sb.append("yes").append("\n");
			else
				sb.append("no").append("\n");
        }
		System.out.println(sb.toString());
		System.exit(0);
    } // end of main
} // end of class