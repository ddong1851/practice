package src.prac;

public class exam {
    public static void main(String[] args) {
        int a = 3; //11
        int b = 1; //01

        System.out.println("AND연산");
        System.out.println(a&b);
        System.out.println("OR연산");
        System.out.println(a|b);
        System.out.println("XOR연산");
        System.out.println(a^b);
        System.out.println("NOT연산, a와 더했을 때 -1이 되게 하는 수");
        System.out.println(~a);
        System.out.println("a << 1, 우측에 0을 하나 추가하고, 왼쪽 끝을 하나 제거 11->110 되게함");
        System.out.println(a << 1);
        System.out.println("a >> 1, 좌측에 0을 하나 추가하고, 우측 끝을 하나 제거 11->01 되게함");
        System.out.println(a >> 1);

        System.out.println("비트연산자는 피연산자<<이동할비트수 a<<2는 2칸 증가 11->1100");
        System.out.println(a<<2);

        System.out.println("Label 사용법");
        dongryul : for(int i=0; i<5; i++){
            if(i==3) break dongryul;
            System.out.println(i);
        }

        
    }
}
