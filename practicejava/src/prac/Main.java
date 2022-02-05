package src.prac;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();       
        
        int n = sc.nextInt();
        for(int i=1; i<=9; i++){
            sb.append(n).append(" ").append("*").append(" ").append(i).
                append(" ").append("=").append(" ").append(n*i).append("\n");
        }
        System.out.println(sb.toString());
    }
}